/**
 * 
 */
package com.capgemini.idolata;

/**
 * @author idolata
 *
 */
public class WashingHistory {
	public Program program;
	public double temp;
	public double spinSpeed;
	public double weight;
	public double weightCapacity;
	
	public WashingHistory(Program program, double temp, double spinSpeed)
	{
		this.program = program;
		this.temp = temp;
		this.spinSpeed = spinSpeed;
	}
	
	public WashingHistory(Program program, double temp, double spinSpeed, double weight, double weightCapacity)
	{
		this.program = program;
		this.temp = temp;
		this.spinSpeed = spinSpeed;
		this.weight = weight;
		this.weightCapacity = spinSpeed;
	}
}