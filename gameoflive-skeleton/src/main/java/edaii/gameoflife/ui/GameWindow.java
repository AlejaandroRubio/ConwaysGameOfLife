package edaii.gameoflife.ui;

import edaii.gameoflife.ui.canvas.GameCanvas;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class GameWindow extends Frame {
    private static final long serialVersionUID = -1140312736876348187L;

    private GameCanvas canvas;
    private int generation = 0;

    public GameWindow() {
        setSize(800, 600);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void repaint() {
        super.repaint();
        canvas.repaint();
    }

    public void setCellStates(List<Integer> states) {
        canvas.setCellStates(states);
        setTitle("Generation " + ++this.generation);
        repaint();
    }

    public void setRowsAndColumns(int rows, int columns) {
        this.canvas = new GameCanvas(getWidth(), getHeight(), columns);
        this.removeAll();
        this.add(this.canvas);
        setVisible(true);
        this.generation = 0;
    }
}
