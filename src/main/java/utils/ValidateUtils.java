package utils;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String NAME_REGEX = "^([A-Z]+[a-z]*[ ]?)+$";
    public static final String PHONE_REGEX = "^[0][1-9][0-9]{8,9}$";
    public static final String ADDRESS_REGEX = "^([^. ][.]*[ ]?)+$";
    public static final String EMAIL_REGEX = "^[A-Za-z0-9._]+@[A-Za-z0-9.]+\\.[A-Za-z]{2,4}$";


    public static boolean isNameValid(String name) {
        return Pattern.compile(NAME_REGEX).matcher(name).matches();
    }

    public static boolean isPhoneValid(String number) {
        return Pattern.compile(PHONE_REGEX).matcher(number).matches();
    }

    public static boolean isAddressValid(String address){
        return Pattern.compile(ADDRESS_REGEX).matcher(address).matches();
    }
    public static boolean isEmailValid(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }
}
