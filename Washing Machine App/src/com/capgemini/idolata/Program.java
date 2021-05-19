package com.capgemini.idolata;

/**
 * @author idolata
 *
 */
public class Program {

   
    private String programName;
    public int programNumber;
	private int spinSpeed;
    protected int defoultTime;


    
	/**
	 * @param programName
	 * @param programNumber
	 * @param spinSpeed
	 * @param defoultTime
	 */
	public Program(String programName, int programNumber, int spinSpeed, int defoultTime) {
		super();
		this.programName = programName;
		this.programNumber = programNumber;
		this.spinSpeed = spinSpeed;
		this.defoultTime = defoultTime;
	}



	/**
	 * @return the programName
	 */
	public String getProgramName() {
		return programName;
	}



	/**
	 * @param programName the programName to set
	 */
	public void setProgramName(String programName) {
		this.programName = programName;
	}



	/**
	 * @return the programNumber
	 */
	public int getProgramNumber() {
		return programNumber;
	}



	/**
	 * @param programNumber the programNumber to set
	 */
	public void setProgramNumber(int programNumber) {
		this.programNumber = programNumber;
	}



	/**
	 * @return the spinSpeed
	 */
	public int getSpinSpeed() {
		return spinSpeed;
	}



	/**
	 * @param spinSpeed the spinSpeed to set
	 */
	public void setSpinSpeed(int spinSpeed) {
		this.spinSpeed = spinSpeed;
	}



	/**
	 * @return the defoultTime
	 */
	public int getDefoultTime() {
		return defoultTime;
	}



	/**
	 * @param defoultTime the defoultTime to set
	 */
	public void setDefoultTime(int defoultTime) {
		this.defoultTime = defoultTime;
	}


	

}
