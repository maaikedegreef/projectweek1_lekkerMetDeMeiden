package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TekeningHangManTest {


    TekeningHangMan tekening;
    @Before
    public void setUp() {
      tekening = new TekeningHangMan();
    }

    @Test (expected = DomainException.class)
    public void verwijder_gooi_exception()  {

      tekening.verwijder(new Cirkel(new Punt(30,30) , 10));

    }
    @Test (expected = DomainException.class)
    public void voegtoe_gooi_exception()  {

        tekening.voegToe(new Cirkel(new Punt(30,30) , 10));

    }


}
