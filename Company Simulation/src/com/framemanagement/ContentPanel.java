package com.framemanagement;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import com.actionlistener.ButtonActionListener;
import com.actionlistener.ConfirmBottonActionListener;
import com.entities.Employee;
import com.entities.Product;
import com.gamelogic.Company;
import com.gamelogic.ImageProvider;
import com.gamelogic.ImageProvider.Imagefor;

public class ContentPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2906000336360409527L;
	ImageProvider ip = new ImageProvider();
	Timer timer = new Timer(30, this);
	Company company = new Company(true);
	
	public enum optionPanel { DASHBOARD, MANAGEMENT, EMPLOYEE }
	private optionPanel currentOptionPanel = optionPanel.DASHBOARD;
	private optionPanel feedbackOptionPanel;
	
	JButton buttonDashboard = new JButton("Dashboard");
	JButton buttonManagement = new JButton("Management"); 
	JButton buttonEmployees = new JButton("Employees");
	ButtonActionListener buttonActionListener = new ButtonActionListener(this, buttonDashboard, buttonManagement, buttonEmployees);
	
	JButton buttonConfirm = new JButton("Confirm your input");
	ConfirmBottonActionListener confirmButtonListener = new ConfirmBottonActionListener(buttonConfirm, this);
	
	
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
			
			buttonConfirm.addActionListener(confirmButtonListener);
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
					removeComponents(menuDashboard);
					initMenuDasboard();
					addArrayListToPanel(menuDashboard);
					repaint();
					feedbackOptionPanel = currentOptionPanel;
					break;
				case MANAGEMENT:
					removeComponents(menuManagement);
					initMenuManagement();
					addArrayListToPanel(menuManagement);
					repaint();
					feedbackOptionPanel = currentOptionPanel;
					break;
				case EMPLOYEE:
					removeComponents(menuEmployee);
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
		menuDashboard.add(createLabel("EBIT/Product", 825 , 260));	//#5
		menuDashboard.add(createLabel("Price Product A:", 825 , 260));	//#5
		menuDashboard.add(createLabel("Price Product B:", 825 , 260));	//#5
		menuDashboard.add(createLabel("Day:", 825 , 260));	//#5
		
		menuDashboard.add(createLabel(Double.toString(company.getRevenue()), 1000, 60));
		menuDashboard.add(createLabel(Double.toString(company.getEbit()), 1000, 100));
		menuDashboard.add(createLabel(Double.toString(company.getCash()), 1000, 140));
		menuDashboard.add(createLabel(Integer.toString(company.getProductssold()), 1000, 180));
		menuDashboard.add(createLabel(Integer.toString(company.getArrayListEmployee().size()), 1000, 220));
		menuDashboard.add(createLabel(Double.toString(company.getMonthlyLoans()), 1000, 260));
		
	}
	
	private void initMenuManagement() {
		menuManagement.add(createLabel("Buy x items of product A (as integer)", 825, 60));						//#0
		menuManagement.add(createLabel("Buy x items of product B (as integer)", 825, 160));						//#1
		menuManagement.add(createLabel("Set selling-price of product C (as integer)", 825, 260));				//#2
		menuManagement.add(createLabel("Increasing loan of all employees by x percent (as integer)", 825, 360));	//#3
		menuManagement.add(createLabel("Hire x new employees (as int)",825,460));								//#4
		
		menuManagement.add(createTextField(0, 100,0));					//#5 - Buy product A
		menuManagement.add(createTextField(0, 200,0));					//#6 - Buy product B
		menuManagement.add(createTextField(0, 300,company.getPriceC()));	//#7 - Price for C
 		menuManagement.add(createTextField(0, 400,0));					//#8 - Increase loans
 		menuManagement.add(createTextField(0, 500,0));					//#9 - Hire Employee
 		
 		buttonConfirm.setBounds(825, 550, 350, 50);

		menuManagement.add(buttonConfirm);								//#10
	}
	
	private JLabel createLabel(String text, int xPos, int yPos) {
		JLabel label = new JLabel(text);
		label.setBounds(xPos, yPos, 400, 50);
		return label;
	}
	
	private JTextField createTextField(int val, int yPos, int value) {
		JTextField textfield = new JTextField(val);
		textfield.setText(String.valueOf(value));
		textfield.setBounds(825, yPos, 150, 30);
		return textfield;
	}
	
	private void addArrayListToPanel(ArrayList<JComponent> arrayList) {
		for(JComponent component : arrayList) {
			add(component);
		}
	}
	
	
	private void removeComponents(ArrayList<JComponent> arrayList) {
		for (int i = arrayList.size()-1; i >= 0; i--) {
			arrayList.remove(arrayList.get(i));
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
       
        company.getMachineA().drawImage(g2d);
        company.getMachineA().drawItems(g2d);
        company.getMachineB().drawImage(g2d);
        company.getMachineB().drawItems(g2d);
        company.getMachineC().drawImage(g2d);
        company.getMachineC().drawItems(g2d);
        
        
        	company.getStorage().drawImage(g2d);
        	for(Product product : company.getStorage().getProducts()) {
        		if(product != null) {
        			g2d.drawImage(product.getImage(), product.getxPos(), product.getyPos(),null);
        		}
        	}
        
        	for(Employee employee : company.getArrayListEmployee()){
        		g2d.drawImage(employee.getImage(), employee.getxPos(), employee.getyPos(), null);
        		if(employee.getCarryProduct()!=null) {
        			g2d.drawImage(employee.getCarryProduct().getImage(),employee.getCarryProduct().getxPos()+8,employee.getCarryProduct().getyPos()+8,null );
        		}
        	}
        
        	   company.getTruckEntrence().moveToDestination();
               g2d.drawImage(company.getTruckEntrence().getImage(), company.getTruckEntrence().getxPos(),company.getTruckEntrence().getyPos(), null);
               company.getTruckExit().moveToDestination();
               g2d.drawImage(company.getTruckExit().getImage(), company.getTruckExit().getxPos(),company.getTruckExit().getyPos(), null);
               
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
	    
	      repaint();
	    }
	}
	
	public optionPanel getCurrentOptionPanel() {
		return currentOptionPanel;
	}

	public void setCurrentOptionPanel(optionPanel currentOptionPanel) {
		this.currentOptionPanel = currentOptionPanel;
	}
	
	public ArrayList<JComponent> getMenuManagement(){
		return this.menuManagement;
	}
	
	public Company getCompany() {
		return this.company;
	}	
	
}
