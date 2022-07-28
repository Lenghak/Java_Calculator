package components.sideDrawer.controller;

import components.sideDrawer.view.SideMenuView;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class SideMenuControl {

    private SideMenuView sideMenuView;

    public SideMenuView getSideMenuView() {
        return sideMenuView;
    }

    public void setSideMenuView(SideMenuView sideMenuView) {
        this.sideMenuView = sideMenuView;
    }

    public void setCloseListener(MouseListener mouseListener){
        sideMenuView.setCloseListener(mouseListener);
    }

    public void setNavigateListener(ActionListener listener) {
        sideMenuView.setNavigateListener(listener);
    }

}
