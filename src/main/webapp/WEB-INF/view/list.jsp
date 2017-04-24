<%--
  Created by IntelliJ IDEA.
  User: sador
  Date: 02.03.17
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Super Sprinter 3000</title>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/CSS/style.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
    <script src="/resources/CSS/javascr.js"></script>

</head>
<body id="sonkisz">
<nav class="navbar navbar-default navbar-fixed-top" id="navbar_what">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">
                <span class="glyphicon glyphicon-home"></span>
                SuperSprinter3000</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/story">Add Story</a></li>
            <li class="active"><a href="/list">List stories</a></li>
            <li><a href="/login">
                <span class="glyphicon glyphicon-user"></span>
                Login</a></li>
            <li><a href="#">
                <span class="glyphicon glyphicon-log-out"></span>
                Log out</a></li>
        </ul>
    </div>
</nav>
<table class="stories">
    <thead class="thead-inverse">
    <tr>

        <th>
        Story Id
    </th>
        <th>Title</th>
        <th>Story</th>
        <th>Criteria</th>
        <th>Value</th>
        <th>Estimation</th>
        <th>Status</th>

        </tr>
    </thead>
<c:forEach var="story" items="${story_list}">
<tr id="td_ee">
    <td>
        ${story.id}
    </td>
    <td width=200px>
        ${story.title}
    </td>
    <td width="300px">
        ${story.story}
    </td>
    <td width="400px">
        ${story.criteria}
    </td>
    <td>
        ${story.value}
    </td>
    <td>
        ${story.estimation}
    </td>
    <td>
        ${story.status}
    </td>
    <form action="/delete" method="get">
        <div class="tooltip">
        <th>
                <a data-toggle="tooltip" title="Warning! This will delete the item from the table!" href="<c:url value="/list.html?id=${story.id}" />"
                   name="delete" id="icon_link"><span  class="glyphicon glyphicon-trash"></span></a></th>
                    </a>
        </th>


    <form action="/edit" method="get">
        <th><a id="icon_link"  data-toggle="tooltip" title="Edit the current row" href="<c:url value="/edit?id=${story.id}" />" name="edit">
            <span  class="glyphicon glyphicon-edit"></span></a></th>
</tr>
</c:forEach>
</table>
</body>
</html>
