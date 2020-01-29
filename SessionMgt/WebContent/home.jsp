<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	/*
	String success=(String) request.getAttribute("Success");
	if(success!=null)
		response.sendRedirect("index.jsp");
	
	Cookie cookie[]= request.getCookies();
	
	if(cookie.length<1){
		response.sendRedirect("index.jsp");
	}
	for(int i=0;i<cookie.length;i++){
		if(!cookie[i].getName().equals("Authuser")){
			response.sendRedirect("index.jsp");
		}
	}*/
	
	String username=(String)request.getSession().getAttribute("username");
	if(username==null){
		response.sendRedirect("index.jsp");
	}
%>

Welcome<%=username %>
<a href="logout.jsp">logout</a>
	<form action="Authentication" method="get">
	<table>
		<tr>
			<td>Username</td>
			<td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Login"/></td>
		</tr>
	</table>
	</form>
</body>
</html>