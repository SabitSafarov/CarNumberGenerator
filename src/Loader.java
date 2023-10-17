import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Loader implements Runnable {

    public Loader() {
        run();
    }

    public static synchronized void loader(String location) throws FileNotFoundException {

        long start = System.currentTimeMillis();

        PrintWriter writer = new PrintWriter(location);

        char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        for (int number = 1; number < 1000; number++) {
            StringBuilder builder = new StringBuilder();
            int regionCode = 199;
            for (char firstLetter : letters) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        builder.append(firstLetter)
                                .append(padNumber(number, 3))
                                .append(secondLetter)
                                .append(thirdLetter)
                                .append(padNumber(regionCode, 2))
                                .append("\n");
                    }
                }
            }
            writer.write(builder.toString());
        }

        writer.flush();
        writer.close();

        System.out.println((System.currentTimeMillis() - start) + " ms " + Thread.currentThread().getName() + " " + location);
    }

    private static StringBuilder padNumber(int number, int numberLength) {
        StringBuilder builder = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - builder.length();

        for (int i = 0; i < padSize; i++) {
            builder.append('0');
        }

        return builder;
    }

    @Override
    public void run() {
        try {
            loader("res/numbers1.txt");
            loader("res/numbers2.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
