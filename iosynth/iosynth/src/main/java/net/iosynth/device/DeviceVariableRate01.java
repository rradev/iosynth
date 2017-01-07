/**
 * 
 */
package net.iosynth.device;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import net.iosynth.sensor.Sensor;
import net.iosynth.sensor.SensorCycleDouble;
import net.iosynth.sensor.SensorCycleInt;
import net.iosynth.sensor.SensorCycleString;
import net.iosynth.sensor.SensorRandomDouble;
import net.iosynth.sensor.SensorRandomInt;
import net.iosynth.util.Delay;
import net.iosynth.util.Message;

/**
 * Example Device class
 * @author ross
 *
 */
public class DeviceVariableRate01 extends DeviceSimple {

	/**
	 * 
	 */
	public DeviceVariableRate01() {		
		String stringVal[] = {new String("ON"), new String("OF")};
		addSensor(new String("door"), new SensorCycleString(stringVal));
		
		String stringVal2[] = {new String("elevator_01"), new String("elevator_02"), new String("elevator_03"), new String("elevator_04")};
		addSensor(new String("1st floor"), new SensorCycleString(stringVal2));
		
		addSensor(new String("state"), new SensorRandomInt(0, 25));
		
		addSensor("count");
	}

	public void run() {
		for(final Sensor sensor : sensors) {
		    sensor.step(1);
		}
		getQueue().add(toJson());
		long delay = ThreadLocalRandom.current().nextLong(25*1000)+1000;
		//setDealy(delay);
		Delay d = new Delay(getDelayId(), delay);
		getDelayQueue().add(d);
	}
	

}

