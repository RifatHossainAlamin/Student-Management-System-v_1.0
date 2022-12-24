import javax.swing.*;
import java.awt.event.*;

/**
 * @author Urveshkumar
 */

public class BreakReminder extends JFrame implements ActionListener{

	private final int delay=10000;
	private String message="It's Time to break.\nTake some water and fresh your mind.\n";
	private Object[] possibleValues = { "Reminde Again after 30min", "Reminde Again after 45min", "Reminde Again after 1h","Close the Program"};
	private Object defaultValue=possibleValues[0];
	private Timer t;

	public BreakReminder() {
		t=new Timer(delay,this);
		t.start();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
	}

	public void actionPerformed(ActionEvent ae)
	{
		Object selectedValue = JOptionPane.showInputDialog(null, message, "Break Reminder",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, defaultValue);
		if(selectedValue==possibleValues[0]) {
			defaultValue=possibleValues[0];
			t.setDelay(1800000); // 30 min delay
		}
		else if (selectedValue==possibleValues[1]) {
			defaultValue=possibleValues[1];
			t.setDelay(2700000); // 45 min delay
		}
		else if (selectedValue==possibleValues[2]) {
			defaultValue=possibleValues[2];
			t.setDelay(3600000); // 1h delay
		}
		else {
			System.exit(0);
		}
	}

	public static void main(String arg[]) throws Exception
	{
		new BreakReminder();
	}	
}
