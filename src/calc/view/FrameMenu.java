package calc.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class FrameMenu extends JMenuBar{
	public FrameMenu(){
		createViews();
		createEdits();
		createHelps();
	}

	private void createViews() {
		JMenu mnViews = new JMenu("View");
		mnViews.setMnemonic('V');
		
		this.add(mnViews);
	}

	private void createEdits() {
		JMenu mnEdits = new JMenu("Edit");
		mnEdits.setMnemonic('E');
		
		this.add(mnEdits);
	}

	private void createHelps() {
		JMenu mnHelps = new JMenu("Help");
		mnHelps.setMnemonic('H');
		
		this.add(mnHelps);
	}
}
