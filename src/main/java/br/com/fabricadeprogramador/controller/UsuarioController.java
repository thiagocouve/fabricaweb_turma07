package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;
@WebServlet("/usucontroller.do")

public class UsuarioController extends HttpServlet {

	
	// do leva 
	//get pedi
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		//pagando da tela
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		// guardando o valor no usuario 
		Usuario usu = new Usuario();
		
		if(id!=null){
			
			usu.setId(Integer.parseInt(id));
			
			
		}
		usu.setNome(id);
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);
		
		//presistendo no bando 
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		
		usuarioDAO.salvar(usu);
		//resposta para usuario
		resp.getWriter().print("cadastrado");
		
		
	
		
	}
	

	
	
	
	


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Pegando o id da tela
		String id = req.getParameter("id");
		
		//Preencher o objeto usuario
		Usuario usu = new Usuario();
		usu.setId(Integer.parseInt(id));
		
		//Excluir
		UsuarioDAO usuarioDAO =  new UsuarioDAO();
		usuarioDAO.excluir(usu);
		
		//Mensagem
		resp.getWriter().print("Excluido!");
		
	}

}
