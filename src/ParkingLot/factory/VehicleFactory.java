package ParkingLot.factory;

import java.util.Objects;

public class VehicleFactory {

    public static VehicleFactory vehicleFactory;
    private VehicleFactory() {}
    public static VehicleFactory getVehicleFactory() {
        // thread safety -- introduce synchronization
        if (Objects.isNull(vehicleFactory)) {
            vehicleFactory = new VehicleFactory();
        }
        return vehicleFactory;
    }

    public static IVehicle createVehicle(String vehicle) {

        if (vehicle.equals("Car")) {
            return new Car("V1234");
        }

        return null;
    }
}
