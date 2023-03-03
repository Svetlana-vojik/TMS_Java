package by.teachmeskills.homeworks.hw_03032023.bank;

public class Validator {

    public void validateCard(long number, String type, boolean name, String code, String date) {

        class Card {
            public long cardNumber;
            public String cardType;
            private boolean owner;
            private String cvv;
            private String expDate;

            public Card(long cardNumber, String cardType, boolean owner, String cvv, String expDate) {
                this.cardNumber = cardNumber;
                this.cardType = cardType;
                this.owner = owner;
                this.cvv = cvv;
                this.expDate = expDate;
            }

            public Card() {
            }

            public long getCardNumber() {
                return cardNumber;
            }

            public void setCardNumber(long cardNumber) {
                this.cardNumber = cardNumber;
            }

            public String getCardType() {
                return cardType;
            }

            public void setCardType(String cardType) {
                this.cardType = cardType;
            }

            public boolean isOwner() {
                return owner;
            }

            public void setOwner(boolean owner) {
                this.owner = owner;
            }

            public String getCvv() {
                return cvv;
            }

            public void setCvv(String cvv) {
                this.cvv = cvv;
            }

            public String getExpDate() {
                return expDate;
            }

            public void setExpDate(String expDate) {
                this.expDate = expDate;
            }

            public void validateCardNumber(long cardNumber) {
                int length = String.valueOf(cardNumber).length();
                if (length == 16) {
                    System.out.println("Card number is right");
                } else {
                    System.out.println("Card number is wrong");
                }
            }

            private void validateCardType(String cardType) {
                if (cardType.contains("VISA")) {
                    System.out.println("Card type is right");
                } else {
                    System.out.println("Card type is wrong");
                }
            }

            private void validateOwner(boolean owner) {
                if (owner) {
                    System.out.println("Card has owner");
                } else {
                    System.out.println("Card has not owner");
                }
            }

            private void validateCVV(String cvv) {
                if (cvv.matches("^[\\d]{3}$")) {
                    System.out.println("CVV is right");
                } else {
                    System.out.println("CVV is wrong");
                }
            }

            private void validateExpiryDate(String expDate) {
                if (expDate.matches("(?:0[1-9]|1[0-2])/[2-9]{2}")) {
                    System.out.println("Expiry Date is right");
                } else {
                    System.out.println("Expiry Date is wrong");
                }
            }
        }
        Card card = new Card();
        card.validateCardNumber(number);
        card.validateCardType(type);
        card.validateOwner(name);
        card.validateCVV(code);
        card.validateExpiryDate(date);
    }
}