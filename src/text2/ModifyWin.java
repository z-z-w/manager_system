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

public class ModifyWin extends JPanel{
	
	public JButton jbYes, jbNo;
	public JLabel idLabel;
	public JTextField idText;
	public Person ps_mdf;
	
	public ModifyWin(){
		jbYes = new JButton("ȷ��");
		jbNo = new JButton("����");
		idLabel = new JLabel("�����������޸ĵ�ְ����ְ����");
		idText = new JTextField();
		
		
		setBounds(0, 0, 804, 600);
		setLayout(null);
		
		idLabel.setBounds(230, 100, 350, 40);
		idLabel.setFont(new Font("����", Font.BOLD, 24));
		add(idLabel);
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
				ps_mdf = new Person();
				ps_mdf.setId(idText.getText());
				idText.setText("");
				Operate op = new Operate();
				if(op.view(ps_mdf).getId().equals("0")){
					JOptionPane.showMessageDialog(null, "����������ְ����", "�����ڸ�ְ��",JOptionPane.ERROR_MESSAGE);
				}else{
					ps_mdf = op.view(ps_mdf);
					setVisible(false);
					removeAll();
					add(new Show_modify(ps_mdf));
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
