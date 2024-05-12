import javax.swing.JFrame;

public abstract class View<T extends Controller> extends JFrame implements ModelListener {
	protected Library m;
	protected T c;

	public View(Library m, T c) {
		this.m = m;
		this.c = c;
		m.addListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public abstract void update();
}
