import java.util.ArrayList;

public class Library {
	private String name;// Library has its name.
	private ArrayList<IUser> users;// create an arrayList.
	private ArrayList<ModelListener> modlisteners;
	private ArrayList<Integer> history;

	public Library(String name) {
		this.name = name;
		this.users = new ArrayList<IUser>();// store it into an instance variable.
		this.modlisteners = new ArrayList<ModelListener>();
		this.history = new ArrayList<Integer>();
		history.add(0);
	}

	public void addUser(IUser user) {// can add different into the method.
		users.add(user);
		history.add(this.totalBorrowedBooks());
		this.notifyListeners();
	}

	public void addListener(ModelListener modlistener) {
		modlisteners.add(modlistener);
	}

	private void notifyListeners() {// update all the listeners.
		for (ModelListener l : modlisteners) {
			l.update();
		}
	}
	public ArrayList<Integer> getHistory() {// return the history in the ArrayList.
		return history;
	} 

	public int totalBorrowedBooks() {
		int allbooks = 0;
		for (int i = 0; i < users.size(); i++) {// get the every number of book from the arrayList and add them
												// together.
			allbooks = users.get(i).getBook() + allbooks;
		}
		return allbooks;
	}

	public int getBook(String name) throws UnknownUserException {
		int nameofbook = 0;
		if (users.size() == 0) {
			throw new UnknownUserException("User " + name + " unknown.");
		} else {
			for (int j = 0; j < users.size(); j++) {
				if (users.get(j).getName().equals(name)) {
					nameofbook = users.get(j).getBook();
					break;// only store the number of book in variable when the 2 name is equal, and then
							// jump out of the loop.
				} else if ((j == users.size() - 1) && (!users.get(j).getName().equals(name))) {
					throw new UnknownUserException("User " + name + " unknown.");
				} // throw the exception when the name is not found in the arrayList.
			}
		}
		return nameofbook;
	}

	public void moreBook(String name, int number) throws UnknownUserException, NotALenderException {
		if (users.size() == 0) {
			throw new UnknownUserException("User " + name + " unknown.");
		} else {
			for (int k = 0; k < users.size(); k++) {
				if (users.get(k).getName().equals(name)) {
					users.get(k).moreBook(number);// goes into the implements class to change the number of the books.
					history.add(this.totalBorrowedBooks());
					this.notifyListeners();
					break;
				} else if ((k == users.size() - 1) && (users.get(k).getName() != name)) {
					throw new UnknownUserException("User " + name + " unknown.");
				} // throw the exception when the name is not found in the arrayList.
			}
		}
	}

	public static void testLibrary() {
		Library li = new Library("UIC Library");
		System.out.println(li.totalBorrowedBooks() == 0);
		li.addUser(new Lender("L1", 10));
		try {
			System.out.println(li.getBook("L1") == -10);
			System.out.println(li.totalBorrowedBooks() == -10);
			li.addUser(new Borrower("B1", 20));
			System.out.println(li.getBook("L1") == -10);
			System.out.println(li.getBook("B1") == 20);
			System.out.println(li.totalBorrowedBooks() == 10);
			li.getBook("B2");
		} catch (UnknownUserException ex) {
			System.out.println(ex.getMessage().equals("User B2 unknown."));
		} catch (NotALenderException ex) {
			// This should never happen!
			System.out.println(false);
		}
		try {
			li.addUser(new Lender("L2", 30));
			System.out.println(li.getBook("L2") == -30);
			System.out.println(li.totalBorrowedBooks() == -20);
			li.moreBook("L2", 10);// test whether moreBook method can work successfully.
			System.out.println(li.getBook("L2") == -40);
			System.out.println(li.totalBorrowedBooks() == -30);
			li.addUser(new Borrower("B2", 40));
			System.out.println(li.getBook("B2") == 40);
			System.out.println(li.totalBorrowedBooks() == 10);
			li.moreBook("B2", 20);// to check if Borrower can also work.
			System.out.println(li.totalBorrowedBooks() == 30);
			li.moreBook("B2", -70);// to check if the it will report exception when the number of books is negative
									// in Borrower.
		} catch (UnknownUserException ex2) {
			System.out.println(ex2.getMessage());
		} catch (NotALenderException ex2) {
			System.out.println(ex2.getMessage().equals("A borrower cannot lend 10 book(s)."));
		}
		try {
			li.moreBook("damedane", 123);// test whether exception will report if the name is not found in the method.
		} catch (UnknownUserException ex3) {
			System.out.println(ex3.getMessage().equals("User damedane unknown."));
		} catch (NotALenderException ex3) {
			System.out.println(ex3.getMessage());
		}
	}
}
