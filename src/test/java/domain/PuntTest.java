package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PuntTest {

    private int xCoordinaat;
    private int yCoordinaat;
    private Punt punt;

    @Before
    public void setUp() throws Exception {
        xCoordinaat = 5;
        yCoordinaat = 10;
        punt = new Punt(xCoordinaat, yCoordinaat);
    }

    @Test
    public void Punt_moet_een_punt_maken_met_de_gegeven_coordinaten() {
        punt = new Punt(xCoordinaat, yCoordinaat);
        assertEquals(xCoordinaat, punt.getX());
        assertEquals(yCoordinaat, punt.getY());
    }

    public void equals_moet_true_teruggeven_als_x_en_y_coordinaat_gelijk_zijn(){
        Punt puntAnder = new Punt(xCoordinaat, yCoordinaat);
        assertEquals(punt, puntAnder);
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_null(){
        assertNotNull(punt);
    }

    @Test
    public void equals_moet_false_teruggeven_als_punt_verschillende_x_coordinaat_heeft(){
        Punt puntAnder = new Punt(xCoordinaat-1, yCoordinaat);
        assertNotEquals(punt, puntAnder);
    }

    @Test
    public void equals_moet_false_teruggeven_als_punt_verschillende_y_coordinaat_heeft(){
        Punt puntAnder = new Punt(xCoordinaat, yCoordinaat-1);
        assertNotEquals(punt, puntAnder);
    }

    @Test
    public void compareTo_moet_0_teruggeven_als_punten_gelijk_zijn(){
        assertEquals(punt.compareTo(punt),0);
    }

    @Test
    public void compareTo_moet_min1_teruggeven_als_punt1_kleiner_is_dan_punt2(){
        Punt puntAnder = new Punt(xCoordinaat+1, yCoordinaat+1);
        assertEquals(punt.compareTo(puntAnder),-1);
    }

    @Test
    public void compareTo_moet_1_teruggeven_als_punt1_groter_is_dan_punt2(){
        Punt puntAnder = new Punt(xCoordinaat-1, yCoordinaat-1);
        assertEquals(punt.compareTo(puntAnder),1);
    }

}