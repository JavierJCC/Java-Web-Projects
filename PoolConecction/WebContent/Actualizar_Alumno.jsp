<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	<div id="page">
		<h1>Formulario para actualizar datos</h1>
		<c:set var="Alumno" value="${ACTUALIZAAlUMNOS}"></c:set>
			<form name="registro" method="GET" action="${pageContext.request.contextPath}/ControlAlumnos">
				<label>Cedula: </label>
				<input type="text" id="cedula" name="cedula" value="${Alumno.cedula}"/>
				<div id="feedback_cedula"></div>
				
				<label>Nombres: </label>
				<input type="text" id="nombre" name="nombre" value="${Alumno.nombres }" />
				<div id="feedback_nombre"></div>
				
				<label>Apellidos: </label>
				<input type="text" id="apellido" name="apellido" value="${Alumno.apellidos}"/>
				<div id="feedback_apellido"></div>
				
				<label>Curso: </label>
				<input type="text" id="curso" name="curso" value="${Alumno.curso}"/>
				<div id="feedback_curso"></div>
				<input type="hidden" name="idAlumno" value="${Alumno.idAlumnos}" />
				<input type="hidden" name ="instruccion" value ="actualizaBD">
				<input type="submit" value="Actualizar" />
			</form>	
	</div>

</body>
</html>