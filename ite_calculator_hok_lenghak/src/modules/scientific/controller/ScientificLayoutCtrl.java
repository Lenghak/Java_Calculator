package modules.scientific.controller;

import modules.scientific.view.ScientificLayoutView;

import javax.swing.*;
import java.util.HashMap;

public class ScientificLayoutCtrl {

    private final ScientificLayoutView sciLayoutView;

    public ScientificLayoutCtrl(HashMap<String, JPanel> numExBtn, HashMap<String, JPanel> opExBtn,
                                HashMap<String, JPanel> staticExBtn, HashMap<String, JPanel> sciOpExBtn, HashMap<String, JPanel> upperExBtn){
        sciLayoutView = new ScientificLayoutView(numExBtn, opExBtn, staticExBtn, sciOpExBtn, upperExBtn);
        sciLayoutView.createBtnLayout();
        sciLayoutView.createUpperBtn();
    }

    public JPanel getBtnPanel(){
        return sciLayoutView.getBtnPanel();
    }

    public JPanel getUppBtnPanel(){
        return sciLayoutView.getUpperBtnPanel();
    }

}
