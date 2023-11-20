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
	        // Consulta SQL para obtener el usuario por nombre y contraseña
	        String VALIDAR_CREDENCIALES_SQL = "SELECT * FROM usuario WHERE nombre = ? AND password = ?;";
	        PreparedStatement preparedStatement = conexion.setPreparedStatement(VALIDAR_CREDENCIALES_SQL);
	        preparedStatement.setString(1, nombreUsuario);
	        preparedStatement.setString(2, password);
	        
	        ResultSet rs = conexion.query();

	        // Si se encuentra algún resultado, las credenciales son válidas
	        if (rs.next()) {
	            valido = true;
	        }
	    } catch (SQLException e) {
	        // Manejar la excepción
	        e.printStackTrace();
	    }
	    return valido;
	}

}
