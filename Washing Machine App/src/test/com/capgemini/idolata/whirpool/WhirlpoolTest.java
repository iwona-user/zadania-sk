package com.capgemini.idolata.whirpool;

import com.capgemini.idolata.wirpool.Wirpool;
import org.junit.Test;

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
    public void shouldApplyLastProgramIfParamIsOver14() {}

    @Test
    public void shouldApplyFirstProgramIfParamIsBelowZero() {}

    @Test
    public void shouldSetNextProgramAsZero() {}

    @Test
    public void shouldSetNextProgram() {}

    @Test
    public void shouldSetPreviousProgramAsLastOne() {}


}
