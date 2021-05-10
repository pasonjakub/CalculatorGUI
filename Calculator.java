package graphics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator {

	public static void createAndShowGUI() {
        JFrame jf = new JFrame("Calculator");

        final JTextField tf = new JTextField("0");
        tf.setEditable(false);
        tf.setHorizontalAlignment(SwingConstants.RIGHT);
        jf.getContentPane().add(tf, BorderLayout.NORTH);
        
        
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(4,4));
        jf.getContentPane().add(jp);

        ActionListener myActionListener = new ActionListener() {
        	private int num1 = 0;
        	private int num2 = 0;
        	private boolean isNum = false;
        	private boolean wasEqual = false;
        	private char sign = ' ';
        	private int result = 0;
        	private void calculate()
        	{
        		switch(sign)
        		{
        		case '+':
        			result = num2 + num1;
        			break;
				case '-':
					result = num2 - num1;
					break;
				case '*':
					result = num2 * num1;
					break;
				case '/':
					if(num1 == 0)
        			{
						tf.setText("Invalid operation (division by 0)");
						num1 = 0;
						num2 = 0;
						isNum = false;
						break;
        			}
					result = num2 / num1;
					break;
				default:
					break;
        		}
        		num1 = result;
        	}
        	
        	public void actionPerformed(ActionEvent e) {
        		switch(e.getActionCommand().charAt(0))
        		{
        		case '+':
        			if(isNum)
        			{
        				if(sign == '-' && num2 == 0)
        					num2 -= num1;
        				else if(num2 != 0)
        				{
        					calculate();
        					num2 = num1;
        				}
        				else
        					num2 = num1;
            			num1 = 0;
            			sign = '+';
            			isNum = false;
            			tf.setText(Integer.toString(num2));
        			}
        			else 
        			{
        				sign = '+';
        				wasEqual = false;
        			}
        			break;
        		case '-':
        			if(isNum)
        			{
        				if(sign == '-' && num2 == 0)
        					num2 -= num1;
        				else if(num2 != 0)
        				{
        					calculate();
        					num2 = num1;
        				}
        				else
        					num2 = num1;
	        			num1 = 0;
	        			sign = '-';
	        			isNum = false;
	        			tf.setText(Integer.toString(num2));
	    			}
        			else
        			{
        				sign = '-';
        				wasEqual = false;
        			}
        			break;
        		case '*':
        			if(isNum)
        			{
        				if(sign == '-' && num2 == 0)
        					num2 -= num1;
        				else if(num2 != 0)
        				{
        					calculate();
        					num2 = num1;
        				}
        				else
        					num2 = num1;
            			num1 = 0;
            			sign = '*';
            			isNum = false;
            			tf.setText(Integer.toString(num2));
        			}
        			else
        			{
        				sign = '*';
        				wasEqual = false;
        			}
        			break;
        		case '/':
        			if(isNum)
        			{
        				if(num1 == 0)
        				{
        					tf.setText("Invalid operation (division by 0)");
            				num1 = 0;
            				num2 = 0;
            				isNum = false;
            				break;
        				}
        				if(sign == '-' && num2 == 0)
        					num2 -= num1;
        				else if(num2 != 0)
        				{
        					calculate();
        					num2 = num1;
        				}
        				else
        					num2 = num1;
            			num1 = 0;
            			sign = '/';
            			isNum = false;
            			tf.setText(Integer.toString(num2));
        			}
        			else
        			{
        				sign = '/';
        				wasEqual = false;
        			}
        			break;
        		case '=':
        			switch(sign)
        			{
            		case '+':
            			num2 += num1;
            			break;
    				case '-':
    					num2 -= num1;
    					break;
    				case '*':
    					num2 *= num1;
    					break;
    				case '/':
    					if(num1 == 0)
            			{
    						tf.setText("Invalid operation (division by 0)");
    						num1 = 0;
    						num2 = 0;
    						break;
            			}
    					num2 /= num1;
    					break;
    				default:
    					num2 = num1;
    					break;
        			}
    				tf.setText(Integer.toString(num2));
        			isNum = false;
        			wasEqual = true;
        			break;
        		case 'C':
        			isNum = false;
        			num1 = 0;
        			num2 = 0;
        			sign = ' ';
        			tf.setText("0");
        			break;
        		default:
        			if(!isNum)
        			{
        				if(wasEqual)	
        				{
        					sign = ' ';
        					num1 = 0;
        					num2 = 0;
        					wasEqual = false;
        				}
        				else
        				{
        					num1 = 0;
        				}
        			}
        			isNum = true;
    				num1 = num1*10 + Character.getNumericValue(e.getActionCommand().charAt(0));
    				tf.setText(Integer.toString(num1));
        			break;
        		}
        	}
        };
        
        JButton jb0 = new JButton("0");
        jb0.addActionListener(myActionListener);
        JButton jb1 = new JButton("1");
        jb1.addActionListener(myActionListener);
        JButton jb2 = new JButton("2");
        jb2.addActionListener(myActionListener);
        JButton jb3 = new JButton("3");
        jb3.addActionListener(myActionListener);
        JButton jb4 = new JButton("4");
        jb4.addActionListener(myActionListener);
        JButton jb5 = new JButton("5");
        jb5.addActionListener(myActionListener);
        JButton jb6 = new JButton("6");
        jb6.addActionListener(myActionListener);
        JButton jb7 = new JButton("7");
        jb7.addActionListener(myActionListener);
        JButton jb8 = new JButton("8");
        jb8.addActionListener(myActionListener);
        JButton jb9 = new JButton("9");
        jb9.addActionListener(myActionListener);
        JButton jbPlus = new JButton("+");
        jbPlus.addActionListener(myActionListener);
        JButton jbMinus = new JButton("-");
        jbMinus.addActionListener(myActionListener);
        JButton jbMulti = new JButton("*");
        jbMulti.addActionListener(myActionListener);
        JButton jbDiv = new JButton("/");
        jbDiv.addActionListener(myActionListener);
        JButton jbEqual = new JButton("=");
        jbEqual.addActionListener(myActionListener);
        JButton jbC = new JButton("C");
        jbC.addActionListener(myActionListener);
        
        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        jp.add(jbPlus);
        
        jp.add(jb4);
        jp.add(jb5);
        jp.add(jb6);
        jp.add(jbMinus);
        
        jp.add(jb7);
        jp.add(jb8);
        jp.add(jb9);
        jp.add(jbMulti);
        
        jp.add(jb0);
        jp.add(jbEqual);
        jp.add(jbC);
        jp.add(jbDiv);
        
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
	}

}

