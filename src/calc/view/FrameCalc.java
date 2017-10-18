package calc.view;

import java.awt.Font;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import calc.model.Calculator;
import calc.model.DispListener;

public class FrameCalc extends JFrame{
	private Calculator server = new Calculator();
	private JTextField txtResult;
	
	public FrameCalc(){
		initializeComponents();
		server.addDispListener(new DispListener() {
			@Override
			public void show(String text) {
				text = text.replaceFirst("^0+", "0");
				text = text.replaceFirst("^0(?=[1-9])", ""); 
				text = text.replaceFirst("\\.0+$", "");
				txtResult.setText(text);
			}
		});
	}
	
	private class ClearHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			server.clear();
		}
	}
	
	private class NumberHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			server.pressedNumber(btn.getText()); 
		}
	}
	
	private class OperatorHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			server.pressedOperator(btn.getName());
		}
	}
	
	private class EqualHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			server.pressedEqual();
		}
	}

	private void initializeComponents() {
		txtResult = new JTextField();
		txtResult.setText("0");
		txtResult.setBounds(10, 10, 290, 50);
		txtResult.setFocusable(false);
		txtResult.setFont(new Font(txtResult.getFont().getName(), Font.BOLD, 24));
		txtResult.setHorizontalAlignment(JTextField.RIGHT);
		
		JLabel lbMemery = new JLabel();
		lbMemery.setBounds(10, 70, 50, 50);
		lbMemery.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		JButton btnCE = new JButton("CE");
		btnCE.setBounds(70, 70, 50, 50);
		btnCE.setMargin(new Insets(0, 0, 0, 0));
		this.add(btnCE);
		
		JButton btnClear = new JButton("C");
		btnClear.setBounds(130, 70, 50, 50);
		btnClear.setMargin(new Insets(0, 0, 0, 0));
		btnClear.addActionListener(new ClearHandler());
		this.add(btnClear);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(190, 70, 110, 50);
		btnBack.setMargin(new Insets(0, 0, 0, 0));
		this.add(btnBack);
		
		NumberHandler nh = new NumberHandler();
		OperatorHandler oh = new OperatorHandler();
		EqualHandler eh =  new EqualHandler();
		
		String[] texts = {"MC","7","8","9","-","MR","4","5","6","*",
				"MS","1","2","3","/","M+","0",".","+","="};
		String[] names = {"MC","7","8","9","Sub","MR","4","5","6","Mul",
				"MS","1","2","3","Div","M+","0",".","Add","="};
		ActionListener[] h = {null,nh,nh,nh,oh,null,nh,nh,nh,oh,null,nh,nh,nh,oh,null,nh,nh,oh,eh};
		for(int i = 0; i < texts.length; i++){
			JButton btn = new JButton(texts[i]);
			btn.setName(names[i]);
			btn.setMargin(new Insets(0, 0, 0, 0));
			int x = (i % 5) * 50 + (i % 5 + 1) * 10;
			int y = (i / 5) * 50 + (i / 5 + 1) * 10 + 120;
			btn.setBounds(x, y, 50, 50);
			btn.setFocusable(false);
			btn.addActionListener(h[i]);
			this.add(btn);
		}
		
		this.setJMenuBar(new FrameMenu());
		this.setLayout(null);
		this.add(txtResult);
		this.add(lbMemery);
		this.setTitle("¼ÆËãÆ÷");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
