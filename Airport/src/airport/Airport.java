package airport;

public class Airport {

    Airplane[] airplanes = new Airplane[3];
    String name;

    public Airport() {
        this("");
    }

    public Airport(String name) {
        this.name = name;
        for(int i = 0; i < 3; i++) {
            this.airplanes[i] = new Airplane("ABC" + i);
        }
    }

    public void printAirPlanes() {
        System.out.println("Aircraft from airport ");
        for(Airplane airplane : airplanes) {
            airplane.print();
        }
    }

    public Airplane requestFreeGroundedAirPlane() {
        for(Airplane airplane : airplanes) {
           if(!airplane.isCurrentlyFlying && airplane.maxNumberOfPassengers > airplane.currentNumberOfPassengers) {
               int roomLeft = airplane.maxNumberOfPassengers - airplane.currentNumberOfPassengers;
               System.out.println("Plane " + airplane.planeIdentification + " requested. Is not flying, still room for " + roomLeft + " passengers");
               return airplane;
           }
        }
        return null;
    }

    public void loadAirplane(Airplane airplane, int numberOfPassengers) {
        airplane.loadPassengers(numberOfPassengers);
    }
}
