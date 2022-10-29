package pl.guzik.stringgenerator.reposiotory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.guzik.stringgenerator.domain.TasksOfGenerate;

public interface TasksOfGenerateRepository extends JpaRepository<TasksOfGenerate, String> {
}
