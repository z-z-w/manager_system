package text2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Done_modify extends JPanel{
	
	public Done_modify(){
		JLabel jl = new JLabel("修改成功");
		JButton jb = new JButton("返回");
		
		setBounds(0, 0, 804, 600);
		setLayout(null);
		
		jl.setBounds(310, 180, 300, 40);
		jl.setFont(new Font("宋体", Font.BOLD, 40));
		add(jl);
		
		jb.setBounds(340, 250, 100, 40);
		add(jb);
		
		jb.addActionListener(new ActionListener() {
			
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
