package com.framemanagement;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import com.actionlistener.ButtonActionListener;
import com.gamelogic.Company;
import com.gamelogic.ImageProvider;
import com.gamelogic.ImageProvider.Imagefor;

public class ContentPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2906000336360409527L;
	ImageProvider ip = new ImageProvider();
	Timer timer = new Timer(5000, this);
	
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
	
	JTextField  textFieldBuyA = new JTextField("0"),
				textFieldBuyB = new JTextField("0"),
				textFieldPriceC = new JTextField("0"),
				textFieldLoan = new JTextField("0");
	
	JLabel 	labelBuyA = new JLabel("Buying x of product A (as integer)✓"),
			labelBuyB = new JLabel("Buying x of product B (as integer)"),
			labelPriceC = new JLabel("Change selling-price of product C (as double)"),
			labelLoan = new JLabel("Increase loans by x percent (as double)"),
			labelRevenue = new JLabel("Revenue: "),
			labelProductsSold = new JLabel("Products sold:"),
			labelEBIT = new JLabel("EBIT:"),
			labelEmployees = new JLabel("Number of employees:"),
			labelLoansCombined = new JLabel("Combined loans of employees:"),
			labelCash = new JLabel("Cashflow:"),
			labelRunningCosts = new JLabel("Running costs:");
	
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
        
        //g2d.rotate(Math.toRadians(45));
        drawMenu();
    	drawImages(g2d);
	}
	
	private void drawMenu() {
		if(currentOptionPanel!=feedbackOptionPanel) {
			switch (currentOptionPanel) {
				case DASHBOARD:	
					drawMenuDashboard();
					repaint();
					feedbackOptionPanel = currentOptionPanel;
					break;
				case MANAGEMENT:
					drawMenuManagement();
					repaint();
					feedbackOptionPanel = currentOptionPanel;
					break;
				case EMPLOYEE:
				
				    feedbackOptionPanel = currentOptionPanel;
					break;			
			}
		}
	}

	private void drawMenuDashboard(){
		removeComponents();
		drawLabel(labelRevenue, 60);
		drawLabel(labelCash, 100);
		drawLabel(labelProductsSold, 140);
		drawLabel(labelEBIT, 180);
		drawLabel(labelRunningCosts, 220);
		drawLabel(labelEmployees, 260);
		drawLabel(labelLoansCombined, 300);
		
	}
	
	private void drawMenuManagement() {
		removeComponents();
		drawTextField(textFieldBuyA, 100);
		drawTextField(textFieldBuyB, 200);
		drawTextField(textFieldPriceC, 300);
		drawTextField(textFieldLoan, 400);
		
		drawLabel(labelBuyA, 60);
		drawLabel(labelBuyB, 160);
		drawLabel(labelPriceC, 260);
		drawLabel(labelLoan, 360);
		
		buttonConfirm.setBounds(825, 500, 350, 50);
		add(buttonConfirm);
	}
	
	private void removeComponents() {
		remove(buttonConfirm);
		remove(textFieldBuyA);
		remove(textFieldBuyB);
		remove(textFieldPriceC);
		remove(textFieldLoan);
		remove(labelBuyA);
		remove(labelBuyB);
		remove(labelEBIT);
		remove(labelEmployees);
		remove(labelLoan);
		remove(labelPriceC);
		remove(labelProductsSold);
		remove(labelRevenue);
		remove(labelLoansCombined);
		remove(labelCash);
		remove(labelRunningCosts);
	}
	
	private void drawTextField(JTextField textField, int y) {
		textField.setBounds(825, y, 200, 30);
		add(textField);
	}
	
	private void drawLabel(JLabel label, int y) {
		label.setBounds(825, y, 300, 50);
		add(label);
	}
	
	private void drawImages(Graphics2D g2d) {
		g2d.drawImage(ip.getImage(Imagefor.BUILDING), 0,0,null);
        g2d.drawImage(ip.getImage(Imagefor.TRUCK), 80,75,null);
	}
	
	private void addButton(JButton button, int x, int y) {
		button.setBounds(x, y, 130, 50);
		button.addActionListener(buttonActionListener);
		this.add(button);
	}

	public void actionPerformed(ActionEvent ev){
	    if(ev.getSource()==timer){
	    	System.out.println(ev.getSource());
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
