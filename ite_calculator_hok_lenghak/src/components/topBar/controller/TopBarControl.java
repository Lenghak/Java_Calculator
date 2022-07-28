package components.topBar.controller;

import components.topBar.view.TopBarView;

import javax.swing.*;
import java.awt.event.ActionListener;

public class TopBarControl{

    private final TopBarView topBarView = new TopBarView();

    public JPanel getTopBarView() {
        return topBarView.getTopBarPanel();
    }

    public void setHeader(String header){
        topBarView.setHeader(header);
    }

    public void setOpenDrawerListener(ActionListener listener){
        topBarView.getMenuButton().addActionListener(listener);
    }
}
