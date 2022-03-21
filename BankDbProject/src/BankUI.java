import java.util.Scanner;

public class BankUI {
	//static Repository repo = new AccountRepository();
	static Bank bank = new Bank();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		displayMenu();		
	}
	private static void displayMenu() {
		while(true) {			
			System.out.println("-----Menu-----");
			System.out.println("1:Open Account");
			System.out.println("2:Close Account");
			System.out.println("3:Deposit Amount");
			System.out.println("4:Withdraw Amount");
			System.out.println("5:Print Account Details");
			System.out.println("6:Exit");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:	openAcct();
					break;
			case 2:closeAcct();
					break;
			case 3:depositAmount();
					break;
			case 4:withdrawAmount();
					break;
			case 5:accDetails();
					break;
			case 6:System.exit(0);
					break;
			default : System.out.println("Invalid Choice");
			}
		}
	}
	private static void accDetails() {
		System.out.println("Enter Account No");
		int accno = sc.nextInt();
		Account act;
		try {
			act = bank.AccountDetails(accno);
			System.out.println("--------------------------");
			System.out.println("Account Details are:");
			System.out.println("Account No:"+act.getAccNo()+"\nAccount Name: "+act.getName()+"\nPhone No. :"+act.getPhone()+ "\nBalance:"+act.getBalance());
			System.out.println("--------------------------");
		
		} catch (InvalidAccountException e) {
			System.out.println(e.getMessage());
		}
//		if(act!=null) {
//			System.out.println("--------------------------");
//		System.out.println("Account Details are:");
//		System.out.println("Account No:"+act.getAccNo()+"\nAccount Name: "+act.getName()+"\nPhone No. :"+act.getPhone()+ "\nBalance:"+act.getBalance());
//		System.out.println("--------------------------");
//		}
//		else {
//			System.out.println("Account does not exist. Check your Account No");
//		}
	}
	private static void withdrawAmount() {
		System.out.println("Enter Account No:");
		int acc = sc.nextInt();
		System.out.println("Enter amount to withdraw:");
		int amt = sc.nextInt();
		
		try {
			int balance =	bank.withdrawAmount(amt, acc);		
			System.out.println(amt +"rs deducted from your account");
			System.out.println("Remaining Balance is "+balance+"rs");
		
		} catch (InvalidAccountException | InsufficientAmountException e) {
			System.out.println(e.getMessage());
		}
//		if(a!=null) {
//		if(a.getBalance() < amt) {
//			System.out.println("No sufficient balance to withdraw amount");
//			System.out.println("Account Balance is "+a.getBalance());
//		}
//		else {
//		int balance =	bank.withdrawAmount(amt, acc);		
//			System.out.println(amt +"rs deducted from your account");
//			System.out.println("Remaining Balance is "+balance+"rs");
//		}
//		}
//		else {
//			System.out.println("Account does not exist. Check your Account No");
//		}
		
	}
	private static void depositAmount() {
		System.out.println("Enter Account No:");
		int acc = sc.nextInt();
		System.out.println("Enter amount to deposit:");
		int amt = sc.nextInt();
		int balance;
		try {
			balance = bank.depositAmount(amt, acc);
			System.out.println("Deposited "+amt+"rs succesfully");
			System.out.println("Remaining balance is "+ balance +"rs");
			
		} catch (InvalidAccountException e) {
			System.out.println(e.getMessage());
		}
	
//		Account a = bank.AccountDetails(acc);
//		if(a!=null) {
//		int balance = bank.depositAmount(amt, acc);
//		System.out.println("Deposited "+amt+"rs succesfully");
//		System.out.println("Remaining balance is "+ balance +"rs");
//		}
//		else {
//			System.out.println("Account does not exist. Check your Account No");
//		}
		
	}
	private static void closeAcct() {
		System.out.println("Enter Account No:");
		int acc = sc.nextInt();
		
		try {
			bank.deleteAccount(acc);
			System.out.println("Closed Account Succesfully");
			
		} catch (InvalidAccountException e) {
			System.out.println(e.getMessage());
		}
	
//		Account a = bank.AccountDetails(acc);
//		if(a!=null) {
//		bank.deleteAccount(acc);
//		System.out.println("Closed Account Succesfully");
//		}
//		else {
//			System.out.println("Account does not exist. Check your Account No");
//		}
	}
	private static void openAcct() {
		System.out.println("Enter your Name");
		String name = sc.next();
		System.out.println("Enter your Phone No.");
		int phone = sc.nextInt();
		System.out.println("Enter intial amount");
		int amt = sc.nextInt();
		Account a;
		try {
			a = bank.openAccount(name, phone,amt);
			System.out.println("Account created successfully");
			System.out.println("------------------------");
			System.out.println("Account Details are:");
			System.out.println("Account No:"+a.getAccNo()+"\nAccount Name: "+a.getName()+"\nPhone No. :"+a.getPhone()+ "\nBalance:"+a.getBalance());
			System.out.println("--------------------------");

		} catch (InsufficientAmountException e) {
			System.out.println(e.getMessage());
		}			
	
//		if(amt<=500) {
//			System.out.println("Initial Amount should be greater than 500rs to open account");
//		}
//		else {			
//			Account a = bank.openAccount(name, phone,amt);			
//			System.out.println("Account created successfully");
//			System.out.println("------------------------");
//			System.out.println("Account Details are:");
//			System.out.println("Account No:"+a.getAccNo()+"\nAccount Name: "+a.getName()+"\nPhone No. :"+a.getPhone()+ "\nBalance:"+a.getBalance());
//			System.out.println("--------------------------");
//		}
//		
	}

}
