package text2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class Operate {
	
	File file = new File("1.txt");
	ObjectInputStream in = null;
	ObjectOutputStream out = null;
	ArrayList al =null;
	ArrayList al2 = null;
	Person ps = null;
	Error er = new Error();
	
	public Operate(){
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void add(Person p){
		try {	
				if(file.length() == 0){
					out = new ObjectOutputStream(new FileOutputStream(file));
				}else{
					out = new MyObjectOutputStream(new FileOutputStream(file,true));		
				}
				ps = new Person();
				ps = p;
				out.writeObject(ps);
				out.flush();
				out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public Person view(Person p){
		try {
			in = new ObjectInputStream(new FileInputStream(file));
			ps = new Person();
			while(true){
				ps = (Person) in.readObject();
				if(ps.getId().equals(p.getId())){
					in.close();
					break;
				}
			}
		}catch (EOFException e){
			try{
				if(!ps.getId().equals(p.getId())){
					Person p0 = new Person();
					p0.setId("0");
					return p0;
				}else{
					return ps;
				}
			} catch(NullPointerException npe){
				Person p0 = new Person();
				p0.setId("0");
				return p0;
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return ps;
	}
	
	
	public Person sub(Person p){
		try {
			in = new ObjectInputStream(new FileInputStream(file));
			ps = new Person();
			al = new ArrayList<Person>();
			al2 = new ArrayList<Person>();
			while(true){
				ps = (Person) in.readObject();
				if(ps.getId().equals(p.getId())){
					al2.add(ps);
					continue;
				}else{
					al.add(ps);
					al2.add(ps);
				}
			}
		}catch (EOFException e){
			try {
				in.close();
				if(al.size() == al2.size()){
					Person p0 = new Person();
					p0.setId("0");
					return p0;
				}
				if(al.size() == 0){ //如果是删除文本中最后一个对象，则清空。
					out = new ObjectOutputStream(new FileOutputStream(file,false));
					out.write(new String("").getBytes());
					return p;
				}
				for(int i =0;i< al.size(); i++){
					if(i == 0){
						out = new ObjectOutputStream(new FileOutputStream(file,false));							
					}else{
						out = new MyObjectOutputStream(new FileOutputStream(file,true));
					}
					out.writeObject(al.get(i));
				}
				out.flush();
				out.close();
				} catch (FileNotFoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return p;

	}
	
	public ArrayList sort(){
		try {
			in = new ObjectInputStream(new FileInputStream(file));
			ps = new Person();
			al = new ArrayList<Person>();
			while(true){
				ps = (Person) in.readObject();
				al.add(ps);
			}
		} catch(EOFException e){ 
			try {
				in.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
	}
	
	
}
