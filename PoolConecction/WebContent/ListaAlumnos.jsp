<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.javierchavez.mx.*" %>

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
<%
	//Obtiene la lista de los productos
	List<Alumnos> losAlumnos= (List<Alumnos>) request.getAttribute("LISTAAlUMNOS");
%>
<h1> Lista de alumnos </h1>

<div id="contenedorBoton">
	<input type="button" value="Insertar Registro" onClick="window.location.href='inserta_alumno.jsp'">
</div>
<br>
	<p class="intro">Lista de alumnos registrados para los cursos de programacion</p>
	<table>
		<tr class="head" >
		<td>idAlumno</td>
		<td>cedula</td>
		<td>Nombres</td>
		<td>Apellidos</td>
		<td>Curso</td>
		<td>Actualizar</td>
		</tr>

		<c:forEach var = "tempAlum" items="${LISTAAlUMNOS}">
		
		<c:url var="linkTemp" value="ControlAlumnos">
			<c:param name="instruccion" value="Cargar"></c:param>
			<c:param name="CAlumno" value="${tempAlum.idAlumnos}"></c:param>
		</c:url>
		
			<tr>
				<td>${tempAlum.idAlumnos}</td>
				<td>${tempAlum.cedula}</td>
				<td>${tempAlum.nombres}</td>
				<td>${tempAlum.apellidos}</td>
				<td>${tempAlum.curso}</td>
				<td> <a href="${linkTemp}">Actualizar</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>