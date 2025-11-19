package ca.qc.bdeb.a13.modele;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Horloge implements Observable, Runnable {

    private Calendar cal;
    private String hour = "";

    // Liste des observateurs inscrits
    private List<Observateur> observateurs = new ArrayList<>();

    public Horloge() {
        // Initialisation du calendrier
        this.cal = Calendar.getInstance();
    }

    @Override
    public void addObservateur(Observateur obs) {
        observateurs.add(obs);
    }

    @Override
    public void updateObservateur() {
        for (Observateur obs : observateurs) {
            obs.update(hour);
        }
    }

    @Override
    public void delObservateur(Observateur obs) {
        observateurs.remove(obs);
    }

    @Override
    public void delAllObservateurs() {
        observateurs.clear();
    }

    @Override
    public void run() {
        while (true) {
            // Met à jour la date/heure courante
            this.cal = Calendar.getInstance();

            this.hour =
                    this.cal.get(Calendar.HOUR_OF_DAY) + " : "
                            + (this.cal.get(Calendar.MINUTE) < 10
                            ? "0" + this.cal.get(Calendar.MINUTE)
                            : this.cal.get(Calendar.MINUTE))
                            + ":"
                            + (this.cal.get(Calendar.SECOND) < 10
                            ? "0" + this.cal.get(Calendar.SECOND)
                            : this.cal.get(Calendar.SECOND));

            // Notifier les observateurs
            updateObservateur();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}