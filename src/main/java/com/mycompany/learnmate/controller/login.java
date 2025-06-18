package com.mycompany.learnmate.controller;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * @author yeico
 */
@Named(value = "login")
@SessionScoped
public class login implements Serializable {

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
            HttpSession sesion= (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            sesion.setAttribute("usuario", usuario);
            return "inicio?faces-redirect=true";
        } else {
            FacesContext Contexto = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "usuario y/o contraseña incorrecta", "MSG_ERROR");
            Contexto.addMessage(null, fm);
            return null;
        }
    }

    public login() {
    }
    
}
