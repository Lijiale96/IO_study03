
	}
	sis = new SequenceInputStream(vi.elements());
		//拷贝
		//3、操作（分段读取）
	byte[] flush = new byte[1024*1];//缓冲容器
    int len =-1;//接受长度
    while ((len=sis.read(flush))!=-1) {
	os.write(flush, 0,len);//3、操作（分段写出）
				}
	os.flush();
	sis.close();
	os.close();
	}
	
public static void main(String[] args) throws IOException {
	 SplitFile sf = new SplitFile("src/com/sxt/io/SplitFile.java","dest",1024);
	 sf.split();
	 sf.merge("aaa.java");
}	
}
