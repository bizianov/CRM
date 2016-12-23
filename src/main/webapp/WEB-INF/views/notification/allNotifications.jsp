<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Notifications</title>
</head>
<body>
<p align="center"><a href="/main.jsp">Main menu</a>
<hr>
<font color="blue"><b>1 day to flight</b></font>
<table>
    <tr>
        <th bgcolor="#01DF3A">ID</th>
        <th bgcolor="#01DF3A">START</th>
        <th bgcolor="#01DF3A">END</th>
        <th bgcolor="#01DF3A">TOURIST LIST</th>
        <th bgcolor="#01DF3A">HOTEL</th>
        <th bgcolor="#01DF3A">TO</th>
        <th bgcolor="#01DF3A">VISA</th>
        <th bgcolor="#01DF3A">AVIA</th>
        <th bgcolor="#01DF3A">PRICE</th>
        <th bgcolor="#01DF3A">CLOSURE</th>
        <th bgcolor="#01DF3A">WEATHER</th>
    </tr>
    <c:forEach items="${oneDayToFlightTours}" var="tour">
        <tr>
            <td bgcolor="#E6E6E6"><b>${tour.id}</b></td>
            <td bgcolor="#E6E6E6">${tour.startDate}</td>
            <td bgcolor="#E6E6E6">${tour.endDate}</td>
            <td bgcolor="#E6E6E6">
                <table border="1">
                    <tr>
                        <th bgcolor="#7fffd4"><b>ID</b></th>
                        <th bgcolor="#7fffd4"><b>NAME</b></th>
                        <th bgcolor="#7fffd4"><b>SURNAME</b></th>
                        <th bgcolor="#7fffd4"><b>PHONE</b></th>
                        <th bgcolor="#7fffd4"><b>EMAIL</b></th>
                        <th bgcolor="#7fffd4"><b>BIRTHDAY</b></th>
                        <th bgcolor="#7fffd4"><b>SOURCE</b></th>
                    </tr>
                    <c:forEach items="${tour.touristList}" var="tourist">
                        <tr>
                            <td bgcolor="#F2F2F2">${tourist.id}</td>
                            <td bgcolor="#F2F2F2">${tourist.firstName}</td>
                            <td bgcolor="#F2F2F2">${tourist.lastName}</td>
                            <td bgcolor="#F2F2F2">${tourist.phone}</td>
                            <td bgcolor="#F2F2F2">${tourist.email}</td>
                            <td bgcolor="#F2F2F2">${tourist.birthday}</td>
                            <td bgcolor="#F2F2F2">${tourist.source}</td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
            <td bgcolor="#E6E6E6">
                <table border="1">
                    <tr>
                        <th bgcolor="#dda0dd"><b>ID</b></th>
                        <th bgcolor="#dda0dd"><b>NAME</b></th>
                        <th bgcolor="#dda0dd"><b>RATE</b></th>
                        <th bgcolor="#dda0dd"><b>COUNTRY</b></th>
                        <th bgcolor="#dda0dd"><b>REGION</b></th>
                    </tr>
                    <tr>
                        <td bgcolor="#F2F2F2">${tour.hotel.id}</td>
                        <td bgcolor="#F2F2F2">${tour.hotel.name}</td>
                        <td bgcolor="#F2F2F2">${tour.hotel.rate}</td>
                        <td bgcolor="#F2F2F2"><a
                                href="getHotelsByCountry?country=${tour.hotel.country}">${tour.hotel.country}</a>
                        </td>
                        <td bgcolor="#F2F2F2"><a
                                href="getHotelsByRegion?region=${tour.hotel.region}">${tour.hotel.region}</a></td>
                    </tr>
                </table>
            </td>
            <td bgcolor="#E6E6E6">${tour.tourOperator}</td>
            <td bgcolor="#E6E6E6">${tour.visaRequired}</td>
            <td bgcolor="#E6E6E6">${tour.avia}</td>
            <td bgcolor="#E6E6E6">${tour.priceBrutto}</td>
            <td bgcolor="#E6E6E6">${tour.closureDate}</td>
            <td bgcolor="#E6E6E6"><a href="/weatherForecast?city=${tour.hotel.region}">Forecast</a></td>
        </tr>
    </c:forEach>
