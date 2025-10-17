package com.example.projeto_aerj.beta.entities.pessoas;

import com.example.projeto_aerj.beta.enums.PessoaSexoEnum;
import com.example.projeto_aerj.beta.enums.PessoaStatusEnum;
import com.example.projeto_aerj.beta.enums.StudentStatusEnum;
import com.example.projeto_aerj.beta.valueObjects.CPFValue;
import com.example.projeto_aerj.beta.valueObjects.EmailValue;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

public class Student extends Pessoa{
    private long id;
    // falta fk de pessoa
    private String registration;
    private String course;
    private String institution;
    private StudentStatusEnum studentStatus;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public Student(long idPerson, String name, Date dataNascimento, EmailValue emailValue, String telefone, CPFValue cpfValue, PessoaSexoEnum pessoaSexoEnum, PessoaStatusEnum pessoaStatusEnum, ZonedDateTime dataCriacao, ZonedDateTime dataAtualizacao, long id, String registration, String course, String institution, StudentStatusEnum studentStatus, LocalDateTime creationDate, LocalDateTime updateDate) {
        super(idPerson, name, dataNascimento, emailValue, telefone, cpfValue, pessoaSexoEnum, pessoaStatusEnum, dataCriacao, dataAtualizacao);
        this.id = id;
        this.registration = registration;
        this.course = course;
        this.institution = institution;
        this.studentStatus = studentStatus;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public StudentStatusEnum getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(StudentStatusEnum studentStatus) {
        this.studentStatus = studentStatus;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
