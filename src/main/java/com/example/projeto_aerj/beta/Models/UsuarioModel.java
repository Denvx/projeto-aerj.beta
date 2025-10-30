package com.example.projeto_aerj.beta.Models;

import com.example.projeto_aerj.beta.enums.UsuarioRoleEnum;
import com.example.projeto_aerj.beta.enums.UsuarioSexoEnum;
import com.example.projeto_aerj.beta.enums.UsuarioStatusEnum;
import com.example.projeto_aerj.beta.valueObjects.CPFValue;
import com.example.projeto_aerj.beta.valueObjects.EmailValue;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "usuarioModel")
    private EnderecoModel endereco;

    @OneToOne(mappedBy = "usuarioModel")
    private LogModel log;

    private String name;
    private String firstName;

    @Embedded
    private CPFValue cpfValue;

    private LocalDate dataNascimento;

    private String telefone;

    @Embedded
    private EmailValue emailValue;

    @Enumerated(EnumType.STRING)
    @Column(name = "usuarioSexo", columnDefinition = "VARCHAR(20)")
    private UsuarioSexoEnum usuarioSexoEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "usuarioRole", columnDefinition = "VARCHAR(20)")
    private UsuarioRoleEnum usuarioRoleEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "usuarioStatus", columnDefinition = "VARCHAR(20)")
    private UsuarioStatusEnum usuarioStatusEnum;

    @Column(updatable = false)
    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    public UsuarioModel() {
    }

    public UsuarioModel(String name, String firstName, CPFValue cpfValue, LocalDate dataNascimento,
                        String telefone, EmailValue emailValue, UsuarioSexoEnum usuarioSexoEnum,
                        UsuarioRoleEnum usuarioRoleEnum, UsuarioStatusEnum usuarioStatusEnum) {
        this.name = name;
        this.firstName = firstName;
        this.cpfValue = cpfValue;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.emailValue = emailValue;
        this.usuarioSexoEnum = usuarioSexoEnum;
        this.usuarioRoleEnum = usuarioRoleEnum;
        this.usuarioStatusEnum = usuarioStatusEnum;
    }

    @PrePersist
    protected void onCreate() { // ✅ Use 'protected' em vez de 'public'
        this.dataCriacao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() { // ✅ Use 'protected' em vez de 'public'
        this.dataAtualizacao = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    public LogModel getLog() {
        return log;
    }

    public void setLog(LogModel log) {
        this.log = log;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public CPFValue getCpfValue() {
        return cpfValue;
    }

    public void setCpfValue(CPFValue cpfValue) {
        this.cpfValue = cpfValue;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EmailValue getEmailValue() {
        return emailValue;
    }

    public void setEmailValue(EmailValue emailValue) {
        this.emailValue = emailValue;
    }

    public UsuarioSexoEnum getUsuarioSexoEnum() {
        return usuarioSexoEnum;
    }

    public void setUsuarioSexoEnum(UsuarioSexoEnum usuarioSexoEnum) {
        this.usuarioSexoEnum = usuarioSexoEnum;
    }

    public UsuarioRoleEnum getUsuarioRoleEnum() {
        return usuarioRoleEnum;
    }

    public void setUsuarioRoleEnum(UsuarioRoleEnum usuarioRoleEnum) {
        this.usuarioRoleEnum = usuarioRoleEnum;
    }

    public UsuarioStatusEnum getUsuarioStatusEnum() {
        return usuarioStatusEnum;
    }

    public void setUsuarioStatusEnum(UsuarioStatusEnum usuarioStatusEnum) {
        this.usuarioStatusEnum = usuarioStatusEnum;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
}