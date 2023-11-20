package co.empresa.segundoparcial.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import co.empresa.segundoparcial.dao.UsuarioDao;
import co.empresa.segundoparcial.modelo.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDao usuarioDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.usuarioDao = new UsuarioDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();

		try {
			switch (action) {

				case "/new":
					showNewForm(request, response);
					break;
				case "/valid":
					validacionUsuario(request, response);
					break;
				case "/delete":
					validacionUsuario(request, response);
					break;
				case "/edit":
					validacionUsuario(request, response);
					break;	
				case "/update":
					validacionUsuario(request, response);
					break;
				default:
					validacionUsuario(request, response);
					break;

			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
	}

	private void validacionUsuario(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException, SQLException {

	    String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    boolean credencialesValidas = usuarioDao.validarCredenciales(username, password);

	    if (credencialesValidas) {
	        // Las credenciales son válidas, realiza las acciones necesarias (por ejemplo, redirigir a una página de inicio).
	        response.sendRedirect("movimientos.jsp");
	    } else {
	        // Las credenciales no son válidas, muestra un mensaje de error o redirige a una página de error.
	        response.sendRedirect("pagina_de_error.jsp");
	    }
	}

	/*private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		int id = Integer.parseInt(request.getParameter("id"));

		Usuario usuarioActual = usuarioDao.select(id);

		request.setAttribute("usuario", usuarioActual);

		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);

	}*/

	

	

}
