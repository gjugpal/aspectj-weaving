package com.geek;

import com.geek.aspects.app.PaymentPage;
import com.geek.aspects.app.Homepage;
import org.junit.Test;

public class Showcase {

    @Test
    public void showcaseAspectJLogging() {

        new Homepage()
                .signin("gurdeep", "test")
                .getCustomerMessage();

        new PaymentPage()
                .clickPayByVisa()
                .enterPaymentDetails("1234567", "12/11", "433");
    }
}
