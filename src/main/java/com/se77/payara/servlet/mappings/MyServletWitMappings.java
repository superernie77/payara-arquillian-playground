package com.se77.payara.servlet.mappings;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="myServlet", urlPatterns={"/start2","/myServlet2"})
public class MyServletWitMappings extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        response.getOutputStream().println("Hello World!");
    }

}
