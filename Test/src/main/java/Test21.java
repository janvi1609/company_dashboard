import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test21
 */
@WebServlet("/Test21")
public class Test21 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test21() {
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
		//String startDateStr = request.getParameter("joining_date");
		
		
        /*try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            java.util.Date parsedDate = dateFormat.parse(startDateStr);
            startDate = new Date(parsedDate.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid start date format");
            return;
        }*/
		//Date startDate = CURDATE(); // Initialize to current date
		

       /* if (startDateStr != null && !startDateStr.isEmpty()) {
            try {
                SimpleDateFormat[] dateFormats = {
                    new SimpleDateFormat("yyyy-MM-dd"),
                    new SimpleDateFormat("dd/MM/yy"), // Add more date formats as needed
                    // Add additional date formats here
                };

                java.util.Date parsedDate = null;
                for (SimpleDateFormat dateFormat : dateFormats) {
                    try {
                        parsedDate = dateFormat.parse(startDateStr);
                        startDate = new Date(parsedDate.getTime());
                        break; // Successful parse, exit the loop
                    } catch (Exception e) {
                        // Continue trying the next date format
                    }
                }

                if (parsedDate == null) {
                    // None of the date formats matched
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid start date format");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid start date format");
                return;
            }
        } else {
            // Handle the case when startDateStr is empty or null
        }*/
//		String employeeId= (request.getSession().getAttribute("id")).toString();
		//String employeeId = "1";
	        // Database connection details
	       String url = "jdbc:mysql://localhost:3306/janvi";
	        String username = "root";
	        String password = "jbv123";
	        
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection(url, username, password);
	            
	            /*String sql = "SELECT employeeId, first_name, last_name, job_title, joining_date, salary FROM employees WHERE employeeId = ?";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setString(1, employeeId);
	            
	            ResultSet result = statement.executeQuery();*/
	           /* String salaryQuery ="SELECT SUM(salary) AS total_salary FROM employees "
	                    + "WHERE employeeId = ? AND joining_date <= ?";
	            PreparedStatement salaryStatement = connection.prepareStatement(salaryQuery);
	            salaryStatement.setString(1, employeeId);*/
	            //salaryStatement.setDate(2, startDate);

	           // ResultSet salaryResult = salaryStatement.executeQuery();
	            Date currentDate = new Date(System.currentTimeMillis());
	            Date joiningDate = null;

	            String joinDateQuery = "SELECT joining_date FROM employees WHERE employeeId = ?";
	            PreparedStatement joinDateStatement = connection.prepareStatement(joinDateQuery);
	            joinDateStatement.setString(1, employeeId);
	            

	            ResultSet joinDateResult = joinDateStatement.executeQuery();
	            if (joinDateResult.next()) {
	                joiningDate = joinDateResult.getDate("joining_date");
	            }

