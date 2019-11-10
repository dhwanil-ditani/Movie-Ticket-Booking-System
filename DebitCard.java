import java.util.Scanner;

class DebitCard extends Payment{

    public final Scanner input = new Scanner(System.in);

    void pay(int price) {
        long dcno;
        int cvv;

        System.out.println();
        System.out.println("Payment ₹. " + price + " through Debit Card.");
        System.out.println("_________________________________________________");
        
        System.out.println();
        
        System.out.print("Enter Debit Card holder's name: ");
        setCardholderName(input.nextLine());
        System.out.println();

        do {
            System.out.print("Enter Debit Card number: ");
            dcno = input.nextLong();
        } while (!setCardNumber(dcno));

        System.out.println();

        do {
            System.out.print("Enter Debit Card CVV: ");
            cvv = input.nextInt();
        } while (!setCVV(cvv));

        System.out.println();

        Layout.process();
        System.out.println();
        System.out.println("Payment coomplete!");
        System.out.println();
    }
}