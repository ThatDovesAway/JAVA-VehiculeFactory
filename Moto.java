public class Moto extends Vehicule {
    private String name;
    private Motor motor;
    private Brand brand;
    private final int displacement;
    private final int horsePower;
    private boolean isStarted;
    private double currentFuel;
    private int yearOfConstruction;
    private double maxFuel;
    private Double consumption;
    private double nbKilometers;
    private int nbDoors;


    public Moto(String name, Brand brand, int yearOfConstruction, Motor motor, int displacement, int horsepower, double currentFuel, int nbDoors) {
        super(name, brand, motor, yearOfConstruction);
        this.name = name;
        this.motor = motor;
        this.brand = brand;
        this.yearOfConstruction = yearOfConstruction;
        this.displacement = displacement;
        this.horsePower = horsepower;
        this.currentFuel = currentFuel;
        this.isStarted = false;
        this.nbDoors = nbDoors;
    }

    public String getName() {
        this.name = name;
        return name;
    }

    public void setMotor(final Motor motor, final double consumption) {
        this.motor = motor;
    }

    public void start() {
        if (isStarted) {
            throw new IllegalStateException("The motorcycle is already started");
        } else {
            isStarted = true;
            System.out.println("The motorcycle starts");
        }
    }

    public void addDoors(int doorsToAdd) throws DoorsException {
        if (doorsToAdd > nbDoors) {
            throw new DoorsException("It's a motorcycle, you can't add doors");
        }
    }

    public void stop() {
        if (!isStarted) {
            throw new IllegalStateException("The motorcycle is already stopped");
        } else {
            isStarted = false;
            System.out.println("The motorcycle stops");
        }
    }

    public boolean isConstruct() {
        return yearOfConstruction != 0 && motor != null;
    }

    public void drive(final double nbKilometers) {
        if (isConstruct() && currentFuel > 0) {
            double litersConsumed = (nbKilometers * consumption) / 100;
            double newCurrentFuel = currentFuel - litersConsumed;
            if (newCurrentFuel < 0) newCurrentFuel = 0;
            double delta = currentFuel - newCurrentFuel;
            double realDistance = (delta * 100) / consumption;

            currentFuel = newCurrentFuel;
            this.nbKilometers += realDistance;
        } else {
            throw new IllegalStateException("Cannot drive because motorcycle is not constructed or doesn't have any fuel");
        }
    }

    public void addFuel(double nbFuel) {
        final double newFuel = currentFuel + nbFuel;
        currentFuel = Math.min(newFuel, maxFuel);
    }

    public Brand getBrand() {
        return brand;
    }

    public int getDisplacement() {
        return displacement;
    }

    public int getHorsepower() {
        return horsePower;
    }

    public String toString() {
        return "--------------------\n" +
                "Bike name = " + name + "\n" +
                "Brand = " + brand + "\n" +
                "Motor = " + motor + "\n" +
                "Fuel = " + currentFuel + "/" + maxFuel + "\n" +
                "Consumption = " + consumption + " l/100km" + "\n" +
                "Nb kilometers = " + nbKilometers + "\n" +
                (isConstruct() ? yearOfConstruction : "Not yet constructed");
    }
}


