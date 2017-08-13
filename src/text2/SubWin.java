package text2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubWin extends JPanel{
	public JButton jbYes, jbNo;
	public JLabel idLabel_sb;
	public JTextField idText_sb;
	Person ps_sub;
	
	public SubWin(){
		jbYes = new JButton("删除");
		jbNo = new JButton("返回");
		idLabel_sb = new JLabel("请输入你想删除的职工的职工号");
		idText_sb = new JTextField();
		
		setBounds(0, 0, 804, 600);
		setLayout(null);
		
		idLabel_sb.setBounds(230, 100, 350, 40);
		idLabel_sb.setFont(new Font("宋体", Font.BOLD, 24));
		add(idLabel_sb);
		idText_sb.setBounds(290, 250, 220, 40);
		add(idText_sb);
		
		jbYes.setBounds(250, 400, 120, 50);
		add(jbYes);
		jbNo.setBounds(440, 400, 120, 50);
		add(jbNo);
		
		
		jbYes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ps_sub = new Person();
				ps_sub.setId(idText_sb.getText());
				idText_sb.setText("");
				Operate op = new Operate();
				if(op.view(ps_sub).getId().equals("0")){
					JOptionPane.showMessageDialog(null, "请重新输入职工号", "不存在该职工",JOptionPane.ERROR_MESSAGE);
				}else{
					ps_sub = op.view(ps_sub);
					setVisible(false);
					removeAll();
					add(new Show_sub(ps_sub));
					setVisible(true);
				}
			}
		});
		
		jbNo.addActionListener(new ActionListener() {
			
			@Override
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
