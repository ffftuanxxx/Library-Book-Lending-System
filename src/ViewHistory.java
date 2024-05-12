import java.awt.GridLayout;

public class ViewHistory extends View<ControllerHistory>{
	public ViewHistory(Library m, ControllerHistory c) {
		super(m,c);
		this.setTitle("View History");
		this.setSize(400, 300);
//		this.setLayout(new GridLayout(2, 1));
		HistoryPanel hi = new HistoryPanel(m);
		update();
		this.add(hi);
		update();
		this.setVisible(true);
	}
	public void update() {
		repaint();
	}
}
