<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prediction</title>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"></script>
</head>

<body>
<table class="table table-bordered">
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

<br/>
1. Two isolated categories (‘Never used’ and ‘Used over a decade ago’) are placed
into the class of non-users with a green background in Fig 1 and all other
categories into the class ‘users’ as the simplest version of binary classification.
This classification problem is called ‘decade-based ’ user/non-user separation.
2. The categories ‘Used in last decade’, ‘Used over a decade ago’ and ‘Never used’
are merged to form a group of non-users and all other categories are placed into
the group of users. This classification problem is called ‘year-based ’.
3. The categories ‘Used in last year’, ‘Used in last decade’, ‘Used over a decade ago’
and ‘Never used’ are combined to form a group of non-users and all three other
categories are placed into the group of users. This classification problem is called
‘month-based ’.
4. The categories ‘Used in last week’ and ‘Used in last month’ are merged to form a
group of users and all other categories are placed into the group of non-users.
This classification problem is called ‘week-based ’.
<br>
</body>

</html>
