<p align="center">
  <img width="150" height="150" src="icon.jpeg">
</p>

<h1 align="center">Auto-Logger</h1>
<h3 align="center">Retrospective Logging using AspectJ</h3>

<div align="center">
  Using <code>AspectJ</code> for retrospective logging for an Automation Test Framework
</div>


<div align="center">
  <sub>Super small demo illustrating some of the stuff I've done around Test Automation :necktie:</sub>
</div>


###



#### Common Usage
Created a `Test Automation framework`, but forgot to add any meaningful logging?. This is a super small demonstration of how AspectJ can be used to retrospectively log meaningful information.


For example, take the below **test**:
```java
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
This is a *dummy* UI Automation test for a Page Object Model framework. Using AspectJ, we can log as **much** or as **little** information as we wish without having to actually add any log lines to the Page Objects *(Java methods)*. For example, here is what the logs looks like for the above test

##### Example Log
```bash
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

As you can see, the logs are verbose enough to clearly illustrate what the test did during execution (*this is where having well named Page Objects/Methods really helps)*

##### Custom @Annotations
You can create pointcuts on custom annotations. Say for example, there is certain data which you do not wish to log, e.g. **credit card details**, you can tag methods using custom annotations. In the above log, the payment details are replaced with ```*``` - ideal when running tests in Production. 
```java
@Secure
    public void enterPaymentDetails(String cardNumber, String expiryDate, String cvv) {
      //using the @Secure annotation to redact cardNumber, expiryDate and cvv value

    }
```
