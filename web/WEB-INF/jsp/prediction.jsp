<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prediction</title>
</head>

<body>

<h1>Prediction results:</h1>
<table border="1">
    <tr>
        <th></th>
        <th>Decade-based</th>
        <th>Year-based</th>
        <th>Month-based</th>
        <th>Week-based</th>
        <th>Raw Probability</th>
    </tr>
    <c:forEach items="${result}" var="res">
        <tr>
            <td>${res.drug}</td>
            <td>${res.decadeBasedRisk}</td>
            <td>${res.yearBasedRisk}</td>
            <td>${res.monthBasedRisk}</td>
            <td>${res.weekBasedRisk}</td>
            <td>
                <c:forEach items="${res.rawProbability}" var="risk">
                    ${risk}
                </c:forEach>
            </td>

        </tr>
    </c:forEach>
</table>
<br>
</body>

</html>
