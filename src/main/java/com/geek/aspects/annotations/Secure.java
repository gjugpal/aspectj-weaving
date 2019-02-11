package com.geek.aspects.annotations;

/**
 * Any methods which use this annotation will be excluded from the logging performed by aspectJ.
 * Ideal for methods which hold high security risk information such as credit card details and passwords.
 */
public @interface Secure {


}
