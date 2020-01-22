<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String success=(String) request.getAttribute("success");
if(success!=null)
	out.println(success);
%>
	<form action="Hello" method="get">
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