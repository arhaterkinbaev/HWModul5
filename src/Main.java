import java.util.Scanner;

interface Transport {
    void drive();
    void refuel();
}

class NewCar implements Transport {
    private String brand;
    private String model;
    private String fuelType;

    public NewCar(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    @Override
    public void drive() {
        System.out.println(brand + " " + model + " едет!");
    }

    @Override
    public void refuel() {
        System.out.println(brand + " " + model + " заправляется " + fuelType + "!");
    }
}

class NewMotorcycle implements Transport {
    private String type;
    private int engineCapacity;

    public NewMotorcycle(String type, int engineCapacity) {
        this.type = type;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void drive() {
        System.out.println("Мотоцикл " + type + " с двигателем " + engineCapacity + " кубических см едет!");
    }

    @Override
    public void refuel() {
        System.out.println("Мотоцикл " + type + " заправляется!");
    }
}

class NewTruck implements Transport {
    private int payload;
    private int axles;

    public NewTruck(int payload, int axles) {
        this.payload = payload;
        this.axles = axles;
    }

    @Override
    public void drive() {
        System.out.println("Грузовик с грузоподъемностью " + payload + " тонн и " + axles + " колёсами едет!");
    }

    @Override
    public void refuel() {
        System.out.println("Грузовик заправляется!");
    }
}

class NewBus implements Transport {
    private int capacity;

    public NewBus(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void drive() {
        System.out.println("Автобус вместимостью " + capacity + " человек едет!");
    }

    @Override
    public void refuel() {
        System.out.println("Автобус заправляется!");
    }
}

abstract class TransportAssembler {
    public abstract Transport assembleTransport();
}

class NewCarAssembler extends TransportAssembler {
    @Override
    public Transport assembleTransport() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите марку автомобиля:");
        String brand = scanner.nextLine();
        System.out.println("Введите модель автомобиля:");
        String model = scanner.nextLine();
        System.out.println("Введите тип топлива:");
        String fuelType = scanner.nextLine();
        return new NewCar(brand, model, fuelType);
    }
}

class NewMotorcycleAssembler extends TransportAssembler {
    @Override
    public Transport assembleTransport() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип мотоцикла (спортивный, обычный):");
        String type = scanner.nextLine();
        System.out.println("Введите объем двигателя:");
        int engineCapacity = scanner.nextInt();
        return new NewMotorcycle(type, engineCapacity);
    }
}

class NewTruckAssembler extends TransportAssembler {
    @Override
    public Transport assembleTransport() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите грузоподъемность:");
        int payload = scanner.nextInt();
        System.out.println("Введите количество колёс:");
        int wheels = scanner.nextInt();
        return new NewTruck(payload, wheels);
    }
}

class NewBusAssembler extends TransportAssembler {
    @Override
    public Transport assembleTransport() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вместимость автобуса:");
        int capacity = scanner.nextInt();
        return new NewBus(capacity);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип транспортного средства:");
        System.out.println("1. Машина");
        System.out.println("2. Мотоцикл");
        System.out.println("3. Грузовик");
        System.out.println("4. Автобус");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Чистка после ввода числа

        TransportAssembler assembler = null;

        switch (choice) {
            case 1:
                assembler = new NewCarAssembler();
                break;
            case 2:
                assembler = new NewMotorcycleAssembler();
                break;
            case 3:
                assembler = new NewTruckAssembler();
                break;
            case 4:
                assembler = new NewBusAssembler();
                break;
            default:
                System.out.println("Неверный выбор!");
                break;
        }

        if (assembler != null) {
            Transport transport = assembler.assembleTransport();
            transport.drive();
            transport.refuel();
        }
    }
}
