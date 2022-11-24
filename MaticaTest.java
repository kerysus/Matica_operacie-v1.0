import static org.junit.Assert.*;
import org.junit.Test;

public class MaticaTest {
    
    @Test
    public void testScitajPozitivny() {
        Matica xs = new Matica(new Zlomok[][]
        {
            {new Zlomok(1, 1), new Zlomok(2, 1), new Zlomok(3, 1)},
            {new Zlomok(4, 1), new Zlomok(5, 1), new Zlomok(6, 1)},
            {new Zlomok(7, 1), new Zlomok(8, 1), new Zlomok(9, 1)}
        });
        Matica ys = new Matica(new Zlomok[][]
        {
            {new Zlomok(9, 1), new Zlomok(8, 1), new Zlomok(7, 1)},
            {new Zlomok(6, 1), new Zlomok(5, 1), new Zlomok(4, 1)},
            {new Zlomok(3, 1), new Zlomok(2, 1), new Zlomok(1, 1)}
        });
        Matica expectedZs = new Matica(new Zlomok[][]
        {
            {new Zlomok(10, 1), new Zlomok(10, 1), new Zlomok(10, 1)},
            {new Zlomok(10, 1), new Zlomok(10, 1), new Zlomok(10, 1)},
            {new Zlomok(10, 1), new Zlomok(10, 1), new Zlomok(10, 1)}
        });
        Matica actualZs = xs.scitaj(ys);

        // Pozor nie assertEquals! Nefungoval by.
        assertTrue(expectedZs.jeRovnaka(actualZs));
    }
    
    @Test
    public void testScitajNegativny() {
        assertNull(this.getMaticuCelychCisiel(3, 3).scitaj(this.getMaticuCelychCisiel(3, 4)));
    }
     
    @Test
    public void testVynasobPozitivny() {
        Matica xs = new Matica(new Zlomok[][]
        {
            {new Zlomok(1, 1), new Zlomok(2, 1), new Zlomok(3, 1)},
            {new Zlomok(4, 1), new Zlomok(5, 1), new Zlomok(6, 1)}
        });
        Matica ys = new Matica(new Zlomok[][]
        {
            {new Zlomok(7, 1), new Zlomok(8, 1)},
            {new Zlomok(9, 1), new Zlomok(10, 1)},
            {new Zlomok(11, 1), new Zlomok(12, 1)}
        });
        Matica expectedZs = new Matica(new Zlomok[][]
        {
            {new Zlomok(58, 1), new Zlomok(64, 1)},
            {new Zlomok(139, 1), new Zlomok(154, 1)}
        });
        Matica actualZs = xs.vynasob(ys);

        // Pozor nie assertEquals! Nefungoval by.
        assertTrue(expectedZs.jeRovnaka(actualZs));
    }
    
    @Test
    public void testVynasobNegativny() {
        assertNull(this.getMaticuCelychCisiel(3, 2).vynasob(this.getMaticuCelychCisiel(4, 3)));
    }
           
    @Test
    public void testJeRovnakaPozitivny() {
        assertTrue(this.getMaticuInverznych(2, 3).jeRovnaka(this.getMaticuInverznych(2, 3)));
    }
            
    @Test
    public void testJeRovnakaPrvokNegativny() {
        Matica matA = new Matica(new Zlomok[][]
        {
            {new Zlomok(1, 1), new Zlomok(2, 1)},
            {new Zlomok(3, 1), new Zlomok(4, 1)}
        });
        Matica matB = new Matica(new Zlomok[][]
        {
            {new Zlomok(1, 1), new Zlomok(2, 1)},
            {new Zlomok(3, 1), new Zlomok(3, 1)}
        });
        assertFalse(matA.jeRovnaka(matB));
    }
    
    @Test
    public void testJeRovnakaRozmerNegativny() {
        assertFalse(this.getMaticuCelychCisiel(2, 3).jeRovnaka(this.getMaticuCelychCisiel(3, 3)));
    }
    
    private Matica getMaticuCelychCisiel(int pocetRiadkov, int pocetStlpcov) {
        Zlomok [][] z = new Zlomok[pocetRiadkov][pocetStlpcov];
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < z[0].length; j++) {
                z[i][j] = new Zlomok(i * pocetStlpcov + j + 1, 1);
            }
        }
        return new Matica(z);
    }
    
    private Matica getMaticuInverznych(int pocetRiadkov, int pocetStlpcov) {
        Zlomok [][] z = new Zlomok[pocetRiadkov][pocetStlpcov];
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < z[0].length; j++) {
                z[i][j] = new Zlomok(1, i * pocetStlpcov + j + 1);
            }
        }
        return new Matica(z);
    }
}
