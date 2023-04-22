import java.io.PrintWriter;

public class OddWriter extends Thread{
    private StringBuilder builder;
    private char letters[];
    private PrintWriter writerOdd;
    private Long start;

    public OddWriter(StringBuilder builder, char[] letters, PrintWriter writerEven, Long start) {
        this.builder = builder;
        this.letters = letters;
        this.writerOdd = writerEven;
        this.start = start;
    }

    @Override
    public void run() {
        try {
            for (int number = 1; number < 1000; number += 2) {
                int regionCode = 199;
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {
                            builder.append(firstLetter);
                            builder.append(Loader.padNumber(number, 3));
                            builder.append(secondLetter);
                            builder.append(thirdLetter);
                            builder.append(Loader.padNumber(regionCode, 2));
                            builder.append("\n");
                            writerOdd.write(builder.toString());
                            builder.setLength(0);
                        }
                    }
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
}
