package com.capgemini.idolata.amica;

import com.capgemini.idolata.common.WashProperties;
import com.capgemini.idolata.common.Washmachine;

public class Amica extends Washmachine implements WashProperties {
	
	
	private int maximumCapacity;
	private double weight;
	private double estimatedTime;
	private double defaultTime;

	@Override
	public void checkWeight() {
		if(weight > maximumCapacity) {
			System.out.println("Waga zosta�a przekroczona");
			}
	}

	@Override
	public double estimatedTime() {
		double estimatedTime = defaultTime*(weight/maximumCapacity);
		return estimatedTime;
	}

	@Override
	public void showStatus() {
        if (unitTemp == true) {
            System.out.println("Numer programu:" + currentProgram.getProgramNumber() + " " + currentProgram.getProgramName() + " Temperatura:" + this.temp + "\u00B0 "
                    + "Pr�dko�� wirowania:" + this.spinSpeed + " Domy�lny czas prania:" + currentProgram.getDefoultTime() + "Szacowany czas prania:"+estimatedTime);
        } else {
            System.out.println("Numer programu:" + currentProgram.getProgramNumber() + " " + currentProgram.getProgramName() + " Temperatura:" + this.temp + "F"
                    + " Pr�dko�� wirowania:" + this.spinSpeed + " Domy�lny czas prania:" + currentProgram.getDefoultTime() + "Szacowany czas prania:"+estimatedTime);
        }
	}
	
	
}
