 new RandomAccessFile(this.src,"r");
		 RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i),"rw");

		    //�����ȡ
		    raf.seek(beginPos);
		    //��ȡ
		    //3���������ֶζ�ȡ��
		  		byte[] flush = new byte[1024*1];//��������
		  		int len =-1;//���ܳ���
		  		while ((len=raf.read(flush))!=-1) {
		  		  			if (actualSize>len) {  //��ȡ���ζ�ȡ����������
		  						raf2.write(flush,0,len);
		  		               actualSize -=len;
		  		  			}else {
		  						raf2.write(flush,0,actualSize);
		  						break;
		  					}
		  		}
		  		
		    raf2.close();
		    raf.close();
	}

	
/*
 * �ļ��ĺϲ�	
 */
	public void merge(String destPath) throws IOException {
	//�����
	OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
	Vector<InputStream> vi =new Vector<InputStream>();
	SequenceInputStream sis =null;
	
	//������
	for (int i = 0; i < destPaths.size(); i++) {
		vi.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));	