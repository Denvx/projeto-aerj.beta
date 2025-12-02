package com.example.projeto_aerj.beta.entities.notification;

import com.example.projeto_aerj.beta.models.Student;
import com.example.projeto_aerj.beta.models.Warning;

import java.time.LocalDateTime;

public class WarningsEntitie {

    private int id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataEnvio;
    private int studentId;
    private Student student;

    public WarningsEntitie() {
    }

    public WarningsEntitie(int id,String titulo, String mensagem, LocalDateTime dataEnvio, int studentId, Student student) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataEnvio = dataEnvio;
        this.studentId = studentId;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
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

    public Warning toModel(){
        return new Warning(
                this.getId(),
                this.getTitulo(),
                this.getMensagem(),
                this.getDataEnvio(),
                this.getStudentId(),
                null
        );
    }

    public static WarningsEntitie fromModel(Warning w){
        return new WarningsEntitie(
                w.getId(),
                w.getTitulo(),
                w.getMensagem(),
                w.getDataEnvio(),
                w.getStudentId(),
                null
        );
    }
}