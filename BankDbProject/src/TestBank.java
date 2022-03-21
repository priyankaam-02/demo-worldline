import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBank {

//	Open Account with correctParameters
	@Test
	void testOpenAccountWithCorrectParams() throws InsufficientAmountException{
		Bank bank = new Bank();
		Account a;
		a=bank.openAccount("Priya", 6789876, 1000);
		int accno = bank.noofAcct();
		assertEquals(accno,a.getAccNo());
		assertEquals("Priya",a.getName());
	}

//	Open Account with InsufficientAmount
	@Test
	void testOpenAccountWithInsufficientAmount() throws InsufficientAmountException {
		Bank bank = new Bank();
		assertThrows(InsufficientAmountException.class,
				()->bank.openAccount("RR",87966576,400));
	}

//	Deposit Amount to valid account
	@Test
	void testDepositAmtWithCorrectParams() throws InsufficientAmountException, InvalidAccountException {
		Bank bank = new Bank();
		Account a;
		a = bank.openAccount("KK", 6789876, 2000);
		bank.depositAmount(500, a.getAccNo());
		Account a2 = bank.AccountDetails(a.getAccNo());
		assertEquals(2500, a2.getBalance());
	}

//	Deposit Amount to Invalid account
	@Test
	void testDepositAmtWithInvalidAcct() throws InsufficientAmountException, InvalidAccountException {
		Bank bank = new Bank();
		Account a;
		a = bank.openAccount("SS", 677678, 2000);
		assertThrows(InvalidAccountException.class, () -> bank.depositAmount(500, 90));
	}
	
//	Withdraw Amount with correct parameters
	@Test
	void testWithdrawAmtWithCorrectParams() throws InsufficientAmountException, InvalidAccountException {
		Bank bank = new Bank();
		Account a;
		a = bank.openAccount("XX", 6789876, 1000);
		bank.withdrawAmount(500, a.getAccNo());
		Account a2 = bank.AccountDetails(a.getAccNo());
		assertEquals(500, a2.getBalance());
	}
//	Withdraw Amount with insufficientAmt
	@Test
	void testWithdrawAmtWithInsufficientAmt() throws InsufficientAmountException, InvalidAccountException {
		Bank bank = new Bank();
		Account a;
		a = bank.openAccount("QQ", 6454546, 2000);
		assertThrows(InsufficientAmountException.class, () -> bank.withdrawAmount(3000,a.getAccNo()));
	}
//	Delete Account with correct parameters
	@Test
	void testDeleteAcctWithCorrectParams() throws InvalidAccountException, InsufficientAmountException {
		Bank bank = new Bank();
		Account a;
		a = bank.openAccount("YY", 6789876, 1000);
		bank.deleteAccount(a.getAccNo());
		assertThrows(InvalidAccountException.class, () ->  bank.AccountDetails(a.getAccNo()));		
	}
	
//	Delete Account with Invalid AccountNo
	@Test
	void testDeleteAcctWithInvalidAccount() throws InvalidAccountException, InsufficientAmountException {
		Bank bank = new Bank();
		Account a;
		a = bank.openAccount("ZZ", 56778, 800);
		assertThrows(InvalidAccountException.class, () -> bank.deleteAccount(200));		
	}
	
//	Print Account with Valid AccountNo
	@Test
	void testPrintAccountWithValidAccount() throws InvalidAccountException, InsufficientAmountException {
		Bank bank = new Bank();
		Account a;
		a = bank.openAccount("ABC", 56778, 900);
		Account a2 = bank.AccountDetails(a.getAccNo());
		assertEquals(a.getAccNo(),a2.getAccNo());
		assertEquals(a.getName(),a2.getName());
		assertEquals(a.getPhone(),a2.getPhone());
	}
	
//	Print Account with InValid AccountNo
	@Test
	void testPrintAccountWithInValidAccount() throws InvalidAccountException, InsufficientAmountException {
		Bank bank = new Bank();
		Account a;
		a = bank.openAccount("ABC", 56778, 900);
		Account a2 = bank.AccountDetails(a.getAccNo());
		assertThrows(InvalidAccountException.class, () -> bank.AccountDetails(1000));	
	}
}
