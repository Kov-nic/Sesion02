/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginForm;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet para manejar el formulario de inicio de sesión.
 * Redirige a "index.html" en una solicitud GET y procesa el inicio de sesión en una solicitud POST.
 * Autor: Nicolás Hernández
 */
@WebServlet("/login-form")

public class Formulario extends HttpServlet {
     // Constantes para el usuario y la contraseña válidos
    private static final String USUARIO_VALIDO = "Nicolas";
    private static final String CONTRASEÑA_VALIDA = "1234";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirige a "index.html" cuando se recibe una solicitud GET
        response.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtiene los parámetros del formulario de inicio de sesión
        String usuario = request.getParameter("username");
        String contraseña = request.getParameter("password");
        
// Verifica si el usuario y la contraseña son válidos
        if (USUARIO_VALIDO.equals(usuario) && CONTRASEÑA_VALIDA.equals(contraseña)) {
            // Redirige a "Bienvenido.jsp" si las credenciales son correctas
            request.getRequestDispatcher("Bienvenido.jsp").forward(request, response);
        } else {
             // Establece un atributo de error y redirige a "error.jsp" si las credenciales son incorrectas
            request.setAttribute("error", "Usuario o contraseña inválidos");
            request.setAttribute("errorExist", true);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
