<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input Form</title>
</head>
<body>
    <form method="post" action="/getPrediction">
        <label for="inputStr">Input: </label>
        <input type="text" id="inputStr" name="inputStr">
        <input type="submit" value="send">
    </form>

</body>
</html>
