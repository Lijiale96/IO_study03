/�ܳ���
		long len = this.src.length();
		
		//���������ٿ�
		this.size = (int)Math.ceil(len*1.0/blockSize);
	   //·��
		for (int i = 0; i < size; i++) {
			this.destPaths.add(this.destDir+"/"+i+"-"+this.src.getName());
		}
	}
	
	/*
	 * �ָ�
	 * 1������ÿһ�����ʼλ�úʹ�С
	 * 2���ָ�
	 * 
	 */
	public void split() throws IOException{
		//�ܳ���
		long len = src.length();	
		//��ʼλ�ú�ʵ�ʴ�С
		int beginPos=0;
		int actualSize = (int)(blockSize>len?len:blockSize);
		for (int i = 0; i < size; i++) {
		beginPos = i*blockSize;
		if (i==size-1) {  //���һ��
				actualSize = (int)len;
			}else {
			actualSize =blockSize;
			len-=actualSize;  //ʣ����		
			}
			System.out.println(i+"-->"+beginPos+"-->"+actualSize);
		    splitDetail(i,beginPos,actualSize);
			}		
	}
	
	/*
	 * ָ����i�����ʼλ�ú�ʵ�ʳ���
	 * 
	 * 
	 */
	
	
	//ָ����ʼλ�ã���ȡʣ����������
	private void splitDetail(int i,int beginPos,int actualSize ) throws IOException {
		 RandomAccessFile raf =