package mandelbrot;

import java.awt.*;

public class GridArgandDiagram extends ArgandDiagram {

    GenericQueue<Point> intersectedBoxes;

    int step;

    boolean start;

    boolean finished;

    public GridArgandDiagram(FractalSet fractalSet, DrawingConditions conditions, FractalColours colours) {

        super(fractalSet, conditions, colours);
        this.step = 16;
        this.intersectedBoxes = new GenericQueue<>();
        this.start = false;
        this.finished = false;

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (start) {

            drawGridlines(g);

            drawBoxes(g);

        }

    }

    public void drawGridlines(Graphics g) {

        if (step <= 16 && step >= 2) {
            g.setColor(colours.getInverse());
            for (int x = 0; x < this.getWidth(); x += step) {

                g.drawLine(x, 0, x, this.getHeight());

            }
            for (int y = 0; y < this.getHeight(); y += step) {

                g.drawLine(0, y, this.getWidth(), y);

            }
        }

    }

    public void drawBoxes(Graphics g) {

        for (Point intersected: intersectedBoxes) {

            g.setColor(Color.MAGENTA);
            g.fillRect(intersected.x, intersected.y, step, step);
            g.setColor(Color.GREEN);
            g.drawLine(intersected.x, intersected.y, intersected.x + step - 1, intersected.y + step - 1);

        }

    }

}