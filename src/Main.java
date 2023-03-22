import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        GUI_Response content = new GUI_Response();
        frame.setContentPane(content.getmyPanel());
        content.get_mn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setExtendedState(frame.getExtendedState()|frame.ICONIFIED);
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);
    }
}
