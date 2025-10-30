package com.example.projeto_aerj.beta.entities.pessoas;

import com.example.projeto_aerj.beta.enums.UsuarioRoleEnum;
import com.example.projeto_aerj.beta.enums.UsuarioSexoEnum;
import com.example.projeto_aerj.beta.enums.UsuarioStatusEnum;
import com.example.projeto_aerj.beta.valueObjects.CPFValue;
import com.example.projeto_aerj.beta.valueObjects.EmailValue;

import java.time.LocalDateTime;
import java.util.Date;

public class Motorista extends Usuario{

    private String CNH;
    private Date validadeCNH;

    public Motorista(int id, String name, CPFValue cpfValue, Date dataNascimento, String telefone, EmailValue emailValue, UsuarioSexoEnum usuarioSexoEnum, UsuarioRoleEnum usuarioRoleEnum, UsuarioStatusEnum usuarioStatusEnum, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, String CNH, Date validadeCNH) {
        super(id, name, cpfValue, dataNascimento, telefone, emailValue, usuarioSexoEnum, usuarioRoleEnum, usuarioStatusEnum, dataCriacao, dataAtualizacao);

        this.CNH = CNH;
        this.validadeCNH = validadeCNH;
    }

}
