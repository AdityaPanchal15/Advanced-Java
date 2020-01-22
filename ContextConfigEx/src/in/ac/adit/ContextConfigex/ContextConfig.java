package in.ac.adit.ContextConfigex;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextConfig extends HttpServlet {
	protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		String pass=getServletConfig().getInitParameter("secret");
		System.out.println(pass);
		
		RequestDispatcher rd=null;
		
		if(username.equals("admin") && password.equals(pass)) {
			//out.println("Welcome" + " "+username);
			rd=req.getRequestDispatcher("home.jsp");
			req.setAttribute("success", username);
		}else {
			//out.println("Invalid");
			rd=req.getRequestDispatcher("index.jsp");
			req.setAttribute("error", "Invalid username/password");
		}
		
		rd.forward(req, res);
		//String name=getServletContext().getInitParameter("Heading");
		//out.print("<h1>"+name+"</h1>");
	}
}

