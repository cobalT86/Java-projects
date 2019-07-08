package timerapplication;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class TimerApplication {

    static TimerView view;

    public static void main(String args[]) throws IOException, AWTException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TimerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            if (SystemTray.isSupported()) {
                try {
                    SystemTray st = SystemTray.getSystemTray();
                    TrayIcon trayIcon = new TrayIcon(ImageIO.read(new File("icons8-wii-24.png")));
                    
                    PopupMenu popupMenu = new PopupMenu();
                    MenuItem start = new MenuItem();
                    start.setLabel("Start");
                    start.addActionListener((e) -> {
                        view = new TimerView();
                        view.setVisible(true);
                    });
                    popupMenu.add(start);
                    
                    MenuItem exit = new MenuItem();
                    exit.setLabel("Exit");
                    exit.addActionListener((e) -> {
                        System.exit(0);
                    });
                    
                    popupMenu.add(start);
                    popupMenu.add(exit);
                    
                    trayIcon.setPopupMenu(popupMenu);
                    st.add(trayIcon);
                } catch (AWTException ex) {
                    Logger.getLogger(TimerApplication.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(TimerApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                view = new TimerView();
                view.setVisible(true);
            }
        });
    }
}
