package ca.qc.bdeb.a13.vue;

import ca.qc.bdeb.a13.modele.Horloge;
import ca.qc.bdeb.a13.modele.Observateur;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;

public class Fenetre extends JFrame implements Observateur {

    private JLabel label = new JLabel();
    private Horloge horloge;

    public Fenetre() {
        super("Horloge");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(200, 80);

        horloge = new Horloge();
        horloge.addObservateur(this);
        new Thread(horloge).start();

        Font police = new Font("DS-digital", Font.TYPE1_FONT, 30);
        label.setFont(police);
        label.setHorizontalAlignment(JLabel.CENTER);

        label.setText("----");
        this.getContentPane().add(label, BorderLayout.CENTER);
    }

    @Override
    public void update(String hour) {
        label.setText(hour);
    }

    public static void main(String[] args) {
        Fenetre fen = new Fenetre();
        fen.setVisible(true);
    }
}