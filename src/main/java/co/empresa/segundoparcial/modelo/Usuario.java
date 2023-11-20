package co.empresa.segundoparcial.modelo;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
	Integer id;
	String username;
	String password;
	String email;
	
	public Usuario(String username,String password) {
		this.username=username;
		this.password= password;
	}
}
