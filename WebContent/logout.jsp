<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Selection Comitee</title>

    <link href="css/bootstrap.css" rel="stylesheet">
    <style>
      body {
        padding-top: 60px;
      }
    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <%@taglib uri="/WEB-INF/tlds/sessiontag.tld" prefix="sessiontag" %>
          <a class="brand" href="#"><sessiontag:do/></a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <%@taglib uri="/WEB-INF/tlds/generalmenutag.tld" prefix="generalmenutag" %>
			  <generalmenutag:do/>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">

       <h1>Logout</h1>
       <form name="logoutForm" method="POST" action="controller">
            <input type="hidden" name="command" value="logout">
               <input type="submit" value="Logout">
       </form>

    </div> 

  </body>
</html>
