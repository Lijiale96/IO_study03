
	}
	sis = new SequenceInputStream(vi.elements());
		//����
		//3���������ֶζ�ȡ��
	byte[] flush = new byte[1024*1];//��������
    int len =-1;//���ܳ���
    while ((len=sis.read(flush))!=-1) {
	os.write(flush, 0,len);//3���������ֶ�д����
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
