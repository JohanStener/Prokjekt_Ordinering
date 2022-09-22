package ordination.ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination{
    private final Dosis[] doses = new Dosis[4];

    /**
     * Pre: patient != null
     *
     * @param startDen
     * @param slutDen
     * @param patient
     */
    public DagligFast(LocalDate startDen, LocalDate slutDen, Patient patient) {
        super(startDen, slutDen, patient);
    }

    @Override
    public double samletDosis() {

        return 0;
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
        return null;
    }

    public Dosis[] getDoses() {
        return doses;
    }

    public Dosis createDosis(LocalTime tid, double antal){
        int counter = 0;
        if (doses.length < 4){
            Dosis dosis = new Dosis(tid, antal);
            doses[counter] = dosis;
            return dosis;
        }else {
            throw new RuntimeException("Antal dosis må ikke overstige 4");
        }

    }
}
