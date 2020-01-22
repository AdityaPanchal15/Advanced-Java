package in.ac.adit.ContextConfigex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneServlet extends HttpServlet {
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String msg=request.getParameter("msg");
			String upperMsg=msg.toUpperCase();
			
			RequestDispatcher rd=request.getRequestDispatcher("SecondServlet");
			request.setAttribute("att1",upperMsg);
			request.setAttribute("att2","hello");
			rd.forward(request,response);
			
		}

}
