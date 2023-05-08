public class Car extends Vehicule {

    private String name;
    private final String brand;
    private final int maxNbDoors;
    private final double maxFuel;

    private Motor motor;

    private Integer yearOfConstruction;
    private int nbDoors;

    private double nbKilometers;
    private double currentFuel;
    private Double consumption;

    public Car(final String name, final Brand brand, final Motor motor, final int yearOfConstruction,final int maxNbDoors, final double maxFuel) {
        super(name, brand, motor, yearOfConstruction);
        this.name = name;
        this.brand = String.valueOf(brand);
        this.maxNbDoors = maxNbDoors;
        this.maxFuel = maxFuel;
    }

    public String getName() {
        this.name = name;
        return name;
    }

    public void addDoor() {
        final int newNbDoors = nbDoors + 1;
        nbDoors = Math.min(newNbDoors, maxNbDoors);
    }

    public void addDoors(final int nbDoorsToAdd) {
        final int newNbDoors = nbDoors + nbDoorsToAdd;
        nbDoors = Math.min(newNbDoors, maxNbDoors);
    }

    public void setMotor(final Motor motor, final double consumption) {
        this.motor = motor;
        this.consumption = consumption;
    }

    public void setYearOfConstruction(final int yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public boolean isConstructed() {
        return yearOfConstruction != null && nbDoors == maxNbDoors && motor != null;
    }

    public void drive(final double nbKilometers) {
        if (!isConstructed()) {
            throw new IllegalStateException("Car is not constructed.");
        }

        if (currentFuel <= 0) {
            throw new IllegalStateException("Car has no fuel.");
        }

        double litersConsumed = (nbKilometers * consumption) / 100;
        double newCurrentFuel = currentFuel - litersConsumed;
        if (newCurrentFuel < 0) {
            newCurrentFuel = 0;
        }
        double delta = currentFuel - newCurrentFuel;
        double realDistance = (delta * 100) / consumption;

        currentFuel = newCurrentFuel;
        this.nbKilometers += realDistance;
    }

    public void addFuel(double nbFuel) {
        final double newFuel = currentFuel + nbFuel;
        currentFuel = Math.min(newFuel, maxFuel);
    }

    public String toString() {
        return "--------------------\n" +
                "Car name = " + name + "\n" +
                "Brand = " + brand + "\n" +
                "Motor = " + motor + "\n" +
                "Doors = " + nbDoors + "/" + maxNbDoors + "\n" +
                "Fuel = " + currentFuel + "/" + maxFuel + "\n" +
                "Consumption = " + consumption + " l/100km" + "\n" +
                "Nb kilometers = " + nbKilometers + "\n" +
                (isConstructed() ? "Year of construction = " + yearOfConstruction : "Not yet constructed");
    }
}
