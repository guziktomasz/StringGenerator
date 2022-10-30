package pl.guzik.stringgenerator.service;

import org.junit.jupiter.api.Test;
import pl.guzik.stringgenerator.generationParameters.GenerationParameters;
import pl.guzik.stringgenerator.reposiotory.ResultsOfGenerateRepository;
import pl.guzik.stringgenerator.reposiotory.TasksOfGenerateRepository;

import static org.junit.jupiter.api.Assertions.*;

class GenerateStringServiceImplTest {

    @Test
    void shouldCalculatingNumberOfCombinationsWithResult120() {

        char[] listChar = {'a', 'b', 'c', 'd', 'e'};
        GenerationParameters generationParameters = new GenerationParameters(5,5, listChar,120);
        final TasksOfGenerateRepository repositoryTasks = null;

        final ResultsOfGenerateRepository repositoryResults = null;
        GenerateStringServiceImpl generateStringService = new GenerateStringServiceImpl(repositoryTasks, repositoryResults);
        long numberOfCombination = generateStringService.calculatingNumberOfCombinations(generationParameters);

        assertTrue(numberOfCombination == 120);
    }
}