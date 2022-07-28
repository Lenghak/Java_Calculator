package home.controller;

import home.view.MainView;
import modules.scientific.controller.ScientificIOControl;
import modules.scientific.controller.ScientificLayoutCtrl;
import modules.standard.controller.StandardComponentControl;
import modules.standard.controller.StandardIOControl;
import modules.standard.controller.StandardLayoutControl;
import org.jetbrains.annotations.NotNull;
import components.sideDrawer.controller.SideMenuControl;
import components.sideDrawer.view.SideMenuView;
import components.topBar.controller.TopBarControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class MainCtrl implements ActionListener, MouseListener {

    //static utilities
    private final MainView mainView = new MainView();
    private final TopBarControl topBarCtrl = new TopBarControl();

    //standard calculator utilities
    private final StandardIOControl standardIOCtrl = new StandardIOControl();
    private final ScientificIOControl scientificIOCtrl = new ScientificIOControl();

    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


    /**
     * Constructor for creation of the side menu and the topBar
     */
    public MainCtrl() throws IOException, FontFormatException {

        //add the side drawer to the calculator
        SideMenuControl sideMenuCtrl = new SideMenuControl();
        sideMenuCtrl.setSideMenuView(new SideMenuView());
        sideMenuCtrl.setCloseListener(this);
        sideMenuCtrl.setNavigateListener(this);

        topBarCtrl.setOpenDrawerListener(this);



        //set the icon of the main view
        mainView.setIconImage(new ImageIcon("static/image/logo.png").getImage());
        mainView.setGlassPane(sideMenuCtrl.getSideMenuView());  //set the drawerSide as the glassPane
        mainView.setTopBarPanel(topBarCtrl.getTopBarView());    //set the topBar to the calculator
    }

    /**
     * show the main view which is the standard calculator
     */
    public void showMainView() {
        mainView.showView();
        mainView.showCal("Standard");
    }

    public void createCalculator() {

        createStandardCal();
        createScientificCal();

    }

    /**
     * show the standard calculator to the user
     */
    public void createStandardCal() {

        topBarCtrl.setHeader("Standard");     //the header of the top bar needs to be set
        standardIOCtrl.createView();
        standardIOCtrl.setComponentListener();

        //create the working buttons for standard calculator
        StandardComponentControl componentControl = new StandardComponentControl();
        componentControl.createNumButton();
        componentControl.createOpButtons();
        componentControl.createStaticButton();
        componentControl.setActionListener(componentControl.getComponents().getAllButtons(), standardIOCtrl);
        componentControl.setMouseListener(componentControl.getComponents().getAllButtons(), standardIOCtrl);
        componentControl.setResizeListener(componentControl.getComponents().getOpButton("Btn_="), componentControl);
        componentControl.setKeyAction(standardIOCtrl.getIOPanel());

        //creating buttons layout view for orientation
        StandardLayoutControl layoutCtrl = new StandardLayoutControl();
        layoutCtrl.setComponentControl(componentControl);
        layoutCtrl.createLayout();

        standardIOCtrl.setDisableButton(componentControl.getComponents().getExtOpButtons());

        mainView.setStandardBtnPanel(layoutCtrl.getBtnPanel());
        mainView.setStandardIOPanel(standardIOCtrl.getIOPanel());

        mainView.createSTDCalView();
        mainView.pack();
        mainView.repaint();
        mainView.revalidate();
    }

    public void createScientificCal() {



//        ScientificLayoutCtrl scientificLayoutCtrl = new ScientificLayoutCtrl();

//        mainView.setSciIOPanel(scientificIOCtrl.getIOPanel());
//        mainView.setSciBtnPanel();
        mainView.createSCICalView();
        mainView.repaint();
        mainView.revalidate();
        mainView.pack();
    }

    public void programmingCal() {
    }

    public void showAngleCal() {
    }

    public void showCurrencyCal() {
    }

    public void showDataCal() {
    }


    public void showDrawer(boolean flag) {
        mainView.getGlassPane().setVisible(flag);
    }


    //signal sent from the topBar menu button
    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (!(button.getName() == null))
            showDrawer(true);
        else {

            String text = ((JLabel) button.getComponent(0)).getText();

            topBarCtrl.setHeader(text);
            mainView.showCal(text);


            Timer timer = new Timer(1, e1 -> showDrawer(false));

            timer.start();
            timer.setRepeats(false);

        }

    }

    //signal sent from the opened glass pane
    @Override
    public void mouseClicked(@NotNull MouseEvent e) {
        mainView.getGlassPane().setVisible(!mainView.getGlassPane().isVisible());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
