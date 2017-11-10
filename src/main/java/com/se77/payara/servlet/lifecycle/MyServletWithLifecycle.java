package com.se77.payara.servlet.lifecycle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(value={"/start","/myServlet"})
public class MyServletWithLifecycle extends HttpServlet {

    @Override
    public void init(){
        System.out.println("Init method called with params :");
        Enumeration<String> params = getServletContext().getInitParameterNames();
        while(params.hasMoreElements()) {
           System.out.println(params.nextElement());
       }
    }



    @Override
    public void destroy(){
        System.out.println("Destroy method called.");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>Hello World</body></html>");
    }

}
