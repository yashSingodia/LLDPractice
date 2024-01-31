public class ElectricAllocationStrategy implements  SpotAllocationStrategy {
    private final SpotRepository spotRepository;
    public ElectricAllocationStrategy(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    @Override
    public void parkCar() {

    }
}
