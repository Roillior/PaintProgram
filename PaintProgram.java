
/**
 * This class represent a Paint Program
 * 
 * @author Lior Maimon
 * mmn11 , Question 2
 */

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.security.SecureRandom; //for random numbers

public class PaintProgram extends JPanel {
	//instance variables
	private static final SecureRandom randomNumbers = new SecureRandom(); 
	private Color[] color = { Color.WHITE , Color.black , Color.gray }; //the possible colors of the ellipse
	private Color[][] colors; //a matrix used to hold the colors of the ellipses
	private double numberOfEllipse; //number of ellipse save as double to avoid gap between frame and panel
	
	/**
	 * construct a new Paint Program with a given ellipses number,
	 * @param ellipseNum - represent the number of ellipse in the paint (ellipseNum * ellipseNum)
	 */
	public PaintProgram(int ellipseNum){
		numberOfEllipse = ellipseNum; //set the number of ellipse in the paint
		colors = new Color[ellipseNum][ellipseNum]; //set the matrix size 
		setBackground(Color.WHITE); //set the background to white
	}
	
	/**
	 * method setTheColors - set the colors that will represent the ellipses in a matrix in a random way
	 */
	public void setTheColors(){
		for(int rowCounter = 0; rowCounter < numberOfEllipse ; rowCounter++){ 
			for(int colCounter = 0 ; colCounter < numberOfEllipse ; colCounter++){
				colors[rowCounter][colCounter] = color[randomNumbers.nextInt(3)]; //each cell in the matrix get a random color from the 3 colors possible 
			}
		}
	}
	
	/**
	 * method paintComponent - draw the ellipses using fillOval() 
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		double wSize = (getWidth() / numberOfEllipse); //calculate  the width size of each ellipse
		double hSize = (getHeight() / numberOfEllipse); //calculate the height size of each ellipse
		for(int rowCounter = 0; rowCounter < numberOfEllipse ; rowCounter++){
			for(int colCounter = 0 ; colCounter < numberOfEllipse ; colCounter++){
				g.setColor(colors[rowCounter][colCounter]); //set the color of the ellipse in this position by the color in this position in the matrix
				g.fillOval((int)(colCounter * wSize), (int)(rowCounter * hSize) , (int)wSize , (int)hSize); //draw the ellipses
			}
		}
		
	}
}
