package modules.standard.view;

import org.jetbrains.annotations.NotNull;
import resource.font.QuickSand;
import components.roundPanel.RoundPanel;

import javax.swing.*;
import java.awt.*;

public class StandardComponentView {

    /**
     * <p>This method will create the view for the button that pass into this method</p>
     */
    public @NotNull JPanel createView(@NotNull JButton btn, Color bg, Color fg, String text, String className) {

        btn.setPreferredSize(new Dimension(50, 70));
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setFocusable(false);
        btn.setContentAreaFilled(false);
        btn.setForeground(fg);
        btn.setText(text);
        btn.setName("Btn_" + text);
        btn.setFont(QuickSand.getFont(Font.BOLD, 20));
        btn.setOpaque(false);
        btn.validate();

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(btn);
        panel.setPreferredSize(btn.getPreferredSize());
        panel.setBackground(bg);
        panel.setBorder(BorderFactory.createSoftBevelBorder(0, new Color(0, 0, 0, 15), new Color(0, 0, 0, 50)));
        panel.setName(className);
        panel.validate();
        return panel;

    }


    public @NotNull JPanel createView(@NotNull JButton btn, Color fg, String text, String className) {

        btn.setPreferredSize(new Dimension(40, 30));
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setOpaque(false);
        btn.setForeground(fg);
        btn.setFont(QuickSand.getFont(Font.BOLD, 18));
        btn.setText(text);
        btn.validate();

        RoundPanel panel = new RoundPanel(5);
        panel.setLayout(new BorderLayout());
        panel.add(btn);
        panel.setPreferredSize(btn.getPreferredSize());
        panel.setBorder(BorderFactory.createSoftBevelBorder(0, new Color(0, 0, 0, 15), new Color(0, 0, 0, 50)));
        panel.setName(className);
        panel.validate();
        return panel;
    }

}
