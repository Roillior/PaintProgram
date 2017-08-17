
/**
 * This class drawing the Paint
 * 
 * @author Lior Maimon 
 * mmn11 , Question 2
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PaintProgramTest {
	//main method
	public static void main(String[] args){
		
		int ellipseNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter a number that represent n ")); //user input string and we change it to an integer
		int changeColors ; //use to check if user want to change the paint colors
		PaintProgram panel = new PaintProgram(ellipseNum);
		JFrame application = new JFrame("PaintProgram");
		
		panel.setTheColors(); //set the colors of the paint in a random way
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(500,500);
		application.add(panel);
		application.setVisible(true);
		changeColors = JOptionPane.showConfirmDialog(null , "Do you want to change the colors in a new random order?"); //user answer
		while(changeColors == JOptionPane.YES_OPTION){
			panel.setTheColors(); //set the colors of the paint in a random way
			panel.repaint();
			changeColors = JOptionPane.showConfirmDialog(null , "Do you want to change the colors in a new random order?"); //user answer
		}	
	}
}
