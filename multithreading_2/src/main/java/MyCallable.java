
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {


    @Override
    public String call() {
        int count = 0;

        try {
            while (count < 5) {
                Thread.sleep(2500);
                System.out.println("Всем привет! Это поток " + Thread.currentThread().getName());
                count++;
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.printf("%s завершен\n", Thread.currentThread().getName());
        }
        return Thread.currentThread().getName() + " - " + count;
    }


}