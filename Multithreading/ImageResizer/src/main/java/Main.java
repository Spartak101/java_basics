import java.io.File;

public class Main {

    private static int processorsCount =Runtime.getRuntime().availableProcessors();

    private static int newWidth = 300;

    public static void main(String[] args) {

        String srcFolder = "C:\\Users\\z\\Desktop\\src";
        String dstFolder = "C:\\Users\\z\\Desktop\\dst";


        File scrDir = new File(srcFolder);


        long start = System.currentTimeMillis();

        File[] files = scrDir.listFiles();
        int middle = files.length / processorsCount;

        for (int i = 0; i < processorsCount; i++) {


            File[] files2 = new File[middle];
            System.arraycopy(files, middle * i, files2, 0, files2.length);
            ImageResizer resizer = new ImageResizer(files2, newWidth, dstFolder, start);
            resizer.start();

        }
        System.out.println(processorsCount);
    }
}
