package ParkingLot.factory;

public class Car implements IVehicle{

    private String vehicleId;
    public Car(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public String getVehicleId() {
        return this.vehicleId;
    }
}
