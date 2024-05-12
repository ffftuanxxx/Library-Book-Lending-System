
public class GUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Library UICT = new Library("UIC Library");
				ControllerSimple control = new ControllerSimple(UICT);
				ViewSimple view = new ViewSimple(UICT, control);
				ControllerGetBook controlg = new ControllerGetBook(UICT);
				ViewGetBook viewg = new ViewGetBook(UICT, controlg);
				ControllerMoreBook controlm = new ControllerMoreBook(UICT);
				ViewMoreBook viewm = new ViewMoreBook(UICT, controlm);
				ControllerCreate controlcr = new ControllerCreate(UICT);
				ViewCreate viewc = new ViewCreate(UICT, controlcr);
				ControllerHistory controlh = new ControllerHistory(UICT);
				ViewHistory viewh = new ViewHistory(UICT, controlh);
			}
		});
	}

}
