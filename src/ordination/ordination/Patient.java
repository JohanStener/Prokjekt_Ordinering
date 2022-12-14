package ordination.ordination;

import java.util.ArrayList;

public class Patient {
    private String cprnr;
    private String navn;
    private double vaegt;
    private ArrayList<Ordination> ordinations = new ArrayList<>();
    // Skal denne arraylist være final?

    public Patient(String cprnr, String navn, double vaegt) {
        this.cprnr = cprnr;
        this.navn = navn;
        this.vaegt = vaegt;
    }

    public String getCprnr() {
        return cprnr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getVaegt(){
        return vaegt;
    }

    public void setVaegt(double vaegt){
        this.vaegt = vaegt;
    }


    /**
     * Adds the ordination to this patient,
     * if they aren't connected.
     * Pre: The ordination isn't connected to another patient.
     */
    public void addOrdination(Ordination ordination){
        if (!ordinations.contains(ordination)){
            ordinations.add(ordination);
        }
    }

    public ArrayList<Ordination> getOrdinationer(){
        return new ArrayList<>(ordinations);
    }

    // Der er ikke lavet nogen removeOrdination. Det tror vi ikke skal eksistere.

    @Override
    public String toString(){
        return navn + "  " + cprnr;
    }

}
