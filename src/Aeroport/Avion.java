package Aeroport;

public class Avion {
    private static int CPT = 0;

    private int id;
    private ModeleAvion modeleAvion;
    private Compagnie compagnie;
    private boolean enVol;
    private int capacite;

    public Avion(ModeleAvion modeleAvion, Compagnie compagnie, boolean enVol, int capacite) {
        this.id = CPT++;
        this.modeleAvion = modeleAvion;
        this.compagnie = compagnie;
        this.enVol = enVol;
        this.capacite = capacite;
    }

    public int getId() {
        return this.id;
    }

    public ModeleAvion getModeleAvion() {
        return this.modeleAvion;
    }

    public void setModeleAvion(ModeleAvion modeleAvion) {
        this.modeleAvion = modeleAvion;
    }

    public Compagnie getCompagnie() {
        return this.compagnie;
    }

    /** Ajouter un avion a une compagnie. */
    public void setCompagnie(Compagnie compagnie) {
        this.compagnie = compagnie;
    }

    /** Detache l'avion de sa compagnie. */
    public void retirerCompagnie() {
        this.compagnie = null;
    }

    public boolean isEnVol() {
        return this.enVol;
    }

    public void setEnVol(boolean enVol) {
        this.enVol = enVol;
    }

    public int getCapacite() {
        return this.capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }


    /** Affecte cet avion au vol. */
    public void ajouterVol(Vol vol) {
        if (vol != null) {
            vol.setAvion(this);
        }
    }

    /** Retire cet avion du vol, s'il y etait affecte. */
    public void retirerVol(Vol vol) {
        if (vol != null && vol.getAvion() == this) {
            vol.setAvion(null);
        }
    }
}
