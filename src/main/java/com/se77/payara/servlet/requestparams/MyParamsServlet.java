package com.se77.payara.servlet.requestparams;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value={"/echo","/myServlet"})
public class MyParamsServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        String param1 = request.getParameter("parameter1");
        String param2 = request.getParameter("parameter2");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(param1+param2);
    }

}
