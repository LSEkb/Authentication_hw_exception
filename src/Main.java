import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;
import util.AuthenticationValidator;

public class Main {
    public static void main(String[] args) {

        String login = "0123456789AbCdEfGhIj";
        String password = "ABCDEfghij0123456789";
        String confirmPassword = "ABCDEfghij0123456789";

        try {
            AuthenticationValidator.checkAuthentication(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException ex) {
            System.out.println(ex.getMessage());
        }
    }
}