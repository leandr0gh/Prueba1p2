
package prueba1p2;

import javax.swing.SwingUtilities;

/**
 *
 * @author Leandro
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        
        MainWindow window = new MainWindow();
        window.setVisible(true);
        });
        
    }
}
