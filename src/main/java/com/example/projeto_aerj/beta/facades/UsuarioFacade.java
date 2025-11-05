package com.example.projeto_aerj.beta.facades;

import com.example.projeto_aerj.beta.applications.UsuarioApplication;
import com.example.projeto_aerj.beta.models.UsuarioModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioFacade { //precisa da application
    private final UsuarioApplication usuarioApplication;

    public UsuarioFacade(UsuarioApplication usuarioApplication) {
        this.usuarioApplication = usuarioApplication;
    }

    public List<UsuarioModel> buscarTodos() {
        return this.usuarioApplication.buscarTodos();
    }

    public UsuarioModel buscarPorId(int id) {
        return this.usuarioApplication.buscarPorId(id);
    }

    public void adicionar(UsuarioModel usuarioModel) {
        this.usuarioApplication.adicionar(usuarioModel);
    }

    public void excluir(int id) {
        this.usuarioApplication.excluir(id);
    }

    public void atualizar(int id, UsuarioModel usuarioModel){
        this.usuarioApplication.atualizar(id, usuarioModel);
    }

}
