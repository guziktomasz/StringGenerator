package pl.guzik.stringgenerator.generationParameters;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GenerationParameters {

    private final int minLength;
    private final int maxLength;
    private final char[] listChar;
    private final int numberOfStrings;


    public GenerationParameters(int minLength, int maxLength, char[] listChar, int numberOfStrings) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.listChar = listChar;
        this.numberOfStrings = numberOfStrings;
    }
}
