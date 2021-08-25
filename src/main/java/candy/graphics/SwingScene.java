/**
 * 
 */
package candy.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import candy.common.CandyPair;
import candy.common.Position;
import candy.file.CandyReader;
import candy.input.InputControllerImpl;
import candy.model.Candy;
import candy.model.GameState;
import candy.settings.Resolution;

public final class SwingScene extends JFrame implements Scene {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_BUTTON_DIMENSION = 50;
    private final InputControllerImpl controller;
    private final GameState gameState;
    private final PicLoader loader;
    private final Map<Position, JButton> candies;

    public SwingScene(final GameState gameState, final InputControllerImpl controller) {
        this.candies = new HashMap<>();
        this.controller = controller;
        this.gameState = gameState;
        final Resolution res = CandyReader.readSettings().getResolution();
        this.loader = new PicLoader(res);
        this.loader.loadImage();
        final JPanel mainPanel = new JPanelWithBackground();
        mainPanel.setLayout(new BorderLayout());
        final JPanel candyPanel = new JPanelWithBackground();
        candyPanel.setLayout(new GridLayout(this.gameState.getLevel().getGrid().getRow(),
                this.gameState.getLevel().getGrid().getColumn()));
        System.out.println("Swing Scene's map: " + this.gameState.getLevel().getGrid().getCandies());


        for (int i = 0; i < this.gameState.getLevel().getGrid().getRow(); i++) {
            for (int j = 0; j < this.gameState.getLevel().getGrid().getColumn(); j++) {
                final Position pos = new Position(i, j);
                final Candy cd = this.gameState.getLevel().getGrid().getCandies().get(pos);
                System.out.println(cd);
                if (cd != null) {
                    final JButton bt = new CandyButton(new CandyPair(cd.getType(), cd.getColor()));
                    System.out.println(loader.getCandyImage(new CandyPair(cd.getType(), cd.getColor())));
                    this.candies.put(pos, bt);
                    candyPanel.add(bt);
                    bt.setPreferredSize(new Dimension(DEFAULT_BUTTON_DIMENSION, DEFAULT_BUTTON_DIMENSION));
                    bt.setOpaque(false);
                    bt.setContentAreaFilled(false);
                }
            }
        }

        candyPanel.setPreferredSize(new Dimension(450, 450));
        mainPanel.add(candyPanel, BorderLayout.EAST);
        this.add(mainPanel);
        this.setSize(res.getDimension());
        this.setTitle("Candy Crush");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void paintComponent(final Graphics g) {
        super.paintComponents(g);
        g.drawImage(loader.getBackgroung(), 0, 0, this);
    }

    @Override
    public void render() {
        this.repaint();
    }

    @Override
    public void renderGameOver() {
        // TODO Auto-generated method stub

    }

    private class JPanelWithBackground extends JPanel {

        /**
       * 
       */
      private static final long serialVersionUID = 1L;

      public void paintComponent(final Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        g.drawImage(loader.getBackgroung(), 0, 0, this);
        }
      }

    private class CandyButton extends JButton {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        private final CandyPair candy;

        CandyButton(final CandyPair candy) {
            this.candy = candy;
        }

        public void paintComponent(final Graphics g) {
            super.paintComponent(g);
            g.drawImage(loader.getCandyImage(candy), 10, 15, this);
        }

    }

}
