package airportday5.planes;

public abstract class Airplane {
    protected String planeIdentification;
    private boolean isCurrentlyFlying;
    private int cruiseSpeed;

    protected Airplane() {
        this("", 33);
    }

    protected Airplane(String planeIdentification) {
        this(planeIdentification, 33);
    }

    protected Airplane(String planeIdentification, int maxNumberOfPassengers) {
        this.planeIdentification = planeIdentification;
        this.isCurrentlyFlying = false;
        this.cruiseSpeed = 0;
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
            System.out.println("Airplane " + planeIdentification + " cannot land, because we are still on the ground.");
        }
    }

    public String getPlaneIdentification() {
        return planeIdentification;
    }


    public boolean isCurrentlyFlying() {
        return isCurrentlyFlying;
    }

    public int getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void print() {
        System.out.println("Plane " + planeIdentification);
    }

    public String getStatus() {
        return "Plane " + planeIdentification + " status: " + isCurrentlyFlying();
    }
}