</table>
<hr>
<font color="blue"><b>3 days to flight</b></font>
<table>
    <tr>
        <th bgcolor="#01DF3A">ID</th>
        <th bgcolor="#01DF3A">START</th>
        <th bgcolor="#01DF3A">END</th>
        <th bgcolor="#01DF3A">TOURIST LIST</th>
        <th bgcolor="#01DF3A">HOTEL</th>
        <th bgcolor="#01DF3A">TO</th>
        <th bgcolor="#01DF3A">VISA</th>
        <th bgcolor="#01DF3A">AVIA</th>
        <th bgcolor="#01DF3A">PRICE</th>
        <th bgcolor="#01DF3A">CLOSURE</th>
        <th bgcolor="#01DF3A">WEATHER</th>
    </tr>
    <c:forEach items="${threeDaysToFlightTours}" var="tour">
        <tr>
            <td bgcolor="#E6E6E6"><b>${tour.id}</b></td>
            <td bgcolor="#E6E6E6">${tour.startDate}</td>
            <td bgcolor="#E6E6E6">${tour.endDate}</td>
            <td bgcolor="#E6E6E6">
                <table border="1">
                    <tr>
                        <th bgcolor="#7fffd4"><b>ID</b></th>
                        <th bgcolor="#7fffd4"><b>NAME</b></th>
                        <th bgcolor="#7fffd4"><b>SURNAME</b></th>
                        <th bgcolor="#7fffd4"><b>PHONE</b></th>
                        <th bgcolor="#7fffd4"><b>EMAIL</b></th>
                        <th bgcolor="#7fffd4"><b>BIRTHDAY</b></th>
                        <th bgcolor="#7fffd4"><b>SOURCE</b></th>
                    </tr>
                    <c:forEach items="${tour.touristList}" var="tourist">
                        <tr>
                            <td bgcolor="#F2F2F2">${tourist.id}</td>
                            <td bgcolor="#F2F2F2">${tourist.firstName}</td>
                            <td bgcolor="#F2F2F2">${tourist.lastName}</td>
                            <td bgcolor="#F2F2F2">${tourist.phone}</td>
                            <td bgcolor="#F2F2F2">${tourist.email}</td>
                            <td bgcolor="#F2F2F2">${tourist.birthday}</td>
                            <td bgcolor="#F2F2F2">${tourist.source}</td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
            <td bgcolor="#E6E6E6">
                <table border="1">
                    <tr>
                        <th bgcolor="#dda0dd"><b>ID</b></th>
                        <th bgcolor="#dda0dd"><b>NAME</b></th>
                        <th bgcolor="#dda0dd"><b>RATE</b></th>
                        <th bgcolor="#dda0dd"><b>COUNTRY</b></th>
                        <th bgcolor="#dda0dd"><b>REGION</b></th>
                    </tr>
                    <tr>
                        <td bgcolor="#F2F2F2">${tour.hotel.id}</td>
                        <td bgcolor="#F2F2F2">${tour.hotel.name}</td>
                        <td bgcolor="#F2F2F2">${tour.hotel.rate}</td>
                        <td bgcolor="#F2F2F2"><a
                                href="getHotelsByCountry?country=${tour.hotel.country}">${tour.hotel.country}</a>
                        </td>
                        <td bgcolor="#F2F2F2"><a
                                href="getHotelsByRegion?region=${tour.hotel.region}">${tour.hotel.region}</a></td>
                    </tr>
                </table>
            </td>
            <td bgcolor="#E6E6E6">${tour.tourOperator}</td>
            <td bgcolor="#E6E6E6">${tour.visaRequired}</td>
            <td bgcolor="#E6E6E6">${tour.avia}</td>
            <td bgcolor="#E6E6E6">${tour.priceBrutto}</td>
            <td bgcolor="#E6E6E6">${tour.closureDate}</td>
            <td bgcolor="#E6E6E6"><a href="/weatherForecast?city=${tour.hotel.region}">Forecast</a></td>
        </tr>
    </c:forEach>
