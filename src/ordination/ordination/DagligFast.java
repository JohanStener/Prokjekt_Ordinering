package ordination.ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination{
    private final Dosis[] doses = new Dosis[4];
    int counter = 0;

    /**
     * Pre: patient != null
     *
     * @param startDen
     * @param slutDen
     * @param patient
     * @param laegemiddel
     */
    public DagligFast(final LocalDate startDen, final LocalDate slutDen, final Patient patient, final Laegemiddel laegemiddel) {
        super(startDen, slutDen, patient, laegemiddel);
    }


    @Override
    public double samletDosis() {
        double result = 0;
        for (Dosis d : doses){
            result += d.getAntal();
        }
        return result * antalDage();
    }

    @Override
    public double doegnDosis() {
        double result = 0;
        for (Dosis d : doses){
            result += d.getAntal();
        }
        return result;
    }

    @Override
    public String getType() {
        return "Daglig fast";
    }

    public Dosis[] getDoser() {
        return doses;
    }

    public Dosis createDosis(LocalTime tid, double antal){

        if (LocalTime.of(8,0) == tid){
            Dosis dosis = new Dosis(tid, antal);
            doses[0] = dosis;
            return dosis;
        }else if (LocalTime.of(14,0) == tid){
            Dosis dosis = new Dosis(tid, antal);
            doses[1] = dosis;
            return dosis;
        } else if (LocalTime.of(20,0) == tid) {
            Dosis dosis = new Dosis(tid, antal);
            doses[2] = dosis;
            return dosis;
        }else if (LocalTime.of(2,0) == tid){
            Dosis dosis = new Dosis(tid, antal);
            doses[3] = dosis;
            return dosis;
        }else {
            throw new RuntimeException("Antal dosis må ikke overstige 4");
        }
    }
}
