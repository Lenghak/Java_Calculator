package modules.standard.view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class StandardLayoutView {

//    private final GridBagConstraints gbc = new GridBagConstraints();    //constraint layout

    private final JPanel stdPanel = new JPanel(new GridLayout(5,4));

    private final HashMap<String, JPanel> numExBtn;
    private final HashMap<String, JPanel> opExBtn;
    private final HashMap<String, JPanel> staticExBtn;

    //create the standard buttons views
    public StandardLayoutView(HashMap<String, JPanel> numExBtn, HashMap<String, JPanel> opExBtn, HashMap<String, JPanel> staticExBtn){
        this.numExBtn = numExBtn;
        this.opExBtn = opExBtn;
        this.staticExBtn = staticExBtn;

        stdPanel.setOpaque(false);
    }

    public void createButtonsLayout(){

        JPanel[] buttons = {staticExBtn.get("Btn_%"), staticExBtn.get("Btn_AC"), staticExBtn.get("Btn_C"), opExBtn.get("Btn_+")
                        ,   numExBtn.get("Btn_7"), numExBtn.get("Btn_8"), numExBtn.get("Btn_9"),  opExBtn.get("Btn_-")
                        ,   numExBtn.get("Btn_4"), numExBtn.get("Btn_5"), numExBtn.get("Btn_6"), opExBtn.get("Btn_*")
                        ,   numExBtn.get("Btn_1"), numExBtn.get("Btn_2"), numExBtn.get("Btn_3"), opExBtn.get("Btn_/")
                        ,   staticExBtn.get("Btn_+/_"), numExBtn.get("Btn_0"), staticExBtn.get("Btn_."), opExBtn.get("Btn_=")};


        //adding the button to the panel

        for (int index = 0; index < 20; index++){
            try {
                stdPanel.add(buttons[index]);

            } catch (Exception e) {
                System.out.println("A button is null [@index] : " + index);
                break;
            }
        }

        stdPanel.repaint();
        stdPanel.revalidate();
    }



    public JPanel getBtnPanel(){
        return stdPanel;
    }


}
