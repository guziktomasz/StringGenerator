package pl.guzik.stringgenerator.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ResultOfTheGeneration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int numberOfTask;

    private String generatedString;


    public ResultOfTheGeneration(int id, int numberOfTask, String generatedString) {
        this.id = id;
        this.numberOfTask = numberOfTask;
        this.generatedString = generatedString;
    }

    public ResultOfTheGeneration() {

    }
}
