package airportday5.planes;

import airportday5.behaviors.JetEngineBehavior;

public final class PeoplePlane extends Airplane implements JetEngineBehavior {

    private int maxNumberOfPassengers;
    private int currentNumberOfPassengers;

    public PeoplePlane(String name) {
        this(name, 50, 0);
    }

    public PeoplePlane(String name, int maxNumberOfPassengers, int currentNumberOfPassengers) {
        super(name);
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        this.currentNumberOfPassengers = currentNumberOfPassengers;
    }

    public void loadPassengers(int numberOfPassengers) {
        if(numberOfPassengers + currentNumberOfPassengers > maxNumberOfPassengers) {
            int amountThatCanFit = maxNumberOfPassengers - currentNumberOfPassengers;
            int amountThatCannotFit = numberOfPassengers - amountThatCanFit;
            currentNumberOfPassengers += amountThatCanFit;
            System.out.println("Airplane " + planeIdentification + " charges " + amountThatCanFit + " passengers, " + amountThatCannotFit + " do not fit.");
            return;
        }
        System.out.println("Airplane " + planeIdentification + " loads " + numberOfPassengers + " passengers.");
        this.currentNumberOfPassengers = numberOfPassengers;
    }

    public void unloadPassengers() {
        System.out.println("Airplane " + planeIdentification + " unloads " + currentNumberOfPassengers + " passengers.");
        this.currentNumberOfPassengers = 0;
    }

    public int getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }

    public int getCurrentNumberOfPassengers() {
        return currentNumberOfPassengers;
    }

    @Override
    public void startMotor() {

    }

    @Override
    public String toString() {
        return "PeoplePlane: " + planeIdentification;
    }
}
