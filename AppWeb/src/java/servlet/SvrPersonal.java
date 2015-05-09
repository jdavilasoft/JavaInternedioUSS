/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import Bean.BeanPersonal;
import Logica.LogicaPersonal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author javierdt
 */
public class SvrPersonal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String url;
    HttpSession session;
    LogicaPersonal lPersonal;
    
    protected void metPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        session = request.getSession();    
        url = request.getServletPath();
        if (url.equals("/regPersonal.html")) {
            registrarPersonal(request, response);
        }
    }
    
    protected void metGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        session = request.getSession();        
        url=request.getServletPath();

        if(url.equals("/listarPersonal.html")){
            listar(request,response);
        }
    }
    
    void registrarPersonal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        lPersonal = new LogicaPersonal();
        BeanPersonal bPersonal = new BeanPersonal();
        bPersonal.setNomPer(request.getParameter("txtNombre"));
        bPersonal.setApePer(request.getParameter("txtApellido"));
        bPersonal.setDirPer(request.getParameter("txtDireccion"));
        bPersonal.setEstadoPer("ALTA");
        bPersonal.setSexo(request.getParameter("cmbSexo"));
        bPersonal.setDni(Integer.parseInt(request.getParameter("txtDni")));
        lPersonal.insertar(bPersonal);
        response.sendRedirect("personal.jsp");
    }
    
    public void listar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        lPersonal = new LogicaPersonal();        
        request.setAttribute("listaPersonal", lPersonal.listarPersonal());
        this.getServletContext().getRequestDispatcher("/listaPersonal.jsp").forward(request, response);
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
            Logger.getLogger(SvrPersonal.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SvrPersonal.class.getName()).log(Level.SEVERE, null, ex);
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
