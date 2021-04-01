<%--
  Created by IntelliJ IDEA.
  User: astri
  Date: 1/04/2021
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Toevoegen</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="Servlet?command=overzicht">Toon woordenlijst</a></li>
            <li><a href="voegtoe.jsp">Nieuw woord</a></li>
        </ul>
    </nav>
</header>
<main>
    <h1>Woord toevoegen</h1>
    <!-- NOVALIDATE NIET VERGETEN WEG TE DOEN!!!!!!!!!!!!-->
    <form action="Servlet?command=add" method="POST" novalidate>
        <label for="WoordInhoud">Woord:</label>
        <input id="WoordInhoud" class="tekstinput" name="WoordInhoud" type="text" required>
        <br>
        <label for="WoordNiveau">Niveau:</label>
        <select id="WoordNiveau" class="tekstinput" name="WoordNiveau">
            <option value="" selected>Geen</option>
            <option value="beginner">Beginner</option>
            <option value="expert">Expert</option>
        </select>
        <br>
        <input type="submit" class="button" value="Voeg toe">
    </form>
</main>
</body>
</html>
