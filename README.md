# Logging using AspectJ
> Using AspectJ for retrospective logging in an Automation Test Framework


#### Problem
A automation framework is already in place however it lacks logging, making failing tests really difficult to troubleshoot.


#### Solution
Using AspectJ to retrospectively log information such as Class/Method calls and Input/Output parameters.

Let's take the below test as an example:
```
@Test
    public void showcaseAspectJLogging() {

        new Homepage()
                .signin("gurdeep", "test")
                .getCustomerMessage();

        new PaymentPage()
                .clickPayByVisa()
                .enterPaymentDetails("1234567", "12/11", "433");
    }
```
This is a Selenium based UI Automation test where the framework is designed using the Page Object Model. Using AspectJ we can log as much or as little information
we want without having to add log lines to our Page Objects / Methods. Here is an example log for the above test.

```
2019-02-13 12:23:55 INFO  Page Object: Homepage
2019-02-13 12:23:55 INFO  Method: signin(username=gurdeep,password=test)
2019-02-13 12:23:55 INFO  Page Object: Homepage
2019-02-13 12:23:55 INFO  Method: getCustomerMessage()
2019-02-13 12:23:55 INFO  Return Type: String
2019-02-13 12:23:55 INFO  Page Object: PaymentPage
2019-02-13 12:23:55 INFO  Method: clickPayByVisa()
2019-02-13 12:23:55 INFO  Page Object: PaymentPage
2019-02-13 12:23:55 INFO  Method: enterPaymentDetails(cardNumber=*******,expiryDate=*****,cvv=***)
```

As you can see, you now have a sight of the full journey and what interactions took place e.g. the test attempted to sign in with the username "gurdeep" and password "test".

If there is certain information which you do not want logging then you can create a custom annotation and add it to any method and the parameters will be automatically redacted. For example in the above log
I didn't want to log out the payment details as this test runs in Production. Therefore I created a new annotation called ```@Secure``` and tagged the ```enterPaymentDetails``` method.


```
@Secure
    public void enterPaymentDetails(String cardNumber, String expiryDate, String cvv) {
      //todo

    }
```

