package dev.sgp.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, String> createMap(HttpServletRequest req) {
		HashMap<String, String> mesParams = new HashMap<String, String>();
		mesParams.put("matricule",  "");
		mesParams.put("titre",  "");
		mesParams.put("nom",  "");
		mesParams.put("prenom",  "");
		for (String key : mesParams.keySet()) {
			if (req.getParameterMap().containsKey(key)) {
				mesParams.put(key, req.getParameter(key)); 
			}
		}
		return mesParams;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HashMap <String, String> mesParams = createMap(req);
		resp.setContentType("text/html");

		if (mesParams.get("matricule") == "") {
			resp.setStatus(400);
			resp.getWriter().write("<h1>Erreur : un matricule est attendu !</h1>");		
		} else {
			resp.setStatus(200);
			resp.getWriter().write("<h1>Edition de collaborateur</h1>"
					+"<h2>Matricule : "+ mesParams.get("matricule") +"</h2>"
					+"<ul>"
					+"<li>POST /collaborateurs/editer</li>"
					+"<ul>"
					+"<li>la servlet vérifie que les paramètres suivants sont renseignés : </li>"
					+"<ul>"
					+"<li>matricule</li>"
					+"<li>titre,</li>"
					+"<li>nom</li>"
					+"<li>prénom</li>"
					+"</ul>"
					+"</ul>"
					+"<li>Si au moins une des informations est manquante, alors la réponse générée aura un code 400 et un texte générique : les paramètres suivants sont incorrects</li>"
					+"</ul>"					
					);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HashMap <String, String> mesParams = createMap(req);
		resp.setContentType("text/html");
		String paramManquants = "";
		for (String key : mesParams.keySet()) {
			if (mesParams.get(key) == "") {
				paramManquants += "<li>"+key+"</il>";
			}
		}
		
		if (paramManquants == "") {
			resp.setStatus(201);
			resp.getWriter().write("Création d'un collaborateur avec les informations suivantes : <br>"
					+"<ul><li>matricule="+mesParams.get("matricule")+",titre="+mesParams.get("titre")
					+",nom="+mesParams.get("nom")+",prenom="+mesParams.get("prenom")+"</li></ul>");		
		} else {
			resp.setStatus(400);
			resp.getWriter().write("<h1>Les paramètres suivants sont incorrects : </h1>"
					+"<ul>"+paramManquants+"</ul>"
					);
		}
		
	}

	
}
