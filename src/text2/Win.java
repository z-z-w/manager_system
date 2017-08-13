package text2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javafx.geometry.VerticalDirection;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import com.sun.prism.Image;

public class Win {
	
	JFrame jf;
	JPanel jp1,jp2,jp_top;
	JButton addButton, subButton,modifyButton, viewButton, sortButton, exitButton;
	JLabel jl_top;
	JTextArea jta;
	ImageIcon img2;
	
	
	void init(){
		jf = new JFrame();
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp_top = new JPanel();
		
		img2 = new ImageIcon("top.jpg");
		img2.setImage(img2.getImage().getScaledInstance(821, 70, java.awt.Image.SCALE_DEFAULT));
		jl_top = new JLabel(img2);
		jta = new JTextArea();
		addButton = new JButton("添加");
		subButton = new JButton("删除");
		modifyButton = new JButton("修改");
		viewButton = new JButton("查询");
		sortButton = new JButton("排序");
		exitButton = new JButton("退出");
		
		jf.setTitle("教职工信息系统");
		jf.setBounds(550, 180, 821, 700);
		jp_top.setBounds(0,0,821,70);
		jp1.setBounds(0, 70, 821, 30);
		jp2.setBounds(0, 100, 821, 600);
		jp1.setLayout(null);
		jp2.setLayout(null);
		jp_top.setLayout(null);
		
		
		jl_top.setBounds(0, 0, 821, 70);
		
		jp_top.add(jl_top);
		
		addButton.setBounds(0, 0, 134, 30);
		jp1.add(addButton);
		subButton.setBounds(134, 0, 134, 30);
		jp1.add(subButton);
		modifyButton.setBounds(268, 0, 134, 30);
		jp1.add(modifyButton);
		viewButton.setBounds(402, 0, 134, 30);
		jp1.add(viewButton);
		sortButton.setBounds(536, 0, 134, 30);
		jp1.add(sortButton);
		exitButton.setBounds(670, 0, 134, 30);
		jp1.add(exitButton);
		jp2.add(new Login());
		
		addButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jp2.setVisible(false);
				jp2.removeAll();
				AddWin aw = new AddWin();
				jp2.add(aw);
				jp2.setVisible(true);
				
				
			}
		});
		
		subButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jp2.setVisible(false);
				jp2.removeAll();
				SubWin sw = new SubWin();
				jp2.add(sw);
				jp2.setVisible(true);
			}
		});
		
		modifyButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jp2.setVisible(false);
				jp2.removeAll();
				ModifyWin mw = new ModifyWin();
				jp2.add(mw);
				jp2.setVisible(true);
			}
		});
		
		viewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jp2.setVisible(false);
				jp2.removeAll();
				ViewWin vw = new ViewWin();
				jp2.add(vw);
				jp2.setVisible(true);
			
			}
		});
		
		sortButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jp2.setVisible(false);
				jp2.removeAll();
				SortWin sw = new SortWin();
				jp2.add(sw);
				jp2.setVisible(true);
			}
		});
		
		exitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
			}
		});
		

		jf.add(jp1);
		jf.add(jp2);
		jf.add(jp_top);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
 	}

	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Win().init();
		}

}
