package com.crud.democrud.controllers;


import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.services.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/usuariorol")
public class UsuarioRolController {
    @Autowired
    UsuarioRolService usuarioRolService;

    @GetMapping()
    public ArrayList<UsuarioRolModel> obtenerRoles(){
        return usuarioRolService.obtenerRoles();
    }

    @PostMapping()
    public UsuarioRolModel guardarRol(@RequestBody UsuarioRolModel rol){
        return this.usuarioRolService.guardarRol(rol);
    }

    @GetMapping(path="/editar/{idRol}")
    public UsuarioRolModel modificarRol(@PathVariable("idRol") Long idRol, UsuarioRolModel rol){
        return this.usuarioRolService.modificarRol(rol, idRol);
    }

    @GetMapping(path="/{/idRol}")
    public Optional<UsuarioRolModel> obtenerRolPorId(@PathVariable("idRol") Long idRol){
        return this.usuarioRolService.obtenerRolPorId(idRol);
    }

    @DeleteMapping(path="/{id}")
    public String eliminarPorIdRol(@PathVariable("idRol") Long idRol){
        boolean ok = this.usuarioRolService.eliminarRol(idRol);
        if(ok){
            return "Se eliminó el usuario con id" + idRol;
        }else {
            return "No pudo eliminar el usuario con id" + idRol;
        }
    }
}
