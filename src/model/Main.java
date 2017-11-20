package model;

import controller.MTRController;

public class Main {

    public static void main(String[] args) {
        DataInterpreter interpreter = new DataInterpreter();
        MTRController controller = new MTRController();
        System.out.println(controller.listAllTermini());
    }
}
