package airport;

public class Airplane {
    String planeIdentification;
    int maxNumberOfPassengers;
    int currentNumberOfPassengers;
    boolean isCurrentlyFlying;
    int cruiseSpeed;

    public Airplane(String planeIdentification) {
        this(planeIdentification, 33);
    }

    public Airplane(String planeIdentification, int maxNumberOfPassengers) {
        this.planeIdentification = planeIdentification;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        this.currentNumberOfPassengers = 0;
        this.isCurrentlyFlying = false;
        this.cruiseSpeed = 0;
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

    public void takeOff() {
        if(isCurrentlyFlying) {
            System.out.println("Airplane " + planeIdentification + " cannot takeoff, because we are already flying.");
        } else {
            System.out.println("Airplane " + planeIdentification + " takes off.");
            isCurrentlyFlying = true;
        }
    }

    public void land() {
        if(isCurrentlyFlying) {
            System.out.println("Plane "+ planeIdentification+ " lands.");
            isCurrentlyFlying = false;
        } else {
            System.out.println("Airplane " + planeIdentification + "cannot land, because we are still on the ground.");
        }
    }

    public void print() {
        System.out.println("Plane " + planeIdentification);
    }
}
