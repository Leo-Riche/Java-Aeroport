package Aeroport;

import java.util.ArrayList;
import java.util.List;

public class Vol {
    private static int CPT = 0;

    private int id;
    private Compagnie compagnie;
    private Avion avion;
    private List<Passager> passagers;
    private String heureDepart;
    private String heureArrivee;
    private Aeroport destination;
    private Terminal depart;
    private float prix;
    private String duree;
    private List<Personnel> personnels;

    public Vol(Compagnie compagnie, Avion avion, String heureDepart, String heureArrivee,
            Aeroport destination, Terminal depart, float prix, String duree) {
        this.id = CPT++;
        this.compagnie = compagnie;
        this.avion = avion;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.destination = destination;
        this.depart = depart;
        this.prix = prix;
        this.duree = duree;
        this.passagers = new ArrayList<Passager>();
        this.personnels = new ArrayList<Personnel>();
    }

    public int getId() {
        return this.id;
    }

    public Compagnie getCompagnie() {
        return this.compagnie;
    }

    public void setCompagnie(Compagnie compagnie) {
        this.compagnie = compagnie;
    }

    public Avion getAvion() {
        return this.avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public List<Passager> getPassagers() {
        return this.passagers;
    }

    public String getHeureDepart() {
        return this.heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public String getHeureArrivee() {
        return this.heureArrivee;
    }

    public void setHeureArrivee(String heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public Aeroport getDestination() {
        return this.destination;
    }

    public void setDestination(Aeroport destination) {
        this.destination = destination;
    }

    public Terminal getDepart() {
        return this.depart;
    }

    public void setDepart(Terminal depart) {
        this.depart = depart;
    }

    public float getPrix() {
        return this.prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDuree() {
        return this.duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public List<Personnel> getPersonnels() {
        return this.personnels;
    }

    /** Ajoute un passager au vol, sans doublon. */
    public void ajouterPassager(Passager passager) {
        if (passager != null && !this.passagers.contains(passager)) {
            this.passagers.add(passager);
        }
    }

    /** Retire un passager du vol. */
    public void retirerPassager(Passager passager) {
        this.passagers.remove(passager);
    }

    /** Retourne le nombre de passagers du vol. */
    public int getNombrePassagers() {
        return this.passagers.size();
    }

    /** Definit le terminal de depart du vol et fait pointer ce terminal sur le vol. */
    public void ajouterTerminal(Terminal terminal) {
        this.depart = terminal;
        if (terminal != null) {
            terminal.setVol(this);
        }
    }

    /** Retire le terminal de depart du vol. */
    public void retirerTerminal() {
        if (this.depart != null) {
            if (this.depart.getVol() == this) {
                this.depart.setVol(null);
            }
            this.depart = null;
        }
    }

    /** Affecte un membre du personnel au vol, sans doublon. */
    public void ajouterPersonnel(Personnel personnel) {
        if (personnel != null && !this.personnels.contains(personnel)) {
            this.personnels.add(personnel);
        }
    }

    /** Retire un membre du personnel du vol. */
    public void retirerPersonnel(Personnel personnel) {
        this.personnels.remove(personnel);
    }
}
