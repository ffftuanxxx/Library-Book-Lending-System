import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewGetBook extends View<ControllerGetBook> {
	private JTextField t;

	public ViewGetBook(Library m, ControllerGetBook c) {
		super(m, c);
		this.setTitle("View Getbook");
		this.setSize(400, 300);
		this.setLayout(new GridLayout(2, 1));
		t = new JTextField("Type a user name here");
		update();
		this.add(t);
		JButton pbooknumber = new JButton("Tell me the book number");
		pbooknumber.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String st = c.getBook(t.getText());
				JOptionPane.showMessageDialog(pbooknumber, st);
			}// show the information of text with a window.
		});
		this.add(pbooknumber);
		this.setVisible(true);
	}

	public void update() {

	}

}
