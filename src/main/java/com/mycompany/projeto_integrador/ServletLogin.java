/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto_integrador;

import Entidades.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lukas
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {     

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
        String username = request.getParameter("Login");
        String password = request.getParameter("Senha");
        String check = "";
        System.out.println(username +" "+ password);

        if (username == null || username.equals("")) {
            System.out.println("entrou");
            check += "O usuário não pode estar em branco</br>";
            System.out.println(check);
        }
        if (password == null || password.equals("")) {
            check += "A senha não pode estar em branco</br>";
        }
        if (username != null & username.matches("^[a-zA-Z]+$")) {
            if (check.equals("")) {
                String acao = login(username, password);
                if (acao.equals("Login")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("session", username);
                    session.setMaxInactiveInterval(30 * 60);
                    response.sendRedirect("BemVindo.jsp");
                    if (acao.equals("Usuario Desativado")) {
                        request.setAttribute("ErroEntrar", "Usuario Desativado!");
                    }
                    if (acao.equals("Senha Incorreta") || acao.equals("Usuario nao existente")) {
                        request.setAttribute("ErroEntrar", "Usuario ou Senha incorretos!");
                    }
                }
            }
        } else {
            if (!check.contains("O usuário não pode estar em branco")) {
                check += "Insira apenas LETRAS no Login!";
            }
        }
        if (!check.equals("")) {
            request.setAttribute("ErroEntrar", check);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }

    protected String login(String username, String password) {
        Entidades.Pessoa pessoa = new Entidades.Pessoa();
        DAOs.DAOPessoa daoPessoa = new DAOs.DAOPessoa();
        List<Pessoa> list = daoPessoa.listByLogin(username);
        System.out.println(list.get(0));
        pessoa = list.get(0);
        try {
            if (pessoa.getIdPessoas()!= null || pessoa.getIdPessoas()!= 0) {
                if (pessoa.getSenha().equals(password)) {
                    return "Login";
                } else {
                    return "Usuario ou senha incorretos";
                }
            }
        } catch (Exception ex) {
        }
        return "Usuario nao existente";
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
     * Returns a short deion of the servlet.
     *
     * @return a String containing servlet deion
     */
    @Override
    public String getServletInfo() {
        return "Short deion";
    }// </editor-fold>

}