<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TEST RESULT PAGE</title>
</head>
<br>
    TEST
        FIELD1: <b>${survey.field}</b>
        FIELD2: <b>${survey.field2}</b>

        ARRAY:
        <c:forEach items="${survey.answers}" var="answer">
            <b>${answer}</b> <br/>
        </c:forEach>
</body>
</html>
