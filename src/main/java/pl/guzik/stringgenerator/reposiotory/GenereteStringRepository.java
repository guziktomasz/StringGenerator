package pl.guzik.stringgenerator.reposiotory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.guzik.stringgenerator.domain.ResultOfTheGeneration;

public interface GenereteStringRepository extends JpaRepository<ResultOfTheGeneration, String> {
}
