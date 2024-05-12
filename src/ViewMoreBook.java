import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewMoreBook extends View<ControllerMoreBook>{
	private JTextField t1;
	private JTextField t2;
	public ViewMoreBook(Library m,ControllerMoreBook c) {
		super(m, c);
		this.setSize(400, 300);
		this.setLayout(new GridLayout(3, 1));
		t1 = new JTextField("Type a user name here");
		update();
		this.add(t1);
		t2 = new JTextField("Type a number of books here");
		update();
		this.add(t2);
		JButton pmobook = new JButton("More Book");
		pmobook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String st1 = c.moreBook(t1.getText(),t2.getText());
				if(!st1.equals("")) {
					JOptionPane.showMessageDialog(pmobook, st1);
				}// open a new window to show the information.
			}
		});
		this.add(pmobook);
		this.setVisible(true);
	}
	public void update() {
		
	}
}
