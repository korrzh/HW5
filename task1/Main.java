package HW5.task1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Створення користувача
        User user = new User("User123");

        // Отримання CompletableFuture з кожного джерела
        CompletableFuture<String> source1 = DataService.getSource1Data(user);
        CompletableFuture<String> source2 = DataService.getSource2Data(user);
        CompletableFuture<String> source3 = DataService.getSource3Data(user);

        // Додавання всіх CompletableFuture до списку
        List<CompletableFuture<String>> completableFutures = Arrays.asList(source1, source2, source3);

        // Виконання allOf для завершення всіх задач
        CompletableFuture<Void> resultantCf = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));

        // Збір результатів після завершення
        CompletableFuture<List<String>> allFutureResults = resultantCf.thenApply(t ->
                completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList())
        );

        // Виведення результатів
        System.out.println("Aggregated Results: " + allFutureResults.get());
    }
}
