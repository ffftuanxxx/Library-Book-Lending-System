
public class ControllerMoreBook extends Controller{
	public ControllerMoreBook(Library m) {
		super(m);
	}
	public String moreBook(String name, String number) {
			try {
				int bonumber = Integer.parseInt(number);
				m.moreBook(name, bonumber);// add more books and show in the GUI.
				return "";
			} catch (UnknownUserException e) {
				return e.getMessage();
			} catch (NotALenderException e) {
				return e.getMessage();
			} catch (NumberFormatException e) {
				return "For input string: \"" + number +"\"";
			}
	}
}
