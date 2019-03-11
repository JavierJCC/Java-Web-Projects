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
		<h1>
		<c:set var="Alumno" value="${ESTADOAlUMNOS}"></c:set>
		<c:out value="${Alumno}"></c:out>
		</h1>
	</div>
</body>
</html>