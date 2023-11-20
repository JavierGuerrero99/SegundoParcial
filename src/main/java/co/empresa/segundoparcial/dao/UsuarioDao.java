package co.empresa.segundoparcial.dao;

import co.empresa.segundoparcial.util.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {
	private Conexion conexion;
	
	private static final String VALIDAR_CREDENCIALES_SQL = "INSERT INTO usuers(username,pass) VALUES(?, ?);";
	
	
	public boolean validarCredenciales(String nombreUsuario, String password) {
	    boolean valido = false;
	    try {
	        String VALIDAR_CREDENCIALES_SQL = "SELECT * FROM usuario WHERE nombre = ? AND password = ?;";
	        PreparedStatement preparedStatement = conexion.setPreparedStatement(VALIDAR_CREDENCIALES_SQL);
	        preparedStatement.setString(1, nombreUsuario);
	        preparedStatement.setString(2, password);
	        
	        ResultSet rs = preparedStatement.executeQuery();

	        if (rs.next()) {
	            valido = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return valido;
	}


}
