package airportday5.planes;

import airportday5.behaviors.JetEngineBehavior;
import airportday5.behaviors.MissileBehavior;

public class SpacePlane extends Airplane implements JetEngineBehavior, MissileBehavior {

    @Override
    public void startMotor() {
        System.out.println("started motor!");
    }


    @Override
    public String toString() {
        return "SpacePlane: " + planeIdentification;
    }

    @Override
    public void flyMissiles() {
        System.out.println("Flying missiles!");
    }
}
