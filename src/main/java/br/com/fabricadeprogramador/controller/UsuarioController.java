package br.com.fabricadeprogramador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
	// get pedi
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// pagando da tela
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		// guardando o valor no usuario
		Usuario usu = new Usuario();

		if (id != null) {

			usu.setId(Integer.parseInt(id));

		}
		usu.setNome(id);
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);

		// presistendo no bando
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		usuarioDAO.salvar(usu);
		// resposta para usuario
		resp.getWriter().print("cadastrado");

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String acao = req.getParameter("acao");
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		if (acao == null || acao.equals("lis")) {
			// Carregando a lista do banco
			List<Usuario> lista = usuarioDAO.buscarTodos();
			// Adicionando atributo no request
			req.setAttribute("listaUsu", lista);
			// Objeto de encaminhamento
			RequestDispatcher dispatcher = req
					.getRequestDispatcher("WEB-INF/listusu.jsp");
			// Encaminhando o request e o respose para o JSP
			dispatcher.forward(req, resp);

		} else if (acao.equals("esc")) {
			// Pegando o id da tela
			String id = req.getParameter("id");
			Usuario usu = new Usuario();
			usu.setId(Integer.parseInt(id));
			usuarioDAO.excluir(usu);
			// Mensagem
			resp.getWriter().print("Excluido!");
			// ////////////////////////////////////
		} else if (acao.equals("alt")) {
			String id = req.getParameter("id");
			Usuario usuario = usuarioDAO.buscarPorId(Integer.parseInt(id));
			req.setAttribute("usu", usuario);
			RequestDispatcher dispatcher = req
					.getRequestDispatcher("/WEB-INF/formusuario.jsp");
			dispatcher.forward(req, resp);

		} else if (acao.equals("cad")) {
			String id = req.getParameter("id");

			Usuario usuario = new Usuario();
			usuario.setId(0);
			usuario.setLogin("");
			usuario.setNome("");
			usuario.setSenha("");

			req.setAttribute("usu", usuario);
			RequestDispatcher dispatcher = req
					.getRequestDispatcher("/WEB-INF/formusuario.jsp");
			dispatcher.forward(req, resp);

		}
	}
}