<%-- 
    Document   : playvideo
    Created on : Nov 13, 2016, 11:15:14 AM
    Author     : ROOT
--%>

<%@page import="java.net.InetAddress"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            String s=request.getParameter("t1");
            out.print(s);
                      
                    String newurl = "";
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == ' ') {
                            newurl = newurl + "%20";
                        } else {
                            newurl = newurl + s.charAt(i);
                        }
                    }
            out.print("<br><video controls width=100% height=600 poster=images/img.png ><source src=MyFiles?t1="+newurl+"></source> </video>");
            %>
    </body>
</html>
