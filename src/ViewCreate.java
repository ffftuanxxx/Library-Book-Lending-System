import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewCreate extends View<ControllerCreate>{
	private JTextField t1;
	private JTextField t2;
	private JComboBox<String> cb;
	public ViewCreate(Library m,ControllerCreate c) {
		super(m,c);
		this.setSize(400, 300);
		this.setLayout(new GridLayout(4, 1));
		t1 = new JTextField("Type a new user name here");
		update();
		this.add(t1);
		t2 = new JTextField("Type a number of books here");
		update();
		this.add(t2);
		JComboBox jc=new JComboBox();
		jc.addItem("Lender");
        jc.addItem("Borrower");
        this.add(jc);// choose the user's identity.
		JButton pcreuser = new JButton("Create");
		pcreuser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String st2 = c.create(t1.getText(),t2.getText(),jc.getSelectedIndex());
				if(!st2.equals("")) {
					JOptionPane.showMessageDialog(pcreuser, st2);
				}// only show the window when some errors happen.
			}
		});
		this.add(pcreuser);
		this.setVisible(true);
	}
	public void update() {
		
	}
}
