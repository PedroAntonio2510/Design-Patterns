package common_strategy;

public class CommonStrategy {

    public static void main(String[] args ) {
        var paymentMethodCode = 1;
        var amount = 3.0;

        var paymentMethod = switch (paymentMethodCode) {
            case 1 -> new CreditCard();
            case 2 -> new Boleto();
            case 3 -> new Pix();
            default -> throw new IllegalStateException("Payment not suported");
        };

        var processor = new PaymentProcessor(paymentMethod);
        processor.pay(amount);
    }
}

class PaymentProcessor {
    private PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void pay(double amount) {
        if (paymentMethod == null) {
            throw new IllegalStateException("Payment not suported");
        }
        paymentMethod.pay(amount);
    }
}

interface PaymentMethod {
    void pay(double amount);
}

class CreditCard implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Validating credicad card...");
        System.out.println("Paid R$ " + amount + " with credit card.");
    }
}

class Boleto implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Generating barcode...");
        System.out.println("Paid R$ " + amount + " with boleto.");
    }
}

class Pix implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Generating Qr COde...");
        System.out.println("Paid R$ " + amount + " with pix.");
    }
}
