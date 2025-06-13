package ma.emsi.ebankingbackend.exceptions;

public class BalanceNotSufficientException extends Exception {
    public BalanceNotSufficientException(String notEnoughBalance) {
        super(notEnoughBalance);
    }
}
