<%@page import="java.util.List"%>
<%@page import="br.com.escola.model.domain.Aluno"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ESCOLA</title>
</head>
<body>

	<h2>ESCOLA</h2>
	
	<h3>Form Alunos</h3>
	
	<% 
	Aluno aluno = (Aluno) request.getAttribute("aluno");
	%>

	<form method="POST" action='AlunoServlet' name="frmAddAluno">
        ID: <input type="text" readonly="readonly" name="id"
            value="<%= aluno != null ? aluno.getId() : 0 %>" /> <br /> 
        Nome: <input
            type="text" name="nome"
            value="<%= aluno != null ? aluno.getNome() : "" %>" /> <br /> 
        Email: <input type="text" name="email"
            value="<%= aluno != null ? aluno.getEmail() : "" %>" /> <br /> 
            
        <input type="submit" value="Salvar" />
    </form>
</body>
</html>
