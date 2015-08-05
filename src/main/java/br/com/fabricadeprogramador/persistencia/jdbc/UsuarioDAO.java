package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

//* acesso a banco de dados usuario *//
public class UsuarioDAO {
	
private Connection con;

public UsuarioDAO(){
	// obtendo a conexao com o banco
	
	con = ConexaoFactory.getConnection();
	
}

public void cadastrar (Usuario usuario){
	String sql = "insert into usuario (nome, login, senha) values (?,?,?)";
	try (PreparedStatement preparador = con.prepareStatement(sql);){
	
		
		preparador.setString(1,usuario.getNome());
		preparador.setString(2,usuario.getLogin());
		preparador.setString(3,usuario.getSenha());
		
		preparador.execute();
		//preparador.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
