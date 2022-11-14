public class Arithmetic {

    public int numOne;
    public int numTwo;

/*    public void scanner() {
        System.out.println("Введите первое число и нажмите <Enter>: ");
        numOne = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число и нажмите <Enter>: ");
        numTwo = new Scanner(System.in).nextInt();
    }*/


    public Arithmetic(int numOne, int numTwo) {
        this.numOne = numOne;
        this.numTwo = numTwo;
    }


    public void arithmeticSum() {
        int sum = numOne + numTwo;
        System.out.println("Сумма чисел равна: " + sum);
    }

    public void arithmeticComp() {
        int comp = numOne * numTwo;
        System.out.println("Произведение чисел равно: " + comp);
    }

    public void arithmeticMin() {
        int min;
        if (numOne < numTwo) {
            min = numOne;
            System.out.println("Минимальное число: " + min);
        } else if (numOne > numTwo) {
            min = numTwo;
            System.out.println("Минимальное число: " + min);
        } else System.out.println("Числа равны");
    }

    public void arithmeticMax() {
        int max;
        if (numOne > numTwo) {
            max = numOne;
            System.out.println("Максимальное число: " + max);
        } else if (numOne < numTwo) {
            max = numTwo;
            System.out.println("Максимальное число: " + max);
        } else System.out.println("Числа равны");
    }
}
