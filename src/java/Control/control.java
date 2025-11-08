/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.alumno;
import bean.profesor;

@WebServlet(name = "control", urlPatterns = {"/Control"})
public class control extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcion = request.getParameter("boton");

        if (opcion.equals("Alta Alumno")) {
            alumno p = new alumno();
            p.setNombre(request.getParameter("nombre"));
            p.setGenero(request.getParameter("genero"));
            p.setEdad(Integer.parseInt(request.getParameter("edad")));
            p.guardar();
            response.sendRedirect("respuesta.jsp?respuesta=" + p.getRespuesta());
        }

        if (opcion.equals("Baja Alumno")) {
            alumno p = new alumno();
            p.setNombre(request.getParameter("nombre"));
            p.eliminar();
            response.sendRedirect("respuesta.jsp?respuesta=" + p.getRespuesta());
        }

        if (opcion.equals("Consultar Alumno")) {
            alumno p = new alumno();
            p.setNombre(request.getParameter("nombre"));
            p.consulta();
            response.sendRedirect("respuesta.jsp?respuesta=" + p.getRespuesta());
        }
    
    if (opcion.equals("consultar")) {
    alumno p = new alumno();
    p.setNombre(request.getParameter("nombre"));
    p.consulta(); // usar el método que ya tienes
    
    if (p.getRespuesta().contains("encontrada")) {
        // Si la persona existe, redirigir a formulario de modificación
        request.setAttribute("persona", p);
        request.getRequestDispatcher("modificar.jsp").forward(request, response);
    } else {
        // Si no existe, mostrar error
        response.sendRedirect("respuesta.jsp?respuesta=" + p.getRespuesta());
    }
}
    ///CONTROL PARA EL PROFESOR
     if (opcion.equals("Alta Profesor")) {
            profesor p = new profesor();
            p.setNombre(request.getParameter("nombre"));
            p.setGenero(request.getParameter("genero"));
            p.setEdad(Integer.parseInt(request.getParameter("edad")));
            p.guardar();
            response.sendRedirect("respuesta.jsp?respuesta=" + p.getRespuesta());
        }
     
     if (opcion.equals("Baja Profesor")) {
            profesor p = new profesor();
            p.setNombre(request.getParameter("nombre"));
            p.eliminar();
            response.sendRedirect("respuesta.jsp?respuesta=" + p.getRespuesta());
        }
     
      if (opcion.equals("Consultar Profesor")) {
            profesor p = new profesor();
            p.setNombre(request.getParameter("nombre"));
            p.consulta();
            response.sendRedirect("respuesta.jsp?respuesta=" + p.getRespuesta());
      }
    }
    
    @Override
    public String getServletInfo() {
        return "Controlador de altas, bajas y consultas de persona";
    }
}
