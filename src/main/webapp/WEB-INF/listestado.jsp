<%@page import="java.util.List"%>
<%@page
	import="br.com.fabricadeprogramador.persistencia.entidade.Estado"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//Acessando dados do Servlet
		List<Estado> lista = (List<Estado>) request
				.getAttribute("listaestado");
		//Gerando linhas na tabela para imprimir os dados
		for (Estado u : lista) {
			out.print("<tr>  <td> " + u.getId() + " </td> <td> "
					+ u.getNome() + "</td></tr>");
		}
	%>>
</body>
</html>