package pl.guzik.stringgenerator.reposiotory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.guzik.stringgenerator.domain.ResultsOfGenerate;
import pl.guzik.stringgenerator.domain.TasksOfGenerate;

import java.util.Optional;

public interface ResultsOfGenerateRepository extends JpaRepository<ResultsOfGenerate, String> {


}
