package test;

import java.io.IOException;
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
 * Servlet implementation class EditSalesDataServletState
 */
@WebServlet("/SportsStoreTest/EditSalesDataServletState")
public class EditSalesDataServletState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSalesDataServletState() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sales_id =request.getParameter("salesid");
		String sales_amount = request.getParameter("salesamount");
		String state_id = request.getParameter("stateid");
		String admin_user_name = request.getParameter("adminusername");
		
		ModelSportStop model =new ModelSportStop();
		String url = "jdbc:oracle:thin://@localhost:1521:XE";
		String username="rs";	
		String password="rangesh";
		Connection con = null;
		ResultSet state_name_resultset = null;
		PreparedStatement edit_state_sales_stat = null;
		PreparedStatement state_name_ppmt = null;
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
		edit_state_sales_stat = con.prepareStatement("UPDATE SALES SET SALES_AMOUNT=?, STATE_ID=?,"
				+ " LAST_UPDATED_BY=?"
				+ " WHERE SALE_ID=?");
		
		
//		Statement sales_statement = con.createStatement();
		
		edit_state_sales_stat.setString(1,sales_amount);

		edit_state_sales_stat.setString(2,state_id);

		edit_state_sales_stat.setString(3,admin_user_name);

		edit_state_sales_stat.setString(4,sales_id);
		edit_state_sales_stat.executeUpdate();
		 
		con.commit();
		
		state_name_ppmt= con.prepareStatement("SELECT STATE_NAME FROM STATE WHERE STATE_ID=?");
		
		int i = Integer.parseInt(state_id);
		state_name_ppmt.setInt(1, i);
		System.out.println("Integer Value"+i);
		state_name_resultset = state_name_ppmt.executeQuery();
//		System.out.println("RESULTSET VALUE"+region_name_resultset.next());
	if(state_name_resultset.next())
	{
		String state_name = state_name_resultset.getString("STATE_NAME");
			System.out.println("STATE NAME"+state_name);
			model.setStateName(state_name);
			getServletContext().setAttribute("state_name", state_name);
			response.sendRedirect("/test/SportsStoreTest/SearchSalesDataServletState");
	}		
			
//			System.out.println("EDIT SERVLET MODEL VALUE"+model.getRegionName());
	else
	{
		response.sendRedirect("twocolumn2.html");
	}
		}
		catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      try {
		    	 // result.close();
		    	  con.commit();
		    	  state_name_ppmt.close();
		    	  edit_state_sales_stat.close();
		        con.close();
		      } catch (SQLException e) {
		    	  response.sendRedirect("SignInError.jsp");
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
