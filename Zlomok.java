/**
 * Write a description of class Zlomok here.
 *
 * @author Marek Kerata
 * @version (a version number or a date)
 */
public class Zlomok {
    private int citatel;
    private int menovatel;

    public Zlomok(int citatel, int menovatel) {
        //Upravena verzia zo stranky: https://itecnote.com/tecnote/java-simplifying-fractions-in-java/
        int n1 = citatel;
        int n2 = menovatel;
        int temp1 = n1;
        int temp2 = n2;

        while (n1 != n2) {
            if (n1 > n2) {
                n1 = n1 - n2;
            } else {
                n2 = n2 - n1;
            }
        }

        if (n1 == 0 || n2 == 0) {
            this.citatel = 0;
            this.menovatel = 0;
        } else {
            this.citatel = temp1 / n1;
            this.menovatel = temp2 / n1;
        }
    }

    public int getCitatel() {
        return this.citatel;
    }

    public int getMenovatel() {
        return this.menovatel;
    }

    public double getCislo() {
        if (this.menovatel == 0) {
            return 0;
        } else {
            return this.citatel / this.menovatel;
        }
    }

    public Zlomok scitaj(Zlomok iny) {
        int vynasobenyMenovatel;
        int scitanyCitatel;
        Zlomok vysledok = null;
        if (iny.menovatel == this.menovatel) {
            scitanyCitatel = this.citatel + iny.getCitatel();
            vysledok = new Zlomok(scitanyCitatel, this.menovatel);
        } else {
            if (this.getMenovatel() == 0) {
                if (iny.getMenovatel() == 0) {
                    return new Zlomok(0, 0);
                } else {
                    return iny;
                }
            }

            if (iny.getMenovatel() == 0) {
                if (this.getMenovatel() == 0) {
                    return new Zlomok(0, 0);
                } else {
                    return this;
                }
            }

            vynasobenyMenovatel = iny.getMenovatel() * this.menovatel;
            int citatel1 = iny.getMenovatel() * this.citatel;
            int citatel2 = this.menovatel * iny.getCitatel();
            vysledok = new Zlomok((citatel1 + citatel2), vynasobenyMenovatel);
        }
        return vysledok;
    }

    public Zlomok vynasob(Zlomok iny) {
        int vynasobenyCitatel = this.citatel * iny.getCitatel();
        int vynasobenyMenovatel = this.menovatel * iny.getMenovatel();
        return new Zlomok(vynasobenyCitatel, vynasobenyMenovatel);
    }

    public boolean jeRovnaky(Zlomok iny) {
        if (this.menovatel == iny.getMenovatel() && this.citatel == iny.getCitatel()) {
            return true;
        }
        return false;
        
    }
}
