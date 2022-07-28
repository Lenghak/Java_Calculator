package components.sideDrawer.view;

import resource.font.QuickSand;
import components.roundPanel.RoundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SideMenuView extends JPanel {

    private Color color;

    private final JButton[] tabButtons = new JButton[6];
    private final JButton menuButton = new JButton();

    private final RoundPanel[] buttonContainer = new RoundPanel[7];
    private final RoundPanel buttonPanel = new RoundPanel(20);
    private final JPanel trans = new JPanel();

    private final String[] buttonTexts = {"Standard", "Scientific", "Programming", "Angle Converter", "Currency Converter", "Data Converter"};

    private static int finalActive = 0;

    /**
     * constructor of the side Menu
     * */
    public SideMenuView() {

        setOpaque(false);
        createTabBtnView();
        createSideMenu();
        setDefaultActiveTab(0);

        for (int index = 0; index < tabButtons.length; index++) {

            int finalIndex = index;

            tabButtons[index].addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    color = e.getComponent().getParent().getBackground();
                    e.getComponent().getParent().setBackground(color.brighter());
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    e.getComponent().getParent().setBackground(color);
                    super.mouseExited(e);
                }

                @Override
                public void mouseClicked(MouseEvent e) {

                    JPanel parent = (JPanel) tabButtons[finalActive].getParent();

                    if(finalIndex != finalActive){

                        //reset the active state back to the default state before activate another
                        parent.setBorder(BorderFactory.createEmptyBorder(0,5,0,0));
                        parent.setBackground(Color.decode("#3C3C3C"));
                        tabButtons[finalActive].getComponent(0).setForeground(Color.white);
                        finalActive = finalIndex;

                        setDefaultActiveTab(finalActive);

                    }

                    super.mouseClicked(e);

                }
            });
        }
    }


    /**
     * creation of the tabButton
     * */
    private void createTabBtnView() {

        setLayout(new BorderLayout());

        for (int index = 0; index < 6; index++) {

            JLabel label = new JLabel(buttonTexts[index], SwingConstants.LEFT);
            label.setFont(QuickSand.getFont(Font.BOLD, 15));
            label.setForeground(Color.white);

            tabButtons[index] = new JButton();
            tabButtons[index].add(label);
            tabButtons[index].setContentAreaFilled(false);
            tabButtons[index].setBorderPainted(false);

        }
    }

    /**
     * the creation of the side menu
     * */
    private void createSideMenu() {

        //the main panel of the side menu of the border-rounded panel with customization below

        buttonPanel.setLayout(new GridLayout(14,1));
        buttonPanel.setPreferredSize(new Dimension(225, getHeight()));
        buttonPanel.setBorder(BorderFactory.createSoftBevelBorder(0, new Color(0,0,0,50),new Color(0,0,0,50)));
        buttonPanel.setBackground(Color.decode("#3C3C3C"));

        createMenuButton();
        addTabButton();
        addFakeButton();

        trans.setBackground(new Color(0,0,0,0));    /*customizing the transparent panel for putting
                                                                 on the right side of the side menu */
        trans.validate();                                      //validate the panel

        add(buttonPanel, BorderLayout.WEST);    //add the button panel to the glass pane
        add(trans, BorderLayout.CENTER);        //adding the transparent panel to the glass pane
        validate();                             //validate the glass pane
    }


    private void createMenuButton(){
        //the ||| button for close the side menu
        menuButton.setName("MenuButton");
        menuButton.setText("☰");
        menuButton.setFont(new Font("Quicksand", Font.BOLD, 25));
        menuButton.setForeground(Color.white);
        menuButton.setContentAreaFilled(false);
        menuButton.setBorderPainted(false);
        menuButton.setFocusable(false);
        menuButton.setOpaque(false);
        menuButton.validate();

        //button container number 7 a round panel that contain the menu button
        buttonContainer[6] = new RoundPanel(10);
        buttonContainer[6].setLayout(new BorderLayout());
        buttonContainer[6].add(menuButton, BorderLayout.WEST);
        buttonContainer[6].setBorder(BorderFactory.createEmptyBorder(11,10,0,0));
        buttonContainer[6].setBackground(new Color(0,0,0,0));
        buttonPanel.add(buttonContainer[6]);    //adding the menu button into the side menu first
    }


    private void addTabButton(){
        //adding a tab button to a button container and add them one by one to the main side menu panel
        for(int index = 0; index <  buttonContainer.length - 1; index++){

            buttonContainer[index] = new RoundPanel(10);
            buttonContainer[index].setBackground(Color.decode("#3C3C3C"));
            buttonContainer[index].setLayout(new BorderLayout());
            buttonContainer[index].add(tabButtons[index]);
            buttonContainer[index].setBorder(BorderFactory.createEmptyBorder(0,5,0,0));
            buttonPanel.add(buttonContainer[index]);

        }
    }

    private void addFakeButton(){
        //adding fake button for the free space in the side menu panel since the background panel has opaque false
        //the false opaque can let the user click through the panel to the main calculator which is not practical
        for (int index = 0; index < 6; index++) {
            JButton fakeButton = new JButton();
            fakeButton.setBackground(new Color(0,0,0,0));
            fakeButton.setContentAreaFilled(false);
            fakeButton.setBorderPainted(false);
            fakeButton.setFocusPainted(false);
            fakeButton.setEnabled(false);
            buttonPanel.add(fakeButton);
        }
    }


    private void setDefaultActiveTab(int index){

        JPanel parent = (JPanel) tabButtons[index].getParent();
        parent.setBorder(BorderFactory.createMatteBorder(0,5,0,0,Color.decode("#FB5724")));
        parent.setBackground(Color.decode("#505050"));
        tabButtons[index].getComponent(0).setForeground(Color.decode("#FB5724"));
        color = parent.getBackground();
    }

    /**
     * creating the closing functionality to the menuButton and the trans panel for closing the side menu
     * */
    public void setCloseListener(MouseListener mouseListener){
        trans.addMouseListener(mouseListener);
        menuButton.addMouseListener(mouseListener);
    }

    /**
     * setting the navigation listener after a button has been clicked
     * */
    public void setNavigateListener(ActionListener actionListener){
        for (JButton tabButton : tabButtons) {
            tabButton.addActionListener(actionListener);
        }
    }

}
