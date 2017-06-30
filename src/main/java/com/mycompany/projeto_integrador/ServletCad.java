/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto_integrador;

import DAOs.DAOCidade;
import DAOs.DAOPessoa;
import Entidades.Cidade;
import Entidades.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lukas
 */
@WebServlet(name = "ServletCad", urlPatterns = {"/ServletCad"})
public class ServletCad extends HttpServlet {

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
            
            String Id = request.getParameter("Id");
            String Nome = request.getParameter("Nome");
            String Login = request.getParameter("Login");
            String Senha = request.getParameter("Senha");
            String Email = request.getParameter("Email");
            String Telefone = request.getParameter("Telefone");
            String DataNasc = request.getParameter("DataNascimento");
            String Sexo = request.getParameter("Sexo");
            String RG = request.getParameter("RG");
            String CPF = request.getParameter("CPF");
            int Cidade = Integer.valueOf(request.getParameter("Cidade"));
        
            //   List<Pessoa> dados = savePrint(Id, RG, CPF, Email, Telefone, Idade, Sexo);
            String aux[];
//            aux = String.valueOf(dados).split(";");

//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Servlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Id: " + aux[0].substring(1) + "</h1>");
//            out.println("<h1>RG: " + aux[1] + "</h1>");
//            out.println("<h1>CPF: " + aux[2] + "</h1>");
//            out.println("<h1>Telefone: " + aux[3] + "</h1>");
//            out.println("<h1>Email: " + aux[4] + "</h1>");
//            out.println("<h1>Idade: " + aux[5] + "</h1>");
//            out.println("<h1>Sexo: " + aux[6].substring(0, aux[6].length()-1) + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
private List<Pessoa> savePrint(String Id,String Nome, String DataNasc, String Login, String Senha, String RG,
        String CPF, String Telefone, String Email, String Idade, String Sexo,int Cidade) {
        DAOPessoa controle = new DAOPessoa();
        Pessoa entidade = new Pessoa();
        
        Random random = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DAOCidade daoCidade = new DAOCidade();
        Cidade cidade = new Cidade();
        boolean ver_Nome = Nome.matches("^[a-zA-Z]+$");
        
        entidade.setIdPessoas(random.nextInt());
        entidade.setNome(Nome);
        entidade.setLogin(Login);
        entidade.setSenha(Senha);
        entidade.setEmail(Email);
        entidade.setTelefone(Telefone);
        try {
            sdf.setLenient(false);
            entidade.setDataNasc(sdf.parse(DataNasc));
        } catch (ParseException ex) {
            System.out.println("Erro");
        }
        entidade.setSexo(Sexo);
        entidade.setRg(RG);
        entidade.setCpf(CPF);
        cidade = daoCidade.obter(Cidade);
        entidade.setCidadeIdCidade(cidade);
        
        controle.inserir(entidade);

        List<Pessoa> dados = new ArrayList<>();
        dados = controle.listById(Integer.valueOf(Id));
        System.out.println(dados);
        return dados;
    }
}
