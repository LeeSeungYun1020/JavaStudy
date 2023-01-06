package io;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class IOEx4 {
    public static void main(String[] args) {
        InputThread inputThread = new InputThread("InputThread");
        OutputThread outputThread = new OutputThread("OutputThread");

        inputThread.connect(outputThread.getOutput());

        inputThread.start();
        outputThread.start();
    }
}

class InputThread extends Thread {
    private final PipedReader input = new PipedReader();
    private final StringWriter sw = new StringWriter();

    InputThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        try {
            int data = 0;
            while ((data = input.read()) != -1) {
                sw.write(data);
            }
            String msg = sw.toString();
            System.out.println(getName() + " received: " + sw.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedReader getInput() {
        return input;
    }

    public void connect(PipedWriter output) {
        try {
            input.connect(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class OutputThread extends Thread {
    private final PipedWriter output = new PipedWriter();

    OutputThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String msg = scanner.nextLine();
                if ("exit".equalsIgnoreCase(msg))
                    break;
                output.write(msg);
                output.flush();
                System.out.println(getName() + " sent: " + msg);
                Thread.sleep(1000);
            }
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PipedWriter getOutput() {
        return output;
    }

    public void connect(PipedReader input) {
        try {
            output.connect(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}