package pl.guzik.stringgenerator.service;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.guzik.stringgenerator.domain.ResultsOfGenerate;
import pl.guzik.stringgenerator.domain.TasksOfGenerate;
import pl.guzik.stringgenerator.exception.WrongParametersException;
import pl.guzik.stringgenerator.generationParameters.GenerationParameters;
import pl.guzik.stringgenerator.reposiotory.ResultsOfGenerateRepository;
import pl.guzik.stringgenerator.reposiotory.TasksOfGenerateRepository;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class GenerateStringServiceImpl implements GenerateStringService{

    private final TasksOfGenerateRepository repositoryTasks;
    private final ResultsOfGenerateRepository repositoryResults;

    private int numberOfTask = 0;
    private int numberOfThread =0;
    public GenerateStringServiceImpl(TasksOfGenerateRepository repository, ResultsOfGenerateRepository repositoryResults) {
        this.repositoryTasks = repository;
        this.repositoryResults = repositoryResults;
    }


    @Override
    public Set<String> generateString(GenerationParameters generationParameters) throws FileNotFoundException {

            changeException(generationParameters);
            numberOfTask++;
            numberOfThread++;
            int i = 1;
            Set<String> resultSet = new HashSet<>();
            List<String> chars = new ArrayList<>();
            do {
                for (int l = 0; l < generationParameters.getListChar().length; l++) {
                    chars.add(String.valueOf(generationParameters.getListChar()[l]));
                }

                String phrase = "";
                Random number = new Random();
                int stringLength = number.nextInt(generationParameters.getMaxLength() - generationParameters.getMinLength() + 1)
                        + generationParameters.getMinLength();
                System.out.println(numberOfThread + "NR: " + i++);
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
            saveToFile((numberOfTask
                            + "task_"
                            + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"))),
                    resultSet);
            TasksOfGenerate tasksOfGenerate = new TasksOfGenerate(numberOfTask,
                    generationParameters.getMinLength(),
                    generationParameters.getMaxLength());
            saveTaskToDatabase(tasksOfGenerate);
            saveResultToDatabase(tasksOfGenerate, resultSet);
            numberOfThread--;
            return resultSet;
        }
//    }

    public void changeException(GenerationParameters generationParameters){
        if (generationParameters.getMaxLength() < generationParameters.getMinLength() ) {

            throw new WrongParametersException("Długość wymaganego ciągu znakowego min nie może byc wieksza od długości max");

        } else if (generationParameters.getListChar().length < generationParameters.getMaxLength()) {

            throw new WrongParametersException("Podana liczba znaków nie może być mniejsze niż oczekiwany max ciąg znaków");
        } else if (calculatingNumberOfCombinations(generationParameters)
                < generationParameters.getNumberOfStrings()) {

            throw new WrongParametersException("Dla podanych długości znaków nie jest możliwe utworzenie wskazanej ilości unikatowych ciągów znaków");

        }
    }

    @Override
    public Collection<TasksOfGenerate> getAllTasks() {
        return repositoryTasks.findAll();
    }

    @Override
    public Collection<ResultsOfGenerate> getAllResults() {
        return repositoryResults.findAll();
    }

    @Override
    public int numberOfThreads() {
        return numberOfThread;
    }


    @Override
    public long calculatingNumberOfCombinations(GenerationParameters generationParameters) {
        long result = 0;
        long a = 1;
        for (int i = generationParameters.getMinLength(); i <= generationParameters.getMaxLength() ; i++) {

            result = (result + (CombinatoricsUtils.factorial(generationParameters.getListChar().length) /
                    CombinatoricsUtils.factorial(generationParameters.getListChar().length - i)));
        }
        return result;
    }

    @Override
    public void saveToFile(String fileName, Set<String> resultSetToSave) throws FileNotFoundException {
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
