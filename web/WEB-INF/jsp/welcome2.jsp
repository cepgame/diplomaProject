<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<%--<link rel='stylesheet' href='webjars/bootstrap/4.0.0-beta/css/bootstrap.min.css'>--%>
</head>
<body>

<form action=/inputData>
<input type="submit" value="Input data">
</form>

<form action=/trainingData>
<input type="submit" value="Training data">
</form>

<form action=/getPrediction>
<input type="submit" value="Get prediction to input string">
</form>

<form action=/survey>
<input type="submit" value="Survey">
</form>

<form action=/test>
    <input type="submit" value="test">
</form>


<form action=/test2>
    <input type="submit" value="test">
</form>

</body>
</html>

