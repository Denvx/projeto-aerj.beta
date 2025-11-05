package com.example.projeto_aerj.beta.controllers;

import com.example.projeto_aerj.beta.facades.UsuarioFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {

    private final UsuarioFacade usuarioFacade; //precisa da facade


    public UsuarioController(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }
}
