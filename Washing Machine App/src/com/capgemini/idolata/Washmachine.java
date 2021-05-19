package com.capgemini.idolata;

import java.util.ArrayList;
import java.util.List;

/**
 * @author idolata
 *
 */

	//todo zabezpieczenie przed duplikatami ifem
	//todo sprawdziæ listê predefiniowanych programów
	//todo sprawdziæ konstruktor
	//todo pouk³adaæ klasy w pakiety 
	//ograniczenie do wirowanie dla programu Delikatne w getV i upV ifem
	//todo sprawdziæ wagê w Amico
	


public abstract class Washmachine {
	
	protected Program currentProgram;
    protected double temp=0;
    protected boolean unitTemp = true; // if true the temperature is set in Celsius
    protected int spinSpeed;

    

    final protected List<Program> listPrograms = new ArrayList<>(15);
    protected List<Program> sublistProgramList = listPrograms.subList(0, 10);
    
    protected LimitedQueue<WashingHistory> programHistoryQueue = new LimitedQueue<>(30);
    

    
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
    
    
     
    void setProgram(int paramNumber)
	{
        if (paramNumber > sublistProgramList.size())
		{
        	currentProgram = sublistProgramList.get(0);
        } else if (paramNumber < sublistProgramList.get(0).getProgramNumber())
		{
        	currentProgram = sublistProgramList.get(8);
        } else
		{
        	currentProgram = sublistProgramList.get(paramNumber-1);
        }
    }

    int getProgram() {
        return currentProgram.getProgramNumber();
    } 


    void nextProgram()
	{
		if(currentProgram.getProgramNumber() == 10)
		{
			currentProgram = sublistProgramList.get(0);
		}
		else
		{
			currentProgram = sublistProgramList.get(currentProgram.getProgramNumber() + 1);
		}
	}

	
    
    void previusProgram() 
	{

		if(currentProgram.getProgramNumber()==1)
		{
			currentProgram = sublistProgramList.get(9);	
		}
		else
		{
			currentProgram = sublistProgramList.get(currentProgram.getProgramNumber() - 2);
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


  

	void tempUp() {
		if(unitTemp==true) {
			try {
				if(temp>=0 && temp<=89.5) {
					this.temp= Math.round((temp+0.5)*2)/2.0;
					System.out.println("Aktualna temperatura:"+temp+"\u00B0");
					}
				else {
					throw new  IllegalArgumentException();
					}
			} // end try
				catch(IllegalArgumentException e) {
					System.out.println("Próba przekroczenia dopuszczalnego zakresu");
				} // end catch

		} // end if unit
		else {
			try {
			if(temp>=32 && temp<=193) {
				this.temp=Math.rint(temp+1);
				System.out.println("Aktualna temperatura:"+temp+"F");
				}
			else {
				throw new  IllegalArgumentException();				
				}
			}
		catch(IllegalArgumentException e) {
			System.out.println("Próba przekroczenia dopuszczalnego zakresu");
		} // end catch
		} // end else
	}
		

	


	void tempDown() {
		if(unitTemp==true) {
			try {
				if(temp>=0.5 && temp<=90) {
					this.temp= Math.round((temp-0.5)*2)/2.0;
					System.out.println("Aktualna temperatura:"+temp+"\u00B0");
					}
				else {
					throw new  IllegalArgumentException();
					}
			} // end try
				catch(IllegalArgumentException e) {
					System.out.println("Próba przekroczenia dopuszczalnego zakresu");
					} // end catch

		} // end if unit
		else {
			try {
			if(temp>=33 && temp<=194) {
				this.temp=Math.rint(temp-1);
				System.out.println("Aktualna temperatura:"+temp+"F");
				}
			else {
				throw new  IllegalArgumentException();				
				}
			} // end try
		catch(IllegalArgumentException e) {
			System.out.println("Próba przekroczenia dopuszczalnego zakresu");
			} // end catch
		} // end else
	}


	
	

    void setV(int paramV) {
    	if(currentProgram.getProgramNumber() == 1) {
    		 if (paramV >= 0 && paramV <= 500) {
    	            spinSpeed = (int) ((Math.rint(paramV / 100)) * 100);  // with an accuracy of 100
    	        } else {
    	            System.out.println("PrÄ™dkoÅ›Ä‡ wirowania poza zakresem 1-500");
    	        }
    		}
    	else {
    		 if (paramV >= 0 && paramV <= 1000) {
    	            spinSpeed = (int) ((Math.rint(paramV / 100)) * 100);  // with an accuracy of 100
    	        } else {
    	            System.out.println("PrÄ™dkoÅ›Ä‡ wirowania poza zakresem 1-1000");
    	        }
    		}
    	}

    
    
    int getV() {
        return spinSpeed;
    }
    
    

 
	void upV() {
		if(currentProgram.getProgramNumber() == 1)
			{if(spinSpeed ==500) {
				spinSpeed=0;
				}
		else {
			this.spinSpeed=spinSpeed+100;
		}
			}
		else {
			if(spinSpeed==1000) {
			this.spinSpeed = 0;
				}
			else {
			this.spinSpeed=spinSpeed+100;
				}
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
        System.out.println("Pranie skoñczy siê za: "+endWashing+"minut.");
        
    }
    
    
    public void Start()
	{
		programHistoryQueue.add(new WashingHistory(currentProgram, temp, spinSpeed));
	}


} 
