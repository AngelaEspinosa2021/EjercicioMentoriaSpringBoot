package com.crud.democrud.models;

import javax.persistence.*;

@Entity
@Table(name = "usuariorol")
public class UsuarioRolModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idRol;

    @Column(length = 15, nullable = false, unique = true)
    private String Rol;

    @ManyToOne(optional = false)
    @JoinColumn(name="idUsuario")
    private UsuarioModel usuario;

    public UsuarioRolModel() {

    }

    public UsuarioRolModel(String rol, UsuarioModel usuario) {
        Rol = rol;
        this.usuario = usuario;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public void mapRol(UsuarioRolModel rol){
        this.setIdRol(rol.idRol);
        this.setRol(rol.Rol);
        this.setUsuario(rol.usuario);
    }
}
