package util;

import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public class AuthenticationValidator {
    public static void checkAuthentication(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        checkLogin(login);
        checkPassword(password);
        checkConfirmPassword(password, confirmPassword);
    }

    private static final Pattern REGEX = Pattern.compile("^[A-Za-z0-9_]{0,20}$");

    private static void checkLogin(String login) throws WrongLoginException {
        if (!login.matches(REGEX.pattern())) {
            throw new WrongLoginException("Логин должен содержать в себе только латинские буквы, цифры и знак подчеркивания, " +
                    "а также должен быть не более 20 символов");
        }
    }

    private static void checkPassword(String password) throws WrongPasswordException {
        if (!password.matches(REGEX.pattern())) {
            throw new WrongPasswordException("Пароль должен содержать в себе только латинские буквы, цифры и знак подчеркивания, " +
                    "а также должен быть не более 20 символов");
        }
    }

    private static void checkConfirmPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль и повторный пароль не совпадают");
        }
    }
}
