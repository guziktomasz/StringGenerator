package pl.guzik.stringgenerator.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.guzik.stringgenerator.domain.ResultOfTheGeneration;
import pl.guzik.stringgenerator.generationParameters.GenerationParameters;
import pl.guzik.stringgenerator.reposiotory.GenereteStringRepository;

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

        return null;
    }
}
