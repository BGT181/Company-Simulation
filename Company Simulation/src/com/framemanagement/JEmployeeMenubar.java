package com.framemanagement;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.entities.Employee;

public class JEmployeeMenubar extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2931214101722167232L;
	private Employee employee;
	private int x;
	private int y;
	private String name;
	
	JLabel labelName ;
	JCheckBox checkboxLogistic ;
	JCheckBox checkboxPreprocessing;
	JCheckBox checkboxProcessing;
	JCheckBox checkboxQualitycheck;
	JLabel labelEfficiency;
	
	ContentPanel contentP;
	
	public JEmployeeMenubar(Employee employee, String name, int x, int y, ContentPanel contentP) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		this.contentP = contentP;
		initComponents();
		placeComponents();
		
	}
	
	private void initComponents() {
		
		labelName = new JLabel(name);
		checkboxLogistic = new JCheckBox("",false);
		/*System.out.println("debug");
		
		System.out.println("debug5");
		
		System.out.println("debug4");
		checkboxPreprocessing = new JCheckBox("",employee.getQualification(1));
		checkboxProcessing = new JCheckBox("",employee.getQualification(2));
		checkboxQualitycheck = new JCheckBox("",employee.getQualification(3));
		labelEfficiency = new JLabel(Double.toString(employee.getEfficiencyLvl()));
		*/
	}
	
	
	private void placeComponents() {
		System.out.println("debug2");
		labelName.setBounds(x, y, 20, 50);
		checkboxLogistic.setBounds(900, 60, 20, 20);
		
		contentP.add(labelName);
		contentP.add(checkboxLogistic);
	}
	
}
