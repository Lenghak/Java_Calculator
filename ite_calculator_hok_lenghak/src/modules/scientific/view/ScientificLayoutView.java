package modules.scientific.view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ScientificLayoutView {

    private final JPanel sciBtnPanel = new JPanel(new GridLayout(5, 8));
    private final JPanel upperBtnPanel = new JPanel();

    private final HashMap<String, JPanel> numExBtn;
    private final HashMap<String, JPanel> opExBtn;
    private final HashMap<String, JPanel> staticExBtn;
    private final HashMap<String, JPanel> sciExBtn;
    private final HashMap<String, JPanel> upperExBtn;

    public ScientificLayoutView(HashMap<String, JPanel> numExBtn, HashMap<String, JPanel> opExBtn,
                                HashMap<String, JPanel> staticExBtn, HashMap<String, JPanel> sciOpExBtn, HashMap<String, JPanel> upperBtn) {
        this.numExBtn = numExBtn;
        this.opExBtn = opExBtn;
        this.staticExBtn = staticExBtn;
        this.sciExBtn = sciOpExBtn;
        this.upperExBtn = upperBtn;

        sciBtnPanel.setOpaque(false);
    }

    public void createBtnLayout() {

        JPanel[] buttons = {sciExBtn.get("Btn_tan"), sciExBtn.get("Btn_sin"), sciExBtn.get("Btn_cos"), sciExBtn.get("Btn_cot"),
                staticExBtn.get("Btn_%"), staticExBtn.get("Btn_AC"), staticExBtn.get("Btn_C"), opExBtn.get("Btn_+"),
                sciExBtn.get("Btn_1/X"), sciExBtn.get("Btn_√"), sciExBtn.get("Btn_^√"), sciExBtn.get("Btn_mod"),
                numExBtn.get("Btn_7"), numExBtn.get("Btn_8"), numExBtn.get("Btn_9"), opExBtn.get("Btn_-"),
                sciExBtn.get("Btn_X!"), sciExBtn.get("Btn_|X|"), sciExBtn.get("Btn_X^"), sciExBtn.get("Btn_X^2"),
                numExBtn.get("Btn_6"), numExBtn.get("Btn_5"), numExBtn.get("Btn_4"), opExBtn.get("Btn_*"),
                sciExBtn.get("Btn_logX"), sciExBtn.get("Btn_lnX"), sciExBtn.get("Btn_10^x"), sciExBtn.get("Btn_e^x"),
                numExBtn.get("Btn_3"), numExBtn.get("Btn_2"), numExBtn.get("Btn_1"), opExBtn.get("Btn_/"),
                sciExBtn.get("Btn_("), sciExBtn.get("Btn_)"),sciExBtn.get("Btn_π"), sciExBtn.get("Btn_e"),
                staticExBtn.get("Btn_+/_"), numExBtn.get("Btn_0"), staticExBtn.get("Btn_."), opExBtn.get("Btn_=")};

        for (int index = 0; index < buttons.length; index++) {
            try {
                sciBtnPanel.add(buttons[index]);
            } catch (NullPointerException e) {
                System.out.println(index);
            }

        }

        sciBtnPanel.repaint();
        sciBtnPanel.validate();

    }

    public void createUpperBtn(){

        JPanel[] buttons = {upperExBtn.get("Btn_2nd"), upperExBtn.get("Btn_Hyp"), upperExBtn.get("Btn_DEG")};

        upperBtnPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        for (JPanel button : buttons) upperBtnPanel.add(button);

        upperBtnPanel.validate();
    }

    public JPanel getBtnPanel() {
        return sciBtnPanel;
    }

    public JPanel getUpperBtnPanel() {
        return upperBtnPanel;
    }
}
