package Implementation;

import Pixels.*;

public class Example extends ArduinoCode{
	private NeoPixel strip;
	private final int stripLength = 30;
	
	@Override
	public void init() {
		strip = new NeoPixel(stripLength);
	}

	int n = 0;
	@Override
	public void run() {
		for(int a = 0; a < stripLength; ++a) {
			if(a == n) {
				strip.setColor(a, 0, 0, 0);
			}
			else {
				strip.setColor(a, 255, 255, 255);
			}
		}
		n = (n + 1) % stripLength;
		delay(30);
		strip.updateLeds();
	}
}
