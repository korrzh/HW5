package HW5.task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Створення асинхронних завдань для перевірки варіантів транспорту
        CompletableFuture<Route> trainRoute = TransportService.checkTrainRoute();
        CompletableFuture<Route> busRoute = TransportService.checkBusRoute();
        CompletableFuture<Route> flightRoute = TransportService.checkFlightRoute();

        // Виконання всіх завдань паралельно і чекаємо на їх завершення
        CompletableFuture<Void> allRoutes = CompletableFuture.allOf(trainRoute, busRoute, flightRoute);

        // Збираємо результати після завершення всіх задач
        CompletableFuture<List<Route>> allRoutesList = allRoutes.thenApply(v -> {
            return Arrays.asList(trainRoute.join(), busRoute.join(), flightRoute.join());
        });

        // Отримуємо всі результати
        List<Route> routes = allRoutesList.get();

        // Вибір найкращого маршруту (наприклад, з найменшим часом)
        Route bestRoute = routes.stream()
                .min(Comparator.comparingInt(Route::getTravelTime)) // Порівнюємо за часом в дорозі
                .orElseThrow(() -> new IllegalArgumentException("No routes available"));

        // Виведення найкращого маршруту
        System.out.println("Best route: " + bestRoute);
    }
}
