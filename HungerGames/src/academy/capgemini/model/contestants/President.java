package academy.capgemini.model.contestants;

import academy.capgemini.model.Sex;

public class President extends Contestant {

    public static President getInstance() {
        return new President("Snow", Sex.MALE);
    }

    protected President(String name, Sex sex) {
        super(name, sex);
        this.buff(1000);
    }

    public void kill(Contestant contestant) {
        while (contestant.isAlive()) {
            this.attack(contestant);
        }
    }
}
