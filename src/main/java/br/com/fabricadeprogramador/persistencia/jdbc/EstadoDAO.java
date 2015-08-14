package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Estado;
import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class EstadoDAO {
	private Connection conexao;

	public EstadoDAO() {
		// Obtendo uma conexao com o banco
		conexao = ConexaoFactory.getConnection();
	}

	public void cadastrar(Estado estado) {
		String sql = "INSERT INTO estado (nome, uf) VALUES (?, ?)";

		// Criando objeto statement
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {

			preparador.setString(1, estado.getNome());
			preparador.setString(2, estado.getUF());

			// executando no banco
			preparador.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// **//

	public void excluir(Estado  estado) {
		String sql = "delete from estado where id=?";
		try (PreparedStatement preparador = conexao.prepareStatement(sql);) {

			preparador.setInt(1, estado.getId());

			preparador.execute();
			// preparador.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// **//
	public List<Estado> buscarTodos() {

		List<Estado> lista = new ArrayList<Estado>();
		String sql = "Select * from estado";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();
			Estado estado;
			while (resultado.next()) {
				estado = new Estado();
				estado.setId(resultado.getInt("id"));
				estado.setNome(resultado.getString("nome"));
				estado.setUF(resultado.getString("uf"));
				lista.add(estado);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
