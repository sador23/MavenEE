<%--
  Created by IntelliJ IDEA.
  User: sador
  Date: 01.03.17
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Super Sprinter 3000 - Add new Story</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

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
            <li class="active"><a href="/story">Add Story</a></li>
            <li><a href="/list">

                List stories</a></li>
            <li><a href="/login">
                <span class="glyphicon glyphicon-user"></span>
                Login</a></li>
            <li><a href="#">
                <span class="glyphicon glyphicon-log-out"></span>
                Log out</a></li>
        </ul>
    </div>
</nav>
    <h1 id="h1cent">
        User Story Manager - ${welcome}
    </h1>
    <form id="input_fields" class="form-horizontal" action=${action} method="post">
        <fieldset>
            <legend>Add a new Story!</legend>
        <div class="form-group">
            <label class="col-lg-2 control-label" for="title">Story Title</label>
            <div class="col-lg-10">
        <input  placeholder="User title" type="text" id="title" class="form-control" name="title" value='${story.title}' >
            </div>
        </div>
        <div class="form-group">
            <label for="story" class="col-lg-2 control-label">User Story</label>
            <div class="col-lg-10">
            <input type="text" value='${story.story}' placeholder="User Story" class="form-control"  id="story" name="story"  >
            </div>
        </div>
        <div class="form-group"><label for="criteria" class="col-lg-2 control-label">Story Criteria</label>
            <div class="col-lg-10">
            <input placeholder="User Criteria" type="text" class="form-control"  id="criteria" name="criteria" value='${story.criteria}' >
            </div>
        </div>
            <div class="form-group"><label for="value" class="col-lg-2 control-label">Business Value</label>
                <div class="col-lg-10">
                <input placeholder="Story's business value" type="number" class="form-control" min="100" max="1500" step="100" name="value" id="value" value=${story.value} >
                </div>
            </div>
                <div class="form-group"><label for="estimation" class="col-lg-2 control-label">Estimation(h)</label>
                    <div class="col-lg-10">
        <input placeholder="Story's estimation time" type="number" class="form-control" min="0.5" value=${story.estimation} step="0.5" max="40" name="estimation" id="estimation">
                    </div>
                    <div class="form-group" id="selector">
                        <label for="status" class="col-lg-2 control-label" id="padselector">Status</label>
                        <div class="col-lg-10" id="padselector">
        <select id="status" name="status" class="form-control">
            <option value="planning" ${not empty story.status && story.status == "planning" ? 'selected' : ''}>Planning</option>
            <option value="todo" ${not empty story.status && story.status == "todo" ? 'selected' : ''}>To do</option>
            <option value="progress" ${not empty story.status && story.status == "progress" ? 'selected' : ''}>In Progress</option>
            <option value="Review"${not empty story.status && story.status == "Review" ? 'selected' : ''}>Review</option>
            <option value="Done" ${not empty story.status && story.status == "Done" ? 'selected' : ''}>Done</option>
        </select>
                        </div>
                    </div>
       <div class="form-group">
           <div class="col-lg-10 col-lg-offset-2">
           <input type="submit" class="btn btn-success" value=${submit}></div>
       </div>
        </fieldset>
    </form>
</body>
</html>
