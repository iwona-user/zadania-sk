package com.capgemini.idolata.whirpool;


	import org.junit.Test;
	import com.capgemini.idolata.wirpool.Wirpool;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WhirlpoolTest {

    @Test
    public void shouldSetProperProgram() {
        //given
        Wirpool wirpool = new Wirpool();

        //when
        wirpool.setProgram(1);

        //then
        assertEquals(1, wirpool.getProgram());
    }



    @Test
    public void shouldApplyLastProgramIfParamIsOver14() {
    	// wydawa³o mi siê, ¿e ma byæ FirstProgram
	
	//given
    	Wirpool wirpool = new Wirpool();
    	
    	//when
    	wirpool.setProgram(15);
    			 
    	 //then
    	 assertEquals(1, wirpool.getProgram());		 
    	
    }


    @Test
    public void shouldApplyFirstProgramIfParamIsBelowZero() {
    	//wydawalo mi sie, ze tu ma byc LastProgram

    	// given
    	Wirpool wirpool = new Wirpool();
    	
    	//when
    	wirpool.setProgram(-1);
    			 
    	 //then
    	 assertEquals(15, wirpool.getProgram());		

    }

    @Test
    public void shouldSetNextProgramAsZero() {
    	//AsOne
    	
	//given
     Wirpool wirpool = new Wirpool();
      

      //when
     	wirpool.setProgram(15);
	wirpool.nextProgram();
    	
      //then
      assertEquals(1, wirpool.getProgram());
    }


    @Test
    public void shouldSetNextProgram() {
    	
    	//given
      Wirpool wirpool = new Wirpool();
        
      //when
      wirpool.setProgram(3);
	wirpool.nextProgram();
    	
      //then
      assertEquals(4, wirpool.getProgram());
    
}
        
    }

    @Test
    public void shouldSetPreviousProgramAsLastOne() {
    	
	//given
     Wirpool wirpool = new Wirpool();
        
      //when
     	 wirpool.setProgram(1);
	 wirpool.previousProgram();
    	
      //then
      assertEquals(15, wirpool.getProgram());
        	
    }


}
