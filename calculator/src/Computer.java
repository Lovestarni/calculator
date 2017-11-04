import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.File;

enum Oper {plus, sub, mul, div, equ}

class MyExtendsJFrame extends JFrame implements ActionListener,KeyListener {
    JTextField text, text0;//创建文本框对象
    JButton1 button_sqrt, button_squre, button_percent, button_reciprocal, button_oppisite;
    JButton1 button_BackSpace, button_CE, button_C;
    JButton2 button_number1, button_number2, button_number3, button_number4, button_number5, button_number6, button_number7, button_number8, button_number9, button_number0, button_number10;
    JButton1 button_add, button_equ, button_sub, button_mul, button_div;
    Double CurrentNumber;
    Oper oper1 = Oper.equ;
    int m = 0;//小数点个数
    testF t = new testF();//用来释放异常
    int flags = 0;
    int flags1 = 0;
    int flags2 = 0;


    public MyExtendsJFrame() {
        setTitle("计算器");
        setBounds(350, 250, 408, 700);
        getContentPane().setBackground(new Color(63, 63, 63));
        setLayout(null);
        init();   //添plus控件的操作封装成一个函数
        setVisible(true);//放在添plus组件后面执行
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void init() {//添plus的控件
        //菜单栏部分

        JMenuBar menubar = new JMenuBar();
        JMenu menu1 = new JMenu1("Mode");
        JMenuItem menuitem11 = new JMenuItem1("Standord");
        JMenuItem menuitem12 = new JMenuItem1("Science");
        JMenuItem menuitem13 = new JMenuItem1("Program");

        JMenu menu2 = new JMenu1("Edit");
        JMenuItem menuitem21 = new JMenuItem1("Copy");
        JMenuItem menuitem22 = new JMenuItem1("Paste");
        JMenuItem menuitem23 = new JMenuItem1("History");

        JMenu menu3 = new JMenu1("Help");
        JMenu menu31 = new JMenu1("Content");
        JMenuItem menuitem311 = new JMenuItem1("Contact");
        JMenuItem menuitem312 = new JMenuItem1("Address");

        JMenuItem menuitem32 = new JMenuItem1("About");

        setJMenuBar(menubar);
        menubar.add(menu1);
        menu1.add(menuitem11);
        menu1.add(menuitem12);
        menu1.add(menuitem13);

        menubar.add(menu2);
        menu2.add(menuitem21);
        menu2.add(menuitem22);
        menu2.addSeparator();
        menu2.add(menuitem23);

        menubar.add(menu3);
        menu3.add(menu31);
        menu31.add(menuitem311);
        menu31.add(menuitem312);
        menu3.addSeparator();
        menu3.add(menuitem32);
//文本框部分
        text0 = new JTextField(20);
        text0.setBounds(5, 5, 380, 105);//设置大小和位置
        text0.setBackground(new Color(242, 242, 242));
        text0.setFont(new Font("等线Light", Font.BOLD, 30));
        text0.setBorder(null);
        text0.setEditable(false);
        add(text0);//添plus到窗口,



        text = new JTextField(20);
        text.setBounds(5, 105, 380, 100);//设置大小和位置
        text.setBackground(new Color(242, 242, 242));
        text.setFont(new Font("等线Light", Font.BOLD, 30));
        text.setBorder(null);
        text.setHorizontalAlignment(JTextField.RIGHT);
        text.setText("");
        text.setEditable(false);
        text.addKeyListener(this);
        add(text);//添plus到窗口,

//按钮部分

        button_sqrt = new JButton1("√");
        button_sqrt.setBounds(5, 205, 95, 70);
        button_sqrt.setBackground(new Color(242, 242, 242));
        add(button_sqrt);
        button_sqrt.addActionListener(this);

        button_squre = new JButton1(new ImageIcon(getClass().getClassLoader().getResource("x_2.png")));
        button_squre.setBounds(100, 205, 95, 70);
        add(button_squre);
        button_squre.addActionListener(this);


        button_reciprocal = new JButton1(new ImageIcon(getClass().getClassLoader().getResource("1_x.png")));
        button_reciprocal.setBounds(195, 205, 95, 70);
        add(button_reciprocal);
        button_reciprocal.addActionListener(this);

        button_percent = new JButton1("%");
        button_percent.setBounds(290, 205, 95, 70);
        button_percent.setBackground(new Color(242, 242, 242));
        add(button_percent);
        button_percent.addActionListener(this);

        button_CE = new JButton1("CE");
        button_CE.setBounds(5, 275, 95, 70);
        add(button_CE);
        button_CE.addActionListener(this);

        button_C = new JButton1("C");
        button_C.setBounds(100, 275, 95, 70);
        add(button_C);
        button_C.addActionListener(this);

        button_BackSpace = new JButton1(new ImageIcon(getClass().getClassLoader().getResource("backspace.png")));
        button_BackSpace.setBackground(new Color(230, 230, 230));
        button_BackSpace.setBounds(195, 275, 95, 70);
        add(button_BackSpace);
        button_BackSpace.addActionListener(this);

        button_div = new JButton1("/");
        button_div.setBounds(290, 275, 95, 70);
        add(button_div);
        button_div.addActionListener(this);


        button_number1 = new JButton2("1");
        button_number1.setBounds(5, 345, 95, 70);
        add(button_number1);
        button_number1.addActionListener(this);//添plus关联

        button_number2 = new JButton2("2");
        button_number2.setBounds(100, 345, 95, 70);
        add(button_number2);
        button_number2.addActionListener(this);//添plus关联


        button_number3 = new JButton2("3");
        button_number3.setBounds(195, 345, 95, 70);
        add(button_number3);
        button_number3.addActionListener(this);

        button_mul = new JButton1("*");
        button_mul.setBounds(290, 345, 95, 70);
        add(button_mul);
        button_mul.addActionListener(this);


        button_number4 = new JButton2("4");
        button_number4.setBounds(5, 415, 95, 70);
        add(button_number4);
        button_number4.addActionListener(this);

        button_number5 = new JButton2("5");
        button_number5.setBounds(100, 415, 95, 70);
        add(button_number5);
        button_number5.addActionListener(this);

        button_number6 = new JButton2("6");
        button_number6.setBounds(195, 415, 95, 70);
        add(button_number6);
        button_number6.addActionListener(this);

        button_sub = new JButton1("-");
        button_sub.setBounds(290, 415, 95, 70);
        add(button_sub);
        button_sub.addActionListener(this);

        button_number7 = new JButton2("7");
        button_number7.setBounds(5, 485, 95, 70);
        add(button_number7);
        button_number7.addActionListener(this);

        button_number8 = new JButton2("8");
        button_number8.setBounds(100, 485, 95, 70);
        add(button_number8);
        button_number8.addActionListener(this);

        button_number9 = new JButton2("9");
        button_number9.setBounds(195, 485, 95, 70);
        add(button_number9);
        button_number9.addActionListener(this);

        button_add = new JButton1("+");
        button_add.setBounds(290, 485, 95, 70);
        add(button_add);
        button_add.addActionListener(this);//添plus关联

        button_oppisite = new JButton1("±");
        button_oppisite.setBounds(5, 555, 95, 70);
        add(button_oppisite);
        button_oppisite.addActionListener(this);

        button_number0 = new JButton2("0");
        button_number0.setBounds(100, 555, 95, 70);
        add(button_number0);
        button_number0.addActionListener(this);

        button_number10 = new JButton2(".");
        button_number10.setBounds(195, 555, 95, 70);
        add(button_number10);
        button_number10.addActionListener(this);

        button_equ = new JButton1("=");
        button_equ.setBounds(290, 555, 95, 70);
        add(button_equ);
        button_equ.addActionListener(this);//添plus关联

    }


    public void actionPerformed(ActionEvent e) {

        if(flags1 == 1){//判断是否是从清屏为了下次输入
            text.setText("");
            flags1 = 0;
            System.out.println(2);
        }
        

        if (e.getSource() == button_number10) {

            try {
                text.setText(text.getText() + '.');
                m++;
                t.point(m);
            } catch (pointException e1) {
                text.setText(e1.getMessage());
            }
        }

        if (e.getSource() == button_squre) {
            Double t1 = Double.parseDouble(text.getText());
            text.setText(String.valueOf(t1 * t1));
        }

        if (e.getSource() == button_reciprocal) {
            try {
                Double t1 = Double.parseDouble(text.getText());
                t.zero(t1);
                text.setText(String.valueOf(1 / t1));
            } catch (zeroException e1) {
                text.setText(e1.getMessage());
            }
        }

        if (e.getSource() == button_sqrt) {
            Double t1 = Double.parseDouble(text.getText());
            text.setText(String.valueOf(Math.sqrt(t1)));
        }

        if (e.getSource() == button_percent) {
            Double t1 = Double.parseDouble(text.getText());
            text.setText(String.valueOf(t1 / 100));
        }

        if (e.getSource() == button_oppisite) {
            Double t1 = Double.parseDouble(text.getText());
            text.setText(String.valueOf(t1 * -1));
        }


        if (e.getSource() == button_add) {
            text0.setText(text0.getText() + Double.parseDouble(text.getText()) +"+");
            if(flags == 1){
                flags2 = 1;
                button_equ.doClick();
            }
            else {
                CurrentNumber = Double.parseDouble(text.getText());
                flags = 1;
                flags1 = 1;
            }
            oper1 = Oper.plus;
//            text0.setText(text0.getText() + Double.parseDouble(text.getText()) +"+");
        }
        if (e.getSource() == button_sub) {
            text0.setText(text0.getText() + Double.parseDouble(text.getText()) +"-");
            if(flags == 1){
                flags2 = 1;
                button_equ.doClick();
            }
            else {
                CurrentNumber = Double.parseDouble(text.getText());
                flags = 1;
                flags1 = 1;
            }
            oper1 = Oper.sub;
        }
        if (e.getSource() == button_mul) {
            text0.setText(text0.getText() + Double.parseDouble(text.getText()) +"*");
            if(flags == 1){
                flags2 = 1;
                button_equ.doClick();
            }
            else {
                CurrentNumber = Double.parseDouble(text.getText());
                flags = 1;
                flags1 = 1;
            }
            oper1 = Oper.mul;
        }
        if (e.getSource() == button_div) {
            text0.setText(text0.getText() + Double.parseDouble(text.getText()) +"/");
            if(flags == 1){
                flags2 = 1;
                button_equ.doClick();
            }
            else {
                CurrentNumber = Double.parseDouble(text.getText());
                flags = 1;
                flags1 = 1;
            }
            oper1 = Oper.div;
        }
        if (e.getSource() == button_BackSpace) {//退格键
            String temp = text.getText();
            int i = temp.length();
            if (i > 0) {
                if (temp.charAt(i - 1) == '.') m--;
                temp = temp.substring(0, i - 1);
                text.setText(temp);
            }
        }
        if (e.getSource() == button_CE) {
            text.setText("");
            m = 0;
        }
        if (e.getSource() == button_C) {
            CurrentNumber = 0.0;
            text.setText("");
            text0.setText("");
            flags = 0;
            flags1 = 0;
            flags2 = 0;
            CurrentNumber = 0.0;
            m = 0;
            oper1 = Oper.equ;
        }






        if (e.getSource() == button_number1) {
            text.setText(text.getText() + "1");
        }
        if (e.getSource() == button_number2) {
            text.setText(text.getText() + "2");
        }
        if (e.getSource() == button_number3) {
            text.setText(text.getText() + "3");
        }
        if (e.getSource() == button_number4) {
            text.setText(text.getText() + "4");
        }
        if (e.getSource() == button_number5) {
            text.setText(text.getText() + "5");
        }
        if (e.getSource() == button_number6) {
            text.setText(text.getText() + "6");
        }
        if (e.getSource() == button_number7) {
            text.setText(text.getText() + "7");
        }
        if (e.getSource() == button_number8) {
            text.setText(text.getText() + "8");
        }
        if (e.getSource() == button_number9) {
            text.setText(text.getText() + "9");
        }
        if (e.getSource() == button_number0) {
            text.setText(text.getText() + "0");
        }

        if (e.getSource() == button_equ) {
            switch (oper1) {
                case plus:
//                    System.out.println(number);
//                    System.out.println(CurrentNumber);
                    CurrentNumber = CurrentNumber + Double.parseDouble(text.getText());
                    if(flags2 == 1){
                        flags1 = 1;
                        text.setText(String.valueOf(CurrentNumber));
                        flags2 = 0;
                    }
                    else{
                        text0.setText("");
                        text.setText(String.valueOf(CurrentNumber));
                        flags1 = 0;
                        flags = 0;
//                        button_backspce.doClick();
                    }
                    break;
                case sub:
                    CurrentNumber = CurrentNumber - Double.parseDouble(text.getText());
                    if(flags2 == 1){
                        flags1 = 1;
                        text.setText(String.valueOf(CurrentNumber));
                        flags2 = 0;
                    }
                    else{
                        text0.setText("");
                        text.setText(String.valueOf(CurrentNumber));
                        flags1 = 0;
                        flags = 0;
//                        button_backspce.doClick();
                    }
                    break;
                case mul:
                    CurrentNumber = CurrentNumber * Double.parseDouble(text.getText());
                    if(flags2 == 1){
                        flags1 = 1;
                        text.setText(String.valueOf(CurrentNumber));
                        flags2 = 0;
                    }
                    else{
                        text0.setText("");
                        text.setText(String.valueOf(CurrentNumber));
                        flags1 = 0;
                        flags = 0;
//                        button_backspce.doClick();
                    }
                    break;
                case div:
                    try {
                        t.zero(Double.parseDouble(text.getText()));
                        CurrentNumber = CurrentNumber / Double.parseDouble(text.getText());
                        if(flags2 == 1){
                            flags1 = 1;
                            text.setText(String.valueOf(CurrentNumber));
                            flags2 = 0;
                        }
                        else{
                            text0.setText("");
                            text.setText(String.valueOf(CurrentNumber));
                            flags1 = 0;
                            flags = 0;
//                        button_backspce.doClick();
                        }
                        break;
                    } catch (zeroException e1) {
                        text.setText(e1.getMessage());
                    }
                case equ:
                    break;
                default:
                    break;
            }
            if (text0.getText().equals(null)) {
                System.out.println(text0.getText());
                text0.setText(text0.getText() + CurrentNumber);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_NUMPAD1)
            button_number1.doClick();
        if(e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_NUMPAD2)
            button_number2.doClick();
        if(e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_NUMPAD3)
            button_number3.doClick();
        if(e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_NUMPAD4)
            button_number4.doClick();
        if(e.getKeyCode() == KeyEvent.VK_5 || e.getKeyCode() == KeyEvent.VK_NUMPAD5)
            button_number5.doClick();
        if(e.getKeyCode() == KeyEvent.VK_6 || e.getKeyCode() == KeyEvent.VK_NUMPAD6)
            button_number6.doClick();
        if(e.getKeyCode() == KeyEvent.VK_7 || e.getKeyCode() == KeyEvent.VK_NUMPAD7)
            button_number7.doClick();
        if(e.getKeyCode() == KeyEvent.VK_8 || e.getKeyCode() == KeyEvent.VK_NUMPAD8)
            button_number8.doClick();
        if(e.getKeyCode() == KeyEvent.VK_9 || e.getKeyCode() == KeyEvent.VK_NUMPAD9)
            button_number9.doClick();
        if(e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_NUMPAD0)
            button_number0.doClick();
        if(e.getKeyCode() == KeyEvent.VK_PERIOD || e.getKeyCode() == KeyEvent.VK_DECIMAL)
            button_number10.doClick();
        if(e.getKeyCode() == KeyEvent.VK_ADD)
            button_add.doClick();
        if(e.getKeyCode() == KeyEvent.VK_SUBTRACT)
            button_sub.doClick();
        if(e.getKeyCode() == KeyEvent.VK_DIVIDE)
            button_div.doClick();
        if(e.getKeyCode() == KeyEvent.VK_MULTIPLY)
            button_mul.doClick();
        if(e.getKeyCode() == KeyEvent.VK_EQUALS || e.getKeyCode() == 10)
            button_equ.doClick();
        if(e.getKeyCode() == KeyEvent.VK_C)
            button_C.doClick();
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
            button_BackSpace.doClick();
        if(e.getKeyCode() == KeyEvent.VK_E)
            button_CE.doClick();
//        System.out.println(e.getKeyCode());//测试输出键值
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}

class Computer {
    public static void main(String args[]) {
        MyExtendsJFrame frame = new MyExtendsJFrame();
    }
}
