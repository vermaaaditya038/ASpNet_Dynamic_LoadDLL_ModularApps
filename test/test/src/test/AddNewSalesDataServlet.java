package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewSalesDataServlet
 */
@WebServlet("/SportsStoreTest/AddNewSalesDataServlet")
public class AddNewSalesDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewSalesDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String region_name = request.getParameter("region_name");
		String state_id = request.getParameter("state_id");
		String url = "jdbc:oracle:thin://@localhost:1521:XE";
		String username="rs";	
		String password="rangesh";
		Connection con = null;
		
		response.setContentType("text/html");
		PrintWriter pr = response.getWriter();
		ResultSet store_result_set = null;
		PreparedStatement add_region_stat = null;
		PreparedStatement select_region_details = null;
		System.out.println("Entering database");

		try
		{
		Class.forName("oracle.jdbc.OracleDriver");
		}
		catch(java.lang.ClassNotFoundException e){
		System.err.println("ClassNotFoundException:");
		System.err.println(e.getMessage());
		}

		try {
		con = DriverManager.getConnection(url,username,password);
		System.out.println("Entering 2nd try");
		add_region_stat = con.prepareStatement("INSERT INTO REGION(REGION_NAME,STATE_ID)"
				+ " VALUES(?,?)");
		
		
//		Statement sales_statement = con.createStatement();
		
		add_region_stat.setString(1,region_name);

		add_region_stat.setString(2,state_id);

		add_region_stat.executeUpdate();
		 
		con.commit();
		select_region_details = con.prepareStatement("SELECT * FROM REGION");
		
		store_result_set = select_region_details.executeQuery();
		
pr.println("<!DOCTYPE HTML><html lang=\"en\">");
		
		pr.println("<head>"
				+ "<title>SPORTS STOP</title>"
				+ "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />"
						+ "<meta name=\"description\" content=\"\" />"
								+ "<meta name=\"keywords\" content=\"\" />"
										+ "<!--[if lte IE 8]><script src=\"css/ie/html5shiv.js\"></script><![endif]-->"
										+ "<script src=\"js/jquery.min.js\"></script>"
										+ "<script src=\"js/jquery.dropotron.min.js\"></script>"
										+ "<script src=\"js/jquery.scrolly.min.js\"></script>"
										+ "<script src=\"js/jquery.scrollgress.min.js\"></script>"
										+ "<script src=\"js/skel.min.js\"></script>"
										+ "<script src=\"js/skel-layers.min.js\"></script>"
										+ "<script src=\"js/edit-sales-option.js\"></script>"
										+ "<script src=\"js/init.js\"></script>"
										+ "<script src=\"js/add-sales-region.js\"></script>"
										+ "<noscript>"
										+ "<link rel=\"stylesheet\" href=\"css/skel.css\" />"
										+ "<link rel=\"stylesheet\" href=\"css/style.css\" />"
										+ "<link rel=\"stylesheet\" href=\"css/style-wide.css\" />"
										+ "<link rel=\"stylesheet\" href=\"css/style-noscript.css\" />"
										+ "</noscript>"
										+ "</head>");
		pr.println("<body class=\"index\">");
		pr.println("<section class=\"wrapper style4 special container 75%\" style=\"background-color:black \">"
				+ "<div>"
				+ "<h2>NEW STORE ADDED</h2>");
		
			pr.println("<table BORDER=\"3\" BORDERCOLOR=\"RED\">");

			
			pr.println("<th> REGION_ID </th><th> STATE_ID </th><th> CREATED_BY </th><th>REGION_NAME </th>");
			
			System.out.println("resultset value"+store_result_set.next());	
			while(store_result_set.next())
			{
					
					
					int sales_id = store_result_set.getInt("REGION_ID");
					
					String created_by = store_result_set.getString("CREATED_BY");
					String last_by = store_result_set.getString("REGION_NAME");
					
					int final_state_id = store_result_set.getInt("STATE_ID");
					
					pr.println("<tr >"
							+ "<td width:15px,height:10px >"
							+ sales_id
							+ "</td>"
							+ "<td>"
							+ final_state_id
							+ "</td>"
							+ "<td>"
							+ created_by
							+"</td>"
							+ "<td>"
							+ last_by
							+ "</td>"
							+"</tr>");
					
		}
			pr.println("</table>"
					+ "<ul><li><a href=\"admin-home.html\" class=\"button special\">GO BACK</a></li></ul></div></section>");
		pr.println("</body>");
		pr.println("</html>");
		
		}
		catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      try {
		    	 // result.close();
		    	  con.commit();
		    	  add_region_stat.close();
		    	  select_region_details.close();
		        con.close();
		      } catch (SQLException e) {
		    	  response.sendRedirect("twocolumn2.html");
		        e.printStackTrace();
		      }
		    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
