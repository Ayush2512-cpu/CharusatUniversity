package com.example.CharusatUniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;



@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@Accessors(chain = true)

@Entity
@Table(name = "charusatUniversity")
@EntityListeners(AuditingEntityListener.class)
public class CharusatUniversity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String departmentName;
    private String departmentHod;
    private String departmentPrincipal;
    private int noOfFaculties;
    private int noOfStudents;
    private int noOfSem;
    private int noOfSubjects;


    public CharusatUniversity(int id, String departmentName, String departmentHod, String departmentPrincipal, int noOfFaculties, int noOfStudents, int noOfSem, int noOfSubjects) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentHod = departmentHod;
        this.departmentPrincipal = departmentPrincipal;
        this.noOfFaculties = noOfFaculties;
        this.noOfStudents = noOfStudents;
        this.noOfSem = noOfSem;
        this.noOfSubjects = noOfSubjects;

    }

    public CharusatUniversity() {

    }


    @Override
    public String toString() {
        return "CharusatUniversity{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", departmentHod='" + departmentHod + '\'' +
                ", departmentPrincipal='" + departmentPrincipal + '\'' +
                ", noOfFaculties=" + noOfFaculties +
                ", noOfStudents=" + noOfStudents +
                ", noOfSem=" + noOfSem +
                ", noOfSubjects=" + noOfSubjects +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentHod() {
        return departmentHod;
    }

    public void setDepartmentHod(String departmentHod) {
        this.departmentHod = departmentHod;
    }

    public String getDepartmentPrincipal() {
        return departmentPrincipal;
    }

    public void setDepartmentPrincipal(String departmentPrincipal) {
        this.departmentPrincipal = departmentPrincipal;
    }

    public int getNoOfFaculties() {
        return noOfFaculties;
    }

    public void setNoOfFaculties(int noOfFaculties) {
        this.noOfFaculties = noOfFaculties;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public int getNoOfSem() {
        return noOfSem;
    }

    public void setNoOfSem(int noOfSem) {
        this.noOfSem = noOfSem;
    }

    public int getNoOfSubjects() {
        return noOfSubjects;
    }

    public void setNoOfSubjects(int noOfSubjects) {
        this.noOfSubjects = noOfSubjects;
    }
}




