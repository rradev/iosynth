/**
 * 
 */
package net.iosynth.sensor;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author rradev
 *
 */
public class SensorCycleInt extends Sensor {
	private static final long serialVersionUID = 1L;
	private int values[];
	private long state;
	private static String FORMAT = "%d";
	
	/**
	 * 
	 */
	public SensorCycleInt() {
		int val[] = {1, 2, 3};
		init(val);
	}
	
	/**
	 * @param values
	 */
	public SensorCycleInt(int[] values) {
		init(values);
	}
	
	/**
	 * @param values 
	 * 
	 */
	public void init(int[] values) {
		this.state = ThreadLocalRandom.current().nextInt(values.length);
		this.values = new int[values.length];
		for(int i=0; i<values.length; i++){
			this.values[i] = values[i];
		}
	}
	
	/* (non-Javadoc)
	 * @see net.iosynth.sensor.Sensor#replicate()
	 */
	@Override
	public void replicate() {
		state = ThreadLocalRandom.current().nextInt(values.length);
	}
	
	/* (non-Javadoc)
	 * @see net.iosynth.sensor.Sensor#checkParameters()
	 */
	@Override
	public void checkParameters() {
		if (values == null) {
			values = new int[1];
			values[0] = 0;
		}
	}

	// Propagate internal state and epoch
	public void step(long step){
		state = (state + step) % values.length;
		epoch = epoch + step;
	}
	
	/**
	 * @return Sensor value
	 */
	public int getValue(){
		return values[(int)state];
	}

	@Override
	public String getString() {
		return String.format(FORMAT, getValue());
	}


}