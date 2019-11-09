import java.util.Scanner;

class CreditCard extends Payment{

    public final Scanner input = new Scanner(System.in);

    void pay(){
        long ccno;
        int cvv;

        System.out.println();
        System.out.println("Payment through Credit Card");
        System.out.println("_________________________________");

        System.out.println();

        System.out.print("Enter Credit Card holder's name: ");
        setCardholderName(input.nextLine());
        System.out.println();

        do {
            System.out.print("Enter Credit Card number: ");
            ccno = input.nextLong();
        } while (!setCardNumber(ccno));

        System.out.println();

        do {
            System.out.print("Enter Credit Card CVV: ");
            cvv = input.nextInt();
        } while (!setCVV(cvv));

        System.out.println();

        Layout.process();
        System.out.println();
        System.out.println("Payment complete!");
        System.out.println();
    }
}