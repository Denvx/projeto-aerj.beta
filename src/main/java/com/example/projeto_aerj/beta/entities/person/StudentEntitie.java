package com.example.projeto_aerj.beta.entities.person;

import com.example.projeto_aerj.beta.enums.UsuarioRoleEnum;
import com.example.projeto_aerj.beta.enums.UsuarioSexoEnum;
import com.example.projeto_aerj.beta.enums.UsuarioStatusEnum;
import com.example.projeto_aerj.beta.models.Address;
import com.example.projeto_aerj.beta.models.Log;
import com.example.projeto_aerj.beta.models.Student;
import com.example.projeto_aerj.beta.valueObjects.CPFValue;
import com.example.projeto_aerj.beta.valueObjects.EmailValue;

import java.util.Date;
import java.util.List;

public class StudentEntitie {

    private int id;
    private String name;
    private String lastName;
    private CPFValue cpf;
    private Date dataNascimento;
    private String telephone;
    private EmailValue email;
    private UsuarioSexoEnum sexo;
    private String nickName;
    private String passowrd;
    private String registration;
    private String course;
    private String institution;
    private UsuarioStatusEnum status;
    private UsuarioRoleEnum role;
    private List<Address> address;
    private List<Log> log;

    public StudentEntitie() {
    }

    public StudentEntitie(int id, String name, String lastName, CPFValue cpf, Date dataNascimento, String telephone, EmailValue email, UsuarioSexoEnum sexo, String nickName, String passowrd, String registration, String course, String institution, UsuarioStatusEnum status, UsuarioRoleEnum role, List<Address> address, List<Log> log) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telephone = telephone;
        this.email = email;
        this.sexo = sexo;
        this.nickName = nickName;
        this.passowrd = passowrd;
        this.registration = registration;
        this.course = course;
        this.institution = institution;
        this.status = status;
        this.role = role;
        this.address = address;
        this.log = log;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
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

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Log> getLog() {
        return log;
    }

    public void setLog(List<Log> log) {
        this.log = log;
    }

    public Student toModel() {
        return new Student(
                this.getName(),
                this.getLastName(),
                this.getCpf(),
                this.getDataNascimento(),
                this.getTelephone(),
                this.getEmail(),
                this.getSexo(),
                this.getNickName(),
                this.getPassowrd(),
                this.getRegistration(),
                this.getCourse(),
                this.getInstitution(),
                this.getStatus(),
                this.getRole(),
                this.getAddress(),
                this.getLog()

        );
    }

    public static StudentEntitie fromModel(Student s) {
        return new StudentEntitie(
                s.getId(),
                s.getName(),
                s.getLastName(),
                s.getCpf(),
                s.getDataNascimento(),
                s.getTelephone(),
                s.getEmail(),
                s.getSexo(),
                s.getNickName(),
                s.getPassowrd(),
                s.getRegistration(),
                s.getCourse(),
                s.getInstitution(),
                s.getStatus(),
                s.getRole(),
                s.getAddress(),
                s.getLog()
        );
    }
}