package ObjectOrientedDesign.CreditCardApp;

public class Main {
    public static void main(String[] args) {
        CreditCard creditCard = new PredatoryCreditCard("SAS", "SBI Noida", "SBI3080", 50000, 1000, 5);


        CreditCard card = new PredatoryCreditCard("John", "BankY", "5678", 3000, 500, 0.15);

        // Call a method declared in CreditCard
        card.makePayment(100); // Works fine, because it's in superclass

        // Call a method that exists in PredatoryCreditCard
        //card.processMonth(); // **Error!**: Not visible in CreditCard class

        // But if you cast:
        if (card instanceof PredatoryCreditCard) {
            ((PredatoryCreditCard) card).processMonth(); // Now it's safe

        }
    }
    }
