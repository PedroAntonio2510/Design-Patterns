import java.util.function.Consumer;

public class ModernStrategy {
    public static void main(String[] args) {
        String paymentMethod = "PIX";
        PaymentType.valueOf(paymentMethod).pay(3.0);

    }
}

class PaymentMethods {
    public static void creditCard(double amount) {
        System.out.println("Validating credicad card...");
        System.out.println("Paid R$ " + amount + " with credit card.");
    }

    public static void boleto(double amount) {
        System.out.println("Generating barcode...");
        System.out.println("Paid R$ " + amount + " with boleto.");
    }

    public static void pix(double amount) {
        System.out.println("Generating Qr COde...");
        System.out.println("Paid R$ " + amount + " with pix.");
    }
}

enum PaymentType {
    CREDIT_CARD(PaymentMethods::creditCard),
    BOLETO(PaymentMethods::boleto),
    PIX(PaymentMethods::pix);

    private Consumer<Double> paymentStrategy;

    PaymentType(Consumer<Double> paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(Double amount) {
        paymentStrategy.accept(amount);
    }
}