package com.example.projeto_aerj.beta.applications;

import java.util.List;

public class UsuarioApplication { //precisa da interfaçe do repository

    private UsuarioRepository usuarioRepository;

    public UsuarioApplication(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioModel> buscarTodos(){
        return this.usuarioRepository.buscarTodos();
    }

    public UsuarioModel buscarPorId(int id){
        return this.usuarioRepository.buscarPorId(id);
    }

    public void adicionar(UsuarioModel usuarioModel){
        this.usuarioRepository.adicionar(usuarioModel);
    }

    public void excluir(int id){
        this.usuarioRepository.excluir(id);
    }

    public void atualizar(int id, UsuarioModel usuarioModel){
        this.usuarioRepository.atualizar(id, usuarioModel);
    }
}
