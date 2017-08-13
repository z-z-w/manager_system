package text2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import sun.text.resources.zh.JavaTimeSupplementary_zh_TW;

public class AddWin extends JPanel {
	public JButton jbYes, jbNo;
	public JLabel textLabel_ab,idLabel_ab, nameLabel_ab, genderLabel_ab, unitLabel_ab,  
					majorLabel_ab, workLabel_ab,salaryLabel_ab, numberLabel_ab;
	public JTextField idText_ab, nameText_ab, genderText_ab, unitText_ab,  majorText_ab, 
						workText_ab,salaryText_ab, numberText_ab;
	public JComboBox box;
	
	
	public AddWin(){
		
		JButton jbYes = new JButton("添加");
		JButton jbNo = new JButton("返回");
		textLabel_ab = new JLabel("职工基本信息录入");
		idLabel_ab = new JLabel("职工号: ");
		nameLabel_ab = new JLabel("姓名: ");
		genderLabel_ab = new JLabel("性别: ");
		unitLabel_ab = new JLabel("所属单位: ");
		majorLabel_ab = new JLabel("所学专业: ");
		workLabel_ab = new JLabel("职称: ");
		salaryLabel_ab = new JLabel("月工资: ");
		numberLabel_ab = new JLabel("电话号码: ");
		idText_ab = new JTextField();
		nameText_ab = new JTextField();
		//genderText_ab = new JTextField();
		unitText_ab = new JTextField();
		majorText_ab = new JTextField();
		workText_ab = new JTextField();
		salaryText_ab = new JTextField();
		numberText_ab = new JTextField();
		box = new JComboBox();
		
		
		setBounds(0, 0, 804, 600);
		setLayout(null);
		
		textLabel_ab.setBounds(320, 25, 200, 40);
		textLabel_ab.setFont(new Font("宋体", Font.BOLD, 20));
		add(textLabel_ab);
		
		idLabel_ab.setBounds(260, 100, 80, 20);
		add(idLabel_ab);
		idText_ab.setBounds(340, 100, 200, 20);
		add(idText_ab);
		
		nameLabel_ab.setBounds(260, 140, 80, 20);
		add(nameLabel_ab);
		nameText_ab.setBounds(340, 140, 200, 20);
		add(nameText_ab);
		
		genderLabel_ab.setBounds(260, 180, 80, 20);
		add(genderLabel_ab);
		box.addItem("男");
		box.addItem("女");
		box.setBounds(340, 180, 200, 20);
		add(box);
		
		
		unitLabel_ab.setBounds(260, 220, 80, 20);
		add(unitLabel_ab);
		unitText_ab.setBounds(340, 220, 200, 20);
		add(unitText_ab);
		
		majorLabel_ab.setBounds(260, 260, 80, 20);
		add(majorLabel_ab);
		majorText_ab.setBounds(340, 260, 200, 20);
		add(majorText_ab);
		
		workLabel_ab.setBounds(260, 300, 80, 20);
		add(workLabel_ab);
		workText_ab.setBounds(340, 300, 200, 20);
		add(workText_ab);
		
		salaryLabel_ab.setBounds(260, 340, 80, 20);
		add(salaryLabel_ab);
		salaryText_ab.setBounds(340, 340, 200, 20);
		add(salaryText_ab);
		
		numberLabel_ab.setBounds(260, 380, 80, 20);
		add(numberLabel_ab);	
		numberText_ab.setBounds(340, 380, 200, 20);
		add(numberText_ab);
		
		jbYes.setBounds(250, 450, 130, 40);
		add(jbYes);
		jbNo.setBounds(410, 450, 130, 40);
		add(jbNo);
		
		
		
		jbYes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Operate op = new Operate();
				Person ps = new Person();
				Error er = new Error();
				ps.setId(idText_ab.getText().toString());
				ps.setName(nameText_ab.getText().toString());
				if(idText_ab.getText().toString().equals("") || 
						nameText_ab.getText().toString().equals("") || 
						box.getSelectedItem().toString().equals("") || 
						unitText_ab.getText().toString().equals("") || 
						majorText_ab.getText().toString().equals("") || 
						workText_ab.getText().toString().equals("") || 
						salaryText_ab.getText().toString().equals("") || 
						numberText_ab.getText().toString().equals("")){
					JOptionPane.showMessageDialog(null, "请输入完整信息", "出错啦",JOptionPane.ERROR_MESSAGE);
				} else if(idText_ab.getText().toString().equals(op.view(ps).getId())){
					JOptionPane.showMessageDialog(null, "请重新输入职工号", "该职工号已存在",JOptionPane.ERROR_MESSAGE);
				} else if(!idText_ab.getText().toString().matches("[0-9]*")){
					JOptionPane.showMessageDialog(null, "职工号请输入纯数字", "出错啦",JOptionPane.ERROR_MESSAGE);
				} else if (!salaryText_ab.getText().toString().matches("[0-9]*")){
					JOptionPane.showMessageDialog(null, "工资请输入纯数字", "出错啦",JOptionPane.ERROR_MESSAGE);
				} else if (!numberText_ab.getText().toString().matches("[0-9]*")){
					JOptionPane.showMessageDialog(null, "电话号码请输入纯数字", "出错啦",JOptionPane.ERROR_MESSAGE);
				} else {
					ps.setGender(box.getSelectedItem().toString());
					ps.setUnit(unitText_ab.getText().toString());
					ps.setMajor(majorText_ab.getText().toString());
					ps.setWork(workText_ab.getText().toString());
					ps.setSalary(salaryText_ab.getText().toString());
					ps.setNumber(numberText_ab.getText().toString());
					idText_ab.setText("");
					nameText_ab.setText("");
					box.setSelectedItem("男");
					unitText_ab.setText("");
					majorText_ab.setText("");
					workText_ab.setText("");
					salaryText_ab.setText("");
					numberText_ab.setText("");
					op.add(ps);
					}
				
			}
		});
		
		jbNo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				removeAll();
				add(new Login());
				setVisible(true);
			}
		});
		
		
		
		setVisible(true);
	}
	
		
	
	
}
