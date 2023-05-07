package app.kudzy.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResistanceCalServiceImplTest {
@Test
    void checkIsCalculatingForSeries(){
    var rcsi=new ResistanceCalServiceImpl();
    assertEquals(15,rcsi.performResistanceCal("series","5.2,4.3,1.8,3.7"));
}
@Test
    void checkIsCalculatingForParallel(){
        var rcsi=new ResistanceCalServiceImpl();
        assertEquals(0.7995575838926176,rcsi.performResistanceCal("parallel","5.2,4.3,1.8,3.7"));
    }
    @Test
    void checkNumberofResistor(){
        var rsci=new ResistanceCalServiceImpl();
    assertEquals(4,rsci.getResistorsNumber("5.2,4.3,1.8,3.7"));
    }
    @Test
    void checkNumberofResistor2(){
        var rsci=new ResistanceCalServiceImpl();
        assertEquals(4,rsci.getResistorsNumber("5.2,4.3,1.8,3.7"));
    }
    @Test
    void isValidInput(){
        var rsci=new ResistanceCalServiceImpl();
        assertTrue(rsci.checkValidity("5.2,4.3,1.8,3.7")==true);
    }

    @Test
    void isNotValidInput(){
        var rsci=new ResistanceCalServiceImpl();
        assertFalse(rsci.checkValidity("5.2,4.a,c,3.7")==true);
    }
}