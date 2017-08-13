package text2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class SortWin extends JPanel{
	
	
	private JTextArea jta;
	private ArrayList<Person> list, list2;
	private JScrollPane jsPane;
	private JTable jt;
	private JLabel jl;
	private JComboBox box;
	Operate op;
	
	public SortWin(){
		setBounds(0, 0, 804, 600);
		setLayout(null);
		
		jta = new JTextArea();
		op = new Operate();
		box = new JComboBox();
		jl = new JLabel("所属单位：");
		
		jl.setBounds(20, 0, 80, 30);
		add(jl);
		box.setBounds(100, 0, 120, 30);
		add(box);
		jta.setBounds(250, 0, 400, 30);
		jta.setBackground(null);
		jta.setFont(new Font("宋体", Font.BOLD, 20));
		add(jta);
		
		list = op.sort();
		for(int i =0; i < list.size()-1; i++){
			for(int j = 0; j < list.size()-1; j++){
				int num1 = Integer.parseInt(list.get(j).getSalary());
				int num2 = Integer.parseInt(list.get(j+1).getSalary());
				if(num1 < num2){
					Person temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
				} 
			}
		}
		box.addItem("所有单位");
		int sum =0;
		for (Person person : list) {
			sum += Integer.parseInt(person.getSalary());
		}
		jta.setText("职工人数：" + list.size() + "  工资总额：" + sum);
		next:
		for (Person person : list) {
			for(int i =0; i < box.getItemCount() ; i++){
				if(person.getUnit().equals(box.getItemAt(i))){
					continue next; //若单位已存在，则跳出此次双重循环
				}
			}
			box.addItem(person.getUnit());
		}
		
		
		
		String[] column = {"职称号", "名字", "性别", "所属单位", "所学专业", "职称", "工资", "电话号码"};
		Object[][] data = new Object[list.size()][8];
		for(int i =0; i < list.size(); i++){
			data[i] = new Object[]{list.get(i).getId(), list.get(i).getName(), list.get(i).getGender(), 
					list.get(i).getUnit(), list.get(i).getMajor(), list.get(i).getWork(), list.get(i).getSalary(), 
					list.get(i).getNumber()};
		}
		jt = new JTable(data,column);
		jt.setEnabled(false);
		jsPane = new JScrollPane(jt);
		jsPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsPane.setBounds(0, 30, 804, 525);
		add(jsPane);
		
		box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				list2 = new ArrayList<Person>();
				int num = 0;
				int sum =0;
				for (Person person : list) {
					sum += Integer.parseInt(person.getSalary());
				}
				for (Person person : list) {
					if(box.getSelectedItem().toString().equals(person.getUnit())){
						list2.add(person);
						num += Integer.parseInt(person.getSalary());
					}
				}
				if(box.getSelectedItem().toString().equals("所有单位")){
					jta.setText("职工人数：" + list.size() + "  工资总额：" + sum);
					Object[][] data = new Object[list.size()][8];
					for(int i =0; i < list.size(); i++){
						data[i] = new Object[]{list.get(i).getId(), list.get(i).getName(), list.get(i).getGender(), 
								list.get(i).getUnit(), list.get(i).getMajor(), list.get(i).getWork(), list.get(i).getSalary(), 
								list.get(i).getNumber()};
					}
					setVisible(false);
					remove(jsPane);
					jt = new JTable(data,column);
					jt.setEnabled(false);
					jsPane = new JScrollPane(jt);
					jsPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					jsPane.setBounds(0, 30, 804, 525);
					add(jsPane);
					setVisible(true);
				}else{
					jta.setText("职工人数：" + list2.size() + "  工资总额：" + num);
					Object[][] data = new Object[list2.size()][8];
					for(int i =0; i < list2.size(); i++){
						data[i] = new Object[]{list2.get(i).getId(), list2.get(i).getName(), list2.get(i).getGender(), 
								list2.get(i).getUnit(), list2.get(i).getMajor(), list2.get(i).getWork(), 
								list2.get(i).getSalary(), list2.get(i).getNumber()};
					}
					setVisible(false);
					remove(jsPane);
					jt = new JTable(data,column);
					jt.setEnabled(false);
					jsPane = new JScrollPane(jt);
					jsPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					jsPane.setBounds(0, 30, 804, 525);
					add(jsPane);
					setVisible(true);
				}
			}
		});
		
		setVisible(true);
		
	}
}
