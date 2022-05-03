package com.crud.democrud.services;

import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioRolService {
    @Autowired
    UsuarioRolRepository usuarioRolRepository;

    public ArrayList<UsuarioRolModel> obtenerRoles(){
        return (ArrayList<UsuarioRolModel>) usuarioRolRepository.findAll();
    }

    public UsuarioRolModel guardarRol(UsuarioRolModel rol){
        return usuarioRolRepository.save(rol);
    }

    public Optional<UsuarioRolModel> obtenerRolPorId(Long idRol){
        return usuarioRolRepository.findById(idRol);
    }

    public UsuarioRolModel modificarRol(UsuarioRolModel rol, Long idRol){
        UsuarioRolModel rolAModificar = usuarioRolRepository.findById(idRol).get();
        rolAModificar.mapRol(rol);
        return usuarioRolRepository.save(rolAModificar);
    }

    public boolean eliminarRol(Long idRol){
        try {
            usuarioRolRepository.deleteById(idRol);
            return true;
        }catch(Exception err){
            return false;
        }
    }


}
