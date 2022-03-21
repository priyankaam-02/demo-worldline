import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository implements Repository{

	@Override
	public void save(Object obj) {
		if(obj instanceof Account) {
			Account a   = (Account)obj;
			int accId = a.getAccNo();
			String name  = a.getName();
			int phoneno = a.getPhone();
			int balance = a.getBalance();
			PreparedStatement stmt = DBInfra.getPreparedStatement("saveAccount");
			try {
				stmt.setInt(1, accId);
				stmt.setString(2, name);
				stmt.setInt(3, phoneno);
				stmt.setInt(4, balance);
				stmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(int balance, int accno) {
		PreparedStatement stmt = DBInfra.getPreparedStatement("updateAccount");
		try {
			stmt.setInt(1, balance);
			stmt.setInt(2, accno);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Object findById(int accno) {
		PreparedStatement stmt = DBInfra.getPreparedStatement("findAccount");
		try {
			stmt.setInt(1, accno);//select * from Customer where id=1
			
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Account a = new Account();
				String name  = result.getString(2);
				int phone      = result.getInt(3);
				int bal  = result.getInt(4);
				a.setAccNo(accno);
				a.setBalance(bal);
				a.setName(name);
				a.setPhone(phone);			
				return a;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(int accno) {
		PreparedStatement stmt = DBInfra.getPreparedStatement("deleteAccount");
		try {
			stmt.setInt(1, accno);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int noofAcct() {
		PreparedStatement stmt = DBInfra.getPreparedStatement("noofAccounts");
		try {
			ResultSet result = stmt.executeQuery();
			result.next();
			int no =result.getInt(1);
			return no;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
