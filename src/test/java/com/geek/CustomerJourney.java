package com.geek;

import com.geek.aspects.app.Payment;
import com.geek.aspects.app.Signin;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class CustomerJourney {


    private static Logger logger = LogManager.getLogger(CustomerJourney.class);

    @Test
    public void journeyTest() {

        logger.log(Level.INFO, "this is a test");
        logger.log(Level.INFO, "hello my name is gurdeep");
        final Signin signin = new Signin();
        signin.signin("gurdeep", "test");

        final Payment payment = new Payment();
        payment.clickPayByVisa();
        payment.enterPaymentDetails("1234567", "12/11", "433");
    }
}
