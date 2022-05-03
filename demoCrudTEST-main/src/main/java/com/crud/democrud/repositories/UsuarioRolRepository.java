package com.crud.democrud.repositories;

import com.crud.democrud.models.UsuarioRolModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UsuarioRolRepository extends CrudRepository<UsuarioRolModel, Long> {
    public abstract ArrayList<UsuarioRolModel> findByName(String rol);

    public abstract Optional<UsuarioRolModel> obtenerRolPorId(Long idRol);

}
