package com.framemanagement;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import com.actionlistener.ButtonActionListener;
import com.entities.Employee;
import com.gamelogic.Company;
import com.gamelogic.ImageProvider;
import com.gamelogic.ImageProvider.Imagefor;

public class ContentPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2906000336360409527L;
	ImageProvider ip = new ImageProvider();
	Timer timer = new Timer(50, this);
	Company company = new Company(true);
	
	//Logic for the Menu. An Enum to provide the values for the specific Design
	public enum optionPanel { DASHBOARD, MANAGEMENT, EMPLOYEE }
	private optionPanel currentOptionPanel = optionPanel.DASHBOARD;
	private optionPanel feedbackOptionPanel;
	
	//Control-Button Logic - Init Buttons and creating the ActionListener
	JButton buttonDashboard = new JButton("Dashboard");
	JButton buttonManagement = new JButton("Management"); 
	JButton buttonEmployees = new JButton("Employees");
	ButtonActionListener buttonActionListener = new ButtonActionListener(this, buttonDashboard, buttonManagement, buttonEmployees);
	
	JButton 	buttonConfirm = new JButton("Confirm your input");
	
	private ArrayList<JComponent> menuDashboard = new ArrayList<JComponent>();
	private ArrayList<JComponent> menuManagement = new ArrayList<JComponent>();
	private ArrayList<JComponent> menuEmployee = new ArrayList<JComponent>();
	
	public ContentPanel() {
		super();
		timer.start();
		setLayout(null);
		setSize(1200,720);
		
			addButton(buttonDashboard, 800, 0);
			addButton(buttonManagement, 931, 0);
			addButton(buttonEmployees, 1062, 0);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        
        drawMenu();
    	drawImages(g2d);
	}
	
	private void drawMenu() {
		if(currentOptionPanel!=feedbackOptionPanel) {
			removeComponents();
			switch (currentOptionPanel) {
				case DASHBOARD:	
					initMenuDasboard();
					addArrayListToPanel(menuDashboard);
					repaint();
					feedbackOptionPanel = currentOptionPanel;
					break;
				case MANAGEMENT:
					initMenuManagement();
					addArrayListToPanel(menuManagement);
					repaint();
					feedbackOptionPanel = currentOptionPanel;
					break;
				case EMPLOYEE:
					initMenuEmployee();
					addArrayListToPanel(menuEmployee);
					repaint();
				    feedbackOptionPanel = currentOptionPanel;
					break;			
			}
		}
	}
	
	private void initMenuEmployee() {
		
	menuEmployee.add(createLabel("Logistics", 875, 51));
	menuEmployee.add(createLabel("Preprocessing", 925, 71));
	menuEmployee.add(createLabel("Processing", 975, 91));
	menuEmployee.add(createLabel("Qualitycheck", 1025, 111));
		
		int i = 140;
		for (Employee employee : company.getArrayListEmployee()) {
			menuEmployee.add(new JEmployeeMenubar(this,employee, employee.getName(),i));
			i+=20;
		}
	}
	
	private void initMenuDasboard() {
		menuDashboard.add(createLabel("Revenue:", 825, 60));			//#0
		menuDashboard.add(createLabel("EBIT:", 825 , 100));				//#1
		menuDashboard.add(createLabel("Cash:", 825 , 140));				//#2
		menuDashboard.add(createLabel("Products sold:", 825 , 180));	//#3
		menuDashboard.add(createLabel("Employees:", 825 , 220));		//#4
		menuDashboard.add(createLabel("Monthly loans:", 825 , 260));	//#5
	}
	
	private void initMenuManagement() {
		menuManagement.add(createLabel("Buy x items of product A (as integer)", 825, 60));						//#0
		menuManagement.add(createLabel("Buy x items of product B (as integer)", 825, 160));						//#1
		menuManagement.add(createLabel("Set selling-price of product C (as double)", 825, 260));				//#2
		menuManagement.add(createLabel("Increasing loan of all employees by x percent (as double)", 825, 360));	//#3
		
		menuManagement.add(createTextField(0, 100));					//#4 - Buy product A
		menuManagement.add(createTextField(0, 200));					//#5 - Buy product B
		menuManagement.add(createTextField(0, 300));					//#6 - Price for C
 		menuManagement.add(createTextField(0, 400));					//#7 - Increase loans
 		
 		buttonConfirm.setBounds(825, 500, 350, 50);
		menuManagement.add(buttonConfirm);								//#8
	}
	
	private JLabel createLabel(String text, int xPos, int yPos) {
		JLabel label = new JLabel(text);
		label.setBounds(xPos, yPos, 400, 50);
		return label;
	}
	
	private JTextField createTextField(int val, int yPos) {
		JTextField textfield = new JTextField(val);
		textfield.setBounds(825, yPos, 150, 30);
		return textfield;
	}
	
	private void addArrayListToPanel(ArrayList<JComponent> arrayList) {
		for(JComponent component : arrayList) {
			add(component);
		}
	}
	
	private void removeComponents() {
		if(feedbackOptionPanel==optionPanel.DASHBOARD) {
			for(JComponent component : menuDashboard) {
				remove(component);
			} 
		}
		if(feedbackOptionPanel==optionPanel.MANAGEMENT) {
			for(JComponent component : menuManagement) {
				remove(component);
			}
		}
		if(feedbackOptionPanel==optionPanel.EMPLOYEE) {
			for(JComponent component : menuEmployee) {
				if(component instanceof JLabel) {
					remove(component);
				} else  {
					((JEmployeeMenubar) component).removeComponents();
				}
			}
		}
	}
	
	private void drawImages(Graphics2D g2d) {
		g2d.drawImage(ip.getImage(Imagefor.BUILDING), 0,0,null);
        g2d.drawImage(ip.getImage(Imagefor.TRUCK), 80,75,null);
        
        
        company.getStorage().drawImage(g2d);
        
        for (int i = 0; i < company.getMachines().length; i++) {
        	g2d.drawImage(company.getMachines()[i].getImage(), company.getMachines()[i].getxPos(), company.getMachines()[i].getyPos(), null);
		}
        
        for(Employee employee : company.getArrayListEmployee()){
        	//g2d.rotate(Math.toRadians(45));
        	g2d.drawImage(employee.getImage(), employee.getxPos(), employee.getyPos(), null);
        	//g2d.rotate(Math.toRadians(0));
        }
        
        
      }
	
	private void addButton(JButton button, int x, int y) {
		button.setBounds(x, y, 130, 50);
		button.addActionListener(buttonActionListener);
		this.add(button);
	}

	public void actionPerformed(ActionEvent ev){
	    if(ev.getSource()==timer){
	    	
	    	for (Employee employee: company.getArrayListEmployee()) {
				employee.getMovementManager().updatePosition();
			}
	    	
	   
	    	company.process();
	      repaint();
	    }
	}
	
	public optionPanel getCurrentOptionPanel() {
		return currentOptionPanel;
	}

	public void setCurrentOptionPanel(optionPanel currentOptionPanel) {
		this.currentOptionPanel = currentOptionPanel;
	}
	
}
