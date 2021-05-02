package com.capgemini.idolata;

import java.util.ArrayList;
import java.util.List;

/**
 * @author idolata
 *
 */

public abstract class Washmachine {
	
	private Program currentProgram;
    private double temp=0;
    private boolean unitTemp = true; // if true the temperature is set in Celsius
    private int spinSpeed;

    

    final protected List<Program> listPrograms = new ArrayList<>(15);


    // czy protected jest dobrze?
    protected List<Program> sublistProgramList = listPrograms.subList(0, 9);
    
    // czy w konstruktorze powinny byæ te¿ inne zmienne?
    // czy te listy wystarcz¹ aby uznaæ pkt.1) za zrealizowany "Program jest wybierany z listy 10 predefiniowanych programów. "	
    
    public Washmachine() {
       
        listPrograms.add(new Program("Delikatne", 1, 500, 1));
        listPrograms.add(new Program("BaweÅ‚na", 2, 500, 1));
        listPrograms.add(new Program("Syntetyczne", 3, 500, 1 ));
        listPrograms.add(new Program("Mieszane", 4, 500, 1));
        listPrograms.add(new Program("BaweÅ‚na", 5, 500, 1));
        listPrograms.add(new Program("Pranie wstÄ™pne", 6, 500, 1));
        listPrograms.add(new Program("Dodatkowe pÅ‚ukanie/wirowanie", 7, 500, 1));
        listPrograms.add(new Program("Odpompowanie lub wypompowanie", 8, 500, 1));
        listPrograms.add(new Program("Pranie codzienne", 9, 500, 1));
        listPrograms.add(new Program("Pranie intensywne/odplamianie", 10, 500, 1));
        listPrograms.add(new Program("Ciemne kolory", 11, 500, 1));
        listPrograms.add(new Program("Jeansy", 12, 500, 1));
        listPrograms.add(new Program("Jasne kolory", 13, 500, 1));
        listPrograms.add(new Program("WeÅ‚na/pranie rÄ™czne", 14, 500, 1));
        listPrograms.add(new Program("Szybkie pranie", 15, 500, 1));
    }
    
    
    // dlaczego podkreœla siê programNumber? jak to zmieniæ?
    void setProgram(int paramNumber) {
        if (paramNumber > sublistProgramList.size()) {
        	currentProgram.programNumber = sublistProgramList.get(0).getProgramNumber();
        } else if (paramNumber < sublistProgramList.get(0).getProgramNumber()) {
        	currentProgram.programNumber=sublistProgramList.get(9).getProgramNumber();
        } else {
        	currentProgram.programNumber = paramNumber;
        }
    } 

    int getProgram() {
        return currentProgram.getProgramNumber();
    } 


	void nextProgram(){
		if(currentProgram.getProgramNumber()==10){
			currentProgram.programNumber=1;
		}
		else {
			currentProgram.programNumber=currentProgram.getProgramNumber()+1;
			}
		}

	
    
	void previusProgram() {
		if(currentProgram.getProgramNumber()==1) {
			currentProgram.programNumber=10;	
		}
		else {
			currentProgram.programNumber=currentProgram.getProgramNumber()-1;
		}
	}


    void changeUnit(boolean unitTemp) {
        if (unitTemp == true) {
            this.temp = Math.round(2 * ((5 / 9) * temp) - 160 / 9) / 2.0;
            System.out.println("Temperatura:" + temp + "\u00B0");
        } else {
            this.temp = Math.rint(((9 / 5) * temp) + 32);
            System.out.println("Temperatura:" + temp + "F");
        }
    }



    void setTemp(double paramTemp) {
        if (unitTemp = true) {
            if (paramTemp >= 0 && paramTemp <= 90) {
                this.temp = Math.round(2 * paramTemp) / 2.0;
                System.out.println("Temperatura:" + temp + "\u00B0");
            } else {
                System.out.println("Tempeatura poza zakresem");
            }
        } else {
            if (paramTemp >= 32 && paramTemp <= 194) {
                this.temp = Math.rint(paramTemp);
                System.out.println("Temperatura:" + temp + "F");
            } else {
                System.out.println("Temperatura poza zakresem");
            }
        }
    }

