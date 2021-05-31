package academy.capgemini.model.contestants;

import static academy.capgemini.model.Sex.MALE;

public class MaleContestant extends Contestant {
    public MaleContestant(String name) {
        super(name, MALE);
    }
}
