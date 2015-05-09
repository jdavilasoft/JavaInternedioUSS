package servlet;

import Bean.BeanUsuario;
import Logica.LogicaUsuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SvrUsuario extends HttpServlet {

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
    LogicaUsuario lUsuario;
    BeanUsuario bUsuario;
    HttpSession session;

    protected void metPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        url = request.getServletPath();
        if (url.equals("/logueo.html")) {
            verificarUsuario(request, response);
        }
    }

    protected void metGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void verificarUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
        lUsuario = new LogicaUsuario();
        bUsuario = new BeanUsuario();
        session = request.getSession();
        bUsuario.setUserLogin(request.getParameter("txtUsuario"));
        bUsuario.setContrasenia(request.getParameter("txtPass"));
        BeanUsuario b = lUsuario.loguearse(bUsuario);
        if(b != null) {
            session.setAttribute("usuarioSession", b.getUserLogin());
            this.getServletContext().getRequestDispatcher("/inicio.jsp").forward(request, response);
        } else {
            this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
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
        metGet(request, response);
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
            Logger.getLogger(SvrUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