	            if (joiningDate != null) {
	                LocalDate currentLocalDate = currentDate.toLocalDate();
	                LocalDate joiningLocalDate = joiningDate.toLocalDate();
	                Period period = Period.between(joiningLocalDate, currentLocalDate);

	                // Calculate total salary for the period (in months)
	                int months = period.getYears() * 12 + period.getMonths();
	                String salaryQuery = "SELECT SUM(salary) AS total_salary FROM employees "
	                        + "WHERE employeeId = ? AND joining_date <= ?";
	                    PreparedStatement salaryStatement = connection.prepareStatement(salaryQuery);
	                    salaryStatement.setString(1, employeeId);
	                    salaryStatement.setDate(2, currentDate);
	                ResultSet salaryResult = salaryStatement.executeQuery();
	                BigDecimal totalSalary = BigDecimal.ZERO;

	                if (salaryResult.next()) {
	                    BigDecimal monthlySalary = salaryResult.getBigDecimal("total_salary");
	                    totalSalary = monthlySalary.multiply(BigDecimal.valueOf(months));
	                }
	                
	            response.setContentType("text/html");
	            /*String action = request.getParameter("action");
	            if (action != null) {
	                if (action.equals("viewDetails")) {
	                    // Redirect to the view details page (e.g., employeeDetails.jsp)
	                    response.sendRedirect("empl.jsp");
	                    PrintWriter out = response.getWriter();
	    	            out.println("<html><head><title>Employee Details</title></head><body>");

	    	            out.println("<h1>Employee Details</h1>");
	    	            out.println("<table border='1'>");
	    	            out.println("<tr><th>First Name</th><th>Last Name</th><th>Job Title</th></tr>");
	    	            
	    	            if (result.next()) {
	    	                String firstName = result.getString("first_name");
	    	                String lastName = result.getString("last_name");
	    	                String jobTitle = result.getString("job_title");
	    	                out.println("<tr>");
	    	                out.println("<td>" + firstName + "</td>");
	    	                out.println("<td>" + lastName + "</td>");
	    	                out.println("<td>" + jobTitle + "</td>");
	    	                out.println("</tr>");
	    	            } else {
	    	                //response.getWriter().write("Employee not found");
	    	            	out.println("<tr><td colspan='3'>Employee not found</td></tr>");
	    	            }
	    	            out.println("</table>");
	    	            out.println("</body></html>");
	                } else if (action.equals("addDetails")) {
	                    // Redirect to the add details page (e.g., addEmployee.jsp)
	                    response.sendRedirect("addEmployee.jsp");
	                }
	            }*/
	            PrintWriter out = response.getWriter();
	           
	            /*out.println("<html><head><title>Employee Details</title></head><body>");

	            out.println("<h1>Employee Details</h1>");
	            out.println("<table border='1'>");*/
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<style>");
	            out.println("table { width: 50%; margin: 0 auto; border-collapse: collapse; }");
	            out.println("th, td { padding: 10px; text-align: left; border: 1px solid #ccc; }");
	            out.println("th { background-color: #333; color: white; }");
	            out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
	            out.println("body{background-color: #d3d3d3}");
	            out.println("</style>");
	            out.println("</head>");
	            out.println("<body>");

	            out.println("<h1 style='text-align: center;'>Employee Details</h1>");

	            out.println("<table>");
	            out.println("<tr><th>Employee ID</th><th>First Name</th><th>Last Name</th><th>Job Title</th><th>Joining Date</th><th>Salary</th></tr>");
	            Connection connection2 = DriverManager.getConnection(url, username, password);
	            String employeeQuery = "SELECT employeeId, first_name, last_name, job_title, joining_date FROM employees WHERE employeeId = ?";
	            PreparedStatement employeeStatement = connection2.prepareStatement(employeeQuery);
	            employeeStatement.setString(1, employeeId);

	            ResultSet employeeResult = employeeStatement.executeQuery();
	            if (employeeResult.next()) {
	            	String empId = employeeResult.getString("employeeId");
	                String firstName = employeeResult.getString("first_name");
	                String lastName = employeeResult.getString("last_name");
	                String jobTitle = employeeResult.getString("job_title");
	                String joiningDate1 = employeeResult.getString("joining_date");

	                
	              /*  response.getWriter().write("Employee ID: " + employeeId + "<br>");
	                response.getWriter().write("First Name: " + firstName + "<br>");
	                response.getWriter().write("Last Name: " + lastName + "<br>");
	                response.getWriter().write("Job Title: " + jobTitle);*/
	                out.println("<tr>");
	                out.println("<td>" + empId + "</td>");
	                out.println("<td>" + firstName + "</td>");
	                out.println("<td>" + lastName + "</td>");
	                out.println("<td>" + jobTitle + "</td>");
	                out.println("<td>" + joiningDate1 + "</td>");
	                out.println("<td>" + totalSalary + "</td>");
	                /*if (salaryResult.next()) {
	                    BigDecimal totalSalary = salaryResult.getBigDecimal("total_salary");
	                    
	                    out.println("<td>" + totalSalary + "</td>");
	                } else {
	                    out.println("<td>No salary records found for this employee.</td>");
	                }*/
	                out.println("</tr>");
	                out.println("</table>");
	                out.println("<p style='text-align: center;', 'text-size:20px'>Go to <a href=\"employee.jsp\">Home</a> Page.</p>");
		            out.println("</body></html>");
		            connection.close();
		            connection2.close();
	                
	            } else {
	                //response.getWriter().write("Employee not found");
	            	//out.println("<tr><td colspan='6'>Employee not found</td></tr>");
	            	out.println("Joining date not found for the employee.");
	            }
	            }}
	            //out.println("</table>");
	            //out.println("</body></html>");
	            //connection.close();
	            //connection2.close();}}
	            catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}}




