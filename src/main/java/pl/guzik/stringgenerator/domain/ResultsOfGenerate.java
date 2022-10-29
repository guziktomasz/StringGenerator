package pl.guzik.stringgenerator.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ResultsOfGenerate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int taskNumber;

    private String generatedString;

    public ResultsOfGenerate(int taskNumber, String generatedString) {
        this.taskNumber = taskNumber;
        this.generatedString = generatedString;
    }

    public ResultsOfGenerate() {
    }
}
