import javax.swing.*;
import java.awt.*;

public class JButton2 extends JButton {//自定义的jbutton2类

    public JButton2(String a) {
        super(a);
        setBackground(new Color(250, 250, 250));
        setSize(95, 70);
        setFont(new Font("等线Light", Font.BOLD, 18));
        setBorderPainted(false);
    }

    public JButton2(Icon icon) {
        super(icon);
    }

    public JButton2(String text, Icon icon) {
        super(text, icon);
    }

}