</table>
<hr>
<font color="blue"><b>Return today</b></font>
<table>
    <tr>
        <th bgcolor="#01DF3A">ID</th>
        <th bgcolor="#01DF3A">START</th>
        <th bgcolor="#01DF3A">END</th>
        <th bgcolor="#01DF3A">TOURIST LIST</th>
        <th bgcolor="#01DF3A">HOTEL</th>
        <th bgcolor="#01DF3A">TO</th>
        <th bgcolor="#01DF3A">VISA</th>
        <th bgcolor="#01DF3A">AVIA</th>
        <th bgcolor="#01DF3A">PRICE</th>
        <th bgcolor="#01DF3A">CLOSURE</th>
        <th bgcolor="#01DF3A">FEEDBACK</th>
        <th bgcolor="#01DF3A">ACCOUNTING</th>
    </tr>
    <c:forEach items="${returnToday}" var="tour">
        <tr>
            <td bgcolor="#E6E6E6"><b>${tour.id}</b></td>
            <td bgcolor="#E6E6E6">${tour.startDate}</td>
            <td bgcolor="#E6E6E6">${tour.endDate}</td>
            <td bgcolor="#E6E6E6">
                <table border="1">
                    <tr>
                        <th bgcolor="#7fffd4"><b>ID</b></th>
                        <th bgcolor="#7fffd4"><b>NAME</b></th>
                        <th bgcolor="#7fffd4"><b>SURNAME</b></th>
                        <th bgcolor="#7fffd4"><b>PHONE</b></th>
                        <th bgcolor="#7fffd4"><b>EMAIL</b></th>
                        <th bgcolor="#7fffd4"><b>BIRTHDAY</b></th>
                        <th bgcolor="#7fffd4"><b>SOURCE</b></th>
                    </tr>
                    <c:forEach items="${tour.touristList}" var="tourist">
                        <tr>
                            <td bgcolor="#F2F2F2">${tourist.id}</td>
                            <td bgcolor="#F2F2F2">${tourist.firstName}</td>
                            <td bgcolor="#F2F2F2">${tourist.lastName}</td>
                            <td bgcolor="#F2F2F2">${tourist.phone}</td>
                            <td bgcolor="#F2F2F2">${tourist.email}</td>
                            <td bgcolor="#F2F2F2">${tourist.birthday}</td>
                            <td bgcolor="#F2F2F2">${tourist.source}</td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
            <td bgcolor="#E6E6E6">
                <table border="1">
                    <tr>
                        <th bgcolor="#dda0dd"><b>ID</b></th>
                        <th bgcolor="#dda0dd"><b>NAME</b></th>
                        <th bgcolor="#dda0dd"><b>RATE</b></th>
                        <th bgcolor="#dda0dd"><b>COUNTRY</b></th>
                        <th bgcolor="#dda0dd"><b>REGION</b></th>
                    </tr>
                    <tr>
                        <td bgcolor="#F2F2F2">${tour.hotel.id}</td>
                        <td bgcolor="#F2F2F2">${tour.hotel.name}</td>
                        <td bgcolor="#F2F2F2">${tour.hotel.rate}</td>
                        <td bgcolor="#F2F2F2"><a
                                href="getHotelsByCountry?country=${tour.hotel.country}">${tour.hotel.country}</a>
                        </td>
                        <td bgcolor="#F2F2F2"><a
                                href="getHotelsByRegion?region=${tour.hotel.region}">${tour.hotel.region}</a></td>
                    </tr>
                </table>
            </td>
            <td bgcolor="#E6E6E6">${tour.tourOperator}</td>
            <td bgcolor="#E6E6E6">${tour.visaRequired}</td>
            <td bgcolor="#E6E6E6">${tour.avia}</td>
            <td bgcolor="#E6E6E6">${tour.priceBrutto}</td>
            <td bgcolor="#E6E6E6">${tour.closureDate}</td>
            <td bgcolor="#E6E6E6"><a href="/feedback?tourId=${tour.id}">leave feedback</a></td>
            <td bgcolor="#E6E6E6"><a href="/getAccountingByTour?id=${tour.id}">update acts</a></td>
        </tr>
    </c:forEach>
</table>
<hr>
<font color="blue"><b>Birthday today</b></font>
<table border="1">
    <tr>
        <th bgcolor="#01DF3A"><b>ID</b></th>
        <th bgcolor="#01DF3A"><b>FIRST NAME</b></th>
        <th bgcolor="#01DF3A"><b>LAST NAME</b></th>
        <th bgcolor="#01DF3A"><b>PHONE</b></th>
        <th bgcolor="#01DF3A"><b>EMAIL</b></th>
        <th bgcolor="#01DF3A"><b>BIRTHDAY</b></th>
        <th bgcolor="#01DF3A"><b>SOURCE</b></th>
    </tr>
    <c:forEach items="${birthdayToday}" var="tourist">
        <tr>
            <td bgcolor="#E6E6E6">${tourist.id}</td>
            <td bgcolor="#E6E6E6">${tourist.firstName}</td>
            <td bgcolor="#E6E6E6">${tourist.lastName}</td>
            <td bgcolor="#E6E6E6">${tourist.phone}</td>
            <td bgcolor="#E6E6E6">${tourist.email}</td>
            <td bgcolor="#E6E6E6">${tourist.birthday}</td>
            <td bgcolor="#E6E6E6">${tourist.source}</td>
        </tr>
    </c:forEach>
