package domain;

public class DomainException extends RuntimeException{
    public DomainException(String message) {
        super(message);
    }

    public DomainException() {
        super();
    }
}
