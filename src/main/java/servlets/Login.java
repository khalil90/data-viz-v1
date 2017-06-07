package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import utils.HttpRequest;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if(username!=null && password!=null){
			if (username.equals("bilalchami") && password.equals("bilalchami")) {
				System.out.println("Before Redirect");
				
				JSONObject loginUser = new JSONObject();

				loginUser.put("username", "bilalchami");
				loginUser.put("password", "bilalchami");
				
				HttpRequest httpRequest = new HttpRequest("https://api.scriptrapps.io/login?auth_token=TjQ0REMzQTkyMQ==", "POST", loginUser.toString(), HttpRequest.JSON_FORMAT + "charset=UTF-8");
				
				System.out.println(httpRequest.send());
				
				response.sendRedirect("index.jsp?success=true&success_message=Log%20In%20Successful");
			}
		}

	}
	
}