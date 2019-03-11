<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/styles.css" rel="stylesheet" type="text/css"/>
<script src="js/inserta_alumno.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="page">
	<h1>Formulario de Registro</h1>
	<p class="intro">Complete el siguiente fomrnulario: </p>
		<div id="formulario">
			<form name="registro" method="GET" action="${pageContext.request.contextPath}/ControlAlumnos">
				<label>Cedula: </label>
				<input type="text" id="cedula" name="cedula" />
				<div id="feedback_cedula"></div>
				
				<label>Nombres: </label>
				<input type="text" id="nombre" name="nombre" />
				<div id="feedback_nombre"></div>
				
				<label>Apellidos: </label>
				<input type="text" id="apellido" name="apellido"/>
				<div id="feedback_apellido"></div>
				
				<label>Curso: </label>
				<input type="text" id="curso" name="curso"/>
				<div id="feedback_curso"></div>
				
				<input type="hidden" name ="instruccion" value ="insertaBD">
				<input type="submit" value="Insertar" />
			</form>
		</div>
</div>
</body>
</html>