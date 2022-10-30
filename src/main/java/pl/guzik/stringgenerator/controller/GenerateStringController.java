package pl.guzik.stringgenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.guzik.stringgenerator.domain.ResultsOfGenerate;
import pl.guzik.stringgenerator.domain.TasksOfGenerate;
import pl.guzik.stringgenerator.exception.WrongParametersException;
import pl.guzik.stringgenerator.generationParameters.GenerationParameters;
import pl.guzik.stringgenerator.service.GenerateStringService;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@RestController
@RequestMapping
public class GenerateStringController {

    private final GenerateStringService generateStringService;

    public GenerateStringController(GenerateStringService generateStringService) {
        this.generateStringService = generateStringService;
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Set<String> generateString(@RequestBody GenerationParameters generationParameters) throws FileNotFoundException, WrongParametersException {
        try {
            return generateStringService.generateString(generationParameters);
        } catch (WrongParametersException ex) {
            return Collections.singleton(ex.getMessage());

        }
    }


    @GetMapping(path = "/tasks")
    public Collection<TasksOfGenerate> getAllTasks() {
        return generateStringService.getAllTasks();

    }

    @GetMapping(path = "/results")
    public Collection<ResultsOfGenerate> getAllResults() {
        return generateStringService.getAllResults();
    }

    @GetMapping(path = "/threads")
    public int getNumberOfTreads() {
        return generateStringService.numberOfThreads();
    }
}

