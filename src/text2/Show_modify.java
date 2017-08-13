package text2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Show_modify extends JPanel{
	
	public Show_modify(Person p) {
		JLabel textLabel_ab = new JLabel("您想要修改的职工的信息如下");
		JLabel idLabel = new JLabel("职工号: ");
		JLabel nameLabel = new JLabel("姓名: ");
		JLabel genderLabel = new JLabel("性别: ");
		JLabel unitLabel = new JLabel("所属单位: ");
		JLabel majorLabel = new JLabel("所学专业: ");
		JLabel workLabel = new JLabel("职称: ");
		JLabel salaryLabel = new JLabel("月工资: ");
		JLabel numberLabel = new JLabel("电话号码: ");
		JTextField idText = new JTextField();
		JTextField nameText = new JTextField();
		JComboBox box = new JComboBox();
		JTextField unitText = new JTextField();
		JTextField majorText = new JTextField();
		JTextField workText = new JTextField();
		JTextField salaryText = new JTextField();
		JTextField numberText = new JTextField();
		JButton jb_yes = new JButton("修改");
		JButton jb_no = new JButton("取消");
		
		setBounds(0, 0, 804, 600);
		setLayout(null);
		
		textLabel_ab.setBounds(260, 25, 400, 40);
		textLabel_ab.setFont(new Font("宋体", Font.BOLD, 20));
		add(textLabel_ab);
		
		idLabel.setBounds(260, 100, 80, 20);
		add(idLabel);
		idText.setBounds(340, 100, 200, 20);
		add(idText);
		
		nameLabel.setBounds(260, 140, 80, 20);
		add(nameLabel);
		nameText.setBounds(340, 140, 200, 20);
		add(nameText);
		
		genderLabel.setBounds(260, 180, 80, 20);
		add(genderLabel);
		box.addItem("男");
		box.addItem("女");
		box.setBounds(340, 180, 200, 20);
		add(box);
		
		unitLabel.setBounds(260, 220, 80, 20);
		add(unitLabel);
		unitText.setBounds(340, 220, 200, 20);
		add(unitText);
		
		majorLabel.setBounds(260, 260, 80, 20);
		add(majorLabel);
		majorText.setBounds(340, 260, 200, 20);
		add(majorText);
		
		workLabel.setBounds(260, 300, 80, 20);
		add(workLabel);
		workText.setBounds(340, 300, 200, 20);
		add(workText);
		
		salaryLabel.setBounds(260, 340, 80, 20);
		add(salaryLabel);
		salaryText.setBounds(340, 340, 200, 20);
		add(salaryText);
		
		numberLabel.setBounds(260, 380, 80, 20);
		add(numberLabel);
		numberText.setBounds(340, 380, 200, 20);
		add(numberText);
		
		jb_yes.setBounds(250, 450, 130, 40);
		add(jb_yes);
		jb_no.setBounds(410, 450, 130, 40);
		add(jb_no);
		
		idText.setText(p.getId());
		nameText.setText(p.getName());
		box.setSelectedItem(p.getGender());
		unitText.setText(p.getUnit());
		majorText.setText(p.getMajor());
		workText.setText(p.getWork());
		salaryText.setText(p.getSalary());
		numberText.setText(p.getNumber());
		
		jb_yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Operate op = new Operate();
				Person ps = new Person();
				ps.setId(idText.getText().toString());	
				ps.setName(nameText.getText().toString());
				if(idText.getText().toString().equals("") || 
						nameText.getText().toString().equals("") || 
						box.getSelectedItem().toString().equals("") || 
						unitText.getText().toString().equals("") || 
						majorText.getText().toString().equals("") || 
						workText.getText().toString().equals("") || 
						salaryText.getText().toString().equals("") || 
						numberText.getText().toString().equals("")){
					JOptionPane.showMessageDialog(null, "请输入完整信息", "出错啦",JOptionPane.ERROR_MESSAGE);
				}  else if(idText.getText().toString().equals(op.view(ps).getId()) && !p.getId().equals(idText.getText())){
						JOptionPane.showMessageDialog(null, "请重新输入职工号", "该职工号已存在",JOptionPane.ERROR_MESSAGE);
				} else if(!idText.getText().toString().matches("[0-9]*")){
					JOptionPane.showMessageDialog(null, "职工号请输入纯数字", "出错啦",JOptionPane.ERROR_MESSAGE);
				} else if (!salaryText.getText().toString().matches("[0-9]*")){
					JOptionPane.showMessageDialog(null, "工资请输入纯数字", "出错啦",JOptionPane.ERROR_MESSAGE);
				} else if (!numberText.getText().toString().matches("[0-9]*")){
					JOptionPane.showMessageDialog(null, "电话号码请输入纯数字", "出错啦",JOptionPane.ERROR_MESSAGE);
				} else {
					ps.setGender(box.getSelectedItem().toString());
					ps.setUnit(unitText.getText().toString());
					ps.setMajor(majorText.getText().toString());
					ps.setWork(workText.getText().toString());
					ps.setSalary(salaryText.getText().toString());
					ps.setNumber(numberText.getText().toString());
					op.sub(p);
					op.add(ps);
					setVisible(false);
					removeAll();
					add(new Done_modify());
					setVisible(true);
				}
			}
		});
		
		jb_no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				removeAll();
				ModifyWin mdf = new ModifyWin();
				mdf.setBounds(0, 0, 804, 700);
				add(mdf);
				setVisible(true);
			}
		});
	}
}
