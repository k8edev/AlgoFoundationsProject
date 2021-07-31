package project;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import project.Function;
import project.Fibonnaci;
import project.GUIFactorial;

import javax.swing.*;


public class GUI {

	static List<Function> listOfFunctions; 
	
	public static void runGUI() throws InvocationTargetException {
		JFrame frame = new JFrame("Recursive vs Iterative Runtime");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(700,500);
	    
	    Color color = Color.LIGHT_GRAY; 
	    JPanel mainPanel = new JPanel();
	    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	    JPanel inputPanel = new JPanel();
	    JPanel buttonPanel = new JPanel();
	    JPanel outputPanel = new JPanel();
	    JPanel iterTimePanel = new JPanel();
	    JPanel recurTimePanel = new JPanel();
	    
	    mainPanel.setBackground(color);
	    inputPanel.setBackground(color);
	    buttonPanel.setBackground(color);
	    outputPanel.setBackground(color);
	    iterTimePanel.setBackground(color);
	    recurTimePanel.setBackground(color);
	    
	    JTextField input = new JTextField(32);
	    input.setText("1");
	    JTextField inputLabel = new JTextField("User Input");
	    inputLabel.setEditable(false);
	    inputPanel.add(input,BorderLayout.WEST);
	    inputPanel.add(inputLabel,BorderLayout.CENTER);
	    
	    JTextField outputAns = new JTextField(32);
	    JTextField outputLabel = new JTextField("Solution");
	    outputLabel.setEditable(false);
	    outputAns.setEditable(false);
	    outputPanel.add(outputAns,BorderLayout.WEST);
	    outputPanel.add(outputLabel,BorderLayout.CENTER);
	    
	    JTextField iterTime = new JTextField(32);
	    JTextField iterTimeLabel = new JTextField("Time of Iterative Algorithm (ns)");
	    iterTime.setEditable(false);
	    iterTimeLabel.setEditable(false);
	    iterTimePanel.add(iterTime,BorderLayout.WEST);
	    iterTimePanel.add(iterTimeLabel,BorderLayout.CENTER);
	    
	    JTextField recurTime = new JTextField(32);
	    JTextField recurTimeLabel = new JTextField("Time of Recursive Algorithm (ns)");
	    recurTime.setEditable(false);
	    recurTimeLabel.setEditable(false);
	    recurTimePanel.add(recurTime,BorderLayout.WEST);
	    recurTimePanel.add(recurTimeLabel,BorderLayout.CENTER);
	   
	    
	    for (Function i : listOfFunctions) {
	    	JButton button = new JButton(i.getName());
	    	button.addActionListener(new ActionListener(){  
	    		public void actionPerformed(ActionEvent e){  
	    			int inputVal = 0;
	                boolean skip = false; 
	                try {
	                	inputVal = Integer.parseInt(input.getText());
	                } catch (NumberFormatException exec) {
	                	outputAns.setText(" Input needs to be an integer"); 
	                	iterTime.setText("");
	                	recurTime.setText("");
	                	skip = true; 
	                }
	                if (skip == false) {
	                	int iterAns = 0;
	                	long iterDuration = 0; 
	                	long recurDuration = 0; 
	                	try {
	                		long startTime = System.nanoTime();
	                		iterAns = (int) i.getIterative().invoke(null, inputVal);
	                		long endTime = System.nanoTime();
	                		iterDuration = endTime - startTime; 
	                		
					    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
					    	e1.printStackTrace();
					    } 
	                    try {
	                    	long startTime = System.nanoTime();
	                    	int recurAns = (int) i.getRecursive().invoke(null, inputVal);
	                    	long endTime = System.nanoTime();
	                    	recurDuration = endTime - startTime; 
					    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
					    	e1.printStackTrace();
					    }
	                    outputAns.setText(String.valueOf(iterAns));
	                    iterTime.setText(String.valueOf(iterDuration));
	                    recurTime.setText(String.valueOf(recurDuration));
	                 }
	            }  
	        });  
	    	buttonPanel.add(button);
	    }
	    mainPanel.add(inputPanel);
	    mainPanel.add(buttonPanel);
	    mainPanel.add(outputPanel);
	    mainPanel.add(iterTimePanel);
	    mainPanel.add(recurTimePanel);
	    frame.add(mainPanel);
	    frame.setVisible(true);
	}
	
	public static void setupFunctions() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method1 = Fibonnaci.class.getMethod("iterative", int.class);
		Method method2 = Fibonnaci.class.getMethod("recursive", int.class);
		Function fibonnaci = new Function(method1, method2,"Fibonnaci");
		listOfFunctions.add(fibonnaci);
		
		Method method3 = GUIFactorial.class.getMethod("iterative", int.class);
		Method method4 = GUIFactorial.class.getMethod("recursive", int.class);
		Function factorial = new Function(method3, method4,"Factorial");
		listOfFunctions.add(factorial);
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		listOfFunctions = new ArrayList<Function>(); 	
		setupFunctions();
		runGUI();
	}

}