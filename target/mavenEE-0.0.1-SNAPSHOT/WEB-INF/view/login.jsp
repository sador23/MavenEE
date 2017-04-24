
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/CSS/style.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
    <script src="/resources/CSS/javascr.js"></script>
</head>

<body id="sonkisz">
Welcome to login! Finally!

<nav class="navbar navbar-default navbar-fixed-top" id="navbar_what">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">
                <span class="glyphicon glyphicon-home"></span>
                SuperSprinter3000</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/story">Add Story</a></li>
            <li><a href="/list">

                List stories</a></li>
            <li class="active" ><a href="/login">
                <span class="glyphicon glyphicon-user"></span>
                Login</a></li>
            <li><a href="#">
                <span class="glyphicon glyphicon-log-out"></span>
                Log out</a></li>
            <li><a href="/todo">
                To do</a></li>

        </ul>
    </div>
</nav>


<h1>${error}</h1>
<form action="/login" method="post">
<input type="text" name="name" id="input_name">
    <input type="password" name="password" id="psw">
<input type="submit">
</form>
</body>
</html>
