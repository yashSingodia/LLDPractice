import java.util.HashMap;

public class SpotRepository {
    private HashMap<SlotType, Integer> carTypeSpots;

    public HashMap<SlotType, Integer> getCarTypeSpots() {
        return carTypeSpots;
    }

    public void setCarTypeSpots(HashMap<SlotType, Integer> carTypeSpots) {
        this.carTypeSpots = carTypeSpots;
    }
}
