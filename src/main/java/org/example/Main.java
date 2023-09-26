package org.example;

import org.example.View.ConsoleView;
import org.example.Controller.CreditCalculatorController;
public class Main {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        CreditCalculatorController controller = new CreditCalculatorController(view);
        controller.start();
    }
}