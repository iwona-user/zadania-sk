/**
 * 
 */
package com.capgemini.idolata;

/**
 * @author idolata
 *
 */
public class Amica extends Washmachine implements WashProperties {

	/**
	 * 
	 */
	
	private int maximumCapacity;
	private double weight;
	private double estimatedTime;
	private double defaultTime;
	
	public Amica() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkWeight() {
		if(weight > maximumCapacity) {
		System.out.println("Waga zosta³a przekroczona");
		}
	}

		
	@Override
	public double estimatedTime() {
		double estimatedTime = defaultTime*(weight/maximumCapacity);
		return estimatedTime;
	}

	@Override
	void showStatus() {
        if (unitTemp == true) {
            System.out.println("Numer programu:" + currentProgram.getProgramNumber() + " " + currentProgram.getProgramName() + " Temperatura:" + this.temp + "\u00B0 "
                    + "Prêdkoœæ wirowania:" + this.spinSpeed + " Domyœlny czas prania:" + currentProgram.getDefoultTime() + "Szacowany czas prania:"+estimatedTime);
        } else {
            System.out.println("Numer programu:" + currentProgram.getProgramNumber() + " " + currentProgram.getProgramName() + " Temperatura:" + this.temp + "F"
                    + " Prêdkoœæ wirowania:" + this.spinSpeed + " Domyœlny czas prania:" + currentProgram.getDefoultTime() + "Szacowany czas prania:"+estimatedTime);
        }
	}
	
	

}
