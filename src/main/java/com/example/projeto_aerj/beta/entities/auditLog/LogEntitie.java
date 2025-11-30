package com.example.projeto_aerj.beta.entities.auditLog;

import com.example.projeto_aerj.beta.models.Log;
import com.example.projeto_aerj.beta.models.Student;
import java.time.LocalDateTime;

public class LogEntitie {

    private int id;
    private String acao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private int studentId;
    private Student student;

    public LogEntitie() {
    }

    public LogEntitie(String acao, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, int studentId, Student student) {
        this.acao = acao;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.studentId = studentId;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Log toModel(){
        return new Log(
                this.getAcao(),
                this.getDataCriacao(),
                this.getDataAtualizacao(),
                this.getStudentId(),
                null
        );
    }

    public static LogEntitie fromModel(Log log){
        return new LogEntitie(
                log.getAcao(),
                log.getDataCriacao(),
                log.getDataAtualizacao(),
                log.getStudentId(),
                null
        );
    }
}
