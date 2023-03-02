package by.teachmeskills.homeworks.hw_03032023.bank;

public class Validator {
    public void validateCardNumber(long number) {
        class CardNumber {
            private long cardNumber;

            private CardNumber(long cardNumber) {
                this.cardNumber = cardNumber;
            }

            public long getCardNumber() {
                return cardNumber;
            }

            public void setCardNumber(long cardNumber) {
                this.cardNumber = cardNumber;
            }

            private void validateCardNumber() {
                int length = String.valueOf(cardNumber).length();
                if (length == 16) {
                    System.out.println("Card is right");
                } else {
                    System.out.println("Card is wrong");
                }
            }
        }
        CardNumber cardNumber = new CardNumber(number);
        cardNumber.validateCardNumber();
    }

    public void validateCardType(String type) {
        class CardType {
            private String cardType;

            private CardType(String cardType) {
                this.cardType = cardType;
            }

            public String getCardType() {
                return cardType;
            }

            public void setCardType(String cardType) {
                this.cardType = cardType;
            }

            private void validateCardType() {
                if (cardType.contains("VISA")) {
                    System.out.println("Card is right");
                } else {
                    System.out.println("Card is wrong");
                }
            }
        }
        CardType cardType = new CardType(type);
        cardType.validateCardType();
    }

    public void validateOwner(boolean name) {
        class Owner {
            private boolean owner;

            private Owner(boolean owner) {
                this.owner = owner;
            }

            public boolean getOwner() {
                return owner;
            }

            public void setOwner(boolean owner) {
                this.owner = owner;
            }

            private void validateOwner() {
                if (owner) {
                    System.out.println("Card is right");
                } else {
                    System.out.println("Card is wrong");
                }
            }
        }
        Owner owner = new Owner(name);
        owner.validateOwner();
    }

    public void validateCVV(String code) {
        class CVV {
            private String cvv;

            private CVV(String cvv) {
                this.cvv = cvv;
            }

            public String getCvv() {
                return cvv;
            }

            public void setCvv(String cvv) {
                this.cvv = cvv;
            }

            private void validateCVV() {
                if (cvv.matches("^[\\d]{3}$")) {
                    System.out.println("Card is right");
                } else {
                    System.out.println("Card is wrong");
                }
            }
        }
        CVV cvv = new CVV(code);
        cvv.validateCVV();
    }

    public void validateExpiryDate(String date) {
        class ExpiryDate {
            private String expDate;

            public ExpiryDate(String expDate) {
                this.expDate = expDate;
            }

            public String isExpDate() {
                return expDate;
            }

            public void setExpDate(String expDate) {
                this.expDate = expDate;
            }

            private void validateExpiryDate() {
                if (expDate.matches("(?:0[1-9]|1[0-2])/[2-9]{2}")) {
                    System.out.println("Card is right");
                } else {
                    System.out.println("Card is wrong");
                }
            }
        }
        ExpiryDate expiryDate = new ExpiryDate(date);
        expiryDate.validateExpiryDate();
    }
}