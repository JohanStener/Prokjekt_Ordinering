package ordination.ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PN extends Ordination {
    private ArrayList<LocalDate> datoer = new ArrayList<>();

    // altid den samme
    private double antalEnheder;

    /**
     * Pre: patient != null
     *
     * @param startDen
     * @param slutDen
     * @param patient
     * @param laegemiddel
     */
    public PN(final LocalDate startDen, final LocalDate slutDen, final Patient patient, final Laegemiddel laegemiddel) {
        super(startDen, slutDen, patient, laegemiddel);
    }


    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     *
     * @param givesDen
     * @return
     */


    public boolean givDosis(LocalDate givesDen) {
        LocalDate startDato = datoer.get(0);
        LocalDate slutDato = datoer.get(datoer.size() - 1);

        if (givesDen.isAfter(startDato) && givesDen.isBefore(slutDato)) {
            datoer.add(givesDen);
            return true;
        }

        return false;
    }

    public double doegnDosis() {
        LocalDate førsteDagGivet = datoer.get(0);
        LocalDate sidsteDagGivet = datoer.get(datoer.size() - 1);
        return samletDosis() / (ChronoUnit.DAYS.between(førsteDagGivet, sidsteDagGivet) + 1);
    }

    @Override
    public String getType() {
        return "PN";
    }


    public double samletDosis() {
        return datoer.size() * antalEnheder;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     *
     * @return
     */
    public int getAntalGangeGivet() {
        return datoer.size();
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

}
