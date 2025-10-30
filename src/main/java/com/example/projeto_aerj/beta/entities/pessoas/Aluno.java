package com.example.projeto_aerj.beta.entities.pessoas;

import com.example.projeto_aerj.beta.enums.UsuarioRoleEnum;
import com.example.projeto_aerj.beta.enums.UsuarioSexoEnum;
import com.example.projeto_aerj.beta.enums.UsuarioStatusEnum;
import com.example.projeto_aerj.beta.valueObjects.CPFValue;
import com.example.projeto_aerj.beta.valueObjects.EmailValue;

import java.time.LocalDateTime;
import java.util.Date;

public class Aluno extends Usuario{

    private String matricula;
    private String curso;
    private String instituicao;

    public Aluno(long id, String name, CPFValue cpfValue, Date dataNascimento, String telefone, EmailValue emailValue, UsuarioSexoEnum usuarioSexoEnum, UsuarioRoleEnum usuarioRoleEnum, UsuarioStatusEnum usuarioStatusEnum, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, String matricula, String curso, String instituicao) {
        super(id, name, cpfValue, dataNascimento, telefone, emailValue, usuarioSexoEnum, usuarioRoleEnum, usuarioStatusEnum, dataCriacao, dataAtualizacao);

        this.matricula = matricula;
        this.curso = curso;
        this.instituicao = instituicao;
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
}
