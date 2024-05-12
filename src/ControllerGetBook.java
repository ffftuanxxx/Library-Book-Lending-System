import javax.swing.JOptionPane;

public class ControllerGetBook extends Controller {
	public ControllerGetBook(Library m) {
		super(m);
	}

	public String getBook(String name) {
		try {
			String s = Integer.toString(m.getBook(name));
			return s;// return the number of the books.
		} catch (UnknownUserException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
}
