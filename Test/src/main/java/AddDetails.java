

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddDetails
 */
@WebServlet("/AddDetails")
public class AddDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 String employeeId = request.getParameter("employeeId");
	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String jobTitle = request.getParameter("jobTitle");
	        String joiningDateStr = request.getParameter("joiningDate");
	        String salaryStr = request.getParameter("salary");
	        Date joiningDate = Date.valueOf(joiningDateStr); // Assuming the date is in yyyy-MM-dd format
	        BigDecimal salary = new BigDecimal(salaryStr);
	        //Date joiningDate = request.getParameter("joiningDate");
	        // Database connection details
	        String url = "jdbc:mysql://localhost:3306/janvi";
	        String username = "root";
	        String password = "jbv123";

	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection(url, username, password);

	            String sql = "INSERT INTO employees (employeeId, first_name, last_name, job_title, joining_date, salary) VALUES (?, ?, ?, ?, ?, ?)";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setString(1, employeeId);
	            statement.setString(2, firstName);
	            statement.setString(3, lastName);
	            statement.setString(4, jobTitle);
	            statement.setDate(5, joiningDate);
	            statement.setBigDecimal(6, salary);
	            

	            int rowsInserted = statement.executeUpdate();

	            if (rowsInserted > 0) {
	                response.setContentType("text/html");
	                PrintWriter out = response.getWriter();
	                
	                out.println("<h2 style='font-size: 24px;'>Employee added successfully!</h2>");
	                out.println("<p style='text-size: 18px;'>Go to <a href=\"employee.jsp\">Home</a> Page.</p>");
	            } else {
	                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to add employee");
	            }

	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
