package home.init;

import home.controller.MainCtrl;

import javax.swing.*;
import java.awt.FontFormatException;
import java.io.IOException;

public class MainWindow{


    public static void main(String[] args) {

        try {

            MainCtrl mainController = new MainCtrl();
            mainController.createCalculator();
            mainController.showMainView();

        } catch (IOException | NullPointerException
                 | ExceptionInInitializerError | FontFormatException e) {
//
//            JOptionPane.showMessageDialog(null,"Internal Error! Unable to use Calculator",
//                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }

}
