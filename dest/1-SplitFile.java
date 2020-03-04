/总长度
		long len = this.src.length();
		
		//块数：多少块
		this.size = (int)Math.ceil(len*1.0/blockSize);
	   //路径
		for (int i = 0; i < size; i++) {
			this.destPaths.add(this.destDir+"/"+i+"-"+this.src.getName());
		}
	}
	
	/*
	 * 分割
	 * 1、计算每一块的起始位置和大小
	 * 2、分割
	 * 
	 */
	public void split() throws IOException{
		//总长度
		long len = src.length();	
		//起始位置和实际大小
		int beginPos=0;
		int actualSize = (int)(blockSize>len?len:blockSize);
		for (int i = 0; i < size; i++) {
		beginPos = i*blockSize;
		if (i==size-1) {  //最后一块
				actualSize = (int)len;
			}else {
			actualSize =blockSize;
			len-=actualSize;  //剩余量		
			}
			System.out.println(i+"-->"+beginPos+"-->"+actualSize);
		    splitDetail(i,beginPos,actualSize);
			}		
	}
	
	/*
	 * 指定第i块的起始位置和实际长度
	 * 
	 * 
	 */
	
	
	//指定起始位置，读取剩余所有内容
	private void splitDetail(int i,int beginPos,int actualSize ) throws IOException {
		 RandomAccessFile raf =