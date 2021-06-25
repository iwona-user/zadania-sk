package com.capgemini.idolata.wirpool;

import com.capgemini.idolata.common.Washmachine;

public class Wirpool extends Washmachine {

	@Override
	public void setProgram(int paramNumber) {
		if (paramNumber > listPrograms.size()){
        	currentProgram = listPrograms.get(0);
        } else if (paramNumber < listPrograms.get(0).getProgramNumber()){
        	currentProgram = listPrograms.get(14);
        } else{
        	currentProgram = listPrograms.get(paramNumber-1);
        }
	}

	@Override
	public void nextProgram() {
		if(currentProgram.getProgramNumber() ==15) {
			currentProgram = listPrograms.get(0);
		}
		else{
			currentProgram = listPrograms.get(currentProgram.getProgramNumber() + 1);
		}
	}

	@Override
	public void previusProgram() {
		if(currentProgram.getProgramNumber()==1) {
			currentProgram = listPrograms.get(14);	
		}
		else {
			currentProgram = listPrograms.get(currentProgram.getProgramNumber() - 2);
		}
	}
	
	
	
	
} // end of class
