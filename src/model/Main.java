package model;

import controller.MTRController;
import view.TUI;

public class Main {

    public static void main(String[] args) {
       DataInterpreter interpreter = new DataInterpreter();
        MTRController controller = new MTRController();
        TUI tui = new TUI(controller);
        MTR.getInstance().getGraph().BFS(MTR.getInstance().getStations().get("Kowloon"), MTR.getInstance().getStations().get("Central"));
    }
}
