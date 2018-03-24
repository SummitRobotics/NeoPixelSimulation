package Pixels;

import Implementation.*;

public class Simulation {
	private static ArduinoCode runnable;
	private static boolean started = false;
	
	public static void main(String[] args) {
		while(true) {
			if(!started) {
				runnable = new Example();
				runnable.init();
				started = true;
			}
			runnable.run();
		}
	}
}
