/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ROOT
 */
public class MyFiles extends HttpServlet {

    char ch[]=new char[4096];
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              response.setContentType(null);
        PrintWriter out = response.getWriter();
        String path = request.getParameter("t1");

        if (path.equals("home")) {
            out.print("<head><body bgcolor=yellow ><center><br><br><table cellspacing=10 >");
            File[] listRoots = File.listRoots();
            for (File f : listRoots) {
                out.print("<tr><td><h1><a href=MyFiles?t1=" + f + " > Drive <B>" + f + "</B></a></h1>");
                out.print("</td></tr>");
            }
            out.print("</table></center></body></head>");
        } else {
            File f = new File(path);
            if (f.isDirectory()) {
                out.print("<head><body>");
                File[] listFiles = f.listFiles();
                for (File x : listFiles) {
                    String url = x.toString();
                    String newurl = stringToUrl(url);
                    String fileType="";
                    if(x.isDirectory())
                        out.print("<h3><a href=MyFiles?t1=" + newurl + "> DIR  " + x.getName() + "</a></h3>");
                    else
                    {
                        out.print("<br><br><a href=playvideo.jsp?t1="+newurl+" >FILE  "+x.getName()+"</a>");
                        out.print("<br><a href=MyFiles?t1="+newurl+" >Download link...</a>");
                    }
                }
                out.print("</body></head>");
            } else {
                response.setHeader("Content-Disposition", "attachment; filename = "+f.getName());
                response.setContentLength((int) f.length());
                FileInputStream fin = new FileInputStream(f);
                BufferedInputStream bin=new BufferedInputStream(fin);
                int no=bin.read();
                while(no != -1)
                {
                    out.write(no);
                    no=bin.read();
                }
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String stringToUrl(String name)
    {
        String url="";
        for (int i = 0; i < name.length(); i++) {
                        if (name.charAt(i) == ' ') {
                            url = url + "%20";
                        } else {
                            url = url + name.charAt(i);
                        }
                    }
        return url;
    }
}
