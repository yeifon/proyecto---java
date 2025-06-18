package com.mycompany.proyecto_1.security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * @author yeico
 */
public class Filtro implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest solicitud = (HttpServletRequest)request;
        HttpServletResponse respuesta = (HttpServletResponse) response;
        
        respuesta.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        respuesta.setHeader("Pragma", "no-cache");
        respuesta.setDateHeader("Expires", 0);
        
        //Valores pa validaciones
        HttpSession sesion = solicitud.getSession();
        String rutaSolicitud = solicitud.getRequestURI();
        String raiz = solicitud.getContextPath();
        
        //Validaciones
        //1. validar el estado de la sesion
        boolean validaSesion = ((sesion!=null) && (sesion.getAttribute("usuario")!=null));
        //2. validacion login
        boolean validaRutaLogin = (rutaSolicitud.equals(raiz + "/") || (rutaSolicitud.equals(raiz + "/login.xhtml")));
        //3. cargue de contenido estatico
        boolean validaRecurso = rutaSolicitud.contains("/Resources");
        
        if (validaSesion || validaRutaLogin || validaRecurso) {
            chain.doFilter(request, response);
        } else {
            respuesta.sendRedirect(raiz);
        }
        
    }

    @Override
    public void destroy() {
    }
    
}