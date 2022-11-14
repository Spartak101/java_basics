public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.print("Milk");


        Basket basket1 = new Basket();
        basket1.add("Сосиски", 670, 3, 0.9);
        basket1.add("Мангал", 4000);
        basket1.add("Квас", 150, 5, 1.5);
        basket1.add("Лаваш", 90, 3, 0.45);
        basket1.print("Корзина");
    }
/*    public static void main(String[] args) {

        Arithmetic one = new Arithmetic(15, 5);
        one.arithmeticSum();
        one.arithmeticComp();
        one.arithmeticMin();
        one.arithmeticMax();

// В public class Arithmetic закомментировать public Arithmetic(),
// раскомментировать  public void scanner(), и тут у блоков поменять комменты.

*//*        Arithmetic one = new Arithmetic();
        one.scanner();
        one.arithmeticSum();
        one.arithmeticComp();
        one.arithmeticMin();
        one.arithmeticMax();*//*
    }*/
}