package ca.qc.bdeb.a13.modele;

import java.util.Calendar;

public class Horloge {

    Calendar cal;

    private String hour = "";

    public void run() {
        while (true) {

            this.hour
                    = this.cal.get(Calendar.HOUR_OF_DAY) + " : "
                    + (this.cal.get(Calendar.MINUTE) < 10
                    ? "0" + this.cal.get(Calendar.MINUTE) : this.cal.get(Calendar.MINUTE)) + ":"
                    + ((this.cal.get(Calendar.SECOND) < 10)
                    ? "0" + this.cal.get(Calendar.SECOND) : this.cal.get(Calendar.SECOND));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
