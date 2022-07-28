package components.roundPanel;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

public class RoundPanel extends JPanel {

    private int radius;

    public RoundPanel(int radius){
        setOpaque(false);
        this.radius = radius;
    }


    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    protected void paintComponent(@NotNull Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g.create();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(getBackground());
        graphics2D.fill(new Area( new RoundRectangle2D.Double(0,0,getWidth(), getHeight(), radius, radius)));
        graphics2D.dispose();

    }



}
