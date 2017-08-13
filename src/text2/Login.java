package text2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Login extends JPanel{
	
	private JLabel jl;
	private ImageIcon img;
	
	public Login(){
		setBounds(0, 0, 804, 600);
		setLayout(null);
		
		
		img = new ImageIcon("login.jpg");
		img.setImage(img.getImage().getScaledInstance(821, 600, java.awt.Image.SCALE_DEFAULT));
		jl = new JLabel(img);
		jl.setBounds(0, 0, 821, 600);
		add(jl);
	}
}
