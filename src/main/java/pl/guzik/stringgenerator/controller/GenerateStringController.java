package pl.guzik.stringgenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.guzik.stringgenerator.domain.ResultOfTheGeneration;
import pl.guzik.stringgenerator.generationParameters.GenerationParameters;
import pl.guzik.stringgenerator.service.GenerateStringService;

import java.io.FileNotFoundException;
import java.util.Set;

@RestController
@RequestMapping
public class GenerateStringController {

    private final GenerateStringService generateStringService;

    public GenerateStringController(GenerateStringService generateStringService) {
        this.generateStringService = generateStringService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Set<String> generateString(@RequestBody GenerationParameters generationParameters) throws FileNotFoundException {
        return generateStringService.generateString(generationParameters);
    }
}
