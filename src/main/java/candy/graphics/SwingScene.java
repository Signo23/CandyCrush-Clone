/**
 * 
 */
package candy.graphics;

import java.awt.Graphics;

import javax.swing.JFrame;

import candy.file.CandyReader;
import candy.input.InputControllerImpl;
import candy.settings.Resolution;
import model.GameState;

public final class SwingScene extends JFrame implements Scene {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private InputControllerImpl controller;
    private GameState gameState;
    private PicLoader loader;

    public SwingScene(final GameState gameState, final InputControllerImpl controller) {
        this.controller = controller;
        this.gameState = gameState;
        final Resolution res = CandyReader.readSettings().getResolution();
        this.loader = new PicLoader(res);
        this.setSize(res.getDimension());
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

}
