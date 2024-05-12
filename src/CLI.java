import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
	private static Scanner input = new Scanner(System.in);

	private static String readLine(String x) {
		System.out.print(x);
		String inputx = input.nextLine();
		return inputx;
	}

	private static int readPosInt(String y) throws InputMismatchException {
		int flag = 0;
		while (flag == 0) {// only when the flag is changed, it then will jump out of the loop.
			System.out.print(y);
			try {
				int inputx2 = input.nextInt();
				String inputx3 = input.nextLine();
				if (inputx2 < 0) {
					System.out.println("Positive integers only!");
					flag = 0;// it will keep the flag remain in loop if input smaller than 0.
				} else {
					flag = 1;
					return inputx2;
				}
			} catch (InputMismatchException e) {
				String inputwrong = input.nextLine();
				System.out.println("You must type an integer!");
				flag = 0;// When the input is wrong, it can also give user chances to re-input.
			}
			;
		}
		return ' ';
	}

	public static void main(String[] args) {
		Library UIC = new Library("UIC Library");
		int flagx = 1;
		while (flagx == 1) {
			int action = readPosInt("Type an action (total:1 add:2 get:3 more:4 less:5 quit:6): ");
			switch (action) {
			case 1:// calculate the total number of books.
				System.out.println("Total number of borrowed books: " + UIC.totalBorrowedBooks());
				break;
			case 2:
				int role = readPosInt("Type the user role (lender:1 borrower:2): ");
				if (role >= 3 || role < 1) {
					System.out.println("Unknown user role!");
				} else {
					String name = readLine("Enter the name of the user: ");
					if (role == 1) {// if the user is a lender
						int lenumbook = readPosInt("Enter the initial number of borrowed books: ");
						UIC.addUser(new Lender(name, lenumbook));
						System.out.println("Lender \"" + name + "\" lending " + lenumbook + " book(s) has been added.");
					} else if (role == 2) {// if the user is a borrower
						int bornumbook = readPosInt("Enter the initial number of borrowed books: ");
						try {
							UIC.addUser(new Borrower(name, bornumbook));
							System.out.println(
									"Borrower \"" + name + "\" lending " + bornumbook + " book(s) has been added.");
						} catch (NotALenderException e) {
							System.out.println("BUG! This must never happen!");
							System.exit(1);
						}
					}
				}
				break;
			case 3:
				try {// inquire the books amount of specific user.
					String name = readLine("Enter the name of the user: ");
					System.out.println(name + " borrows " + UIC.getBook(name) + " book(s).");
				} catch (UnknownUserException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {// user can lend or borrow more books.
					String name = readLine("Enter the name of the user: ");
					int morenumbook = readPosInt("Enter the number of books: ");
					UIC.moreBook(name, morenumbook);
				} catch (UnknownUserException e) {
					System.out.println(e.getMessage());
				} catch (NotALenderException e) {
					System.out.println("BUG! This must never happen!");
					System.exit(1);
				}
				break;
			case 5:
				try {// use the same method to decrease the amount of the books.
					String name = readLine("Enter the name of the user: ");
					int morenumbook = readPosInt("Enter the number of books: ");
					UIC.moreBook(name, -morenumbook);
				} catch (UnknownUserException e) {
					System.out.println(e.getMessage());
				} catch (NotALenderException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:// log out.
				System.out.println("Goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("Unknown action!");
			}
		}
	}

}
