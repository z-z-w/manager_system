package text2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 重写ObjectOutputStream类，用于在文本追加对象
 * @author ft
 *
 */
public class MyObjectOutputStream extends ObjectOutputStream{
	
	
	public MyObjectOutputStream(OutputStream os) throws IOException{
		super(os);
	}
	
	/*
	 * 重写writeStreamHeader方法，让文本不写入header信息
	 */
	protected void writeStreamHeader() throws IOException{
		super.reset();
	}
	
}
