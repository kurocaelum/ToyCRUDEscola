<%@page import="java.util.List"%>
<%@page import="br.com.escola.model.domain.Aluno"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>ESCOLA</title>
</head>
<body>

	<h2>ESCOLA</h2>	
	<h3>Alunos</h3>	
	<p><a href="AlunoServlet?action=inserir">+ Adicionar</a></p>
	
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Nome</td>
			<td></td>
			<td></td>
		</tr>
		
		<% 
		List<Aluno> alunoList = (List<Aluno>) request.getAttribute("alunoList"); 
		for (Aluno aluno : alunoList) {
		%>
		<tr>
			<td><%= aluno.getId() %></td>
			<td><%= aluno.getNome() %></td>
			<td><a href="AlunoServlet?action=editar&id=<%= aluno.getId() %>">Editar</a></td>
			<td><a href="AlunoServlet?action=remover&id=<%= aluno.getId() %>">Remover</a></td>
		</tr>
		<% 
		} 
		%>
	</table>

</body>
</html>
