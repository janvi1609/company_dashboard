

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String userId = request.getParameter("userId");
	        String password = request.getParameter("password");

	        String dbUrl = "jdbc:mysql://localhost:3306/janvi";
	        String dbUser = "root";
	        String dbPassword = "jbv123";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE userid=? AND password=?");
	            preparedStatement.setString(1, userId);
	            preparedStatement.setString(2, password);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                // Authentication successful
	                // Store user information in session
	                HttpSession session = request.getSession();
	                session.setAttribute("userId", userId);

	                // Redirect to another servlet or JSP page
	                response.sendRedirect("employee.jsp");
	            } else {
	                // Authentication failed
	                out.println("Invalid user ID or password. Please try again.");
	            }

	            resultSet.close();
	            preparedStatement.close();
	            connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	            out.println("An error occurred while processing your request.");
	        }
	    }
	}

