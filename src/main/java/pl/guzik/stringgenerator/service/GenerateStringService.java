package pl.guzik.stringgenerator.service;

import pl.guzik.stringgenerator.domain.ResultOfTheGeneration;
import pl.guzik.stringgenerator.generationParameters.GenerationParameters;

public interface GenerateStringService {

    ResultOfTheGeneration generateString (GenerationParameters generationParameters);
}
