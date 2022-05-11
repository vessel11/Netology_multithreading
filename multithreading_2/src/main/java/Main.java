import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Callable<String>> callables = createCallables(4);

        forInvokeAll(threadPool, callables);
    }

    private static List<Callable<String>> createCallables(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> new MyCallable())
                .collect(Collectors.toList());
    }

    private static void forInvokeAll(ExecutorService threadPool, List<Callable<String>> callables) throws InterruptedException, ExecutionException {
        List<Future<String>> futures = threadPool.invokeAll(callables);

        threadPool.shutdown();

        System.out.println("Результат всех задач:");
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
    }
}