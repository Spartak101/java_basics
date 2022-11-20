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

/*        Order original = new Order(new Dimensions(2.5, 2.8, 2.7),
                1500, "Морская 15", true, "sdf3153121", true);
        System.out.println(original);
        Order newOrder = original.setDeliveryAddress("Туманная 2");
        System.out.println(newOrder);
        original.setDimensionsWidth(1.5);
        original.setRegistrationNumber("ASDFQW98098");
        original.setMass(2500);
        original.print();
        System.out.println(original);
        System.out.println(newOrder);

    }*/
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.print("Milk");


        Basket basket1 = new Basket();
        basket1.add("Сосиски", 670, 3, 0.9);
        basket1.add("Мангал", 4000);
        basket1.add("Квас", 150, 5, 1.5);
        basket1.add("Лаваш", 90, 3, 0.45);
        basket1.print("\n" + "Корзина");

        Basket basket2 = new Basket();
        basket2.add("Молоко", 120, 2, 1.5);
        basket2.add("Хлеб", 36, 3, 0.65);
        basket2.add("Масло сливочное", 280, 1, 0.18);
        basket2.print("\n" + "Корзина");
        System.out.println("\n" + "Средняя цена корзины: " + Basket.getAveragePriceBasket());
        System.out.printf("\n" + "Средняя цена товара: " + "%.2f", Basket.getAveragePriceCount());
    }
}