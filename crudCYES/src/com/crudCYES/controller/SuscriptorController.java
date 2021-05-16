package com.crudCYES.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crudCYES.dao.PlanDAO;
import com.crudCYES.dao.SuscriptorDAO;
import com.crudCYES.model.Plan;
import com.crudCYES.model.Suscriptor;

/**
 * Servlet implementation class SuscriptorController
 */
@WebServlet(description = "Administra peticiones para la tabla suscriptor", urlPatterns = { "/suscriptor" })
public class SuscriptorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuscriptorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opcion = request.getParameter("opcion");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Views/crear.jsp");
		requestDispatcher.forward(request, response);
		
		if(opcion.equals("crear")) {
			System.out.println("Usted ha presionado la opcion crear");
		}else if(opcion.equals("listar")) {
			System.out.println("Usted ha presionado la opcion listar");
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion=request.getParameter("opcion");
		SuscriptorDAO suscriptorDAO = new SuscriptorDAO();
		Suscriptor suscriptor = new Suscriptor();
		suscriptor.setNomPila(request.getParameter("nomPila"));
		suscriptor.setApPat(request.getParameter("apPat"));
		suscriptor.setApMat(request.getParameter("apMat"));
		suscriptor.setServicio(request.getParameter("servicio"));
		//suscriptor.setFechaNac(request.getParameter("fechaNac"));
		suscriptor.setEstatus(request.getParameter("estatus"));
		suscriptor.setPlan(request.getParameter("plan"));
		try {
			suscriptorDAO.crear(suscriptor);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		String opcion2=request.getParameter("opcion2");
		PlanDAO planDAO = new PlanDAO();
		Plan plan = new Plan();
		plan.setNombre(request.getParameter("nombre"));
		plan.setImporte(request.getParameter("importe"));
		
		try {
			planDAO.crear(plan);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		//doGet(request, response);
	}

}
