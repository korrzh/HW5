package HW5.task2;

public class Route {
    private String transportType;
    private double price;
    private int travelTime; // в хвилинах

    public Route(String transportType, double price, int travelTime) {
        this.transportType = transportType;
        this.price = price;
        this.travelTime = travelTime;
    }

    public String getTransportType() {
        return transportType;
    }

    public double getPrice() {
        return price;
    }

    public int getTravelTime() {
        return travelTime;
    }

    @Override
    public String toString() {
        return transportType + " - Price: " + price + " USD, Time: " + travelTime + " min";
    }
}
