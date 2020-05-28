package com.framemanagement;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;

import com.actionlistener.CheckBoxActionListener;
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
	
	public JEmployeeMenubar(ContentPanel contentP, Employee employee, String name, int y) {
		super();
		this.employee = employee;
		this.name = name;
		this.x = 825;
		this.y = y;
		this.contentP = contentP;
		initComponents();
		placeComponents();
	}
	
	private void initComponents() {	
		labelName = new JLabel(name);
		checkboxLogistic = new JCheckBox("", employee.getQualification(0));
		checkboxPreprocessing = new JCheckBox("",employee.getQualification(1));
		checkboxProcessing = new JCheckBox("",employee.getQualification(2));
		checkboxQualitycheck = new JCheckBox("",employee.getQualification(3));
		labelEfficiency = new JLabel(Double.toString(employee.getEfficiencyLvl()));
	}
	
	private void placeComponents() {
		labelName.setBounds(x, y, 20, 50);
		checkboxLogistic.setBounds(x+75, y+10, 25, 25);
		checkboxPreprocessing.setBounds(x+125, y+10, 25, 25);
		checkboxProcessing.setBounds(x+175, y+10, 25, 25);
		checkboxQualitycheck.setBounds(x+225, y+10, 25, 25);
		labelEfficiency.setBounds(x+300, y, 20, 50);
		
		CheckBoxActionListener boxActionListener = new CheckBoxActionListener(employee, checkboxLogistic, checkboxPreprocessing, checkboxProcessing, checkboxQualitycheck);

		checkboxLogistic.addActionListener(boxActionListener);
		checkboxPreprocessing.addActionListener(boxActionListener);
		checkboxProcessing.addActionListener(boxActionListener);
		checkboxQualitycheck.addActionListener(boxActionListener);
		
		contentP.add(labelName);
		contentP.add(checkboxLogistic);
		contentP.add(checkboxPreprocessing);
		contentP.add(checkboxProcessing);
		contentP.add(checkboxQualitycheck);
		contentP.add(labelEfficiency);
	}
	
	public void removeComponents() {
		contentP.remove(labelName);
		contentP.remove(checkboxLogistic);
		contentP.remove(checkboxPreprocessing);
		contentP.remove(checkboxProcessing);
		contentP.remove(checkboxQualitycheck);
		contentP.remove(labelEfficiency);
	}
	
}
