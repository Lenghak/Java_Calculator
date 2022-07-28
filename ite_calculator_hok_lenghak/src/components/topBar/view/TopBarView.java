package components.topBar.view;

import resource.font.QuickSand;

import javax.swing.*;
import java.awt.*;


public class TopBarView {

    private static final JPanel TOP_BAR_PANEL = new JPanel();

    private static final JButton MENU_BUTTON = new JButton();

    private static final JLabel HEADER_STRING = new JLabel();


    public TopBarView(){

//        MENU_BUTTON.setPreferredSize(new Dimension(50, 35));
        MENU_BUTTON.setName("MenuButton");
        MENU_BUTTON.setText("☰");
        MENU_BUTTON.setFont(new Font("Quicksand", Font.BOLD, 25));
        MENU_BUTTON.setForeground(Color.white);
        MENU_BUTTON.setContentAreaFilled(false);
        MENU_BUTTON.setBorderPainted(false);
        MENU_BUTTON.setFocusable(false);
        MENU_BUTTON.setOpaque(false);
        MENU_BUTTON.validate();

        HEADER_STRING.setFont(QuickSand.getFont(Font.BOLD, 18));
        HEADER_STRING.setForeground(Color.white);

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.X_AXIS));
        innerPanel.add(MENU_BUTTON);
        innerPanel.add(HEADER_STRING);
        innerPanel.setOpaque(false);

        TOP_BAR_PANEL.setLayout(new BorderLayout());
        TOP_BAR_PANEL.setBorder(BorderFactory.createEmptyBorder(10, 13,0,0));
        TOP_BAR_PANEL.add(innerPanel, BorderLayout.WEST);
        TOP_BAR_PANEL.setOpaque(false);
    }

    public void setHeader(String header){
        HEADER_STRING.setText(header);
    }

    public JPanel getTopBarPanel() {
        return TOP_BAR_PANEL;
    }

    public JButton getMenuButton() {
        return MENU_BUTTON;
    }


    public String getHeader() {
        return HEADER_STRING.getText();
    }
}
