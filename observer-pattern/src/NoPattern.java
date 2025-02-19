public class NoPattern {
    public static void main(String[] args) {
        var stockData = new StockDataCommom();

        stockData.updateStock("AAPL", 150.0);
        stockData.updateStock("GOOGLE", 250.0);
    }
}

class StockDataCommom {
    public void updateStock(String stockName, double stockPrice) {
        System.out.println("Console notification - Stock: " + stockName +  ", Price: " + stockPrice);
        System.out.println("Email notification - Stock: " + stockName +  ", Price: " + stockPrice);
        System.out.println("SMS notification - Stock: " + stockName +  ", Price: " + stockPrice);
    }
}