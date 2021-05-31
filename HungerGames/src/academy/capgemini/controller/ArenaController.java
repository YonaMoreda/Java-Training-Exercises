package academy.capgemini.controller;

import academy.capgemini.model.Arena;
import academy.capgemini.model.contestants.Contestant;
import academy.capgemini.model.Pair;
import academy.capgemini.model.contestants.President;

import java.util.List;
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
            this.provideBattleItemsToContestants();
            this.replenishContestantHealths();
            var chanceOfMeeting = random.nextFloat();
            double hoursLeftInTheDay = HOURS_IN_A_DAY;
            while (hoursLeftInTheDay > 0 && numberOfAliveContestants > 1) {
                log.info(">>> Hours left in the day " + hoursLeftInTheDay);
                var firstContestant = getAPairOfContestants().getX();
                var secondContestant = getAPairOfContestants().getY();
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
                numberOfAliveContestants = arena.getContestants().size();
            }
            log.info("Day " + day + " over.");
            log.info("Number of alive contestants: " + numberOfAliveContestants + ". " + (NUMBER_OF_CONTESTANTS - numberOfAliveContestants) + " contestants have died.");
            day++;
        }
        log.info("The Hunger Games is over");
        Contestant champ = arena.getContestants().get(0);
        log.info("Contestant " + champ.getName() + " is the champion.");
        President snow = President.getInstance();
        snow.attack(champ);
    }

    private void replenishContestantHealths() {
        for(Contestant contestant : arena.getContestants()) {
            contestant.replenish();
        }
    }

    private void provideBattleItemsToContestants() {
        for (Contestant contestant : arena.getContestants()) {
            float chanceOfBattleItem = random.nextFloat();
            if (chanceOfBattleItem <= 0.05) {
                contestant.buff(10);
            } else if (chanceOfBattleItem <= 0.1) {
                contestant.buff(3);
            } else if (chanceOfBattleItem <= 0.3) {
                contestant.buff(2);
            }
        }
    }

    private Pair<Contestant, Contestant> getAPairOfContestants() {
        Pair<Contestant, Contestant> pair = new Pair<>();
        List<Contestant> contestants = arena.getContestants();
        pair.setX(contestants.get(random.nextInt(contestants.size())));
        arena.getContestants().remove(pair.getX());
        pair.setY(contestants.get(random.nextInt(contestants.size())));
        arena.getContestants().add(pair.getX());
        return pair;
    }

    private boolean twoMeet(float chanceOfMeeting) {
        return chanceOfMeeting <= 0.3;
    }
}
