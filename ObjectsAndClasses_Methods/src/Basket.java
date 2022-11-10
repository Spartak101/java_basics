<<<<<<< HEAD
=======
import java.text.DecimalFormat;

>>>>>>> a21abaf (The task was simple. Improved a little.)
public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
<<<<<<< HEAD
=======
    private double totalWeight = 0;
>>>>>>> a21abaf (The task was simple. Improved a little.)

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
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

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
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
<<<<<<< HEAD
            count + " шт. - " + price;
        totalPrice = totalPrice + count * price;
    }

=======
                count + " шт. - " + price;
        totalPrice = totalPrice + count * price;
    }

    public void add(String name, int price, int count, double weight) {
        add(name, price, 1);
        totalWeight = totalWeight + weight * count;
    }

>>>>>>> a21abaf (The task was simple. Improved a little.)
    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

<<<<<<< HEAD
=======
    public double getTotalWeight() {
        return totalWeight;
    }

>>>>>>> a21abaf (The task was simple. Improved a little.)
    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
<<<<<<< HEAD
=======
        DecimalFormat df = new DecimalFormat("#.##");
>>>>>>> a21abaf (The task was simple. Improved a little.)
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
<<<<<<< HEAD
=======
            System.out.println("Вес корзины: " + df.format(getTotalWeight()) + " кг.");
>>>>>>> a21abaf (The task was simple. Improved a little.)
        }
    }
}
