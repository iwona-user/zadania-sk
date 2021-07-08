package com.capgemini.idolata;

import com.capgemini.idolata.amica.Amica;
import com.capgemini.idolata.beko.Beko;
import com.capgemini.idolata.techbackground.Program;
import com.capgemini.idolata.wirpool.Wirpool;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Program prog = new Program("Jeden", 1, 2, 3);
		System.out.println("ccccc "+prog); // Test
		System.out.println("bbbbb");
		
		
		Amica amica = new Amica(); 
		Beko beko = new Beko();
		Wirpool wirpool = new Wirpool();
		
		
		amica.setProgram(2);
		amica.setTemp(60);
		amica.tempUp();
		amica.tempDown();
		amica.setV(600);
		amica.showStatus();
		
		
		beko.setProgram(3);
		beko.setTemp(70);
		beko.tempUp();
		beko.tempDown();
		beko.setV(700);
		beko.showStatus();
		
		
		wirpool.setProgram(4);
		wirpool.setTemp(80);
		wirpool.tempUp();
		wirpool.tempDown();
		wirpool.setV(600);
		wirpool.showStatus();

		

		
		
		
	} // end of main method

}
