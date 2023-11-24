package ParkingLot;

import ParkingLot.exceptions.NoSlotFoundException;
import ParkingLot.exceptions.SlotNotAvailableException;
import ParkingLot.factory.IVehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParkingLot {
    private List<Slot> parkingSlots = new ArrayList<>();


    public ParkingLot(int slots) {
        for (int slot = 0; slot < slots; slot++) {
            parkingSlots.add(new Slot(slot+1));
        }
    }

    public Slot parkAtSlot(IVehicle iVehicle, int slotNumber) {
        Slot parkingSlot;
        if (parkingSlots.get(slotNumber).isAvailable()) {
            parkingSlot = parkingSlots.get(slotNumber);
            parkingSlot.setAvailable(false);
            parkingSlot.setVehicleId(iVehicle.getVehicleId());
        } else {
            throw new SlotNotAvailableException();
        }
        return parkingSlot;
    }

    public Slot unparkAtSlot(IVehicle iVehicle, int slotNumber) {
        Slot parkingSlot = parkingSlots.get(slotNumber);
        if (Objects.isNull(parkingSlot)) {
            throw new NoSlotFoundException();
        }
        parkingSlot.setAvailable(true);
        parkingSlot.setVehicleId(null);
        return parkingSlot;
    }
}
