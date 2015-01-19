package application;

import control.Command;
import control.NextImageOperation;
import control.PrevImageOperation;
import model.Image;
import view.persistence.FileImageLoader;
import view.swing.SwingFrame;
import view.ui.ImageDisplay;

public class SwingApp {

    public static void main(String[] args) {
        new SwingApp().start(args[0]);
    }

    private void start(String filename) {
        Image image = new FileImageLoader(filename).load();
        SwingFrame frame = new SwingFrame();
        frame.getDisplay().setImage(image);
        frame.register(createOperations(frame.getDisplay()));
        frame.start();       
    }

    private Command[] createOperations(final ImageDisplay display) {
        Command[] commands = new Command[2];
        commands[SwingFrame.NEXT] = new NextImageOperation(display);
        commands[SwingFrame.PREV] = new PrevImageOperation(display);
        return commands;
    }
    
}
