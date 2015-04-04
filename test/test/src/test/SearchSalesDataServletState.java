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
 * Servlet implementation class SearchSalesDataServletState
 */
@WebServlet("/SportsStoreTest/SearchSalesDataServletState")
public class SearchSalesDataServletState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSalesDataServletState() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String st = request.getParameter("state");
		ModelSportStop model = new ModelSportStop();
		
		String url = "jdbc:oracle:thin://@localhost:1521:XE";
		String username="rs";	
		String password="rangesh";
		Connection con = null;
		ResultSet resultsetstate = null;
		PreparedStatement sales_stat_state = null;
		System.out.println("Entering database");
//		String query="SELECT * FROM SALES WHERE REGION_NAME = 1";
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
		sales_stat_state = con.prepareStatement("SELECT * FROM SALES WHERE STATE_ID = (SELECT STATE_ID FROM STATE WHERE STATE_NAME = ?) ORDER BY SALE_ID");
	
//		Statement sales_statement = con.createStatement();
		
		
		String test ;
		
		if(st!=null)
		{
			model.setStateName(st);
			test = model.getStateName();
			System.out.println("STATE_NAME"+test);
			sales_stat_state.setString(1,test);
		}
		else
		{
			
			test =(String) getServletContext().getAttribute("state_name");
			System.out.println("The con value ins"+test);
			sales_stat_state.setString(1,test);
		}
		
		resultsetstate= sales_stat_state.executeQuery();
		//html code starts here
		response.setContentType("text/html");
		PrintWriter pr = response.getWriter();
		
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
										+ "<noscript>"
										+ "<link rel=\"stylesheet\" href=\"css/skel.css\" />"
										+ "<link rel=\"stylesheet\" href=\"css/style.css\" />"
										+ "<link rel=\"stylesheet\" href=\"css/style-wide.css\" />"
										+ "<link rel=\"stylesheet\" href=\"css/style-noscript.css\" />"
										+ "</noscript>"
										+ "</head>");
		pr.println("<body class=\"index\">");
	
	
		pr.println("<header id=\"header\" class=\"alt\">"
				+ "<h1 id=\"logo\"><a href=\"index.html\">SPORTS <span>STOP</span></a></h1>"
				+ "<nav id=\"nav\">"
				+ "<ul>"
				+ "<li><h2>SALES BY STATE</h2></li>"
				+ "<li><a href=\"admin-home.html\" class=\"button special\">GO BACK</a></li></ul>"
				+ "</nav></header>"
				+ "<section id=\"banner\"><div class=\"wrapper style4 special container 75%\" style=\"background-color:black\">");
					
		pr.println("<table BORDER=\"3\" BORDERCOLOR=\"RED\">");

		
	pr.println("<th> SALE_ID </th><th> SALE_AMOUNT </th><th> STATE_ID </th><th> CREATED_BY </th><th> LAST_UPDATED_BY </th>");
	
	System.out.println("resultset value"+resultsetstate.next());	
	if(resultsetstate.next())
	{
	while (resultsetstate.next())
		{
			
			
			int sales_id = resultsetstate.getInt("SALE_ID");
			
			String created_by = resultsetstate.getString("CREATED_BY");
			String last_by = resultsetstate.getString("LAST_UPDATED_BY");
			int sales_amt = resultsetstate.getInt("SALES_AMOUNT");
			int state_id = resultsetstate.getInt("STATE_ID");
			
			pr.println("<tr >"
					+ "<td width:15px,height:10px >"
					+ sales_id
					+ "</td>"
					+ "<td>"
					+ sales_amt
					+ "</td>"
					+ "<td>"
					+ state_id
					+ "</td>"
					+ "<td>"
					+ created_by
					+"</td>"
					+ "<td>"
					+ last_by
					+ "</td>"
					+"</tr>");
				}
		pr.println("</table><ul><li><a href=\"#edit-sales-data\" class=\"button-edit\">EDIT SALES RECORD</a></li>");
		pr.println( "</section></div>");
		pr.println("<article id=\"edit-sales-data\"><section class=\"wrapper-sales-edit\"><form action=\"EditSalesDataServletState\" method=\"GET\">"
				+ "<div class=\"inner\">"
				+ "<form>"
				+ "<div class=\"row 50%\">"
				+ "<div class=\"6u 12u(3)\">"
						+ "<input type=\"text\" name=\"salesid\" placeholder=\"ENTER SALES ID\" />"
						+ "</div>"
						+ "<div class=\"6u 12u(3)\">"
						+ "<input type=\"text\" name=\"salesamount\" placeholder=\"ENTER SALES AMOUNT\" />"
						+ "	</div>"
						+ "</div>"
						+ "<div class=\"row 50%\">"
								+ "<div class=\"6u 12u(3)\">"
										+ "<input type=\"text\" name=\"stateid\" placeholder=\"ENTER STATE ID\" />"
										+ "</div>"
										+ "<div class=\"6u 12u(3)\">"
										+ "<input type=\"text\" name=\"adminusername\" placeholder=\"ENTER USER NAME\"/>"
										+ "</div>"
										+ "</div>"
										+ "<div class=\"row\">"
										+ "<div>"
										+ "<ul>"
										+ "<li><input type=\"submit\" class=\"button-edit-sales-region\" value=\"EDIT SALES RECORD\" align=\"center\"/></li></ul>"
										+ "</div>"
										+ "</div>"
										+ "</form>"
										+ "</section>");
		pr.println("</body>");
		pr.println("</html>");
		
	}
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
		    	  sales_stat_state.close();
		        con.close();
		      } catch (SQLException e) {
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
