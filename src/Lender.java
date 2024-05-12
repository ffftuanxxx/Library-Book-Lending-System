
public class Lender extends User {
	public Lender(String name, int book) {
		super(name, -book);// for the lender, the books it lends to other should be seen as minus for
							// borrower.
	}

	public void moreBook(int number) {
		int minnumber2 = -number;// for lender, it should be minus.
		super.setBook(super.getBook() + minnumber2);// reset the number of the book it lends.
	}

	public static void testLender() {
		Lender l = new Lender("Anna",5);
		System.out.println(l.getName() == "Anna");
		System.out.println(l.getBook() == -5);
		l.setBook(-6);
		System.out.println(l.getBook() == -6);
		l.moreBook(2);
		System.out.println(l.getBook() == -8);
		l.moreBook(-9);
		System.out.println(l.getBook() == 1);
	}
}
