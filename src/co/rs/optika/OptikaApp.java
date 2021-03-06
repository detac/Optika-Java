package co.rs.optika;

import co.rs.optika.gui.frame.FullScreenFrame;
import co.rs.optika.gui.menu.MenuBar;
import co.rs.optika.gui.panel.LayeredPane;
import co.rs.optika.gui.util.GUIUtil;
import co.rs.optika.util.SpringUtil;
import org.springframework.beans.BeanInfoFactory;

import javax.swing.*;

public class OptikaApp {

    private LayeredPane content;
    private MenuBar menu;
    private FullScreenFrame frame;

    public OptikaApp() {
        try {
            GUIUtil.setNimbusLookAndFeel();

            frame = new FullScreenFrame("Optika");
            content = SpringUtil.getBean("layeredPane", LayeredPane.class);
            menu = new MenuBar(content);

            frame.setJMenuBar(menu);
            frame.setContentPane(content);
            frame.setVisible(true);
            BeanInfoFactory bi;
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OptikaApp();
            }
        });
    }

}
