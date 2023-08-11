package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/jspservelt-app-bmi-calculator/main"})
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
    }




	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
    	String name = request.getParameter("name");
		double height = Double.parseDouble(request.getParameter("height"));
		double weight = Double.parseDouble(request.getParameter("weight"));
		
		double heightInMeter = height/100;
	
		double roundOffBMI  = CalculateBMI.calculate(heightInMeter, weight);
		
		request.setAttribute("name", name);
		request.setAttribute("value",roundOffBMI);
		
		String calculate = request.getParameter("calculate");
		
		String description = CalculateBMI.description(roundOffBMI);
		if(calculate != null) {
			request.setAttribute("description",description);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
}
