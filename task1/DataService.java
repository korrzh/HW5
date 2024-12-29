package HW5.task1;

import java.util.concurrent.CompletableFuture;

public class DataService {
    // Метод для отримання даних з першого джерела
    public static CompletableFuture<String> getSource1Data(User user) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay(500); // Затримка
            return "Data from Source 1 for User: " + user.getUserID();
        });
    }

    // Метод для отримання даних з другого джерела
    public static CompletableFuture<String> getSource2Data(User user) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay(2000); // Затримка
            return "Data from Source 2 for User: " + user.getUserID();
        });
    }

    // Метод для отримання даних з третього джерела
    public static CompletableFuture<String> getSource3Data(User user) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay(1000); // Затримка
            return "Data from Source 3 for User: " + user.getUserID();
        });
    }

    // Симуляція затримки
    private static void simulateDelay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
