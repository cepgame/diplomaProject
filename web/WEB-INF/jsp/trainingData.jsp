<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Training Data</title>
</head>
<body>
Training Data <br/> <a href="/"><--Back to main menu</a>
<%--<a href="CardDetailForm.jsp"><input type="button" value="Cancel" name="cancel"/></a>--%>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Age</th>
        <th>Gender</th>
        <th>Education</th>
        <th>Country</th>
        <th>Ethnicity</th>
        <th>Nscore</th>
        <th>Escore</th>
        <th>Oscore</th>
        <th>Ascore</th>
        <th>Cscore</th>
        <th>Impulsive</th>
        <th>SS</th>
        <th>Alcohol</th>
        <th>Amphet</th>
        <th>Amyl</th>
        <th>Benzos</th>
        <th>Caffein</th>
        <th>Cannabis</th>
        <th>Choc</th>
        <th>Coke</th>
        <th>Crack</th>
        <th>Ecstasy</th>
        <th>Heroin</th>
        <th>Ketamine</th>
        <th>Legalh</th>
        <th>LSD</th>
        <th>Meth</th>
        <th>Mushrooms</th>
        <th>Nicotine</th>
        <th>Semer</th>
        <th>VSA</th>
    </tr>
    <%--ID,Age,Gender,Education,Country,Ethnicity,Nscore,Escore,Oscore,Ascore,Cscore,Impulsive,SS,Alcohol--%>
    <%--,Amphet,Amyl,Benzos,Caff,Cannabis,Choc,Coke,Crack,Ecstasy,Heroin,Ketamine,Legalh,LSD,Meth,Mushrooms,--%>
    <%--Nicotine,Semer,VSA--%>
    <c:forEach items="${list}" var="tmp">
        <tr>
        <td>${tmp.id}</td>
        <td>${tmp.age}</td>
        <td>${tmp.gender}</td>
        <td>${tmp.education}</td>
        <td>${tmp.country}</td>
        <td>${tmp.ethnicity}</td>
        <td>${tmp.nscore}</td>
        <td>${tmp.escore}</td>
        <td>${tmp.oscore}</td>
        <td>${tmp.ascore}</td>
        <td>${tmp.cscore}</td>
        <td>${tmp.impulsive}</td>
        <td>${tmp.sensationSeeing}</td>
        <td>${tmp.alcohol}</td>
        <td>${tmp.amphetamin}</td>
        <td>${tmp.amyl}</td>
        <td>${tmp.benzodiazepine}</td>
        <td>${tmp.caffein}</td>
        <td>${tmp.canabis}</td>
        <td>${tmp.chocolate}</td>
        <td>${tmp.cocain}</td>
        <td>${tmp.crack}</td>
        <td>${tmp.ecstasy}</td>
        <td>${tmp.heroin}</td>
        <td>${tmp.ketamin}</td>
        <td>${tmp.legalHighs}</td>
        <td>${tmp.lsd}</td>
        <td>${tmp.methadone}</td>
        <td>${tmp.mushrooms}</td>
        <td>${tmp.nicotine}</td>
        <td>${tmp.semer}</td>
        <td>${tmp.vsa}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
