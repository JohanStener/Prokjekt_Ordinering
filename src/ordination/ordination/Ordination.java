package ordination.ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Ordination { // Er en superklasse
    private LocalDate startDen;
    private LocalDate slutDen;
    private Laegemiddel laegemiddel;

    // TODO Link til Laegemiddel
    // TODO constructor (med specifikation)

    /**
    * Pre: patient != null
     */
    public Ordination(LocalDate startDen, LocalDate slutDen, Patient patient){
        this.startDen = startDen;
        this.slutDen = slutDen;
        patient.addOrdination(this);
        /* Magnus ved ikke om "patient.addPatient(this);" skal
        være på superklassens constructor eller kun på subklassen
        constructorer..?
         */
    }

    public LocalDate getStartDen() {
        return startDen;
    }	

    public LocalDate getSlutDen() {
        return slutDen;
    }

    /**
     * Antal hele dage mellem startdato og slutdato. Begge dage inklusive.
     * @return antal dage ordinationen gælder for
     */
    public int antalDage() {
        return (int) ChronoUnit.DAYS.between(startDen, slutDen) + 1;
    }

    @Override
    public String toString() {
        return startDen.toString();
    }

    /**
     * Returnerer den totale dosis der er givet i den periode ordinationen er gyldig
     * @return
     */
    public abstract double samletDosis();

    /**
     * Returnerer den gennemsnitlige dosis givet pr dag i den periode ordinationen er gyldig
     * @return
     */
    public abstract double doegnDosis();

    /**
     * Returnerer ordinationstypen som en String
     * @return
     */
    public abstract String getType();

    public Laegemiddel getLaegemiddel(){
        return laegemiddel;
    }

    public void setLaegemiddel(Laegemiddel laegemiddel){
        if (this.laegemiddel != laegemiddel){
            this.laegemiddel = laegemiddel;
        }
    }
}
