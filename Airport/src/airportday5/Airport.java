package airportday5;

import airportday5.planes.Airplane;
import airportday5.planes.CargoPlane;
import airportday5.planes.PeoplePlane;

import java.util.ArrayList;
import java.util.List;

import static airportday5.planes.CargoPlane.MAX_CAPACITY;

public class Airport {

    Airplane[] airplanes = new Airplane[6];
    String name;

    public Airport(String name) {
        this.name = name;
        for(int i = 0; i < 3; i++) {
            this.airplanes[i] = new PeoplePlane("ABC" + i);
        }

        for(int i = 3; i < 6; i++) {
            this.airplanes[i] = new CargoPlane("FFF" + i);
        }
    }

    public void printAirPlanes() {
        System.out.println("Aircraft from airport ");
        for(Airplane airplane : airplanes) {
            airplane.print();
        }
    }

    public Airplane requestFreeGroundedAirPlane() {
        for (Airplane airplane : airplanes) {
            if (airplane instanceof PeoplePlane) {
                return requestFreeGroundedPeoplePlane((PeoplePlane) airplane);
            } else if (airplane instanceof CargoPlane) {
                return requestFreeGroundedCargoPlane((CargoPlane) airplane);
            }
        }
        return null;
    }

    private CargoPlane requestFreeGroundedCargoPlane(CargoPlane cargoPlane) {
        if (!cargoPlane.isCurrentlyFlying() && cargoPlane.getOccupiedCargoArea() < MAX_CAPACITY) {
            int cargoSpace = MAX_CAPACITY - cargoPlane.getOccupiedCargoArea();
            System.out.println("Plane " + cargoPlane.getPlaneIdentification() + " requested. Is not flying, still room for " + cargoSpace + " tons of freight");
            return cargoPlane;
        }
        return null;
    }

    private Airplane requestFreeGroundedPeoplePlane(PeoplePlane peoplePlane) {
        if (!peoplePlane.isCurrentlyFlying() && peoplePlane.getMaxNumberOfPassengers() > peoplePlane.getCurrentNumberOfPassengers()) {
            int roomLeft = peoplePlane.getMaxNumberOfPassengers() - peoplePlane.getCurrentNumberOfPassengers();
            System.out.println("Plane " + peoplePlane.getPlaneIdentification() + " requested. Is not flying, still room for " + roomLeft + " passengers");
            return peoplePlane;
        }
        return null;
    }

    public List<PeoplePlane> getPeoplePlaneList() {
        return getPlaneList(PeoplePlane.class);
    }

    public List<CargoPlane> getCargoPlaneList() {
        return getPlaneList(CargoPlane.class);
    }

    public <E extends Airplane> List<E> getPlaneList(Class<E> incomingClass) {
        List<E> planes = new ArrayList<>();
        for(Airplane airplane: airplanes) {
            if(incomingClass.isAssignableFrom(airplane.getClass())) {
                planes.add((E) airplane);
            }
        }
        return planes;
    }

}
