public class NoStrategy {
    public static void main(String[] args) {
        var paymentMethodCode = 1;
        var amount = 3.0;

        if (paymentMethodCode == 1) {
            System.out.println("Paying with credit card...");
            System.out.println("Paid R$ " + amount + " with credit card.");
        } else if (paymentMethodCode == 2) {
            System.out.println("Generating barcode...");
            System.out.println("Paid R$ " + amount + " with boleto.");
        } else if (paymentMethodCode == 3) {
            System.out.println("Generating Qr code..");
            System.out.println("Paid R$ " + amount + " with pix.");
        } else {
            throw new IllegalStateException("Payment method not supported");
        }
    }
}
