package ca.qc.bdeb.a13.vue;

import ca.qc.bdeb.a13.modele.Observateur;
import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame implements Observateur {

    private JLabel label = new JLabel();

    public Fenetre() {
        super("Horloge");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(200, 80);

        Font police = new Font("DS-digital", Font.TYPE1_FONT, 30);
        label.setFont(police);
        label.setHorizontalAlignment(JLabel.CENTER);

        label.setText("----");   // Valeur affichée au démarrage
        this.getContentPane().add(label, BorderLayout.CENTER);
    }

    @Override
    public void update(String hour) {
        // Affiche l'heure reçue de l'horloge
        label.setText(hour);
    }

    public static void main(String[] args) {
        Fenetre fen = new Fenetre();
        fen.setVisible(true);
    }
}