</table>
<hr>
<font color="blue"><b>Ask for feedback</b></font>
<table>
    <tr>
        <th bgcolor="#01DF3A">ID</th>
        <th bgcolor="#01DF3A">START</th>
        <th bgcolor="#01DF3A">END</th>
        <th bgcolor="#01DF3A">TOURIST LIST</th>
        <th bgcolor="#01DF3A">HOTEL</th>
        <th bgcolor="#01DF3A">TO</th>
        <th bgcolor="#01DF3A">VISA</th>
        <th bgcolor="#01DF3A">AVIA</th>
        <th bgcolor="#01DF3A">PRICE</th>
        <th bgcolor="#01DF3A">CLOSURE</th>
        <th bgcolor="#01DF3A">FEEDBACK</th>
        <th bgcolor="#01DF3A">ACCOUNTING</th>
    </tr>
    <c:forEach items="${feedbackPending}" var="tour">
        <tr>
            <td bgcolor="#E6E6E6"><b>${tour.id}</b></td>
            <td bgcolor="#E6E6E6">${tour.startDate}</td>
            <td bgcolor="#E6E6E6">${tour.endDate}</td>
            <td bgcolor="#E6E6E6">
                <table border="1">
                    <tr>
                        <th bgcolor="#7fffd4"><b>ID</b></th>
                        <th bgcolor="#7fffd4"><b>NAME</b></th>
                        <th bgcolor="#7fffd4"><b>SURNAME</b></th>
                        <th bgcolor="#7fffd4"><b>PHONE</b></th>
                        <th bgcolor="#7fffd4"><b>EMAIL</b></th>
                        <th bgcolor="#7fffd4"><b>BIRTHDAY</b></th>
                        <th bgcolor="#7fffd4"><b>SOURCE</b></th>
                    </tr>
                    <c:forEach items="${tour.touristList}" var="tourist">
                        <tr>
                            <td bgcolor="#F2F2F2">${tourist.id}</td>
                            <td bgcolor="#F2F2F2">${tourist.firstName}</td>
                            <td bgcolor="#F2F2F2">${tourist.lastName}</td>
                            <td bgcolor="#F2F2F2">${tourist.phone}</td>
                            <td bgcolor="#F2F2F2">${tourist.email}</td>
                            <td bgcolor="#F2F2F2">${tourist.birthday}</td>
                            <td bgcolor="#F2F2F2">${tourist.source}</td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
            <td bgcolor="#E6E6E6">
                <table border="1">
                    <tr>
                        <th bgcolor="#dda0dd"><b>ID</b></th>
                        <th bgcolor="#dda0dd"><b>NAME</b></th>
                        <th bgcolor="#dda0dd"><b>RATE</b></th>
                        <th bgcolor="#dda0dd"><b>COUNTRY</b></th>
                        <th bgcolor="#dda0dd"><b>REGION</b></th>
                    </tr>
                    <tr>
                        <td bgcolor="#F2F2F2">${tour.hotel.id}</td>
                        <td bgcolor="#F2F2F2">${tour.hotel.name}</td>
                        <td bgcolor="#F2F2F2">${tour.hotel.rate}</td>
                        <td bgcolor="#F2F2F2"><a
                                href="getHotelsByCountry?country=${tour.hotel.country}">${tour.hotel.country}</a>
                        </td>
                        <td bgcolor="#F2F2F2"><a
                                href="getHotelsByRegion?region=${tour.hotel.region}">${tour.hotel.region}</a></td>
                    </tr>
                </table>
            </td>
            <td bgcolor="#E6E6E6">${tour.tourOperator}</td>
            <td bgcolor="#E6E6E6">${tour.visaRequired}</td>
            <td bgcolor="#E6E6E6">${tour.avia}</td>
            <td bgcolor="#E6E6E6">${tour.priceBrutto}</td>
            <td bgcolor="#E6E6E6">${tour.closureDate}</td>
            <td bgcolor="#E6E6E6"><a href="/feedback?tourId=${tour.id}">leave feedback</a></td>
            <td bgcolor="#E6E6E6"><a href="/getAccountingByTour?id=${tour.id}">update acts</a></td>
        </tr>
    </c:forEach>
</table>
<hr>
<font color="blue"><b>Passports due to expire</b></font>
<table border="1">
    <tr>
        <th bgcolor="#01DF3A">ID</th>
        <th bgcolor="#01DF3A">SERIAL NUMBER</th>
        <th bgcolor="#01DF3A">ISSUER</th>
        <th bgcolor="#01DF3A">ISSUE DATE</th>
        <th bgcolor="#01DF3A">EXPIRE DATE</th>
        <th bgcolor="#01DF3A">TOURIST</th>
    </tr>
    <c:forEach items="${passportsDueToExpire}" var="passport">
        <tr>
            <td bgcolor="#E6E6E6">${passport.id}</td>
            <td bgcolor="#E6E6E6">${passport.serialNumber}</td>
            <td bgcolor="#E6E6E6">${passport.issuer}</td>
            <td bgcolor="#E6E6E6">${passport.issueDate}</td>
            <td bgcolor="#E6E6E6">${passport.expireDate}</td>
            <td bgcolor="#E6E6E6"><a href="/getTouristById?id=${passport.tourist.id}">${passport.tourist.id}</a></td>
        </tr>
    </c:forEach>
</table>
<hr>
</body>
</html>
