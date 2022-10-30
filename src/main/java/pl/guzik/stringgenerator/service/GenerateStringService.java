package pl.guzik.stringgenerator.service;

import pl.guzik.stringgenerator.domain.ResultsOfGenerate;
import pl.guzik.stringgenerator.domain.TasksOfGenerate;
import pl.guzik.stringgenerator.generationParameters.GenerationParameters;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Set;

public interface GenerateStringService {

    Set<String> generateString (GenerationParameters generationParameters) throws FileNotFoundException;

    Collection<TasksOfGenerate> getAllTasks ();

    Collection<ResultsOfGenerate> getAllResults ();

    int numberOfThreads();

    long calculatingNumberOfCombinations(GenerationParameters generationParameters);

    void saveToFile(String fileName, Set<String> resultSetToSave) throws FileNotFoundException;
}
