package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.persistencia.entidade.Estado;
import br.com.fabricadeprogramador.persistencia.jdbc.EstadoDAO;
@WebServlet("/estadocontroller.do")

public class EstadoController  extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	//pagando da tela
			String nome = req.getParameter("nome");
			String Uf = req.getParameter("uf");
	
			// guardando o valor no usuario 
			Estado estado = new Estado();
			estado.setNome(nome);
			estado.setUF(Uf);
			
			//presistendo no bando 
			EstadoDAO estadoDAO = new EstadoDAO();
			
			estadoDAO.cadastrar(estado);
			//resposta para usuario
			resp.getWriter().print("cadastrado");
	}

}
