package nl.hu.v1ipass.applicatie.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hu.v1ipass.applicatie.persistene.Kamer;
import nl.hu.v1ipass.applicatie.persistene.KamerDAO;

@WebServlet(urlPatterns = "/DynamicServlet.do")
public class DynamicServlet extends HttpServlet {
	private static final String SHOW = "/showKamer.jsp";
	private KamerDAO dao;
	
	public DynamicServlet(){
		dao = new KamerDAO();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forward = "";

		forward = SHOW;
		req.setAttribute("students", dao.getKamer());
		
		RequestDispatcher view = req.getRequestDispatcher(forward);
		view.forward(req, resp);
	}
}
