<%@ page import="domain.model.Woord" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Woordenlijst</title>
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
    <h1>Woordenlijst</h1>
    <a href="Servlet?command=download">Download woordenlijst</a>
    <br><br>
    <table>
        <tr>
            <th>#</th>
            <th>Woord</th>
            <th>Niveau</th>
        </tr>
            <%  ArrayList<Woord> woordenlijst = (ArrayList<Woord>) request.getAttribute("woordenlijst");
                for (int i = 0; i < woordenlijst.size(); ++i) { %>
        <tr>
            <td><%=i+1%></td>
            <td><%=woordenlijst.get(i).getInhoud()%></td>
            <td>
                <%  String niveau = woordenlijst.get(i).getNiveau();
                    if (niveau == null || niveau.isEmpty()) {%>

                <% } else {%>
                    <%=niveau%>
                <% }}%>
            </td>
        </tr>
    </table>
</main>
</body>
</html>

</body>
</html>
