package airportday5.planes;

import airportday5.behaviors.PropellerBehavior;

public final class CargoPlane extends Airplane implements PropellerBehavior {

    public static final int MAX_CAPACITY = 20;
    private int occupiedCargoArea = 0;

    public CargoPlane(String name) {
        super(name);
    }

    public int getOccupiedCargoArea() {
        return occupiedCargoArea;
    }

    public void loadCargo(int weight) {
        if(occupiedCargoArea + weight > MAX_CAPACITY) {
            return;
        }
        occupiedCargoArea += weight;
    }

    private void dischargeAllCargo() {
        this.occupiedCargoArea = 0;
    }

    @Override
    public void tightenPropellers() {

    }

    @Override
    public String toString() {
        return "CargoPlane: " + planeIdentification;
    }
}
