package com.mukesh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MyMain implements Runnable{
	private static String fileInputPath = "C:\\Users\\mukesh\\Desktop\\enwik8.txt";
	private static int wc = 0;
	private int from = 0;
	private int to = 0;
	
	public MyMain(int from, int to) {
		this.from = from;
		this.to = to;
	}


	@Override
	public void run() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(fileInputPath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}   
		
		int line = 0;
		String s;
		
		//System.out.println(from+" "+to);
		int count = 0;
		try {
			while( (s = br.readLine()) != null) {
				line++;
				if(line >= from && line <= to) {
					String str = "";
				
					for(int i=0;i<s.length();i++) {
				  		  if(s.charAt(i) == ' ') {
				  			  if(!str.equals("")) {
				  				  //System.out.println(str);
				  				  count++;
				  			  }
				  			  
				  			  str = "";
				  		  }else {
				  			  str = str + s.charAt(i);
				  		  }
				  	}
					
					if(!str.equals("")) {
				  		  //System.out.println(str);
				  		  count++;
				  	}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
		wc = wc + count;
		
		
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new FileReader(new File(fileInputPath)));   
	  
	    
	    // n is core in this code
	    int core = 3;
	    
	    int line = 0;
	    while(br.readLine() !=null) {
	    	line++;
	    }
	    
	    System.out.println("Number of Threads: "+ core);
	    
	    System.out.println("Number of lines in the file: " +line);
	    
	    
	    int threadSize = line/core;
	    System.out.println("Approx No. of lines to be process by thread: "+threadSize);
	    
	    
	    long startTime = System.currentTimeMillis();
	    
	    Set<Thread> threadSet = new HashSet<>(core);
	    int from = 0;
	    int to = 0;
	    for(int i=0;i<core;i++) {
	    	if(i == core-1) {
	    		from = to + 1;
	    		to = line;
	    	}else {
	    		from = to + 1;
	    		to = to + threadSize;
	    	}
	    	
	    	Thread t = new Thread(new MyMain(from, to));
	    	t.start();
	    	threadSet.add(t);
	    }
	    
	    for(Thread t : threadSet) {
	    	t.join();
	    }
	    long endTime = System.currentTimeMillis();
	    
	    br.close();
	    System.out.println("Number of words in the file: " +wc);
	    System.out.println("time required to execute in sec = "+(endTime - startTime)/1000.0+"s");
	}
}
