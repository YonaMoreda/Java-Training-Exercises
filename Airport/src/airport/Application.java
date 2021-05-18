package airport;

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
        Airport airport = new Airport("Eindoven");
        airport.printAirPlanes();
        Airplane freeGroundedAirPlane = airport.requestFreeGroundedAirPlane();
        airport.loadAirplane(freeGroundedAirPlane, 93);
    }
}
