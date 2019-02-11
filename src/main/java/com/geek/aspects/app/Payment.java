package com.geek.aspects.app;

import com.geek.aspects.annotations.Secure;

public class Payment {

    public void clickPayByVisa() {

    }

    @Secure
    public void enterPaymentDetails(String cardNumber, String expiryDate, String cvv) {

    }

}
