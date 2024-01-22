package cz.czechitas.recept;

import cz.czechitas.recept.naradi.ElektrickaTrouba;
import cz.czechitas.recept.naradi.Miska;
import cz.czechitas.recept.naradi.Mixer;
import cz.czechitas.recept.naradi.PlechNaPeceni;
import cz.czechitas.recept.naradi.Vaha;
import cz.czechitas.recept.suroviny.Cukr;
import cz.czechitas.recept.suroviny.Maslo;
import cz.czechitas.recept.suroviny.Mouka;
import cz.czechitas.recept.suroviny.Ovoce;
import cz.czechitas.recept.suroviny.PrasekDoPeciva;
import cz.czechitas.recept.suroviny.Vajicka;
import cz.czechitas.recept.suroviny.intf.NadobaSKusovouSurovinou;
import cz.czechitas.recept.suroviny.intf.NadobaSeSypkouSurovinou;

public class SpousteciTrida {

  public static void main(String[] args) {
    Miska cervenaMiska;
    Miska zlutaMiska;
    Mixer mixer;
    Vaha kuchynskaVaha;
    PlechNaPeceni plech;
    ElektrickaTrouba trouba;
    Vajicka vajicka;

    Ovoce ovoce;
    Maslo maslo125g;
    Mouka pytlikMouky;
    Cukr pytlikCukru;
    PrasekDoPeciva prasekDoPeciva;

    cervenaMiska = new Miska("cervenaMiska");
    zlutaMiska = new Miska("zlutaMiska");
    mixer = new Mixer("mixer");
    kuchynskaVaha = new Vaha("vaha");
    plech = new PlechNaPeceni("plech");
    trouba = new ElektrickaTrouba("trouba");

    vajicka = new Vajicka("vajicka");
    ovoce = new Ovoce("ovoce");
    maslo125g = new Maslo("maslo125g");
    pytlikMouky = new Mouka("pytlikMouky");
    pytlikCukru = new Cukr("pytlikCukru");
    prasekDoPeciva = new PrasekDoPeciva("prasekDoPeciva");

    //---------------------------------------------------------------------

    // TODO: Sem napiste recept na bublaninu
    // Pouzivejte napovidani v editoru.
    // Vyskakuje samo nebo pomoci Ctrl+Mezernik

//    Nejdříve se musí zapnout trouba
    trouba.zapniSe(180);

//1. Smíchejte vajickaka a cukr: nejdříve si naložíme vajicka
    for (int i = 0; i <=3; i++) {
      cervenaMiska.nalozSiJedenKus(vajicka);
      //takhle staci, aby ve vysledek byl 4 vaj. nebo?
    }
// přidáme cukr a mícháme
    cervenaMiska.nalozSiCelyObsah(pytlikCukru);
    mixer.zamichej(cervenaMiska);

// 2. Pridejte máslo a dobre zamíchejte
    //    kuchynskaVaha.vynulujSeS(cervenaMiska);
    //    cervenaMiska.setHmotnostMasla(125);
    cervenaMiska.nalozSiCelyObsah(maslo125g);
    mixer.zamichej(cervenaMiska);
// 3. Přisypte 250 g mouky (pozor, pytlík mouky má 1 kg)
//      kuchynskaVaha.zjistiHmotnost(zlutaMiska);
    kuchynskaVaha.vynulujSeS(zlutaMiska);
    zlutaMiska.setHmotnostMouky(250);

    /*nepovedené pokusy
    while (zlutaMiska.getHmotnostMouky() !=250){
        zlutaMiska.nalozSiTrochu(pytlikMouky);

        if (zlutaMiska.getHmotnostMouky() ==250) {
            break;
      }
    }
  */

    if (zlutaMiska.getHmotnostMouky() == 250){
//      cervenaMiska.nalozSiCelyObsah(prasekDoPeciva);
    }
    else if (zlutaMiska.getHmotnostMouky() > 250){
      zlutaMiska.vylozSiTrochu(); }

    else if (zlutaMiska.getHmotnostMouky() < 250 ) {
      zlutaMiska.nalozSiTrochu(pytlikMouky);
    }

// 4. Nakonec do teste pridejte prasek do peciva
    cervenaMiska.nalozSiCelyObsah(prasekDoPeciva);
    mixer.zamichej(zlutaMiska);
    cervenaMiska.nalozSiObsahJineMisky(zlutaMiska);
    mixer.zamichej(cervenaMiska);
//    nalozit si na plech
    plech.preberSiObsah(cervenaMiska);
// 5. pred vlozenim do trouby posypte ovoce

    for (int i = 0; i <= 49; i++) {
      plech.posypSeKusem(ovoce);
//      zlutaMiska.nalozSiJedenKus(ovoce); Pozor na tuto chybu. Kod nepobezi. Ma se nalozit ovoce na plech, ne do misky.
    }

//6. Vlozte do predehrate trouby a pecte 25 minut na 180 stupnu
    trouba.vlozSiDovnitr(plech);
    trouba.nechejPect(25);
    trouba.vypniSe();
    trouba.vyndejObsahVen();

  }

}
