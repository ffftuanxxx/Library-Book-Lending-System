import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class HistoryPanel extends JPanel{
	private Library m;
	public HistoryPanel(Library m) {
		this.m = m;
	}
	private int historyMax(ArrayList<Integer> history) {
		return Collections.max(history);
	}
	private int historyMin(ArrayList<Integer> history) {
		return Collections.min(history);
	}
	private int historyRange(ArrayList<Integer> history) {
		int max = historyMax(history);
		int min = historyMin(history);
		if(max - min < 10){
			return 10;
		}
		else {
			return max - min;
		}
	}
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		ArrayList<Integer> history = m.getHistory();
		int min = historyMin(history);
		int range = historyRange(history);
		int maxX = getWidth() - 1;
		int maxY = getHeight() - 1;
		int zero = maxY + min * maxY / range;
		g.setColor(Color.BLUE);
		g.drawLine(0,zero, maxX, zero);// draw the horizontal line.
		for(int i = 0;i < history.size();i++) {
			g.setColor(Color.RED);
			g.drawRect(10 * i, zero - history.get(i) * maxY / range, 1, 1);
			if(i > 0) {
				g.drawLine(10 * (i - 1),  zero - history.get(i - 1) * maxY / range, 10 * i, zero - history.get(i) * maxY / range);
			}// draw the changing line.
		}
//		repaint();
	}
}
