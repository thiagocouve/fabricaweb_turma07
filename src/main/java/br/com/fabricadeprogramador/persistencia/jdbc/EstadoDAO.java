package br.com.fabricadeprogramador.persistencia.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fabricadeprogramador.persistencia.entidade.Estado;

public class EstadoDAO {
	private Connection conexao;

	public EstadoDAO() {
		//Obtendo uma conexao com o banco
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
}