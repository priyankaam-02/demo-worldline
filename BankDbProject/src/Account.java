
public class Account {
	int accNo;
	String name;
	int phone;
	int balance;
	public Account(int accNo, String name, int phone, int balance) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.phone = phone;
		this.balance = balance;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
