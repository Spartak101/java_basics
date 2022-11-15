import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*        Elevator elevator = new Elevator(-3, 26);
        while (true) {
            System.out.print("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }
    }*/

        Order original = new Order(1500, "Морская 15", true, "sdf3153121", true);
        Dimensions dimensions = new Dimensions(2.5, 2.8, 2.7);
        dimensions.setDimensionsHeight(1.5);
        System.out.println(dimensions);
        dimensions.dimensionsPrint();
        System.out.println(original);
        Order copy = new Order(original.getMass(), original.getDeliveryAddress(), original.isFlipOver(), original.getRegistrationNumber(), original.isFragile());
        copy.setMass(2500);
        copy.setDeliveryAddress("Туманная 2");
        copy.setRegistrationNumber("QWDS4165168");
        copy.setFlipOver(false);
        copy.setFragile(false);
        copy.print();

    }
}