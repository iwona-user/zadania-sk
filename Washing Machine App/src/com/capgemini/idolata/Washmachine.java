/**
 * 
 */
package com.capgemini.idolata;

import java.util.ArrayList;
import java.util.List;
import com.sun.tools.javac.util.List;

/**
 * @author idolata
 *
 */
public abstract class Washmachine {

	private String programName;
	private int programNumber;
	private int defaultTime;
	private double temp;
	private boolean unitTemp =true; // if true the temperature is set in Celcius
	private int spinSpeed =0;
	private int maximumCapacity;
	final protected List<Program> listPrograms= new ArrayList<Program>(15);
			listPrograms.add(new Program("Delikatne", 1, 500));
			listPrograms.add(new Program("Bawe³na",2, 500));
			listPrograms.add(new Program("Syntetyczne",3, 500));
			listPrograms.add(new Program("Mieszane",4, 500));
			listPrograms.add(new Program("Bawe³na",5, 500));
			listPrograms.add(new Program("Pranie wstêpne",6, 500));
			listPrograms.add(new Program("Dodatkowe p³ukanie/wirowanie",7, 500));
			listPrograms.add(new Program("Odpompowanie lub wypompowanie",8, 500));
			listPrograms.add(new Program("Pranie codzienne",9, 500));
			listPrograms.add(new Program("Pranie intensywne/odplamianie",10, 500));
			listPrograms.add(new Program("Ciemne kolory",11, 500));
			listPrograms.add(new Program("Jeansy",12, 500));
			listPrograms.add(new Program("Jasne kolory",13, 500));
			listPrograms.add(new Program("We³na/pranie rêczne",14, 500));
			listPrograms.add(new Program("Szybkie pranie",15, 500));
			
			List<Program> sublistProgramList = listPrograms.subList(1, 10);	
			
			
			
			
			
	void setProgram(int paramNumber) {
		if(paramNumber>sublistProgramList.size()) {
			System.out.println("Numer programu jest poza zakresem 1-10");
			}
		else if(paramNumber<sublistProgramList.get(0)) {
			System.out.println("Number programu jest poza zakresem 1-10");
			}
		else {
			this.programNumber=paramNumber;
		}		
	} // end method
	
	
	
	int getProgram() {
		Program program = new Program();
		program.programName;
		program.programNumber;
		return Program program;		
	} // end method
	
	
	
	
	Program nextProgram(int paramNext){
		int currentProgram;
		for(int i=1; i<=Math.round(programNumber+paramNext/10); i++) {
			if(programNumber + paramNext>10) {
				currentProgram =programNumber+ paramNext-10;
			}
			else {
				currentProgram = programNumber + paramNext;
			}
		}
	}
		
	
	Program previusProgram(int pramPrevios){
		int currentProgram;
		for(int i=1; i<=Math.round((programNumber-pramPrevios)/10); i++) {
			if(programNumber - pramPrevios<-10) {
				int difference = programNumber - pramPrevios;
				currentProgram =10- difference;
			}
			else {
				currentProgram = spinSpeed-pramPrevios;
			}
		}
			
	}
	
	
	void changeUnit(boolean unitTemp) {
		if(unitTemp = true) {
			this.temp = ((5/9)*temp)-160/9;
			System.out.println("Temperatura:"+temp+"\u00B0");
		}
		else {
			this.temp = ((9/5)*temp)+32;
			System.out.println("Temperatura:"+temp+"F");
		}
	}
		
	void setTemp(double paramTemp) {
		if(unitTemp=true) {
			if(paramTemp>=0 && paramTemp<=90) {
				this.temp=Math.round(2*paramTemp)/2.;
				System.out.println("Temperatura;"+temp+"\u00B0");
			}
			else {
				System.out.println("Tempeatura poza zakresem");
			}
		}
		else {
			if(paramTemp>=32 && paramTemp<=194) {
				this.temp=Math.rint(paramTemp);
				System.out.println("Temperatura:"+temp+"F");
			}
			else {
				System.out.println("Temperatura poza zakresem");
			}
		}
	}
	
	
	double getTemp() {
		
		return temp;
	}
	

	double tempUp(double tempUp) {
		if(unitTemp=true) {
			if(temp+tempUp>=0 && temp+tempUp<=90) {
				this.temp=Math.round((temp+tempUp)*2)/2.0;
				System.out.println("Current temp:"+temp+"\u00B0");
			}
			else {
				System.out.println("Tempeatura poza zakresem");
			}
		}
		else {
			if(temp+tempUp>=32 && temp+tempUp<=194) {
				this.temp=Math.rint(temp+tempUp);
				System.out.println("Current temp:"+temp+"F");
			}
			else {
				System.out.println("Temperatura poza zakresem");
			}
		}
		
	}
	
	double tempDown(double tempDown) {
		if(unitTemp=true) {
		if(temp-tempDown>=0 && temp-tempDown<=90) {
			this.temp=Math.round((temp-tempDown)*2)/2.0 ;
			System.out.println("Current temp:"+temp+"\u00B0");
		}
		else {
			System.out.println("Tempeatura poza zakresem");
		}
	}
	else {
		if(temp-tempDown>=32 && temp-tempDown<=194) {
			this.temp=Math.rint(temp-tempDown);
			System.out.println("Current temp:"+temp+"F");
		}
		else {
			System.out.println("Temperatura poza zakresem");
		}
	}
	}
	
		void setV(int paramV) {
			if(paramV>=0 && paramV<=1000) {
				spinSpeed = (int) ((Math.rint(paramV/100))*100);  // with an accuracy of 100
			}
			else {
				System.out.println("Prêdkoœæ wirowania poza zakresem 1-1000");
			}
			
		}
		int getV() {
			
			return spinSpeed;
			
		}
		
		int upV(int paramUpV){
				for(int i=1; i<=Math.round(spinSpeed+paramUpV/1000);i++) {
					if((spinSpeed+paramUpV)>1000) {
						int currentSpeed = spinSpeed + paramUpV-10; 
					}
					else {
						currentSpeed = spinSpeed + paramUpV;
					}
			}
		}
		int downV(int paramDownV){
			for(int =1 ; i<=Math.round((spinSpeed-paramDownV)/10); i++) {
				if((spinSpeed+paramDownV)<-10) {
					int differenceSpin = spinSpeed-paramDownV;
					int currentSpeed = 100- differenceSpin; 
				}
				else {
					currentSpeed = spinSpeed - paramUpV;
				}
			}
		}
		
		void showStatus(){
			if(unitTemp=true) {
				System.out.println("Numer programu:"+program.programNumber+" "+programname+" Temperatura:"+temp+"\u00B0 "+"Prêdkoœæ wirowania:"+spinSpeed+" Czas prania:"+duration+"Szacowany czas prania:"+Washmashine.estimatedTime);
			}
			else {	
			System.out.println("Numer programu:"+program.programNumber+" "+programname+" Temperatura:"+temp+"F"+" Prêdkoœæ wirowania:"+spinSpeed+" Czas prania:"+duration+"Szacowany czas prania:"+Washmashine.estimatedTime);
			}
		}
		
		int estimatedTime(double weight){
			 int estimatedTime= (int) (defaultTime*weight/maximumCapacity);
			 return estimatedTime; 
		}
			

		int delayStart(int paramDelayStart) {

			int endWashing = duration+paramDelayStart;
			System.out.println("Pranie skoñczy siê za:"+endWashing+"minut.");
		}
		

			

} // end class
