package com.example.projeto_aerj.beta.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "warnings")
public class Warning {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String mensagem;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataEnvio;

    @Column(name = "student_id")
    private int studentId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

    public Warning() {
    }

    public Warning(int id, String titulo, String mensagem, LocalDateTime dataEnvio, int studentId, Student student) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataEnvio = dataEnvio;
        this.studentId = studentId;
        this.student = student;
    }

    @PrePersist
    protected void onCreate() {
        this.dataEnvio = LocalDateTime.now();
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
}