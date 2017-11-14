package org.thoughtworks.sg;

import org.thoughtworks.sg.controller.AbstractCommand;
import org.thoughtworks.sg.controller.CommandFactory;
import org.thoughtworks.sg.models.canvas.Canvas;
import org.thoughtworks.sg.exceptions.CommandValidationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Canvas canvas = null;
        boolean isRunning = true;
        System.out.println("*** Welcome to Sample Canvas! ***");
        while (isRunning) {
            System.out.println("Enter the command: ");
            String[] rawCommand = scanner.nextLine().split(" ");
            List<String> parameters = new ArrayList<>(Arrays.asList(rawCommand));

            String commandType = null;
            if (!parameters.isEmpty()) {
                commandType = parameters.remove(0);
            }

            try {
                AbstractCommand command = CommandFactory.getCommand(commandType);
                canvas = command.execute(canvas, parameters);
            } catch (CommandValidationException e) {
                if (e.getMessage().equals("QUIT")) {
                    isRunning = false;
                } else {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}
