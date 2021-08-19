package candy.outcome;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class GameOutcomeGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private static int fontSize = 24;
    public GameOutcomeGUI(final GameOutcome gameOutcome) {
        super();
        if (gameOutcome.equals(GameOutcome.MOVES_OVER) || gameOutcome.equals(GameOutcome.TIME_OVER)) {
            final JFrame frame = this;
            this.setTitle("You loose!");
            final JPanel panel = new JPanel();
            final JLabel lb = new JLabel("GAME OVER");
            panel.setLayout(new GridBagLayout());
            panel.setBorder(new LineBorder(Color.BLACK));
            panel.setBackground(Color.ORANGE);
            lb.setFont(new Font("Comic Sans MS", Font.PLAIN, fontSize));
            panel.add(lb);
            final JButton rankingButton = new JButton("Show general ranking");
            //rankingButton.addActionListener(e -> saveSettings(sound.isSelected())); manca il metodo che mostra la classifica
            panel.add(rankingButton);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.addWindowListener(new WindowAdapter() {
                public void windowClosing(final WindowEvent e) {
                    final int n = JOptionPane.showConfirmDialog(frame, "Do you really want to quit?", 
                            "Quitting...", JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION) {
                        System.exit(0);
                        //metodo per uscire dal gioco meglio
                    }
                }
            });
        } else if (gameOutcome.equals(GameOutcome.OBJECTIVE_ACHIEVED)) {
            final JFrame frame = this;
            this.setTitle("You won!");
            final JPanel panel = new JPanel();
            final JLabel lb = new JLabel("YOU COMPLETE THE LEVEL");
            panel.setLayout(new GridBagLayout());
            panel.setBorder(new LineBorder(Color.BLACK));
            panel.setBackground(Color.ORANGE);
            lb.setFont(new Font("Comic Sans MS", Font.PLAIN, fontSize));
            panel.add(lb);
            final JButton rankingButton = new JButton("Show level's ranking");
            //rankingButton.addActionListener(e -> saveSettings(sound.isSelected())); manca il metodo che mostra la classifica
            panel.add(rankingButton);
            final JButton nextLevel = new JButton("Go to next level");
            //rankingButton.addActionListener(e -> saveSettings(sound.isSelected())); manca il metodo che manda al livello successivo
            panel.add(nextLevel);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.addWindowListener(new WindowAdapter() {
                public void windowClosing(final WindowEvent e) {
                    int n = JOptionPane.showConfirmDialog(frame, "Do you really want to quit?", 
                            "Quitting...", JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION) {
                        System.exit(0);
                      //metodo per uscire dal gioco meglio
                    }
                }
            });
        } else if (gameOutcome.equals(GameOutcome.LEVELS_ENDED)) {
            final JFrame frame = this;
            this.setTitle("You won!");
            final JPanel panel = new JPanel();
            final JLabel lb = new JLabel("YOU COMPLETE THE LEVEL");
            panel.setLayout(new GridBagLayout());
            panel.setBorder(new LineBorder(Color.BLACK));
            panel.setBackground(Color.ORANGE);
            lb.setFont(new Font("Comic Sans MS", Font.PLAIN, fontSize));
            panel.add(lb);
            final JButton levelRankingButton = new JButton("Show level's ranking");
            //rankingButton.addActionListener(e -> ); manca il metodo che mostra la classifica del livello
            panel.add(levelRankingButton);
            final JButton generalRankingButton = new JButton("Show level's ranking");
            //rankingButton.addActionListener(e -> ); manca il metodo che mostra la classifica generale
            panel.add(generalRankingButton);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.addWindowListener(new WindowAdapter() {
                public void windowClosing(final WindowEvent e) {
                    final int n = JOptionPane.showConfirmDialog(frame, "Do you really want to quit?", 
                            "Quitting...", JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION) {
                        System.exit(0);
                      //metodo per uscire dal gioco meglio
                    }
                }
            });
        } else {
            throw new IllegalArgumentException("The GameOutcome is wrong or don't exist!");
        }
    }

}
