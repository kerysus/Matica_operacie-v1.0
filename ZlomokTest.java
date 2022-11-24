import static org.junit.Assert.*;
import org.junit.Test;

public class ZlomokTest {

    @Test
    public void testZakladnyTvar() {
        Zlomok zlomok = new Zlomok(5, 5);
        Zlomok vysledok = new Zlomok(1, 1);
        assertTrue(zlomok.jeRovnaky(vysledok));
    }

    @Test
    public void testGetCislo() {
        Zlomok zlomok = new Zlomok(5, 5);
        assertTrue(zlomok.getCislo() == 1);
    }

    @Test
    public void testScitaj() {
        Zlomok scitanec1 = new Zlomok(5, 5);
        Zlomok scitanec2 = new Zlomok(5, 5);
        Zlomok spravnyVysledok = new Zlomok(2, 1);
        Zlomok sucet = scitanec1.scitaj(scitanec2);
        assertTrue(sucet.jeRovnaky(spravnyVysledok));
    }

    @Test
    public void testVynasob() {
        Zlomok cinitel1 = new Zlomok(2, 2);
        Zlomok cinitel2 = new Zlomok(3, 2);
        Zlomok spravnyVysledok = new Zlomok(3, 2);
        Zlomok sucin = cinitel1.vynasob(cinitel2);
        assertTrue(sucin.jeRovnaky(spravnyVysledok));
    }

    @Test
    public void jeRovnaky() {
        Zlomok zlomok1 = new Zlomok(3, 1);
        Zlomok zlomok2 = new Zlomok(3, 1);
        assertTrue(zlomok1.getCitatel() == zlomok2.getCitatel() && zlomok1.getMenovatel() == zlomok2.getMenovatel());
    }

    @Test
    public void testNieJeRovnaky() {
        Zlomok zlomok1 = new Zlomok(3, 1);
        Zlomok zlomok2 = new Zlomok(2, 4);
        assertTrue(zlomok1.getCitatel() != zlomok2.getCitatel() || zlomok1.getMenovatel() != zlomok2.getMenovatel());
    }

}