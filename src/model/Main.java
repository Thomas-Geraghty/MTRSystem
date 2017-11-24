package model;

import controller.MTRController;
import view.TUI;

public class Main {

    public static void main(String[] args) {
        new DataInterpreter(new Reader());
        new TUI(new MTRController());
    }
}
