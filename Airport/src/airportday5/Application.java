package airportday5;

import airportday5.planes.Airplane;
import airportday5.planes.CargoPlane;
import airportday5.planes.PeoplePlane;
import airportday5.planes.SpacePlane;

public class Application {

    public static void main(String[] args) {
        //assignment 1
//        Airplane airplane1 = new Airplane("ABC123");
//        airplane1.loadPassengers(43);
//        airplane1.land();
//        airplane1.takeOff();
//
//        Airplane airplane2 = new Airplane("DDD888");
//        airplane2.loadPassengers(23);
//        airplane2.takeOff();
//
//        airplane1.land();
//        airplane1.unloadPassengers();
//
//        airplane2.takeOff();
//        airplane2.land();
//        airplane2.unloadPassengers();

        //assignment 2
//        Airport airport = new Airport("Eindoven");
//        airport.printAirPlanes();
//        PeoplePlane freeGroundedAirPlane = airport.requestFreeGroundedPeopleAirPlane();
//        airport.loadAirplane(freeGroundedAirPlane, 93);


//        Airport airport = new Airport("Eindoven");
//        airport.printAirPlanes();
//
//
//        Airplane freeGroundedPeopleAirPlane = airport.requestFreeGroundedAirPlane();
//        if (freeGroundedPeopleAirPlane instanceof PeoplePlane) {
//            ((PeoplePlane) freeGroundedPeopleAirPlane).loadPassengers(93);
//        } else if(freeGroundedPeopleAirPlane instanceof CargoPlane) {
//            ((CargoPlane) freeGroundedPeopleAirPlane).loadCargo(10);
//        }

        // Day 5
        SpacePlane spacePlane = new SpacePlane();
        spacePlane.startMotor();
        spacePlane.takeOff();
        spacePlane.flyMissiles();

    }
}
