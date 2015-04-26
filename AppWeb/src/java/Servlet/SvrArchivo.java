/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author PAUL
 */
public class SvrArchivo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    PrintWriter out;

    protected void metGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    protected void metPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException, Exception {

        subirArchivos(request, response);

    }

    public void subirArchivos(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, Exception {
        out = response.getWriter();
//Crear un temporal o crear un pequeño disco virtual 

        FileItemFactory fac = new DiskFileItemFactory();

        //cargar los archivos multipart
        ServletFileUpload up = new ServletFileUpload(fac);
        up.setFileSizeMax(10);
        //El item guarda los campos obtenidos en la vista
        List item = up.parseRequest(request);

        for (Object items : item) {
            FileItem fI = (FileItem) items;
            out.print(fI.getContentType() + " - ");//
            if (fI.getContentType().equals("image/jpeg") || fI.getContentType().equals("image/png")) {
                File archivo = new File("D:\\archivos", fI.getName());
                try {
                    fI.write(archivo);
                } catch (Exception ex) {
                    out.print("Hubo error:" + ex.getLocalizedMessage());
                }

                out.print("Subido Correctamente");
            } else {
                out.print("el archivo no es correcto");
            }
        }

//        for(int i=0;i<item.size();i++){
//            FileItem fI=(FileItem) item.get(i);
//        }
//        
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
            Logger.getLogger(SvrArchivo.class.getName()).log(Level.SEVERE, null, ex);
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
