package ParkingLot;

public class Slot {
    private int slotId;
    private SlotType slotType;
    private int price;
    private boolean isAvailable;

    private String userId;
    private String vehicleId;

    public Slot(int slotId) {
        this.slotId = slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getSlotId() {
        return slotId;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getUserId() {
        return userId;
    }

    public String getVehicleId() {
        return vehicleId;
    }
}
