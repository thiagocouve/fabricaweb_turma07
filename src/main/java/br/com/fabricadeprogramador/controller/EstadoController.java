package br.com.fabricadeprogramador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.persistencia.entidade.Estado;
import br.com.fabricadeprogramador.persistencia.jdbc.EstadoDAO;

@WebServlet("/estadocontroller.do")
public class EstadoController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// pagando da tela
		String nome = req.getParameter("nome");
		String Uf = req.getParameter("uf");

		// guardando o valor no usuario
		Estado estado = new Estado();
		estado.setNome(nome);
		estado.setUF(Uf);

		// presistendo no bando
		EstadoDAO estadoDAO = new EstadoDAO();

		estadoDAO.cadastrar(estado);
		// resposta para usuario
		resp.getWriter().print("cadastrado");

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String acao = req.getParameter("acao");
		EstadoDAO estadoDAO = new EstadoDAO();

		if (acao == null || acao.equals("lis")) {
			List<Estado> lista = estadoDAO.buscarTodos();
			resp.getWriter().print(lista);
			req.setAttribute("listaestado",lista);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/listestado.jsp");
			//Encaminhando o request e o respose para o JSP
			dispatcher.forward(req, resp);
			
		} else if (acao.equals("esc")) {
			// Pegando o id da tela
			String id = req.getParameter("id");
			Estado usu = new Estado();
			usu.setId(Integer.parseInt(id));
			estadoDAO.excluir(usu);
			// Mensagem
			resp.getWriter().print("Excluido!");
		}

	}

}
