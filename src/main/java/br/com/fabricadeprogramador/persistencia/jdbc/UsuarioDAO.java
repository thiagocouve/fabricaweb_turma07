package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

//* acesso a banco de dados usuario *//
public class UsuarioDAO {

	private Connection con;

	public UsuarioDAO() {
		// obtendo a conexao com o banco

		con = ConexaoFactory.getConnection();

	}

	public void cadastrar(Usuario usuario) {
		String sql = "insert into usuario (nome, login, senha) values (?,?,?)";
		try (PreparedStatement preparador = con.prepareStatement(sql);) {

			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());

			preparador.execute();
			// preparador.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usuario) {
		String sql = "update usuario set nome=?, login=?, senha=? where id=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			// Criando objeto Statement

			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());

			// Executando no banco
			preparador.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void excluir (Usuario usuario) {
		String sql = "delete from usuario where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql);) {

			preparador.setInt(1, usuario.getId());
		

			preparador.execute();
			// preparador.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Salva com Insert ou Update Se o usuario tiver id então altera senao
	 * insere
	 * 
	 * @param usuario
	 */
	public void salvar(Usuario usuario) {
		if (usuario.getId() == null || usuario.getId() == 0) {
			cadastrar(usuario);
		} else {
			alterar(usuario);
		}
	}

}
