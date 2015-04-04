package org.can;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "A simple servlet", urlPatterns = { "/SimpleServletPath" })/**urlPattern is the servlet name*/
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		String[] picked = request.getParameterValues("player");
		
		double gamep=Double.parseDouble(request.getParameter("gamep"));
		double socialp=Double.parseDouble(request.getParameter("socialp"));
		double gameWeight=gamep/(gamep+socialp);
		//System.out.println(gameWeight);
		List<Player> playerList=new ArrayList<Player>();
		if (picked != null && picked.length != 0) {
			for(int i=0; i<picked.length; i++){
				DBConnection playerInfo=new DBConnection("SELECT * FROM players where name='"+picked[i]+"'");
				ResultSet info=playerInfo.getData();
				try {
					while(info.next()){
						Player person=new Player(info.getString("name"),info.getDouble("injuryOdds"),info.getDouble("tacticGoodOdds"),info.getDouble("PAE"),info.getDouble("PAG"),info.getDouble("commercialEventsRateHighOdds"),info.getDouble("scandalWillAppearOdds"),info.getString("position"));
						playerList.add(person);
						//System.out.println(person.getNotInjueryOdds());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		request.setAttribute("playerList", playerList); 
		InfluenceDiagram id = new InfluenceDiagram();
		HashMap<String, Double> res = id.constructDiagram(playerList, gameWeight);
		request.setAttribute("score", res); 
		RequestDispatcher rd = request.getRequestDispatcher("weights.jsp");
		rd.forward(request, response);
		

		
	}

}
