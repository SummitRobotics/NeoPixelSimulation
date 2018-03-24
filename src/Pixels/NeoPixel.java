package Pixels;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
/*
 * Simulating the NeoPixel
 * So that I can play with leds at school too
 * @James Gunderson
 */	
public class NeoPixel{
	private Animation strip;
	
	//n = number of leds in the strip
	public NeoPixel(int n) {
		strip = new Animation(n);
	}
	
	//n = index of led
	//r,g,b are the color input RGB values
	public void setColor(int n, int r, int g, int b) {
		strip.setColor(n, r, g, b);
	}
	
	//updates the display
	public void updateLeds() {
		strip.updateLeds();
	}
}

@SuppressWarnings("serial")
class Animation extends JFrame{
	private int[][] pixels;
	private final int numOfPixels;
	
	//updating the display
	private int windowWidth = 2000;
	private int windowHeight = 125;
	
	public Animation(int n) {
		super("NeoPixel Strip Simulation");
		
		//setting up array
		numOfPixels = n;
		pixels = new int[numOfPixels][3];
		for(int a = 0; a < pixels.length; ++a) {
			setColor(a, 0,0,0);
		}
		
		//setup window
		setSize(windowWidth, windowHeight);
		setLocation(100, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@SuppressWarnings("unused")
	public void setColor(int index, int R, int G, int B) {
		//throw an error if the values are not in the range 0<x<255
		if(R > 255 || R < 0) {
			int error = 1 / 0;
		}
		else if(G > 255 || G < 0) {
			int error = 1 / 0;
		}
		else if(B > 255 || B < 0) {
			int error = 1 / 0;
		}
		//otherwise set the values
		pixels[index][0] = R;
		pixels[index][1] = G;
		pixels[index][2] = B;
	}
	
	public void updateLeds() {
		paint(this.getGraphics());
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		int x = (int) this.getWidth() / numOfPixels;
		for(int a = 0; a < numOfPixels; ++a) {
			g.setColor(getColor(a));
			g.fillRect(x*a, 0, x, this.getHeight());
		}
	}
	
	private Color getColor(int a) {
		float[] hsb = Color.RGBtoHSB(pixels[a][0], pixels[a][1], pixels[a][2], null);
		return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
	}
}
