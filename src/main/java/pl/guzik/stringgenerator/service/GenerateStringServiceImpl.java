package pl.guzik.stringgenerator.service;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.guzik.stringgenerator.domain.ResultsOfGenerate;
import pl.guzik.stringgenerator.domain.TasksOfGenerate;
import pl.guzik.stringgenerator.generationParameters.GenerationParameters;
import pl.guzik.stringgenerator.reposiotory.ResultsOfGenerateRepository;
import pl.guzik.stringgenerator.reposiotory.TasksOfGenerateRepository;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Component
//todo
//component adnotation to remove
public class GenerateStringServiceImpl implements GenerateStringService{

    private final TasksOfGenerateRepository repositoryTasks;
    private final ResultsOfGenerateRepository repositoryResults;

    private int numberOfTask = 0;
    public GenerateStringServiceImpl(TasksOfGenerateRepository repository, ResultsOfGenerateRepository repositoryResults) {
        this.repositoryTasks = repository;
        this.repositoryResults = repositoryResults;
    }

    /*private int minLength = 5;
    private int maxLength = 5;
    private char[] tableChar = {'a','b' ,'c','1','2'};
    private  int numberOfStrings = 5;*/

    @Override
    public Set<String> generateString(GenerationParameters generationParameters) throws FileNotFoundException {
        numberOfTask++;
        int i = 1;
        Set<String> resultSet = new HashSet<>();
        List<String> chars = new ArrayList<>();
        do {
            for (int l = 0; l < generationParameters.getListChar().length; l++) {
                chars.add(String.valueOf(generationParameters.getListChar()[l]));
            }

            String phrase = "";
            Random number = new Random();
            int stringLength = number.nextInt(generationParameters.getMaxLength()- generationParameters.getMinLength()+1)
                    + generationParameters.getMinLength();
            System.out.println("NR: " + i++);
            for (int j = 0; j < stringLength; j++) {
                Random position = new Random();
                int positionOfChar = position.nextInt(chars.size());
                phrase = phrase.concat(chars.get(positionOfChar));
                chars.remove(positionOfChar);
            }
            resultSet.add(phrase);
        } while (resultSet.size() < generationParameters.getNumberOfStrings());

        System.out.println(resultSet);
        System.out.println(resultSet.size());
        System.out.println(calculatingNumberOfCombinations(2,3));
        saveToFile((numberOfTask
                +"task_"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"))),
                resultSet);
        TasksOfGenerate tasksOfGenerate = new TasksOfGenerate(numberOfTask,
                generationParameters.getMinLength(),
                generationParameters.getMaxLength());
        saveTaskToDatabase(tasksOfGenerate);
        saveResultToDatabase(tasksOfGenerate, resultSet);
        return resultSet;
    }


    public int calculatingNumberOfCombinations (int minLength, int maxLength) {
        int result = 0;
        for (int i = minLength; i <= maxLength ; i++) {
            result = (int) (result + CombinatoricsUtils.factorial(i));
        }
        return result;
    }

    public void saveToFile (String fileName, Set<String> resultSetToSave) throws FileNotFoundException {
        PrintWriter save = new PrintWriter(fileName+".txt");
        Iterator<String> resultSetIterator = resultSetToSave.iterator();
        while (resultSetIterator.hasNext()){
            save.println(resultSetIterator.next());
        }
        save.close();

    }

    public void saveTaskToDatabase (TasksOfGenerate tasksOfGenerate){
        repositoryTasks.save(tasksOfGenerate);
    }

    public void saveResultToDatabase (TasksOfGenerate tasksOfGenerate, Set<String> resultSet) {
        Iterator<String> resultSetIterator = resultSet.iterator();
        while (resultSetIterator.hasNext()){
            ResultsOfGenerate newResult = new ResultsOfGenerate(tasksOfGenerate, resultSetIterator.next());
            repositoryResults.save(newResult);
        }
    }
}
