package in.ac.adit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Authentication")
public class Authentication extends HttpServlet {
	private String username;
	private String password;
	private RequestDispatcher rd=null;
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		username=request.getParameter("username");
		password=request.getParameter("password");
		
		StringBuffer sb=new StringBuffer(password);
		String newPass=sb.reverse().toString();
		
		if(username.equals(newPass)) {
			rd=request.getRequestDispatcher("home.jsp");
			/*Cookie loginCookie=new Cookie("Authuser", newPass);
			request.setAttribute("Success", username);
			response.addCookie(loginCookie);*/
			
			HttpSession session=request.getSession();
			session.setAttribute("username",username);
		
			
		}else {
			rd=request.getRequestDispatcher("login.jsp");
			request.setAttribute("Error", "Invalid username or password");
		}
		
		rd.forward(request, response);
	}
}
