<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tour panel</title>
</head>
  <body>
    <p align="center"><a href="/main.jsp">Main menu</a>
    <p align="right">You are logged in as <b>${userLoggedIn}</b>
    <a href="/login?logout">logout</a></p>

    <hr>
    <b>Find tour by id:</b><br>
    <form action="/getTourById" method="get">
       id = <input type="text" name="id">
       <input type="submit" value="Find">
    </form><hr>

  <b>Create tour:</b><br>
          <form action="/createTour" method="get">
          start = <input type="text" name="startDate">
          end = <input type="text" name="endDate">
          hotel = <input type="text" name="hotelId"><br>
          TO = <input type="text" name="tourOperator" list="tourOperatorList">
                   <datalist id="tourOperatorList">
                               <option value="TPG" selected>TPG</option>
                               <option value="Anex">Anex</option>
                               <option value="TUI">TUI</option>
                               <option value="TEZTour">TEZTour</option>
                               <option value="Coral">Coral</option>
                               <option value="JoinUp">JoinUp</option>
                               <option value="Akkord">Akkord</option>
                   </datalist>
          avia = <input type="text" name="isAvia" list="isAviaList">
                   <datalist id="isAviaList">
                                <option value="true">true</option>
                                <option value="false">false</option>
                   </datalist>
          visa = <input type="text" name="visaRequired" list="visaRequiredList"><br>
                   <datalist id="visaRequiredList">
                                <option value="true">true</option>
                                <option value="false">false</option>
                   </datalist>
          price = <input type="text" name="priceBrutto">
          closure = <input type="text" name="closureDate" placeholder="2016-05-16"><br>
          tourists: <input type="text" name="touristId" placeholder="tourist1">
          <input type="text" name="touristId" placeholder="tourist2">
          <input type="text" name="touristId" placeholder="tourist3">
          <input type="text" name="touristId" placeholder="tourist4">
          <input type="text" name="touristId" placeholder="tourist5">
          <br>
          <input type="submit" value="Create">
      </form>
      <hr>

      <b>Delete tour:</b><br>
          <form action="/deleteTour" method="get">
              id = <input type="text" name="id">
              <input type="submit" value="Delete">
      </form><hr>

  </body>
</html>
