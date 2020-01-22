package in.ac.adit.httpreq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpRequestDemo extends HttpServlet {
	protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=res.getWriter();
		String firstname=req.getParameter("FirstName");
		res.setContentType("text/html");
		out.println("Hello"+firstname);
	}
}
