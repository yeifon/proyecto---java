/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.proyecto_1.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author yeico
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

    private String usuario;
    private String contrasenna;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String iniciarSesion() {
        if (usuario.equals("admin") && contrasenna.equals("123")) {
            return "inicio";
        } else {
            FacesContext Contexto = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "usuario y/o contraseña incorrecta", "MSG_ERROR");
            Contexto.addMessage(null, fm);
            return null;
        }
    }

    public Login() {
    }

}
