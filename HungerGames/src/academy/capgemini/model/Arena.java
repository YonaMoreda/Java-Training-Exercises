package academy.capgemini.model;

import academy.capgemini.model.contestants.Contestant;
import academy.capgemini.model.contestants.FemaleContestant;
import academy.capgemini.model.contestants.MaleContestant;

import java.util.ArrayList;
import java.util.List;

import static academy.capgemini.model.Constants.NUMBER_OF_FEMALE_CONTESTANTS;
import static academy.capgemini.model.Constants.NUMBER_OF_MALE_CONTESTANTS;

public class Arena {

    private final List<Contestant> contestants;

    public Arena() {
        this.contestants = createContestants();
    }

    private List<Contestant> createContestants() {
        ArrayList<Contestant> newContestants = new ArrayList<Contestant>();
        for (var i = 0; i < NUMBER_OF_MALE_CONTESTANTS; i++) {
            newContestants.add(new MaleContestant("MaleContestant#" + i));
        }
        for (var i = 0; i < NUMBER_OF_FEMALE_CONTESTANTS; i++) {
            newContestants.add(new FemaleContestant("FemaleContestant#" + i));
        }
        return newContestants;
    }

    public List<Contestant> getContestants() {
        return contestants;
    }
}