    double getTemp() {
        return temp;
    }


  

	// nie wiem jak zrobiæ tutaj obslugê b³êdu, co dok³adnie umieœciæ w try{} catch{} 
	// czy przy tak napisanej metodzie próba zmiany temperatury poza zakres, temperautra siê nie zmieni?
	void tempUp() {
		if(unitTemp==true) {
			if(temp>=0 && temp<90) {
			this.temp= temp+0.5;
			System.out.println("Aktualna temperatura:"+temp+"\u00B0");
			}
			else {
				System.out.println("Próba wykroczenia poza zakres temperatur 0-90"+"\u00B0");
			}
		}
		else {
			if(temp>=32 && temp<194) {
				this.temp=temp+1;
				System.out.println("Aktualna temperatura:"+temp+"F");
			}
			else {
				System.out.println("Próba wykroczenia poza zakres temperatur 32-194 F");
			}
		}
	}
		

	
	// nie wiem jak jak zrobiæ tutaj obslugê b³êdu, co dok³adnie umieœciæ w try{} catch{} 
	// czy przy tak napisanej metodzie próba zmiany temperatury poza zakres, temperautra siê nie zmieni?
	void tempDown() {
		if(unitTemp==true) {
			if(temp>0 && temp<=90) {
			this.temp= temp-0.5;
			System.out.println("Aktualna temperatura:"+temp+"\u00B0");
			}
			else {
				System.out.println("Próba wykroczenia poza zakres temperatur 0-90"+"\u00B0");
			}
		}
		else {
			if(temp>32 && temp<=194) {
				this.temp=temp-1;
				System.out.println("Aktualna temperatura:"+temp+"F");
			}
			else {
				System.out.println("Próba wykroczenia poza zakres temperatur 32-194 F");
			}
		}
	}


	
	

    void setV(int paramV) {
        if (paramV >= 0 && paramV <= 1000) {
            spinSpeed = (int) ((Math.rint(paramV / 100)) * 100);  // with an accuracy of 100
        } else {
            System.out.println("PrÄ™dkoÅ›Ä‡ wirowania poza zakresem 1-1000");
        }
    }

    
    
    int getV() {
        return spinSpeed;
    }
    
    

 
	void upV() {
		if(spinSpeed==1000) {
			this.spinSpeed = 0;
		}
		else {
			this.spinSpeed=spinSpeed+100;
		}
	}

	
	void downV() {
		if(spinSpeed==0) {
			this.spinSpeed=1000;
		}
		else {
			this.spinSpeed=spinSpeed-100;
		}
	}


    void showStatus() {
        if (unitTemp == true) {
            System.out.println("Numer programu:" + currentProgram.getProgramNumber() + " " + currentProgram.getProgramName() + " Temperatura:" + this.temp + "\u00B0 "
                    + "Prêdkoœæ wirowania:" + this.spinSpeed + " Domyœlny czas prania:" + currentProgram.getDefoultTime());
        } else {
            System.out.println("Numer programu:" + currentProgram.getProgramNumber() + " " + currentProgram.getProgramName() + " Temperatura:" + this.temp + "F"
                    + " Prêdkoœæ wirowania:" + this.spinSpeed + " Domyœlny czas prania:" + currentProgram.getDefoultTime());
        }
    }

    
   

    void delayStart(int paramDelayStart) {
        int endWashing = this.currentProgram.getDefoultTime() + paramDelayStart;
        System.out.println("Pranie skoÅ„czy siÄ™ za:" + endWashing + "minut.");
    }
    
    
    void washingHistory() {
    	Queue<> history = new ArrayDeque<>();
    	System.out.println(history);
    }


} 
