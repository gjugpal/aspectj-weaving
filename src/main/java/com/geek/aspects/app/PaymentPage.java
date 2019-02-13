package com.geek.aspects.app;

import com.geek.aspects.annotations.Secure;

public class PaymentPage {

    public PaymentPage clickPayByVisa() {
        return this;
    }

    @Secure
    public void enterPaymentDetails(String cardNumber, String expiryDate, String cvv) {

    }

}
