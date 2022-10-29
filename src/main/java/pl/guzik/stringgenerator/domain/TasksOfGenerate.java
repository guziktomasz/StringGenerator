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
public class TasksOfGenerate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int taskNumber;

    private int minLength;

    private int maxLength;

    public TasksOfGenerate(int taskNumber, int minLength, int maxLength) {
        this.taskNumber = taskNumber;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public TasksOfGenerate() {

    }
}
