package personal.queiroz.felipe.desafioJava.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BusinessRuleException extends RuntimeException {

    public BusinessRuleException(String s) {
        super(s);
    }

}
