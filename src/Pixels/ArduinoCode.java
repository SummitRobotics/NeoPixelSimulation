package Pixels;

public abstract class ArduinoCode {
	public abstract void init();
	public abstract void run();
	
	protected final void delay(long x) {
		try {
			Thread.sleep(x);
		}catch(Exception e) {
		}
	}
}
