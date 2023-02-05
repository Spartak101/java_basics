import java.util.concurrent.atomic.AtomicInteger;

public class AllTransactionsCount {
    private volatile static AtomicInteger integer = new AtomicInteger();
    public static void incrementInteger(){
        integer.incrementAndGet();
    }

    public static int getInteger() {
        return integer.intValue();
    }
}
