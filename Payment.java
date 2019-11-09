abstract class Payment {
    long CardNumber;
    String CardholderName;
    int CVV;
    
    void setCardholderName(String CardHolderName) {
        this.CardholderName = CardHolderName;
    }
    
    boolean setCardNumber(long CardNumber) {
        if (CardNumber < 1000000000000000L || CardNumber > 9999999999999999L)
        {
            System.out.println();
            System.out.println("Invalid card number! Please try again.");
            System.out.println();
            return false;
        }
        
        else
        {
            this.CardNumber = CardNumber;
            return true;
        }
    }

    boolean setCVV(int CVV) {
        if (CVV < 100 || CVV > 999)
        {
            System.out.println();
            System.out.println("Invalid CVV! Please try again.");
            System.out.println();
            return false;
        }
        
        else
        {
            this.CVV = CVV;
            return true;
        }
    }
    
    String getCardholderName() {
        return this.CardholderName;
    }
    
    long getCardNumber() {
        return this.CardNumber;
    }

    int getCVV() {
        return this.CVV;
    }
    
    abstract void pay();
}