<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Weather</title>
</head>
<body>
<p align="center"><a href="/weather">Weather menu</a></p>
The weather in <b>${city}</b>:<br>
    Temperature = ${weatherValues.temperature}<br>
    Humidity = ${weatherValues.humidity}%
</body>
</html>
