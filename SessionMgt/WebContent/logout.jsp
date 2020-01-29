

<%
	request.getSession().setAttribute("username",null);
	request.getSession().invalidate();
	response.sendRedirect("index.jsp");
%>