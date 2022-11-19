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

        Order original = new Order(new Dimensions(2.5, 2.8, 2.7),
                1500, "Морская 15", true, "sdf3153121", true);
        System.out.println(original);
        Order newOrder = original.setDeliveryAddress("Туманная 2");
        newOrder = newOrder.setRegistrationNumber("SXCDFV1234");
        newOrder = newOrder.setFragile(false);
        newOrder = newOrder.setDimensionsLong(2.2);
        System.out.println(newOrder);
/*        original.setDimensionsWidth(1.5);
        original.setRegistrationNumber("ASDFQW98098");
        original.setMass(2500);
        original.print();
        System.out.println(original);
        System.out.println(newOrder);*/

    }
}