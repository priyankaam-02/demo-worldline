import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DBInfra {
	private static Map<String,PreparedStatement> preparedStatementMap = new HashMap();//Collection-Map
	private static Connection conn;
	static {		
		try {//Exception handling using try catch
			//JDBC Connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/BankDb","root","root");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static PreparedStatement saveAccount;
	static PreparedStatement updateAccount;
	static PreparedStatement findAccount;
	static PreparedStatement deleteAccount;
	static  PreparedStatement noofAccounts;
	static {
		try {
			saveAccount   =conn.prepareStatement("insert into Account values(?,?,?,?)");
			updateAccount =conn.prepareStatement("update Account set balance=? where accId = ?");
			findAccount   =conn.prepareStatement("select * from Account where accId = ?");
			deleteAccount =conn.prepareStatement("delete from Account where accId= ?");
			noofAccounts = conn.prepareStatement("Select Count(*) from Account");
			preparedStatementMap.put("saveAccount", saveAccount);
			preparedStatementMap.put("updateAccount", updateAccount);
			preparedStatementMap.put("findAccount", findAccount);
			preparedStatementMap.put("deleteAccount", deleteAccount);
			preparedStatementMap.put("noofAccounts", noofAccounts);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static PreparedStatement getPreparedStatement(String id) {
		return preparedStatementMap.get(id);
	}
	

}
