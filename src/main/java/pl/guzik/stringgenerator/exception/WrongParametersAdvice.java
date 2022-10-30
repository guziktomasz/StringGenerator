package pl.guzik.stringgenerator.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class WrongParametersAdvice {

    @ResponseBody
    @ExceptionHandler(WrongParametersException.class)

    public String wrongParameterHandler (WrongParametersException ex) {
        return ex.getMessage();
    }
}
