/**
 * 
 */
package com.capgemini.idolata;

/**
 * @author idolata
 *
 */
public class Beko extends Washmachine implements WashProperties {

	/**
	 * 
	 */
	
	private int maximumCapacity;
	private double weight;
	private String estimatedTime;
	private double defaultTime;

	
	public Beko() {
		// TODO Auto-generated constructor stub
	}
	

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
	void tempUp() {
		if(unitTemp==true) {
			try {
				if(temp>=0 && temp<=89.5) {
					this.temp= temp+1;
					System.out.println("Aktualna temperatura:"+temp+"\u00B0");
					}
				else {
					throw new  IllegalArgumentException();
					}
			} // end try
				catch(IllegalArgumentException e) {
					System.out.println("Pr�ba przekroczenia dopuszczalnego zakresu");
				} // end catch

		} // end if unit
		else {
			try {
			if(temp>=32 && temp<=193) {
				this.temp=temp+2;
				System.out.println("Aktualna temperatura:"+temp+"F");
				}
			else {
				throw new  IllegalArgumentException();				
				}
			}
		catch(IllegalArgumentException e) {
			System.out.println("Pr�ba przekroczenia dopuszczalnego zakresu");
		} // end catch
		} // end else
	}
		

	
	
	@Override
	void tempDown() {
		if(unitTemp==true) {
			try {
				if(temp>=0.5 && temp<=90) {
					this.temp= temp-1;
					System.out.println("Aktualna temperatura:"+temp+"\u00B0");
					}
				else {
					throw new  IllegalArgumentException();
					}
			} // end try
				catch(IllegalArgumentException e) {
					System.out.println("Pr�ba przekroczenia dopuszczalnego zakresu");
					} // end catch

		} // end if unit
		else {
			try {
			if(temp>=33 && temp<=194) {
				this.temp=temp-2;
				System.out.println("Aktualna temperatura:"+temp+"F");
				}
			else {
				throw new  IllegalArgumentException();				
				}
			} // end try
		catch(IllegalArgumentException e) {
			System.out.println("Pr�ba przekroczenia dopuszczalnego zakresu");
			} // end catch
		} // end else
	}

	
	
	@Override
	void showStatus() {
        if (unitTemp == true) {
            System.out.println("Numer programu:" + currentProgram.getProgramNumber() + " " + currentProgram.getProgramName() + " Temperatura:" + this.temp + "\u00B0 "
                    + "Pr�dko�� wirowania:" + this.spinSpeed + " Domy�lny czas prania:" + currentProgram.getDefoultTime() + "Szacowany czas prania:"+estimatedTime);
        } else {
            System.out.println("Numer programu:" + currentProgram.getProgramNumber() + " " + currentProgram.getProgramName() + " Temperatura:" + this.temp + "F"
                    + " Pr�dko�� wirowania:" + this.spinSpeed + " Domy�lny czas prania:" + currentProgram.getDefoultTime() + "Szacowany czas prania:"+estimatedTime);
        }
	}
	
	
	
		

}
