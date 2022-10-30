package pl.guzik.stringgenerator.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ResultsOfGenerate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "taskNumber")
    private TasksOfGenerate tasksOfGenerate;

    private String generatedString;

    public ResultsOfGenerate(TasksOfGenerate tasksOfGenerate, String generatedString) {
        this.tasksOfGenerate = tasksOfGenerate;
        this.generatedString = generatedString;
    }

    public ResultsOfGenerate() {
    }
}
