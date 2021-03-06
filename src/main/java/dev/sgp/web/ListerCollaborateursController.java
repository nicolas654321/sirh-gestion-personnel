package dev.sgp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListerCollaborateursController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// resp.getWriter().write("Hello Lister Collaborateurs Controller");
		
		// recupere la valeur d'un parametre dont le nom estavecPhoto
		String avecPhotoParam = req.getParameter("avecPhoto");
		// recupere la valeur d'un parametre dont le nom estdepartement
		String departementParam = req.getParameter("departement");
		resp.setContentType("text/html");

		// code HTMLecrit dans le corps de la reponse
		resp.getWriter().write("<h1>Liste des collaborateurs</h1>"
		+"<ul>"
		+"<li>avecPhoto="+ avecPhotoParam +"</li>"
		+"<li>departement="+ departementParam +"</li>"
		+"</ul>");
	}
	
}
