/**
 * Write a description of class Matica here.
 *
 * @author Marek Kerata
 * @version (a version number or a date)
 */
public class Matica {
    private Zlomok[][] kopiaMatice;

    public Matica(Zlomok[][] matica) {
        this.kopiaMatice = matica;
    }

    public int getPocetRiadkov() {
        return this.kopiaMatice.length;
    }

    public int getPocetStlpcov() {
        return this.kopiaMatice[0].length;
    }

    public Zlomok getPrvok(int riadok, int stlpec) {
        return this.kopiaMatice[riadok][stlpec];
    }

    public Matica scitaj(Matica ina) {
        Zlomok zlomokInejMatice;
        Zlomok zlomokThisMatice;
        Matica vysledok = this;
        if (this.getPocetRiadkov() != ina.getPocetRiadkov() || this.getPocetStlpcov() != ina.getPocetStlpcov()) {
            return null;
        }

        for (int riadok = 0; riadok < ina.getPocetRiadkov(); riadok++) {
            for (int stlpec = 0; stlpec < ina.getPocetStlpcov(); stlpec++) {

                zlomokThisMatice = this.getPrvok(riadok, stlpec);
                zlomokInejMatice = ina.getPrvok(riadok, stlpec);
                vysledok.kopiaMatice[riadok][stlpec] = this.kopiaMatice[riadok][stlpec].scitaj(zlomokInejMatice);
            }
        }
        return vysledok;
    }

    public Matica vynasob(Matica ina) {
        boolean pricitajRaz = false;
        Zlomok pomocnyZlomok = new Zlomok(1, 1);
        Zlomok vynasobenePrvky;
        Zlomok scitanePrvky;

        //kotrola ci sa da matica vobec vynasobit
        if (this.getPocetStlpcov() != ina.getPocetRiadkov()) {
            return null;
        }

        //vytvorenie matice do ktorej budem zapisovat nove hodnoty
        Zlomok[][] pomocnaKopia = new Zlomok[this.getPocetRiadkov()][ina.getPocetStlpcov()];
        for (int riadok = 0; riadok < this.getPocetRiadkov(); riadok++) {
            for (int stlpec = 0; stlpec < ina.getPocetStlpcov(); stlpec++) {
                pomocnaKopia[riadok][stlpec] = new Zlomok(0, 0);
            }
        }
        Matica pomocnaMatica = new Matica(pomocnaKopia);
        //nasobenie matice
        for (int riadok = 0; riadok < this.getPocetRiadkov(); riadok++) {
            for (int stlpec = 0; stlpec < ina.getPocetStlpcov(); stlpec++) {
                for (int prvok = 0; prvok < ina.getPocetRiadkov(); prvok++) {
                    if (this.kopiaMatice[riadok][prvok].getMenovatel() == 0) {
                        vynasobenePrvky = pomocnyZlomok.vynasob(ina.kopiaMatice[prvok][stlpec]);
                        pricitajRaz = true;
                    } else {
                        vynasobenePrvky = this.kopiaMatice[riadok][prvok].vynasob(ina.kopiaMatice[prvok][stlpec]);
                    }
                    scitanePrvky = pomocnaMatica.kopiaMatice[riadok][stlpec].scitaj(vynasobenePrvky);
                    pomocnaMatica.kopiaMatice[riadok][stlpec] = scitanePrvky;
                }
                pricitajRaz = false;
            }
        }
        return pomocnaMatica;
    }

    public boolean jeRovnaka(Matica ina) {

        //kotrola ci sa da matica vobec porovnat
        if (this.getPocetRiadkov() != ina.getPocetRiadkov() || this.getPocetStlpcov() != ina.getPocetStlpcov()) {
            return false;
        }

        //kontrola prvkov
        for (int riadok = 0; riadok < this.getPocetRiadkov(); riadok++) {
            for (int stlpec = 0; stlpec < ina.getPocetStlpcov(); stlpec++) {
                if (this.kopiaMatice[riadok][stlpec].getCislo() != ina.kopiaMatice[riadok][stlpec].getCislo()) {
                    return false;
                }
            }
        }
        return true;
    }
}