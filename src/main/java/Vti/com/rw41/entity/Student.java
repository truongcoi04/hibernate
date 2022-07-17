package Vti.com.rw41.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Student {
    @Id
    @GenericGenerator(name = "StudentIdGenerator",
            strategy = "Vti.com.rw41.entity.generator.StudentIdGenerator")
    @GeneratedValue(generator = "StudentIdGenerator")
    private String id; //SVYYYYxxxxx -> SV202200001,SV202200002,SV202200003
    private String name;
}
