package com.capgemini.idolata;

/**
 * @author idolata
 *
 */
public class Program {

   
    private String programName;
    private int programNumber;
    private int spinSpeed;
    private int defoultTime;


    
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
	 * @return the programNumber
	 */
	public int getProgramNumber() {
		return programNumber;
	}




	/**
	 * @return the spinSpeed
	 */
	public int getSpinSpeed() {
		return spinSpeed;
	}




	/**
	 * @return the defoultTime
	 */
	public int getDefoultTime() {
		return defoultTime;
	}

}
