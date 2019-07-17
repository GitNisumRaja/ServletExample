<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Welcome to ur profile Page </h1>
<% out.println(request.getCookies()[0].getValue()); %>
<a href="LogoutServlet">Logout</a>
</body>
</html>