import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class extra_servercheck {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
        System.out.println("MySQL JDBC Driver Version: " + driver.getMajorVersion() + "." + driver.getMinorVersion());
	}

}
