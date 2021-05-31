package academy.capgemini.model;

import static academy.capgemini.model.Sex.MALE;

public class MaleContestant extends Contestant {
    protected MaleContestant(String name) {
        super(name, MALE);
    }
}
