package modules.standard.controller;

import modules.standard.view.StandardLayoutView;

import javax.swing.JPanel;

/**
 * This is class is controlling the flow between the button model and the button view
 */
public class StandardLayoutControl {

    private StandardLayoutView stdBtnView;          //The button view variable for creating the layout view
    private StandardComponentControl componentControl; //the component control for button creation

    //create the button layout which will arrange the buttons in the correct order done by the layout view class
    public void createLayout(){
        stdBtnView = new StandardLayoutView(componentControl.getComponents().getExtNumButtons(),
                componentControl.getComponents().getExtOpButtons(), componentControl.getComponents().getExtStaticButtons());
        stdBtnView.createButtonsLayout();
    }

    //setter method for component control
    public void setComponentControl(StandardComponentControl componentControl) {
        this.componentControl = componentControl;
    }

    //get the button panel back from the layout view after the creation
    public JPanel getBtnPanel() {
        return stdBtnView.getBtnPanel();
    }

}
