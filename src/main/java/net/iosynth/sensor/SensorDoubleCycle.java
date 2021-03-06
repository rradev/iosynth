/**
 * 
 */
package net.iosynth.sensor;

/**
 * @author rradev
 *
 */
public class SensorDoubleCycle extends Sensor {
	private double values[];
	transient private long state;
	
	/**
	 * 
	 */
	public SensorDoubleCycle() {
		this.format = "%.4f";
		this.state = 0;
	}
	
	/* (non-Javadoc)
	 * @see net.iosynth.sensor.Sensor#replicate()
	 */
	@Override
	public void replicate() {
		state = rnd.nextInt(values.length);
	}
	
	/* (non-Javadoc)
	 * @see net.iosynth.sensor.Sensor#checkParameters()
	 */
	@Override
	public void checkParameters() {
		if (values == null) {
			values = new double[2];
			values[0] = 0.0;
			values[1] = 1.0;
		}
	}
	
	/* (non-Javadoc)
	 * @see net.iosynth.sensor.Sensor#step(long)
	 */
	@Override
	public void step(long step){
		state = (state + step) % values.length;
	}
	
	/**
	 * @return Sensor value
	 */
	public double getValue(){
		return values[(int)state];
	}

	@Override
	public String getString() {
		return String.format(format, getValue());
	}


}
