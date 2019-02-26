/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author drogaria rio branco
 */
@WebServlet(urlPatterns = {"/juroscompostos.html"})
public class JurosCompostos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet - Calculo de Juros Compostos </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet - Calculo de Juros Compostos " + request.getContextPath() + "</h1>");
            
            out.println("<form>");
            out.println("Capital: <input type='text' name='capital'/>");
            out.println("Juros ao mês: <input type='text' name='juros'/>");
            out.println("Tempo: <input type='text' name='tempo'/>");
            out.println("<input type='submit' value='Calcular'>");
            out.println("</form>");
                                                          
                                   
                    double capital = Double.parseDouble(request.getParameter("capital"));
                    double juros = Double.parseDouble(request.getParameter("juros"));
                    double tempo = Double.parseDouble(request.getParameter("tempo"));
                    double jurosMes = juros /100;
                    if(capital != 0 && tempo!=0){                            
                       
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<th> Capital </th>");
                    out.println("<th> Numero do mes </th>");
                    out.println("</tr");
                    //  MOntante = capital * (1+juros) ^ tempo
                    for (double tempoMes=1; tempoMes<= tempo; tempoMes++){
                    out.println("<tr>");
                    capital += capital * jurosMes;                                      
                    out.println("<td> R$"+  capital + "</td></hr>");
                    out.println("<td>" + tempoMes + "</td></hr>");
                    }               
                    out.println("</hr>");
                    out.println("</tr>");
                    out.println("</td>");
                    out.println("</table>");
                    }else{
                        out.println("<h1>VALORES INVALIDOS</h1>");
                    }
                    
                                       
                                   
                           
                      
            out.println("<hr>");
            out.println("<h3><a href='index.html'> VOLTAR</h3>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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