package home.view;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame{

    //topBar menu
    private JPanel topBarPanel;
    //------------------------------------------------------------------------------------------------------

    //standard type calculator
    private final JPanel stdMainPanel = new JPanel();
    private JPanel standardBtnPanel;
    private JPanel standardIOPanel;
    //------------------------------------------------------------------------------------------------------

    //scientific type calculator
    private final JPanel sciMainPanel = new JPanel();
    private JPanel sciBtnPanel;
    private JPanel upperBtnPanel;
    private JPanel sciIOPanel;
    //------------------------------------------------------------------------------------------------------

    //util objects
    private final CardLayout layout = new CardLayout();
    private final GridBagConstraints gbc = new GridBagConstraints();
    //------------------------------------------------------------------------------------------------------

    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    //creating a frame each time the object is instantiated
    public MainView() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(21, 21, 21));
        setLayout(layout);
        validate();

    }
    //------------------------------------------------------------------------------------------------------

    //creating the standard calculator view
    public void createSTDCalView(){
        stdMainPanel.setLayout(new GridBagLayout());
        stdMainPanel.setOpaque(false);

        if(standardBtnPanel != null && standardIOPanel != null && topBarPanel != null) {

            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridy = 5;
            gbc.gridheight = 3;
            gbc.gridwidth = 1;
            gbc.weighty = 0.25;
            stdMainPanel.add(standardIOPanel, gbc);


            gbc.gridy = 8;
            gbc.gridwidth = 1;
            gbc.gridheight = 5;
            gbc.weighty = 0.7;
            stdMainPanel.add(standardBtnPanel, gbc);
            revalidate();

            getContentPane().add("Standard", stdMainPanel);
            layout.first(getContentPane());

        } else System.out.println("\"Some Required Objects are null\".");

        stdMainPanel.setSize(new Dimension ((int) (0.25F * screenSize.width), (int) (0.75F * screenSize.height)));
        stdMainPanel.setMinimumSize(new Dimension(getWidth() + 50, getHeight() + 50));

        repaint();
        revalidate();
    }
    //------------------------------------------------------------------------------------------------------

    public void createSCICalView(){

        sciMainPanel.setLayout(new GridBagLayout());
        sciMainPanel.setOpaque(false);
//
//        gbc.gridy = 6;
//        gbc.gridheight = 4;
//        gbc.gridwidth = 1;
//        gbc.weighty = 0.5;
//        sciMainPanel.add(sciIOPanel, gbc);
//
//        gbc.gridy = 8;
//        gbc.gridwidth = 1;
//        gbc.gridheight = 2;
//        gbc.weighty = 0.15;
//        sciMainPanel.add(upperBtnPanel, gbc);
//
//        gbc.gridy = 13;
//        gbc.gridwidth = 1;
//        gbc.gridheight = 5;
//        gbc.weighty = 0.65;
//        sciMainPanel.add(sciBtnPanel, gbc);

        sciMainPanel.setSize(new Dimension ((int) (0.45F * screenSize.width), (int) (0.75F * screenSize.height)));
        sciMainPanel.setMinimumSize(new Dimension(getWidth() + 50, getHeight() + 50));
        getContentPane().add("Scientific", sciMainPanel);
        repaint();
        revalidate();
    }
    //------------------------------------------------------------------------------------------------------

    //----- standard calculator setting util --------------------------------------------------------------
    public void setStandardBtnPanel(JPanel standardBtnSPanel) {
        this.standardBtnPanel = standardBtnSPanel;
    }

    public void setStandardIOPanel(JPanel standardIOPanel) {
        this.standardIOPanel = standardIOPanel;
    }
    //------------------------------------------------------------------------------------------------------


    public void setSciBtnPanel(JPanel sciBtnPanel) {
        this.sciBtnPanel = sciBtnPanel;
    }

    public void setSciIOPanel(JPanel sciIOPanel) {
        this.sciIOPanel = sciIOPanel;
    }

    public void setUpperBtnPanel(JPanel upperBtnPanel) {
        this.upperBtnPanel = upperBtnPanel;
    }

    public void setTopBarPanel(JPanel topBarPanel) {
        this.topBarPanel = topBarPanel;
    }

    public void showCal(@NotNull String name){

        layout.show(getContentPane(), name);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0;


        switch (name) {

            case "Standard" -> {
                setMinimumSize(new Dimension((int) (0.25F * screenSize.width), (int) (0.75F * screenSize.height)));
                stdMainPanel.add(topBarPanel, gbc);
            }
            case "Scientific" -> {
                setMinimumSize(new Dimension((int) (0.45F * screenSize.width), (int) (0.75F * screenSize.height)));
                sciMainPanel.add(topBarPanel, gbc);
            }
        }

        setTitle(name + " Calculator");
        setSize(getMinimumSize());
        repaint();
        revalidate();


    }

    public void showView(){
        setVisible(true);
    }



    //------------------------------------------------------------------------------------------------------
}
