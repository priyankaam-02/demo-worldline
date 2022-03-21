//Interface
public interface Repository {
	void save(Object obj);
	void update(int balance,int accno);
	Object findById(int accno);
	void delete(int accno);
	int noofAcct();
}
