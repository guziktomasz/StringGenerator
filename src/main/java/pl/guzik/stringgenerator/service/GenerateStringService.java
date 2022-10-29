package pl.guzik.stringgenerator.service;

import pl.guzik.stringgenerator.generationParameters.GenerationParameters;

import java.io.FileNotFoundException;
import java.util.Set;

public interface GenerateStringService {

    Set<String> generateString (GenerationParameters generationParameters) throws FileNotFoundException;
}
