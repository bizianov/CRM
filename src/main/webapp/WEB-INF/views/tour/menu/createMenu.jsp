<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create tour panel</title>
</head>
  <body>
    <p align="center"><a href="/tour">Tour menu</a>
    <p align="right">You are logged in as <b>${userLoggedIn}</b>
    <a href="/login?logout">logout</a></p>

    <hr>
    <form action="/createTourWithParameters" method="get">
    <b>Tour</b><br>
    start = <input type="text" name="startDate" placeholder="2016-05-16">
    end = <input type="text" name="endDate" placeholder="2016-05-16">
    closure = <input type="text" name="closureDate" placeholder="2016-05-16">
    TO = <input type="text" name="tourOperator" list="tourOperatorList">
        <datalist id="tourOperatorList">
             <option value="TPG" selected>TPG</option>
             <option value="Anex">Anex</option>
             <option value="TUI">TUI</option>
             <option value="TEZTour">TEZTour</option>
             <option value="Coral">Coral</option>
             <option value="JoinUp">JoinUp</option>
             <option value="Akkord">Akkord</option>
        </datalist><br>
    avia = <input type="text" name="isAvia" list="isAviaList">
           <datalist id="isAviaList">
               <option value="true">true</option>
               <option value="false">false</option>
           </datalist>
    visa = <input type="text" name="visaRequired" list="visaRequiredList">
           <datalist id="visaRequiredList">
               <option value="true">true</option>
               <option value="false">false</option>
           </datalist>
    price = <input type="text" name="priceBrutto">
    <hr>
    <b>Hotel</b><br>
    id = <input type="text" name="hotelId">
    name = <input type="text" name="name">
    rate = <input type="text" name="rate" list="ratelist">
              <datalist id="ratelist">
                        <option value="FIVE" selected>FIVE</option>
                        <option value="FOUR">FOUR</option>
                        <option value="THREE">THREE</option>
                        <option value="TWO">TWO</option>
                        <option value="ONE">ONE</option>
              </datalist>
    country = <input type="text" name="country">
    region = <input type="text" name="region">
    <hr>
    <b>Tourist 1</b><br>
    id = <input type="text" name="id_1"><br>
    name = <input type="text" name="firstName_1">
    surname = <input type="text" name="lastName_1"><br>
    phone = <input type="text" name="phone_1">
    email = <input type="text" name="email_1">
    birthday = <input type="text" name="birthday_1" placeholder="2016-05-16">
    source = <input type="text" name="source_1" list="sourcelist"><br>
             <datalist id="sourcelist">
                       <option value="REGULAR" selected>REGULAR</option>
                       <option value="WEBSITE">WEBSITE</option>
                       <option value="REFERRAL">REFERRAL</option>
                       <option value="CASUAL">CASUAL</option>
                       <option value="OTHER">OTHER</option>
             </datalist>
    <b>Tourist 2</b><br>
    id = <input type="text" name="id_2"><br>
    name = <input type="text" name="firstName_2">
    surname = <input type="text" name="lastName_2"><br>
    phone = <input type="text" name="phone_2">
    email = <input type="text" name="email_2">
    birthday = <input type="text" name="birthday_2" placeholder="2016-05-16">
    source = <input type="text" name="source_2" list="sourcelist"><br>
             <datalist id="sourcelist">
                       <option value="REGULAR" selected>REGULAR</option>
                       <option value="WEBSITE">WEBSITE</option>
                       <option value="REFERRAL">REFERRAL</option>
                       <option value="CASUAL">CASUAL</option>
                       <option value="OTHER">OTHER</option>
             </datalist>
    <b>Tourist 3</b><br>
    id = <input type="text" name="id_3"><br>
    name = <input type="text" name="firstName_3">
    surname = <input type="text" name="lastName_3"><br>
    phone = <input type="text" name="phone_3">
    email = <input type="text" name="email_3">
    birthday = <input type="text" name="birthday_3" placeholder="2016-05-16">
    source = <input type="text" name="source_3" list="sourcelist"><br>
             <datalist id="sourcelist">
                       <option value="REGULAR" selected>REGULAR</option>
                       <option value="WEBSITE">WEBSITE</option>
                       <option value="REFERRAL">REFERRAL</option>
                       <option value="CASUAL">CASUAL</option>
                       <option value="OTHER">OTHER</option>
             </datalist>
    <b>Tourist 4</b><br>
    id = <input type="text" name="id_4"><br>
    name = <input type="text" name="firstName_4">
    surname = <input type="text" name="lastName_4"><br>
    phone = <input type="text" name="phone_4">
    email = <input type="text" name="email_4">
    birthday = <input type="text" name="birthday_4" placeholder="2016-05-16">
    source = <input type="text" name="source_4" list="sourcelist"><br>
             <datalist id="sourcelist">
                       <option value="REGULAR" selected>REGULAR</option>
                       <option value="WEBSITE">WEBSITE</option>
                       <option value="REFERRAL">REFERRAL</option>
                       <option value="CASUAL">CASUAL</option>
                       <option value="OTHER">OTHER</option>
             </datalist>
    <hr>
    <input type="submit" value="Create tour">
    </form>

  </body>
</html>