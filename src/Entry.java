import java.awt.Insets;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calc.view.FrameCalc;


public class Entry {
	public static void main(String[] args) {
		FrameCalc frame = new FrameCalc();
		frame.setVisible(true);
		Insets in = frame.getInsets();
		frame.setSize(310+in.left*2, 394+in.top+in.bottom);
		frame.setLocationRelativeTo(null);
	}
}
	