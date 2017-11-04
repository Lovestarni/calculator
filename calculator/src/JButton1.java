import javax.swing.*;
import java.awt.*;

public class JButton1 extends JButton {//自定义的buuton1类

    public JButton1(String a) {
        super(a);
        setBackground(new Color(230, 230, 230));
        setSize(95, 70);
        setFont(new Font("等线Light", Font.BOLD, 18));
        setBorderPainted(false);
    }

    public JButton1(Icon icon) {
        super(icon);
        setBackground(new Color(242, 242, 242));
        setBorderPainted(false);
    }

    public JButton1(String text, Icon icon) {
        super(text, icon);
    }

}
