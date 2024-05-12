
public class Borrower extends User {
	public Borrower(String name, int book) throws NotALenderException {
		super(name, book);
		if (book < 0) {// for borrower, it cannot lend books.
			throw new NotALenderException("A new borrower cannot lend books.");
		}
	}

	public void moreBook(int number) throws NotALenderException {// the same exception can throw different sentences.
		if (number < 0 && number + super.getBook() < 0) {
			throw new NotALenderException("A borrower cannot lend " + -(super.getBook() + number) + " book(s).");
		} else {
			super.setBook(super.getBook() + number);// reset the number of the book it lends.
		}
	}

	public static void testBorrower() {
		try {
			Borrower b = new Borrower("Bob", -1);
		} catch (NotALenderException e) {
			System.out.println(e.getMessage().equals("A new borrower cannot lend books."));
		}
		try {
			Borrower b = new Borrower("Bob", 10);
			System.out.println(b.getName() == "Bob");
			System.out.println(b.getBook() == 10);
			b.setBook(5);
			System.out.println(b.getBook() == 5);
			b.moreBook(2);
			System.out.println(b.getBook() == 7);
			b.moreBook(-2);
			System.out.println(b.getBook() == 5);
			b.moreBook(-5);
			System.out.println(b.getBook() == 0);
			b.moreBook(-1);
		} catch (NotALenderException e) {
			System.out.println(e.getMessage().equals("A borrower cannot lend 1 book(s)."));
		}

	}

}
