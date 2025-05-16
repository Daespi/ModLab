package com.example.Models.PaymentMethod.Entity;

import java.util.UUID;

import com.example.Exceptions.BuildException;
import com.example.Operations.Checker;

public class PaymentMethod {

    protected String paymentId;
    protected String paymentMethod;
    protected String cardNumber;
    protected String cardExpiry;
    protected String cardCvv;
    protected String userId;

    protected PaymentMethod() {}

    public static PaymentMethod getInstance(String paymentMethod, String cardNumber, String cardExpiry,
                                            String cardCvv, String userId) throws BuildException {
        String message = "";
        PaymentMethod method = new PaymentMethod();

        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
        method.paymentId = uuid;

        int resultMethod = method.setPaymentMethod(paymentMethod);
        if (resultMethod != 0) {
            message += "El método de pago no es válido porque " + Checker.getErrorMessage(resultMethod, 3, 30);
        }

        int resultCard = method.setCardNumber(cardNumber);
        if (resultCard != 0) {
            message += "El número de tarjeta no es válido porque " + Checker.getErrorMessage(resultCard, 16, 19);
        }

        int resultExpiry = method.setCardExpiry(cardExpiry);
        if (resultExpiry != 0) {
            message += "La fecha de expiración no es válida.";
        }

        int resultCvv = method.setCardCvv(cardCvv);
        if (resultCvv != 0) {
            message += "El CVV no es válido.";
        }

        if (Checker.isNull(userId) != 0) {
            message += "El ID de usuario no puede ser nulo.";
        } else {
            method.userId = userId;
        }

        if (!message.isEmpty()) {
            method = null;
            throw new BuildException(message);
        }

        return method;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public int setPaymentMethod(String paymentMethod) {
        if (Checker.isNull(paymentMethod) != 0) return -1;
        if (Checker.minLength(3, paymentMethod) != 0) return -2;
        if (Checker.maxLenght(30, paymentMethod) != 0) return -10;
        this.paymentMethod = paymentMethod;
        return 0;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int setCardNumber(String cardNumber) {
        if (Checker.isNull(cardNumber) != 0) return -1;
        if (Checker.minLength(16, cardNumber) != 0) return -2;
        if (Checker.maxLenght(19, cardNumber) != 0) return -10;
        this.cardNumber = cardNumber;
        return 0;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public int setCardExpiry(String cardExpiry) {
        if (Checker.isNull(cardExpiry) != 0) return -1;
        this.cardExpiry = cardExpiry;
        return 0;
    }

    public String getCardCvv() {
        return cardCvv;
    }

    public int setCardCvv(String cardCvv) {
        if (Checker.isNull(cardCvv) != 0) return -1;
        if (cardCvv.length() < 3 || cardCvv.length() > 4) return -2;
        this.cardCvv = cardCvv;
        return 0;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "paymentId='" + paymentId + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardExpiry='" + cardExpiry + '\'' +
                ", cardCvv='" + cardCvv + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
