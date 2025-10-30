package com.example.projeto_aerj.beta.entities.pessoas;

import com.example.projeto_aerj.beta.enums.UsuarioRoleEnum;
import com.example.projeto_aerj.beta.enums.UsuarioSexoEnum;
import com.example.projeto_aerj.beta.enums.UsuarioStatusEnum;
import com.example.projeto_aerj.beta.valueObjects.CPFValue;
import com.example.projeto_aerj.beta.valueObjects.EmailValue;

import java.time.LocalDateTime;
import java.util.Date;

public class Administrador extends Usuario {

    private String cargo;

    public Administrador(long id, String name, CPFValue cpfValue, Date dataNascimento, String telefone, EmailValue emailValue, UsuarioSexoEnum usuarioSexoEnum, UsuarioRoleEnum usuarioRoleEnum, UsuarioStatusEnum usuarioStatusEnum, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, String cargo) {
        super(id, name, cpfValue, dataNascimento, telefone, emailValue, usuarioSexoEnum, usuarioRoleEnum, usuarioStatusEnum, dataCriacao, dataAtualizacao);

        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
