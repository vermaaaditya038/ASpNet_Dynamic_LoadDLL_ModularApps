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
 * Servlet implementation class AddStoreDataServlet
 */
@WebServlet("/SportsStoreTest/AddStoreDataServlet")
public class AddStoreDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStoreDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String region_id = request.getParameter("store_region_id");
		String state_id = request.getParameter("store_state_id");
		String store_location = request.getParameter("storelocation");
		String store_username = request.getParameter("storeusername");
		String url = "jdbc:oracle:thin://@localhost:1521:XE";
		String username="rs";	
		String password="rangesh";
		Connection con = null;
		
		response.setContentType("text/html");
		PrintWriter pr = response.getWriter();
		ResultSet store_result_set = null;
		PreparedStatement edit_store_sales_stat = null;
		PreparedStatement select_store_details = null;
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
		edit_store_sales_stat = con.prepareStatement("INSERT INTO STORE(REGION_ID,STATE_ID,STORE_LOCATION,LAST_UPDATED_BY)"
				+ " VALUES(?,?,?,?)");
		
		
//		Statement sales_statement = con.createStatement();
		
		edit_store_sales_stat.setString(1,region_id);

		edit_store_sales_stat.setString(2,state_id);

		edit_store_sales_stat.setString(3,store_location);

		edit_store_sales_stat.setString(4,store_username);
		edit_store_sales_stat.executeUpdate();
		 
		con.commit();
		select_store_details = con.prepareStatement("SELECT * FROM STORE");
		
		store_result_set = select_store_details.executeQuery();
		
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

			
			pr.println("<th> STORE_ID </th><th> REGION_ID </th><th> STATE_ID </th><th> CREATED_BY </th><th>STORE_LOCATION </><th> LAST_UPDATED_BY </th>");
			
			System.out.println("resultset value"+store_result_set.next());	
			while(store_result_set.next())
			{
					
					
					int sales_id = store_result_set.getInt("STORE_ID");
					
					String created_by = store_result_set.getString("CREATED_BY");
					String last_by = store_result_set.getString("STORE_LOCATION");
					int sales_amt = store_result_set.getInt("REGION_ID");
					int final_state_id = store_result_set.getInt("STATE_ID");
					String last_updated_by = store_result_set.getString("LAST_UPDATED_BY");
					pr.println("<tr >"
							+ "<td width:15px,height:10px >"
							+ sales_id
							+ "</td>"
							+ "<td>"
							+ sales_amt
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
							+ "<td>"
							+ last_updated_by
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
		    	  edit_store_sales_stat.close();
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
