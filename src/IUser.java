
public interface IUser {
	public String getName();

	public int getBook();

	public void moreBook(int number) throws NotALenderException;// since in Borrower adds this exception.
}
