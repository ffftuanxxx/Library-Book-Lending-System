
public class ControllerCreate extends Controller{
	public ControllerCreate(Library m) {
		super(m);
	}
	public String create(String name, String number, int type) {
		try {
		int bonumber = Integer.parseInt(number);
		if(type == 0) {
			m.addUser(new Lender(name, bonumber));
		}// add a lender and show it in GUI.
		else if(type == 1) {
				m.addUser(new Borrower(name, bonumber));
			}// add a borrower and show it in GUI.
		return "";
		} catch (NotALenderException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}catch (NumberFormatException e) {
			return "For input string: \"" + number +"\"";
		}
	}
}
