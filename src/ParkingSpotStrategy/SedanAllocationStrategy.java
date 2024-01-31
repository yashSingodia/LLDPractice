import java.util.HashMap;
import java.util.Objects;

public class SedanAllocationStrategy implements SpotAllocationStrategy{
    private final SpotRepository spotRepository;
    private final SlotType carType;

    public SedanAllocationStrategy(SpotRepository spotRepository, SlotType carType) {
        this.spotRepository = spotRepository;
        this.carType = carType;
    }

    @Override
    public void parkCar() {
        HashMap<SlotType, Integer> carTypeSpots = spotRepository.getCarTypeSpots();
        if (Objects.isNull(carTypeSpots.get(carType)) || carTypeSpots.get(carType) <= 0) {
            throw new ParkingException("Slots full for " + carType + " allocation.");
        }

        carTypeSpots.put(carType, carTypeSpots.get(carType)-1);
        spotRepository.setCarTypeSpots(carTypeSpots);
    }
}
