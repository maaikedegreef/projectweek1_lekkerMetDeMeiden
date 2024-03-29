package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class CirkelTest {
    private Punt geldigMiddelpunt;
    private Punt anderMiddelpunt;
    private int geldigRadius;
    private Cirkel geldigeCirkel;

    @Before
    public void setup() {
        this.geldigMiddelpunt = new Punt(5, 8);
        this.anderMiddelpunt = new Punt(7, 3);
        this.geldigRadius = 5;
        geldigeCirkel = new Cirkel(geldigMiddelpunt, geldigRadius);
    }

    @Test(expected = DomainException.class)
    public void test_Cirkel_MetMiddelpuntIsNull_GooitIllegalArgumentException() {
        new Cirkel(null, geldigRadius);
    }

    @Test(expected = DomainException.class)
    public void test_Cirkel_MetStraalKleinerDan0_GooitIllegalArgumentException() {
        new Cirkel(geldigMiddelpunt, -1);
    }

    @Test(expected = DomainException.class)
    public void test_Cirkel_MetStraalGelijkAan0_GooitIllegalArgumentException() {
        new Cirkel(geldigMiddelpunt, 0);
    }

    @Test
    public void test_Cirkel_MetGeldigMiddelpuntEnGeldigRadius_MaaktObject() {
        Cirkel cirkel = new Cirkel(geldigMiddelpunt, geldigRadius);
        assertEquals(geldigMiddelpunt, cirkel.getMiddelPunt());
        assertEquals(geldigRadius, cirkel.getRadius());
    }

    @Test
    public void test_Cirkel_TweeGelijkeCirkels_GeeftTrue() {
        Cirkel cirkel = new Cirkel(geldigMiddelpunt, geldigRadius);
        assertTrue(geldigeCirkel.equals(cirkel));
    }

    @Test
    public void test_Cirkel_EqualsMetTweedeCirkelNull_GeeftFalse() {
        assertFalse(geldigeCirkel.equals(null));
    }

    @Test
    public void test_Cirkel_EqualsMetTweedeCirkelMetVerschillendMiddelpunt_GeeftFalse() {
        Cirkel cirkel = new Cirkel(anderMiddelpunt, geldigRadius);
        assertFalse(geldigeCirkel.equals(cirkel));
    }

    @Test
    public void test_Cirkel_EqualsMetTweedeCirkelMetVerschillendStraal_GeeftFalse() {
        Cirkel cirkel = new Cirkel(anderMiddelpunt, geldigRadius - 2);
        assertFalse(geldigeCirkel.equals(cirkel));
    }

    @Test
    public void test_Cirkel_getOmhullende_GeeftOmhulling() {
        Cirkel cirkel = new Cirkel(geldigMiddelpunt, geldigRadius);
        Punt positieLinksBoven = new Punt(0,13);
        int breedte = 10;
        int hoogte = 10;
        Omhullende omhullende = new Omhullende(positieLinksBoven,breedte,hoogte);
        assertEquals(cirkel.getOmhullende(),omhullende);
    }

}

