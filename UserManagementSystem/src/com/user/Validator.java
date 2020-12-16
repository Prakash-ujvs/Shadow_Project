package com.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    // digit + lower case char + upper case char + punctuation + symbol

    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[!@#$%^&*()]).{8,20})";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean passwordValid(final String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
    private static final String USER_NAME = "^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*$";
    private static final Pattern pattern1 = Pattern.compile(USER_NAME);
    
    public static boolean userNameValid(final String userName) {
    	Matcher matcher = pattern1.matcher(userName);
    	return matcher.matches();
    }
    
    private static final String PERSON_NAME = "^[a-zA-Z]+( [a-zA-Z]+)+$";
    private static final Pattern pattern2 = Pattern.compile(PERSON_NAME);
    
    public static boolean nameValid(final String name) {
    	Matcher matcher = pattern2.matcher(name);
    	return matcher.matches();
    }
    
    private static final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern4 = Pattern.compile(EMAIL_PATTERN);
    
    public static boolean emailValid(final String email) {
    	Matcher matcher = pattern4.matcher(email);
    	return matcher.matches();
    }
}