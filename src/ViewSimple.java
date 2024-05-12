import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewSimple extends View<ControllerSimple> {
	private JLabel label;

	public ViewSimple(Library m, ControllerSimple c) {
		super(m, c);
		this.setSize(400, 300);
		this.setTitle("View Simple");
		label = new JLabel();
		update();
		this.add(label);
		this.setVisible(true);
	}

	public void update() {// update the action1 in GUI.
		label.setText("total number of borrowed books: " + m.totalBorrowedBooks());
	}
}
