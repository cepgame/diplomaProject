<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>


<html>
<head>
    <title>Prediction</title>
    <%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"></script>--%>
    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    <script type="text/javascript">
        window.onload = function() {


            <c:forEach items="${charts}" var="chart">


                var chart = new CanvasJS.Chart("${chart.container}", {
                    animationEnabled: true,
                    title:{
                        text: "${chart.title}"
                    },
                    legend: {
                        verticalAlign: "center",
                        horizontalAlign: "right"
                    },
                    data: [{
                        type: "pie",
                        showInLegend: true,
                        indexLabel: "{y}%",
                        indexLabelPlacement: "inside",
                        legendText: "{label}: {y}%",
                        toolTipContent: "<b>{label}</b>: {y}%",
                        dataPoints : ${chart.datapoints}
                    }]
                });

                chart.render();
            </c:forEach>
        }
    </script>
</head>

<body>
<%--<table class="table table-bordered" style="clear: both; display: inline;">--%>
    <%--<tr>--%>
        <%--<th></th>--%>
        <%--<th>Decade-based</th>--%>
        <%--<th>Year-based</th>--%>
        <%--<th>Month-based</th>--%>
        <%--<th>Week-based</th>--%>
        <%--<th>Raw Probability</th>--%>
    <%--</tr>--%>
    <%--<c:forEach items="${result}" var="res">--%>
        <%--<tr>--%>
            <%--<td>${res.drug}</td>--%>
            <%--<td>${res.decadeBasedRisk}</td>--%>
    <%--<td>${res.yearBasedRisk}</td>--%>
    <%--<td>${res.monthBasedRisk}</td>--%>
    <%--<td>${res.weekBasedRisk}</td>--%>
    <%--<td>--%>
        <%--<c:forEach items="${res.rawProbability}" var="risk">--%>
            <%--${risk}--%>
        <%--</c:forEach>--%>
    <%--</td>--%>

    <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>

<%-- Graphs --%>
<div class="col-md-12">
    <div id="chartContainer0" style="height: 370px; width: 100%;"></div>
</div>
<div class="col-md-12">
    <div id="chartContainer1" style="height: 370px; width: 100%;"></div>
</div>
<div class="col-md-12">
    <div id="chartContainer2" style="height: 370px; width: 100%;"></div>
</div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

<br>
</body><br/>


</html>
