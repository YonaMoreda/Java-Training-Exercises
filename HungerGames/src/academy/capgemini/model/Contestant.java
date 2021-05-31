package academy.capgemini.model;

import java.util.Random;
import java.util.logging.Logger;

import static academy.capgemini.model.Constants.FIFTY;
import static academy.capgemini.model.Constants.FULL_AMOUNT;
import static academy.capgemini.model.Constants.TEN;

public abstract class Contestant {

    private static final Logger log = Logger.getLogger(Contestant.class.getName());
    private String name;
    private Sex sex;
    private int healthAmount = FULL_AMOUNT;
    private float attackLevel;        //attack amount multiplier
    private int attackAmount;
    private float defenseLevel;       //defense amount multiplier
    private int armorAmount;
    private final Random random = new Random();

//    private int

    protected Contestant(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
        this.attackLevel = 1 + random.nextFloat();   //btn 1 and 2
        this.attackAmount = calculateAmountFromMultiplier(TEN, attackLevel);
        this.defenseLevel = 1 + random.nextFloat();   //btn 1 and 2
        this.armorAmount = calculateAmountFromMultiplier(FIFTY, defenseLevel);
    }

    public boolean isAlive() {
        return healthAmount > 0;
    }

    private int calculateAmountFromMultiplier(int value, float level) {
        return (int) (value * level);
    }


    public void attack(Contestant contestant) {
        if (contestant.armorAmount > 0) {           //contestant has a functioning armor
            contestant.healthAmount -= 0.1 * attackAmount;
            contestant.armorAmount -= 0.9 * attackAmount;
        } else {
            contestant.armorAmount = 0;
            contestant.healthAmount -= attackAmount;
        }
        log.info("> " + this.name + " has attacked " + contestant.name);
        log.info("> More info on the attack. " + this + " has attacked " + contestant);
    }

    public Contestant fightTillDeath(Contestant contestant) {
        while (this.isAlive() && contestant.isAlive()) {
            if (firstContestantAttacks(this, contestant)) {
                this.attack(contestant);
            } else {
                contestant.attack(this);
            }
        }
        return this.isAlive() ? this : contestant;
    }

    private boolean firstContestantAttacks(Contestant firstContestant, Contestant secondContestant) {
        if (isLeftContestantSignificantlyStronger(firstContestant, secondContestant, 10)) {
            log.info("> First contestant attacks as he/she is significantly stronger!");
            return true;
        }
        if (isLeftContestantSignificantlyStronger(secondContestant, firstContestant, 10)) {
            log.info("> Second contestant attacks as he/she is significantly stronger!");
            return false;
        }
        log.info("> They are truly matched in their raw strength. One of the contestant attacks!!");
        return random.nextFloat() < 0.5;            //random if they are nearly equal in terms of strength
    }

    private boolean isLeftContestantSignificantlyStronger(Contestant leftContestant, Contestant rightContestant, int strengthDifference) {
        return leftContestant.attackAmount - strengthDifference > rightContestant.attackAmount;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Contestant{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", healthAmount=" + healthAmount +
                ", attackLevel=" + attackLevel +
                ", attackAmount=" + attackAmount +
                ", defenseLevel=" + defenseLevel +
                ", armorAmount=" + armorAmount +
                '}';
    }
}

