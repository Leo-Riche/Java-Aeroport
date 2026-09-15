package Aeroport;

public class Terminal {
    private Vol vol;
    private String nom;
    private Aeroport aeroport;

    public Terminal(Vol vol, String nom, Aeroport aeroport) {
        this.vol = vol;
        this.nom = nom;
        this.aeroport = aeroport;
    }

    public Vol getVol() {
        return this.vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Aeroport getAeroport() {
        return this.aeroport;
    }

    public void setAeroport(Aeroport aeroport) {
        this.aeroport = aeroport;
    }
}
