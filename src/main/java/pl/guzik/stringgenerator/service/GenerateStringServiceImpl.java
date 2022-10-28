package pl.guzik.stringgenerator.service;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.guzik.stringgenerator.domain.ResultOfTheGeneration;
import pl.guzik.stringgenerator.generationParameters.GenerationParameters;
import pl.guzik.stringgenerator.reposiotory.GenereteStringRepository;

import java.util.*;

@Service
@Component
//todo
//component adnotation to remove
public class GenerateStringServiceImpl implements GenerateStringService{

    private final GenereteStringRepository repository;

    public GenerateStringServiceImpl(GenereteStringRepository repository) {
        this.repository = repository;
    }


    @Override
    public ResultOfTheGeneration generateString(GenerationParameters generationParameters) {
        System.out.println("Wydruk z generateString");
        return null;
    }

    private int minLength = 5;
    private int maxLength = 5;
        private char[] tableChar = {'a','b' ,'c','1','2'};
    private  int numberOfStrings = 100;
    @Bean
    public ResultOfTheGeneration generateStringTest() {
        int i = 1;
        Set<String> resultSet = new HashSet<>();
        do {
            List<String> chars = new ArrayList<>();
            for (int l = 0; l < tableChar.length; l++) {
                chars.add(String.valueOf(tableChar[l]));
            }

            String phrase = "";
            Random number = new Random();
            int stringLength = number.nextInt(maxLength-minLength+1) + minLength;
            System.out.println("NR: " + i++);
            for (int j = 0; j < stringLength; j++) {
                Random position = new Random();
                int positionOfChar = position.nextInt(chars.size());
                phrase = phrase.concat(chars.get(positionOfChar));
                chars.remove(positionOfChar);
            }
            resultSet.add(phrase);
        } while (resultSet.size() < numberOfStrings);

        System.out.println(resultSet);
        System.out.println(resultSet.size());
        System.out.println(calculatingNumberOfCombinations(2,3));

        return null;
    }

    public int calculatingNumberOfCombinations (int minLength, int maxLength) {
        int result = 0;
        for (int i = minLength; i <= maxLength ; i++) {
            result = (int) (result + CombinatoricsUtils.factorial(i));
        }
        return result;
    }
}
