package ca.qc.bdeb.a13.modele;

public interface Observable {
    public void addObservateur(Observateur obs);
    public void updateObservateur();
    public void delObservateur();
}
