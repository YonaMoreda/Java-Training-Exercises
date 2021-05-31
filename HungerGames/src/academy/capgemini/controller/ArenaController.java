package academy.capgemini.controller;

import academy.capgemini.model.Arena;
import academy.capgemini.model.Contestant;

import java.util.Random;
import java.util.logging.Logger;

import static academy.capgemini.model.Constants.HOURS_IN_A_DAY;
import static academy.capgemini.model.Constants.NUMBER_OF_CONTESTANTS;

public class ArenaController {

    private final Arena arena;
    private Random random = new Random();
    private static final Logger log = Logger.getLogger(ArenaController.class.getName());

    public ArenaController(Arena arena) {
        this.arena = arena;
    }

    public void startGame() {
        log.info(">>>>> The hunger games has started");
        double numberOfAliveContestants = NUMBER_OF_CONTESTANTS;
        int day = 0;
        while (numberOfAliveContestants > 1) {
//            float chanceOfBattleItem = random.nextFloat();
            var chanceOfMeeting = random.nextFloat();
            double hoursLeftInTheDay = HOURS_IN_A_DAY;
            while (hoursLeftInTheDay > 0) {
                log.info(">>> Hours left in the day " + hoursLeftInTheDay);
                var firstContestant = arena.getContestants().get(random.nextInt(arena.getContestants().size()));
                var secondContestant = arena.getContestants().get(random.nextInt(arena.getContestants().size()));
                if (twoMeet(chanceOfMeeting)) {
                    log.info(">> Contestants have met to battle to their deaths!");
                    var survivingContestant = firstContestant.fightTillDeath(secondContestant);
                    if (survivingContestant.getName().equals(firstContestant.getName())) {
                        log.info("Contestant " + firstContestant.getName() + " wins the battle over " + secondContestant.getName());
                        arena.getContestants().remove(secondContestant);
                    } else {
                        log.info("Contestant " + secondContestant.getName() + " wins the battle over " + firstContestant.getName());
                        arena.getContestants().remove(firstContestant);
                    }
                }
                hoursLeftInTheDay--;
            }
            numberOfAliveContestants = arena.getContestants().size();
            log.info("Day " + day + " over.");
            log.info("Number of alive contestants: " + numberOfAliveContestants + ". " + (NUMBER_OF_CONTESTANTS - numberOfAliveContestants) + " contestants have died.");
            day++;
        }
    }

    private boolean twoMeet(float chanceOfMeeting) {
        return chanceOfMeeting <= 0.3;
    }
}
