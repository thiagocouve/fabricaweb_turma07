<!DOCTYPE html>
<%@page import="br.com.fabricadeprogramador.persistencia.entidade.Usuario"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script>
	function excluir() {

		if (window.confirm("tem certeza")) {

			idDigitado = document.getElementById("id").value;

			location.href = "usucontroller.do?id=" + idDigitado;
		}
	}
</script>
</head>
<body>
<%
		 Usuario usu= (Usuario)	request.getAttribute("usu");
	%>
	<form action="usucontroller.do" method="POST">
		ID : <input type="number" name="id" id="id" value="<%=usu.getId()%>">
		Nome: <input type="text" name="nome" id="nome" value="<%=usu.getNome()%>">
		Login: <input type="text" name="login" id="login" value="<%=usu.getLogin()%>">
		Senha <input type="password" name="senha" value="<%=usu.getSenha()%>">
		<input type="submit" value="Salvar">		
		<input type="button" value="Excluir" onclick="javascript:excluir()"/>
	</form>
</body>
</html>