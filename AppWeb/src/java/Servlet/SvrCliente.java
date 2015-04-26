/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.BeanCliente;
import Logica.LogicaCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumno
 */
public class SvrCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String varUrl;
    PrintWriter out;
    HttpSession session;
    LogicaCliente lCliente;

    protected void metGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        session=request.getSession();
        out = response.getWriter();
        varUrl = request.getServletPath();

        if (varUrl.equals("/listarCliente.cl")) {
            listar(request, response);
        }
    }

    protected void metPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        varUrl = request.getServletPath();

        if (varUrl.equals("/registrarCliente.cl")) {
            registrar(request, response);
        }
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        lCliente=new LogicaCliente();
        request.setAttribute("listaCliente", lCliente.listarCliente() );
        this.getServletContext().getRequestDispatcher("/listaCliente.jsp").forward(request, response);
        
        
    }
    
    
    public void registrar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LogicaCliente lCliente = new LogicaCliente();
        BeanCliente bCliente = new BeanCliente();
        bCliente.setNomCli(request.getParameter("txtNombre"));
        bCliente.setApeCli(request.getParameter("txtApellido"));
        bCliente.setCelCli(request.getParameter("txtCelular"));
        bCliente.setDirCli(request.getParameter("txtDireccion"));
        bCliente.setDniCli(Integer.parseInt(request.getParameter("txtDni")));
        bCliente.setSexo(request.getParameter("cmbSexo"));
        bCliente.setTipoCli(request.getParameter("cmbTipo"));
        bCliente.setEmailCli(request.getParameter("txtEmail"));
        lCliente.insertar(bCliente);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            metGet(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SvrCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            metPost(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SvrCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
