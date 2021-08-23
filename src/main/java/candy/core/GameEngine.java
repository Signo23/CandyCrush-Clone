package candy.core;

import java.util.LinkedList;

import candy.graphics.Scene;
import candy.graphics.SwingScene;
import candy.input.InputControllerImpl;
import candy.model.GameState;
import candy.model.LevelEvent;
import candy.model.LevelEventListener;

public class GameEngine implements LevelEventListener {

    private static final long PERIOD = 20;
    private Scene view;
    private GameState gameState;
    private InputControllerImpl controller;
    private LinkedList<LevelEvent> eventQueue;

    public GameEngine() {
        this.eventQueue = new LinkedList<>();
    }

    public final void initGame() {
        this.gameState = new GameState();
        this.controller = new InputControllerImpl();
        this.view = new SwingScene(this.gameState, this.controller);
    }

    public final void mainLoop() {
        while (!this.gameState.isGameOver()) {
            final long currentTime = System.currentTimeMillis();
            this.processInput();
            this.updateGame();
            this.render();
            this.waitNextFrame(currentTime);
        }
        this.renderGameOver();
    }

    private void waitNextFrame(final long current) {
        final long dt = System.currentTimeMillis() - current;
        if (dt < PERIOD) {
            try {
                Thread.sleep(PERIOD - dt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void processInput() {
//        this.gameState.getLevel().updateInput(this.controller);
    }

    private void updateGame() {
        this.eventQueue.stream().forEach(ev -> {
//      TODO
        });
    }

    private void render() {
        this.view.render();
    }

    private void renderGameOver() {
        //TODO
    }

    @Override
    public final void notifyEvent(final LevelEvent event) {
        this.eventQueue.add(event);
    }
}
