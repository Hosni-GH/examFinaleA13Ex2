package ca.qc.bdeb.a13.vue;

import ca.qc.bdeb.a13.modele.Horloge;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fenetre extends JFrame {

    private JLabel label = new JLabel();
    private Horloge horloge;

    public Fenetre() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(200, 80);

        this.horloge = new Horloge();

        Font police = new Font("DS-digital", Font.TYPE1_FONT, 30);
        this.label.setFont(police);
        this.label.setHorizontalAlignment(JLabel.CENTER);

        this.label.setText("----");
        this.getContentPane().add(this.label, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Fenetre fen = new Fenetre();
        Horloge h = new Horloge();
        fen.setVisible(true);
    }
}

