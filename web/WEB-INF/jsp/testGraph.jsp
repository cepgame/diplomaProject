<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<%
    Gson gsonObj = new Gson();
    Map<Object,Object> map = null;
    List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

    map = new HashMap<Object,Object>(); map.put("label", "Electrical"); map.put("y", 35); list.add(map);
    map = new HashMap<Object,Object>(); map.put("label", "Transport"); map.put("y", 20); list.add(map);
    map = new HashMap<Object,Object>(); map.put("label", "Cosumer Durables"); map.put("y", 18); list.add(map);
    map = new HashMap<Object,Object>(); map.put("label", "Packaging"); map.put("y", 15); list.add(map);
    map = new HashMap<Object,Object>(); map.put("label", "Construction"); map.put("y", 5); list.add(map);
    map = new HashMap<Object,Object>(); map.put("label", "Machinery"); map.put("y", 7); list.add(map);
    map = new HashMap<Object,Object>(); map.put("label", "Others"); map.put("y", 7); list.add(map);
    String dataPoints = gsonObj.toJson(list);
%>

<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="http://canvasjs.com/assets/script/canvasjs.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"></script>
    <script type="text/javascript">
        window.onload = function() {

            var chart = new CanvasJS.Chart("chartContainer", {
                animationEnabled: true,
                title:{
                    text: "Aluminium Demand by Sector - 2014"
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
                    dataPoints : <%out.print(dataPoints);%>
                }]
            });
            chart.render();

            var chart2 = new CanvasJS.Chart("chartContainer2", {
                animationEnabled: true,
                title:{
                    text: "Aluminium Demand by Sector - 2014"
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
                    dataPoints : <%out.print(dataPoints);%>
                }]
            });

            chart2.render();

        }
    </script>
</head>
<body>
    <div class="col-md-12">
        <div id="chartContainer" style="height: 370px; width: 100%;"></div>
    </div>
    <div class="col-md-12">
    <div id="chartContainer2" style="height: 370px; width: 100%;"></div>
    </div>

<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>