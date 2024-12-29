package HW5.task2;

import java.util.concurrent.CompletableFuture;

public class TransportService {

    // Симуляція перевірки поїзда
    public static CompletableFuture<Route> checkTrainRoute() {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay(2000); // Затримка для симуляції часу перевірки
            return new Route("Train", 50.0, 220); // Ціна і час в дорозі
        });
    }

    // Симуляція перевірки автобуса
    public static CompletableFuture<Route> checkBusRoute() {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay(1500); // Затримка для симуляції часу перевірки
            return new Route("Bus", 30.0, 180); // Ціна і час в дорозі
        });
    }

    // Симуляція перевірки літака
    public static CompletableFuture<Route> checkFlightRoute() {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay(500); // Затримка для симуляції часу перевірки
            return new Route("Flight", 150.0, 90); // Ціна і час в дорозі
        });
    }

    // Метод для перевірки доступності місць у поїзді
    public static CompletableFuture<Boolean> checkTrainAvailability(Route trainRoute) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay(1000);  // Затримка
            return true;  // Припустимо, місця є
        });
    }

    // Метод для перевірки доступності місць у автобусі
    public static CompletableFuture<Boolean> checkBusAvailability(Route busRoute) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay(800);  // Затримка
            return true;  // Припустимо, місця є
        });
    }

    // Метод для перевірки доступності місць на літаку
    public static CompletableFuture<Boolean> checkFlightAvailability(Route flightRoute) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay(500);  // Затримка
            return true;  // Припустимо, місця є
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