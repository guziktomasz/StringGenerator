package pl.guzik.stringgenerator.exception;

public class WrongParametersException extends IllegalArgumentException{
    public WrongParametersException (String message){
        super("Nieprawidłowe parametry wejściowe. " + message);
    }
}
