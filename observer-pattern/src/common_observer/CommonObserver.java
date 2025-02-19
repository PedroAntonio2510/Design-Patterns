package common_observer;

import java.util.ArrayList;
import java.util.List;

public class CommonObserver {
    public static void main(String[] args) {
        var stockData = new StockDataCommon();
        var consoleObserver = new ConsoleObserver();
        var emailObserver = new EmailObserver();
        var smsObserver = new SmsObserver();

        stockData.addObserver(consoleObserver);
        stockData.addObserver(emailObserver);
        stockData.addObserver(smsObserver);

        stockData.removeObserver(consoleObserver);

        stockData.newStockData("AAPL", 150.00);
        stockData.newStockData("GOOGL", 2500.00);
    }
}

interface Observer {
    void update(String stockName, double stockPrice);
}

class ConsoleObserver implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Console notification - Stock: " + stockName +  ", Price: " + stockPrice);
    }
}

class EmailObserver implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Email notification - Stock: " + stockName +  ", Price: " + stockPrice);
    }
}

class SmsObserver implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("SMS notification - Stock: " + stockName +  ", Price: " + stockPrice);
    }
}

class StockDataCommon {
    private List<Observer> observers =  new ArrayList<>();
    private String stockName;
    private double stockPrice;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void newStockData(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }
}