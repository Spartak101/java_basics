
import java.text.DecimalFormat;


public class Basket {

    private static int countBasket = 0;
    private String items = "";

    private int limit;

    private double totalWeight = 0;

    private final int price = 0;


    private int priceBasket = 0;

    private static int count = 0;
    private static int totalPrice;



    public static double getAveragePriceCount() {
        return (double) totalPrice / count;
    }

    public static double getAveragePriceBasket() {
        return (double) totalPrice / countBasket;
    }

    public Basket() {
        increaseCount(1);
        items = "Список товаров: ";
        this.limit = 1000000;
        countBasket = countBasket + 1;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        this.count = this.count + count;
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +

                count + " шт. - " + price;
        totalPrice = totalPrice + count * price;
        priceBasket = priceBasket + count * price;
    }

    public void add(String name, int price, int count, double weight) {
        add(name, price, count);
        totalWeight = totalWeight + weight * count;
    }


    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getPrice() {
        return price;
    }

    public static int getCount() {
        return count;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getPriceBasket() {
        return priceBasket;
    }

    public double getTotalWeight() {
        return totalWeight;
    }


    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {

        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Общая стоимость корзины: " + getPriceBasket());
            System.out.println("Вес корзины: " + df.format(getTotalWeight()) + " кг.");
        }
    }
}

