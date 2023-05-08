public class Vehicule {
    private String name;
    private Brand brand;
    private Motor motor;
    private int yearOfConstruction;

    public Vehicule(String name, Brand brand, Motor motor, int yearOfConstruction) {
        this.name = name;
        this.brand = brand;
        this.motor = motor;
        this.yearOfConstruction = yearOfConstruction;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public void setYearOfConstruction(int yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }
}


