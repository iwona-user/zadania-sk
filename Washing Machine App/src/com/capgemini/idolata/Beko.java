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

	
	public Beko() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void checkWeight() {
		// TODO Auto-generated method stub

	}

	@Override
	public int estimatedTime() {
		double estimatedTime = defaultTime*(weight/maximumCapacity);
		return estimatedTime;
	}

	
	
	//skok temperatury o 1 C i 2 F
	@Override
	void tempUp() {
		if(unitTemp==true) {
			if(temp>=0 && temp<90) {
			this.temp= temp+1;
			System.out.println("Aktualna temperatura:"+temp+"\u00B0");
			}
			else {
				System.out.println("Próba wykroczenia poza zakres temperatur 0-90"+"\u00B0");
			}
		}
		else {
			if(temp>=32 && temp<194) {
				this.temp=temp+2;
				System.out.println("Aktualna temperatura:"+temp+"F");
			}
			else {
				System.out.println("Próba wykroczenia poza zakres temperatur 32-194 F");
			}
		}
	}

	//skok temperatury o 1 C i 2 F
	@Override
	void tempDown() {
		if(unitTemp==true) {
			if(temp>0 && temp<=90) {
			this.temp= temp-1;
			System.out.println("Aktualna temperatura:"+temp+"\u00B0");
			}
			else {
				System.out.println("Próba wykroczenia poza zakres temperatur 0-90"+"\u00B0");
			}
		}
		else {
			if(temp>32 && temp<=194) {
				this.temp=temp-2;
				System.out.println("Aktualna temperatura:"+temp+"F");
			}
			else {
				System.out.println("Próba wykroczenia poza zakres temperatur 32-194 F");
			}
		}
	}

	
	@Override
	void showStatus() {
        if (unitTemp == true) {
            System.out.println("Numer programu:" + currentProgram.getProgramNumber() + " " + currentProgram.getProgramName() + " Temperatura:" + this.temp + "\u00B0 "
                    + "Prêdkoœæ wirowania:" + this.spinSpeed + " Domyœlny czas prania:" + currentProgram.getDefoultTime() + "Szacowany czas prania:"+currentProgram.estimatedTime);
        } else {
            System.out.println("Numer programu:" + currentProgram.getProgramNumber() + " " + currentProgram.getProgramName() + " Temperatura:" + this.temp + "F"
                    + " Prêdkoœæ wirowania:" + this.spinSpeed + " Domyœlny czas prania:" + currentProgram.getDefoultTime() + "Szacowany czas prania:"+currentProgram.estimatedTime);
        }
	}
	
	
	
		

}
