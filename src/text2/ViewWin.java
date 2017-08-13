package text2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sun.net.www.content.image.jpeg;

public class ViewWin extends JPanel{

	public JButton jbYes, jbNo;
	public JLabel idLabel_view;
	public JTextField idText;
	Person ps_view;
	
	public ViewWin(){
		jbYes = new JButton("确定");
		jbNo = new JButton("返回");
		idLabel_view = new JLabel("请输入你想查询的职工的职工号");
		idText = new JTextField();
		
		setBounds(0, 0, 804, 600);
		setLayout(null);
		
		idLabel_view.setBounds(230, 100, 350, 40);
		idLabel_view.setFont(new Font("宋体", Font.BOLD, 24));
		add(idLabel_view);
		idText.setBounds(290, 250, 220, 40);
		add(idText);
		
		jbYes.setBounds(250, 400, 120, 50);
		add(jbYes);
		jbNo.setBounds(440, 400, 120, 50);
		add(jbNo);
		
		setVisible(true);
		
		jbYes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ps_view = new Person();
				ps_view.setId(idText.getText());
				idText.setText("");
				Operate op = new Operate();
				if(op.view(ps_view).getId().equals("0")){
					JOptionPane.showMessageDialog(null, "请重新输入职工号", "不存在该职工",JOptionPane.ERROR_MESSAGE);
				}else{
					ps_view = op.view(ps_view);
					setVisible(false);
					removeAll();
					add(new Show(ps_view));
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
		
	}
	
	
}
