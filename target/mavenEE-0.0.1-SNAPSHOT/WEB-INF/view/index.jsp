<%--
  Created by IntelliJ IDEA.
  User: sador
  Date: 28.02.17
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Menu</title>
</head>
<body>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/CSS/style.css" rel="stylesheet" type="text/css">

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
            <li><a href="/list">List stories</a></li>
            <li><a href="/login">
                <span class="glyphicon glyphicon-user"></span>
                Login</a></li>
            <li><a href="#">
                <span class="glyphicon glyphicon-log-out"></span>
                Log out</a></li>
        </ul>
    </div>
</nav>
<h1>Welcome to SuperSprinter 3000!</h1>
<h2>Here you can add new user stories to your list, and edit/delete them the way you like!</h2>


</body>
</html>
