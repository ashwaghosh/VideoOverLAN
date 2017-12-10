<%-- 
    Document   : uploader
    Created on : Nov 17, 2016, 12:51:45 PM
    Author     : ROOT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" >
        <title>JSP Page</title>
    </head>
    <body>
        <form action="upload" enctype="multipart/form-data" method="post" >
            <input type="file" name="name" multiple />
            <input type="submit" value="upload" />
        </form>
    </body>
</html>
