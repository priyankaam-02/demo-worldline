
public class Bank {
	static Repository repo = new AccountRepository();//object creation
	
	public Account openAccount(String name,int phone,int amt) throws InsufficientAmountException{
		if(amt<=500)
			throw new InsufficientAmountException("Intial Amount should be greater than 500 to open Account");//Exception handling		
		int no= repo.noofAcct();
		int accno = no+1;
		Account a = new Account(accno,name,phone,amt);
		repo.save(a);
		return a;
	}
	public int depositAmount(int amount,int accno) throws InvalidAccountException {
		Account a = (Account) repo.findById(accno);
		if(a==null)
			throw new InvalidAccountException("Account No is not found,Please check your Account No.");
		int oldbalance = a.getBalance();
		int newbalance = oldbalance +amount;
//		a.setBalance(oldbalance+amount);
		repo.update(newbalance, accno);
		Account a2 = (Account) repo.findById(accno);
		return a2.getBalance() ;
	}
	public int withdrawAmount(int amount, int accno) throws InvalidAccountException, InsufficientAmountException {
		Account a = (Account) repo.findById(accno);
		if(a==null)
			throw new InvalidAccountException("Account No is not found,Please check your Account No.");
		int oldbalance = a.getBalance();
		if(oldbalance < amount){
			throw new InsufficientAmountException("No sufficient balance to withdraw amount.");
		}
		int newbalance = oldbalance - amount;
//		a.setBalance(oldbalance+amount);
		repo.update(newbalance, accno);
		Account a2 = (Account) repo.findById(accno);
		return a2.getBalance();
	}
	public Account AccountDetails(int accno) throws InvalidAccountException {
		Account a = (Account) repo.findById(accno);
		if(a==null)
			throw new InvalidAccountException("Account No is not found,Please check your Account No.");
			
		return a;
	}
	public void deleteAccount(int acc) throws InvalidAccountException {
		 Account a = (Account) repo.findById(acc);
		if(a==null)
			throw new InvalidAccountException("Account No is not found,Please check your Account No.");
		
		repo.delete(acc);		
	}
	public int noofAcct() {
		return repo.noofAcct();
	}
}
