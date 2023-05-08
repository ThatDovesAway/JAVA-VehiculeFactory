import java.io.Serial;

public class DoorsException extends Exception {
    @Serial
    private static final long serialVersionUID =1L;

    public DoorsException(String s) {
        super("Too much Doors for this Vehicule !!");
    }
}
