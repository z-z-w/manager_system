package text2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Show_sub extends JPanel{	
	
	public Show_sub(Person p) {
		JLabel textLabel_ab = new JLabel("您想要删除的职工的信息如下");
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
		JTextField genderText = new JTextField();
		JTextField unitText = new JTextField();
		JTextField majorText = new JTextField();
		JTextField workText = new JTextField();
		JTextField salaryText = new JTextField();
		JTextField numberText = new JTextField();
		JButton jb_yes = new JButton("删除");
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
		genderText.setBounds(340, 180, 200, 20);
		add(genderText);
		
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
		idText.setEditable(false);
		idText.setBorder(null);
		nameText.setText(p.getName());
		nameText.setEditable(false);
		nameText.setBorder(null);
		genderText.setText(p.getGender());
		genderText.setEditable(false);
		genderText.setBorder(null);
		unitText.setText(p.getUnit());
		unitText.setEditable(false);
		unitText.setBorder(null);
		majorText.setText(p.getMajor());
		majorText.setEditable(false);
		majorText.setBorder(null);
		workText.setText(p.getWork());
		workText.setEditable(false);
		workText.setBorder(null);
		salaryText.setText(p.getSalary());
		salaryText.setEditable(false);
		salaryText.setBorder(null);
		numberText.setText(p.getNumber());
		numberText.setEditable(false);
		numberText.setBorder(null);
		
		jb_yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Operate op = new Operate();
				op.sub(p);
				setVisible(false);
				removeAll();
				add(new Done_sub());
				setVisible(true);
			}
		});
		
		jb_no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				removeAll();
				SubWin sw = new SubWin();
				sw.setBounds(0, 0, 804, 700);
				add(sw);
				setVisible(true);
			}
		});
	}
}
