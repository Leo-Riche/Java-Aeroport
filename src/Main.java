import Aeroport.Aeroport;
import Aeroport.Avion;
import Aeroport.Bagage;
import Aeroport.Compagnie;
import Aeroport.ModeleAvion;
import Aeroport.Passager;
import Aeroport.Personnel;
import Aeroport.Profession;
import Aeroport.Terminal;
import Aeroport.Vol;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        titre("Creation des objets");

        Compagnie airFrance = new Compagnie("Air France");
        Aeroport cdg = new Aeroport("95700 Roissy-en-France", "Charles de Gaulle", "France", "UTC+1");
        Aeroport jfk = new Aeroport("Queens, New York", "John F. Kennedy", "Etats-Unis", "UTC-5");

        Terminal terminal2E = new Terminal(null, "2E", cdg);
        Terminal terminal2F = new Terminal(null, "2F", cdg);

        Avion avion = new Avion(ModeleAvion.Boeing777, null, false, 350);

        Personnel pilote = new Personnel("Dupont", "Jean", Profession.PILOTE);
        Personnel copilote = new Personnel("Martin", "Claire", Profession.COPILOTE);
        Personnel stewart = new Personnel("Lopez", "Ana", Profession.STEWART);

        Passager alice = new Passager("Bernard", "Alice");
        alice.setPasseport(true);
        alice.setBagage(Bagage.SOUTE);
        Passager bob = new Passager("Petit", "Bob");

        Vol vol = new Vol(airFrance, null, 0, "10h30", "13h15", jfk, null, 649.99f, "8h45");

        System.out.println("Compagnie : " + airFrance.getNom() + " (id " + airFrance.getId() + ")");
        System.out.println("Aeroport  : " + cdg.getNom() + ", " + cdg.getPays() + " " + cdg.getUTC());
        System.out.println("Avion     : " + avion.getModeleAvion() + ", " + avion.getCapacite() + " places");
        System.out.println("Vol       : id " + vol.getId() + ", " + vol.getHeureDepart() + " -> "
                + vol.getHeureArrivee() + " (" + vol.getDuree() + "), " + vol.getPrix() + " euros");

        titre("Terminaux de l aeroport : ajouterTerminal / retirerTerminal");

        cdg.ajouterTerminal(terminal2E);
        cdg.ajouterTerminal(terminal2F);
        cdg.ajouterTerminal(terminal2E); // doublon ignore
        afficherTerminaux(cdg);
        System.out.println("Aeroport du terminal 2E : " + nomAeroport(terminal2E));

        cdg.retirerTerminal(terminal2F);
        System.out.println("Apres retrait du 2F :");
        afficherTerminaux(cdg);
        System.out.println("Aeroport du terminal 2F : " + nomAeroport(terminal2F));

        titre("Personnel de l aeroport : ajouterPersonnel / retirerPersonnel");

        cdg.ajouterPersonnel(pilote);
        cdg.ajouterPersonnel(copilote);
        cdg.ajouterPersonnel(stewart);
        afficherPersonnels("CDG", cdg.getPersonnels());

        cdg.retirerPersonnel(stewart);
        System.out.println("Apres retrait de Lopez :");
        afficherPersonnels("CDG", cdg.getPersonnels());

        titre("Compagnie de l avion : ajouterCompagnie / retirerCompagnie");

        System.out.println("Compagnie avant : " + nomCompagnie(avion.getCompagnie()));
        avion.ajouterCompagnie(airFrance);
        System.out.println("Compagnie apres ajout : " + nomCompagnie(avion.getCompagnie()));
        avion.retirerCompagnie();
        System.out.println("Compagnie apres retrait : " + nomCompagnie(avion.getCompagnie()));
        avion.ajouterCompagnie(airFrance);

        titre("Avion du vol : ajouterVol / retirerVol");

        System.out.println("Avion du vol avant : " + idAvion(vol.getAvion()));
        avion.ajouterVol(vol);
        System.out.println("Avion du vol apres ajout : " + idAvion(vol.getAvion()));
        avion.retirerVol(vol);
        System.out.println("Avion du vol apres retrait : " + idAvion(vol.getAvion()));
        avion.ajouterVol(vol);

        titre("Terminal de depart du vol : ajouterTerminal / retirerTerminal");

        vol.ajouterTerminal(terminal2E);
        System.out.println("Terminal de depart : " + nomTerminal(vol.getDepart()));
        System.out.println("Vol rattache au terminal 2E : " + idVol(terminal2E.getVol()));

        vol.retirerTerminal();
        System.out.println("Apres retrait :");
        System.out.println("Terminal de depart : " + nomTerminal(vol.getDepart()));
        System.out.println("Vol rattache au terminal 2E : " + idVol(terminal2E.getVol()));
        vol.ajouterTerminal(terminal2E);

        titre("Passagers du vol : ajouterPassager / retirerPassager");

        vol.ajouterPassager(alice);
        vol.ajouterPassager(bob);
        vol.ajouterPassager(alice); // doublon ignore
        afficherPassagers(vol);

        vol.retirerPassager(bob);
        System.out.println("Apres retrait de Bob :");
        afficherPassagers(vol);

        titre("Cote passager : ajouterVol / retirerVol");

        bob.ajouterVol(vol);
        System.out.println("Apres bob.ajouterVol(vol) :");
        afficherPassagers(vol);

        alice.retirerVol(vol);
        System.out.println("Apres alice.retirerVol(vol) :");
        afficherPassagers(vol);
        alice.ajouterVol(vol);

        titre("Personnel du vol : ajouterPersonnel / retirerPersonnel");

        vol.ajouterPersonnel(pilote);
        vol.ajouterPersonnel(copilote);
        vol.ajouterPersonnel(stewart);
        afficherPersonnels("vol " + vol.getId(), vol.getPersonnels());

        vol.retirerPersonnel(copilote);
        System.out.println("Apres retrait de Martin :");
        afficherPersonnels("vol " + vol.getId(), vol.getPersonnels());

        titre("Etat final du vol " + vol.getId());

        System.out.println("Compagnie : " + nomCompagnie(vol.getCompagnie()));
        System.out.println("Avion     : " + idAvion(vol.getAvion()) + " (" + avion.getModeleAvion() + ")");
        System.out.println("Depart    : terminal " + nomTerminal(vol.getDepart()) + " de "
                + vol.getDepart().getAeroport().getNom() + " a " + vol.getHeureDepart());
        System.out.println("Arrivee   : " + vol.getDestination().getNom() + " a " + vol.getHeureArrivee());
        afficherPassagers(vol);
        afficherPersonnels("vol " + vol.getId(), vol.getPersonnels());
        System.out.println("nombrePassager (attribut) : " + vol.getNombrePassager()
                + " / passagers.size() : " + vol.getPassagers().size());
    }

    private static void titre(String texte) {
        System.out.println();
        System.out.println("=== " + texte + " ===");
    }

    private static void afficherTerminaux(Aeroport aeroport) {
        System.out.print("Terminaux de " + aeroport.getNom() + " (" + aeroport.getTerminals().size() + ") :");
        for (Terminal terminal : aeroport.getTerminals()) {
            System.out.print(" " + terminal.getNom());
        }
        System.out.println();
    }

    private static void afficherPassagers(Vol vol) {
        System.out.println("Passagers du vol " + vol.getId() + " (" + vol.getPassagers().size() + ") :");
        for (Passager passager : vol.getPassagers()) {
            System.out.println("  - " + passager.getPrenom() + " " + passager.getNom()
                    + ", passeport : " + passager.getPasseport() + ", bagage : " + passager.getBagage());
        }
    }

    private static void afficherPersonnels(String contexte, List<Personnel> personnels) {
        System.out.println("Personnel de " + contexte + " (" + personnels.size() + ") :");
        for (Personnel personnel : personnels) {
            System.out.println("  - " + personnel.getPrenom() + " " + personnel.getNom()
                    + " : " + personnel.getProfession());
        }
    }

    private static String nomAeroport(Terminal terminal) {
        return terminal.getAeroport() == null ? "aucun" : terminal.getAeroport().getNom();
    }

    private static String nomCompagnie(Compagnie compagnie) {
        return compagnie == null ? "aucune" : compagnie.getNom();
    }

    private static String nomTerminal(Terminal terminal) {
        return terminal == null ? "aucun" : terminal.getNom();
    }

    private static String idAvion(Avion avion) {
        return avion == null ? "aucun" : "id " + avion.getId();
    }

    private static String idVol(Vol vol) {
        return vol == null ? "aucun" : "id " + vol.getId();
    }
}
