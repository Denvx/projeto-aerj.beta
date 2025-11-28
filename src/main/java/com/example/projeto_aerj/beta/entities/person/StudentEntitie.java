package com.example.projeto_aerj.beta.entities.person;

import com.example.projeto_aerj.beta.enums.UsuarioRoleEnum;
import com.example.projeto_aerj.beta.enums.UsuarioSexoEnum;
import com.example.projeto_aerj.beta.enums.UsuarioStatusEnum;
import com.example.projeto_aerj.beta.models.Student;
import com.example.projeto_aerj.beta.valueObjects.CPFValue;
import com.example.projeto_aerj.beta.valueObjects.EmailValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class StudentEntitie {

    private int id;
    private String nome;
    private String sobrenome;
    private CPFValue cpf;
    private Date dataNascimento;
    private String telefone;
    private EmailValue email;
    private UsuarioSexoEnum sexo;
    private String apelido;
    private String senhaHash;
    private String matricula;
    private String curso;
    private String instituicao;
    private Boolean isAdmin;
    private UsuarioStatusEnum status;
    private UsuarioRoleEnum role;

    public StudentEntitie(int id, String nome, String sobrenome, CPFValue cpf, Date dataNascimento, String telefone, EmailValue email, UsuarioSexoEnum sexo, String apelido, String senhaHash, String matricula, String curso, String instituicao, Boolean isAdmin, UsuarioStatusEnum status, UsuarioRoleEnum role) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.sexo = sexo;
        this.apelido = apelido;
        this.senhaHash = senhaHash;
        this.matricula = matricula;
        this.curso = curso;
        this.instituicao = instituicao;
        this.isAdmin = isAdmin;
        this.status = status;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public CPFValue getCpf() {
        return cpf;
    }

    public void setCpf(CPFValue cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EmailValue getEmail() {
        return email;
    }

    public void setEmail(EmailValue email) {
        this.email = email;
    }

    public UsuarioSexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(UsuarioSexoEnum sexo) {
        this.sexo = sexo;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public UsuarioStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UsuarioStatusEnum status) {
        this.status = status;
    }

    public UsuarioRoleEnum getRole() {
        return role;
    }

    public void setRole(UsuarioRoleEnum role) {
        this.role = role;
    }

    public Student toStudent(){
        return new Student(
          this.getNome(),
          this.getSobrenome(),
          this.getCpf(),
          this.getDataNascimento(),
          this.getTelefone(),
          this.getEmail(),
          this.getSexo(),
          this.getApelido(),
          this.getSenhaHash(),
          this.getMatricula(),
          this.getCurso(),
          this.getInstituicao(),
          this.getAdmin(),
          this.getStatus(),
          this.getRole()
        );
    }

    public StudentEntitie fromStudent(Student model){
        return new StudentEntitie(
                model.getId(),
                model.getLastName(),
                model.getCpf(),
                model.getDataNascimento(),
                model.getTelephone(),
                model.getEmail(),
                model.getSexo(),
                model.getNickName(),
                model.getPassowrd(),
                model.getRegistration(),
                model.getCourse(),
                model.getInstitution(),
                model.getStatus(),
                model.getRole()
        );
    }
}
