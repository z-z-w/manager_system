package text2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * ��дObjectOutputStream�࣬�������ı�׷�Ӷ���
 * @author ft
 *
 */
public class MyObjectOutputStream extends ObjectOutputStream{
	
	
	public MyObjectOutputStream(OutputStream os) throws IOException{
		super(os);
	}
	
	/*
	 * ��дwriteStreamHeader���������ı���д��header��Ϣ
	 */
	protected void writeStreamHeader() throws IOException{
		super.reset();
	}
	
}
