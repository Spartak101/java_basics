import jdk.jshell.execution.LoaderDelegate;

import java.io.PrintWriter;

public class EvenWriter extends Thread {
    private StringBuilder builder;
    private char letters[];
    private PrintWriter writerEven;
    private Long start;

    public EvenWriter(StringBuilder builder, char[] letters, PrintWriter writerEven, Long start) {
        this.builder = builder;
        this.letters = letters;
        this.writerEven = writerEven;
        this.start = start;
    }

    @Override
    public void run() {
        try {
            for (int number = 2; number < 1000; number += 2) {
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
                            writerEven.write(builder.toString());
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
