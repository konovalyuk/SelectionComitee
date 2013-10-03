<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
      <br/>

 	  <table border="1">
 	  <tr><th>Faculty</th><th>Results</th></tr>
	  <c:forEach items="${faculties}" var="faculty">
		  <tr>
		  <td><c:out value="${faculty}"/></td>
 		  <td>
 		    <form name="adminListForm" method="POST" action="controller">
 		    <input type="hidden" name="command" value="viewapplicants">
		    <input type="hidden" name="faculty" value="${faculty}">
		    <input type="submit" value="View"></input></form>
		  </td>
 		  </tr>
	  </c:forEach>
      </table>
      
      <br/>
      <br/>
      <br/>
	  <h2>Faculty: <c:out value="${facname}"/></h2>
	  <br/>
	  <h4>List of passed applicants:</h3>
	  <table style="display: inline-block;">
 	  <tr><th>Applicant name</th></tr>
	  	  
	  	  <c:forEach items="${fullnames}" var="name">
		  <tr>
		  <td>
		    <c:out value="${name}"/>
		  </td>
		  </tr>
		  </c:forEach>
		
      </table>
      
      <table style="display: inline-block;">
 	  <tr><th>Grade</th></tr>
	  	  
 		  <c:forEach items="${fullgrades}" var="grade">
 		  <tr>
		  <td>
		    <c:out value="${grade}"/>
		  </td>
		  </tr>
		  </c:forEach>
	  
      </table>
	  
    </div> 
    
  </body>
</html>
