
public abstract class User implements IUser {// the class is abstract because the morebook method is abstract.
	private String name;
	private int book;

	public User(String name, int book) {
		this.name = name;
		this.book = book;
	}

	public String getName() {// the implements from IUser.
		return name;
	}

	public int getBook() {// the implements from IUser.
		return book;
	}

	protected void setBook(int book) {// this method is only used in this class and the subclass of User, which means
										// only users can use this method.
		this.book = book;
	}

	public abstract void moreBook(int number) throws NotALenderException;// the method is abstract, because it depends
																			// on the specific users, since the borrower
																			// adds exception.

	public static void testUser() {

	}
}
