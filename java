package Calculator;

import java.awt.borderLayout;
import java.awt.font;
import java.awt.gridLayout;
import java.awt.image;
import java.awt.label;
import java.awt.toolkit;
import java.awt.*;
import javax.swing.abstractButton;
import javax.swing.jButton;
import javax.swing.jFrame;
import javax.swing.jLabel;
import javax.swing.jPanel;
import javax.swing.jTextField;
import javax.swing.*;

public class Calculator extends jFrame {
   private double op1 = 0;
   private double op2 = 0;
   private String operator;
   
   
   Calculator(){
      this.setTitle("계산기");//제목
      Image picture = Toolkit.getDefaultToolkit().getImage("calculator.gif");
      this.setIconImage(picture);
      this.setBounds(100,100,400,500);
      this.setLayout(new borderLayout());
      JTextField display = new jTextField("0");
      display.setFont(new Font("궁서체", Font.BOLD, 50));
      display.setHorizontalAlignment(jTextField.RIGHT);
      JPanel panel = new jPanel();
      panel.setLayout(new GridLayout(4, 4));
      JLabel status = new jLabel("계산기 입니다.");
      
      
      for (int i = 7; i < 10; i++) {
         JButton btn = new jButton("" + i);
         btn.addActionListener(e-> {
            if(display.getText().equals("0")) {
               display.setText(btn.getText());
            }
            else {
               display.setText(display.getText() + btn.getText());
            }
         });
         panel.add(btn);
      }
      
      JButton btnmultiply = new jButton("×");
      btnmultiply.addActionListener(e->{
         op1 = Double.parseDouble(display.getText());
         display.setText("0");
         operator = "×";
      });
      panel.add(btnmultiply);
      
      for (int i = 4; i < 7; i++) {
          JButton btn = new JButton("" + i);
          btn.addActionListener(e-> {
             if(display.getText().equals("0")) {
                display.setText(btn.getText());
             }
             else {
                display.setText(display.getText() + btn.getText());
             }
          });
          panel.add(btn);
       }
      
      JButton btnPlus = new JButton("+");
      btnPlus.addActionListener(e->{
         op1 = Double.parseDouble(display.getText());
         display.setText("0");
         operator = "+";
         status.setText(String.valueOf(op1 + "+"));
      });
      panel.add(btnPlus);
      
      for (int i = 1; i < 4; i++) {
          JButton btn = new JButton("" + i);
          btn.addActionListener(e-> {
             if(display.getText().equals("0")) {
                display.setText(btn.getText());
             }
             else {
                display.setText(display.getText() + btn.getText());
             }
          });
          panel.add(btn);
       }
      
      JButton btnMinus = new JButton("-");
      btnMinus.addActionListener(e->{
         op1 = Double.parseDouble(display.getText());
         display.setText("0");
         operator = "-";
      });
      panel.add(btnMinus);
     
      JButton btndivison = new JButton("÷");
      btndivison.addActionListener(e->{
         op1 = Double.parseDouble(display.getText());
         display.setText("0");
         operator = "÷";
      });
      panel.add(btndivison);
      
      for (int i = 0; i < 1; i++) {
          JButton btn = new JButton("" + i);
          btn.addActionListener(e-> {
             if(display.getText().equals("0")) {
                display.setText(btn.getText());
             }
             else {
                display.setText(display.getText() + btn.getText());
             }
          });
          panel.add(btn);
      }
      
      
      JButton btnDot = new JButton(".");
      btnDot.addActionListener(e->{
         if(!display.getText().contains(".")) {
            display.setText(display.getText()+ btnDot.getText());
         }
      });
      panel.add(btnDot);
      
      
      
      JButton btnEqual = new JButton("=");
      btnEqual.addActionListener(e->{
         op2 = Double.parseDouble(display.getText());
         double result = calc(op1, op2, operator);
         display.setText(""+ result);
         status.setText(String.valueOf(op1 + operator + op2));
      });
      panel.add(btnEqual);
      this.add(panel);
   
      
      
      this.add(BorderLayout.NORTH, display);
      this.add(BorderLayout.CENTER, panel);
      this.add(BorderLayout.SOUTH, status);
   }
   
   private double calc(double op1, double op2, String operator) {
      double result = 0;
      switch(operator) {
      case "+":
         result = op1 + op2;
         break;
      case "-":
         result = op1 - op2;
         break;
      case "×":
         result = op1 * op2;
         break;
      case "÷":
         result = op1 / op2;
         break;
      }
      return result;
   }
   
   public static void main(String[] args) {
   }

}
