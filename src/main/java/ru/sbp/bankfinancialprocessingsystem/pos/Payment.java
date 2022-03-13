package ru.sbp.bankfinancialprocessingsystem.pos;

public class Payment {

    private String cardNumber;
    private String cardDate;
    private double summa;

    public Payment(String cardNumber, String cardDate, double summa) {
        this.cardNumber = cardNumber;
        this.cardDate = cardDate;
        this.summa = summa;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardDate() {
        return cardDate;
    }

    public void setCardDate(String cardDate) {
        this.cardDate = cardDate;
    }

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardDate='" + cardDate + '\'' +
                ", summa=" + summa +
                '}';
    }

}
