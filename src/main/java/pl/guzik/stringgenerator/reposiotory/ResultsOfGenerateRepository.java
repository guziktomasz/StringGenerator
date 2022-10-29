package pl.guzik.stringgenerator.reposiotory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.guzik.stringgenerator.domain.ResultsOfGenerate;

public interface ResultsOfGenerateRepository extends JpaRepository<ResultsOfGenerate, String> {
}
