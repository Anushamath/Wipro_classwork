<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application Form</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%
    String username = request.getParameter("username");
    session.setAttribute("user", username);
    String password = request.getParameter("password");
    session.setAttribute("password", password);
%>
<center><h3>Welcome, <%= session.getAttribute("user") %></h3>

<form action="processLoan.jsp" method="post">
    Name: <input type="text" name="name" required><br><br>
    Loan Amount: <input type="number" name="amount" required><br><br>
    Tenure (in months): <input type="number" name="tenure" required><br><br>
    <input type="submit" value="Apply Loan">
</form></center>
<%@ include file="footer.jsp" %>
</body>
</html>