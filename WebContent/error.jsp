<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html>
        <head>
            <title>Error</title>
        </head>
        <body>
            <h3>Error</h3>
            <hr/>
            <jsp:expression>(request.getAttribute("errorMessage") != null) ? (String) request.getAttribute("errorMessage") : "unknown error"</jsp:expression>
            <hr/>
            <a href="controller">Return to login page</a>
        </body>
    </html>
