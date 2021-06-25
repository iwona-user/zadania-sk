package com.capgemini.idolata.techbackground;

public class Program {
			
    private String programName;
    public int programNumber;
	private int spinSpeed;
    protected int defoultTime;


	public Program(String programName, int programNumber, int spinSpeed, int defoultTime) {
		super();
		this.programName = programName;
		this.programNumber = programNumber;
		this.spinSpeed = spinSpeed;
		this.defoultTime = defoultTime;
	}


	public String getProgramName() {
		return programName;
	}


	public int getProgramNumber() {
		return programNumber;
	}


	public int getSpinSpeed() {
		return spinSpeed;
	}


	public int getDefoultTime() {
		return defoultTime;
	}
	
	
}
