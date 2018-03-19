<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Input Form</title>
</head>
<body>
<form method="post" action="/getPrediction">
    <label for="inputStr">Enter String:</label>
    <input type="text" id="inputStr" name="inputStr">
    <br/>
    <br/>
    <%--<label for="author">Author name:</label>--%>
    <%--<input type="text" id="author" name="author" />--%>
    <%--<br/>--%>
    <%--<br/>--%>
    <%--<label for="text">Message text:</label>--%>
    <%--<input type="text" id="text" name="text" />--%>
    <%--<br/>--%>
    <%--<br/>--%>

    <%-- TODO: create dropmenu for input parameters--%>
    <%-- Age --%>
    <%--<label for="age">Age:</label>--%>
    <%--<select id="age" name="age">--%>
        <%--<option>18-24</option>--%>
        <%--<option>25-34</option>--%>
        <%--<option>35-44</option>--%>
        <%--<option>45-54</option>--%>
        <%--<option>55-64</option>--%>
        <%--<option>65+</option>--%>
    <%--</select>--%>
    <%--<br/>--%>
    <%--<br/>--%>
    <%--&lt;%&ndash; Gender &ndash;%&gt;--%>
    <%--<label for="gender">Gender:</label>--%>
    <%--<select id="gender" name="gender">--%>
        <%--<option>Female</option>--%>
        <%--<option>Male</option>--%>
    <%--</select>--%>
    <%--<br/>--%>
    <%--<br/>--%>
    <%--&lt;%&ndash; Education &ndash;%&gt;--%>
    <%--<label for="education">Education:</label>--%>
    <%--<select id="education" name="education">--%>
        <%--<option>Left school before 16 years</option>--%>
        <%--<option>Left school at 16 years</option>--%>
        <%--<option>Left school at 17 years</option>--%>
        <%--<option>Left school at 18 years</option>--%>
        <%--<option>Some college or university, no certificate or degree</option>--%>
        <%--<option>Professional certificate/ diploma</option>--%>
        <%--<option>University degree</option>--%>
        <%--<option>Masters degree</option>--%>
        <%--<option>Doctorate degree</option>--%>
    <%--</select>--%>
    <%--<br/>--%>
    <%--<br/>--%>
    <%--&lt;%&ndash; Country &ndash;%&gt;--%>
    <%--<label for="country">Country:</label>--%>
    <%--<select id="country" name="country">--%>
        <%--<option>Australia</option>--%>
        <%--<option>Canada</option>--%>
        <%--<option>New Zealand</option>--%>
        <%--<option>Republic of Ireland</option>--%>
        <%--<option>UK</option>--%>
        <%--<option>USA</option>--%>
        <%--<option>Other</option>--%>
    <%--</select>--%>
    <%--<br/>--%>
    <%--<br/>--%>
    <%--&lt;%&ndash; Ethnicity &ndash;%&gt;--%>
    <%--<label for="ethnicity">Ethnicity:</label>--%>
    <%--<select id="ethnicity" name="ethnicity">--%>
        <%--<option>Asian</option>--%>
        <%--<option>Black</option>--%>
        <%--<option>Mixed-Black/Asian</option>--%>
        <%--<option>Mixed-White/Asian</option>--%>
        <%--<option>Mixed-White/Black</option>--%>
        <%--<option>White</option>--%>
        <%--<option>Other</option>--%>
    <%--</select>--%>
    <%--<br/>--%>
    <%--<br/>--%>
    <%--<label for="nscore">test</label>--%>
    <%--<input type="text" id="nscore" name="nscore" />--%>
    <input type="submit" value="send"/>
</form>
</body>
</html>

