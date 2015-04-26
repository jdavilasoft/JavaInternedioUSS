package Servlet;

import AccesoDatos.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;

public class reporteJava extends HttpServlet {

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
            throws ServletException, IOException, Exception {

        String url = request.getServletPath();
        if (url.equals("/reporteJava.html")) {
            Conexion conn = new Conexion("org.postgresql.Driver", "jdbc:postgresql://", "127.0.0.1", "5432", "javaintermedio", "postgres", "123456");
            conn.Conectar();

            try {
                //Encabezado y nombre del reporte
//                response.setHeader("Content-Disposition", "attachment; filename='reporteArea.pdf';");
//                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename='reporteArea.docx';");
                response.setContentType("application/docx");

                //Salida con el nombre del reporte
                ServletOutputStream salida = response.getOutputStream();

                //Obtener la ruta del diseño del reporte, para luego compilar
                JasperReport reporte = JasperCompileManager.compileReport("D:\\_USS_\\Cursos CIS\\JD_Intermedio\\Practices\\2015-03-21\\APLICATIONWEB\\AppWeb\\web\\WEB-INF\\reporteJava.jrxml");

                //Obtiene la ruta y la conexion de la bd
                JasperPrint imprimir = JasperFillManager.fillReport(reporte, null, conn.getCnx());

                //exportar el reporte
                //JRExporter exportar = new JRPdfExporter();
                JRExporter exportar = new JRDocxExporter();
                exportar.setParameter(JRExporterParameter.JASPER_PRINT, imprimir);
                exportar.setParameter(JRExporterParameter.OUTPUT_STREAM, salida);
                exportar.exportReport();
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    protected void metPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
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
            Logger.getLogger(reporteJava.class.getName()).log(Level.SEVERE, null, ex);
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
        metPost(request, response);
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
