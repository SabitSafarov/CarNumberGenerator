import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Loader.loader("res/numbers1.txt");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                Loader.loader("res/numbers2.txt");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).start();

//        ExecutorService executors = Executors.newFixedThreadPool(6);
//        executors.execute(new Loader());
//        executors.shutdown();
    }
}
