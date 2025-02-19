import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class ModernObserver {
    public static void main(String[] args) {
        var stockdata = new StockData();

        stockdata.addObserver((stockName, stockPrice) -> System.out
                .println("Console Notification - Stock: " + stockName + " Price: " + stockPrice));

        stockdata.addObserver((stockName, stockPrice) -> System.out
                .println("Email Notification - Stock: " + stockName + " Price: " + stockPrice));

        stockdata.addObserver(NotificationMethods::smsNotification);

        stockdata.newStockData("AAPL", 150.00);
        stockdata.newStockData("GOOGL", 2500.00);
    }
}

class NotificationMethods {
    public static void smsNotification(String stockName, double stockPrice) {
        System.out.println("SMS Notification - Stock: " + stockName + " Price: " + stockPrice);
    }
}

class StockData {
    private final List<BiConsumer<String, Double>> observers = new ArrayList<>();

    public void addObserver(BiConsumer<String, Double> observer) {
        observers.add(observer);
    }

    public void removerObserver(BiConsumer<String, Double> observer) {
        observers.remove(observer);
    }

    public void newStockData(String stockName, Double stockPrice) {
        observers.forEach(observer -> observer.accept(stockName, stockPrice));
    }

}
