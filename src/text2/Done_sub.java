package text2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Done_sub extends JPanel{
	
	public Done_sub(){
		JLabel jl = new JLabel("ɾ���ɹ�");
		JButton jb = new JButton("����");
		
		setBounds(0, 0, 804, 600);
		setLayout(null);
		
		jl.setBounds(310, 180, 300, 40);
		jl.setFont(new Font("����", Font.BOLD, 40));
		add(jl);
		
		jb.setBounds(340, 250, 100, 40);
		add(jb);
		
		jb.addActionListener(new ActionListener() {
			
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
