import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.concurrent.ForkJoinPool;

public class Loader {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        PrintWriter writerEven = new PrintWriter("res/evenNumbers.txt");
        PrintWriter writerOdd = new PrintWriter("res/oddNumbers.txt");
        StringBuilder builder = new StringBuilder();
        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        EvenWriter evenWriter = new EvenWriter(builder, letters, writerEven, start);
        evenWriter.start();
        OddWriter oddWriter = new OddWriter(builder, letters, writerOdd, start);
        oddWriter.start();

        writerEven.flush();
        writerOdd.flush();
        writerEven.close();
        writerOdd.flush();

/*        System.out.println((System.currentTimeMillis() - start) + " ms");*/
    }

    public static String padNumber(int number, int numberLength) {
        StringBuilder numberStr = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr.append("0");
        }

        return String.valueOf(numberStr);
    }
}
