import java.util.ArrayList;

public class Factory {
    public static void main(final String[] args) {
        ArrayList<Object> vehicles = new ArrayList<>();

        final Motor diesel = new Motor(Motor.MotorType.DIESEL, 100);
        final Motor essence = new Motor(Motor.MotorType.ESSENCE, 80);
        final Brand peugeot = new Brand("Peugeot", Brand.Country.FRANCE);
        final Brand volkswagen = new Brand("Volkswagen", Brand.Country.GERMANY);

        final Car car1 = new Car("Peugeot 308", peugeot, diesel, 2004, 5, 90);
        final Car car2 = new Car("Volkswagen Polo", volkswagen, essence, 2023, 5, 130);
        car1.setMotor(diesel, 30);
        car1.addFuel(800);
        car1.addDoors(10);
        car1.setYearOfConstruction(2023);
        try {
            car1.drive(200);
        } catch (IllegalStateException e) {
            System.out.println("[ERROR] Car1: " + e.getMessage());
        }
        vehicles.add(car1);
        vehicles.add("\n");

        car2.setMotor(diesel, 30);
        car2.addFuel(80);
        car2.addDoors(4);
        car2.setYearOfConstruction(2023);
        try {
            car2.drive(200);
        } catch (IllegalStateException e) {
            System.out.println("[ERROR] Car2: " + e.getMessage());
        }
        vehicles.add(car2);
        vehicles.add("\n");

        final Brand aprilia = new Brand("Aprilia", Brand.Country.ITALIE);
        final Brand kawasaki = new Brand("Kawasaki", Brand.Country.JAPAN);
        final Moto moto1 = new Moto("Aprilia RS4", aprilia, 2013, essence, 150000, 6, 70, 0);
        final Moto moto2 = new Moto("Kawasaki Z SPIRIT", kawasaki, 2020, essence, 400000, 15, 85, 0);

        try {
            moto1.addDoors(3);
        } catch (DoorsException e) {
            System.out.println("[ERROR] Moto1: " + e.getMessage());
        } finally {
            System.out.println("It's a MotorBike, you can't add doors! Use your mind, please.");
        }

        vehicles.add(moto1);
        vehicles.add("\n");
        vehicles.add(moto2);
        System.out.println(vehicles);
        System.out.println("\n");

        String vehicleTypeCar = "Car"; // Type de véhicule à filtrer
        String vehicleTypeMoto = "Moto";

        System.out.println("Véhicules de type " + vehicleTypeCar + ":");
        for (Object vehicle : vehicles) {
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                if (car.getClass().getSimpleName().equals(vehicleTypeCar)) {
                    System.out.println("- " + car.getName());
                }
            }
        }
        System.out.println("\n");
        System.out.println("Véhicules de type " + vehicleTypeMoto + ":");
        for (Object vehicle : vehicles){
            if (vehicle instanceof Moto) {
                Moto moto = (Moto) vehicle;
                if (moto.getClass().getSimpleName().equals(vehicleTypeMoto)) {
                    System.out.println("- " + moto.getName());
                }
            }
        }
    }
}

