public class ElectricSedanAllocationStrategy implements SpotAllocationStrategy {
    private final SpotRepository spotRepository;

    public ElectricSedanAllocationStrategy(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    @Override
    public void parkCar() {
        // factory, type->electric
        ElectricAllocationStrategy electricAllocationStrategy = new ElectricAllocationStrategy(spotRepository);
        electricAllocationStrategy.parkCar();

        // if full -> sedan
        SedanAllocationStrategy sedanAllocationStrategy = new SedanAllocationStrategy(spotRepository, SlotType.SEDAN);
        sedanAllocationStrategy.parkCar();
    }
}
