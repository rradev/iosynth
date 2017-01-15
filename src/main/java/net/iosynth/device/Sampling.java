/**
 * 
 */
package net.iosynth.device;

import java.io.Serializable;

import net.iosynth.util.Xoroshiro128;

/**
 * @author rradev
 *
 */
public abstract class Sampling implements Serializable{
	private static final long serialVersionUID = 1L;
	protected long interval;
	protected Xoroshiro128 rnd;
	/**
	 * 
	 */
	public Sampling() {
		
	}
	
	/**
	 * 
	 */
	abstract public void checkParameters();
	/**
	 * @return sampling interval value
	 */
	abstract public long getInterval();
	/**
	 * 
	 */
	abstract public void replicate();
	
	/**
	 * @param interval the interval to set
	 */
	public void setInterval(long interval) {
		this.interval = interval;
	}

	/**
	 * @return the rnd
	 */
	public Xoroshiro128 getRnd() {
		return rnd;
	}

	/**
	 * @param rnd the rnd to set
	 */
	public void setRnd(Xoroshiro128 rnd) {
		this.rnd = rnd;
	}
}