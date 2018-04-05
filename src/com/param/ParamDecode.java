package com.param;

import java.io.File;

public class ParamDecode {
	private String[]args;
	
	public ParamDecode(String[]args) {
		this.args=args;
	}
	
	public Options decode() {
		int len=args.length;
		Options op=new Options();
		if(len>1) {//error
			op.isErr=true;
			return op;
		}
		String s=args[0].trim();
		if(s.equals("-x")) {
			//图形界面
			op.isX=true;
		}else if(s.endsWith(".txt")) {
			if(!new File(s).exists()) {
				op.isErr=true;
				op.setFn("文件不存在！");
			}else {
				op.isConsole=true;
				op.setFn(s);
			}
		}else {
			//error
			op.isErr=true;
			op.setInfo("参数异常！");
		}
		return op;
	}
	
	public static class Options{
		public boolean isX;
		public boolean isConsole;
		public boolean isErr;
		private String fn;
		private String info;
		public void setFn(String fn) {
			this.fn=fn;
		}
		public String getFn() {
			return fn;
		}
		
		public String getInfo() {
			return info;
		}
		
		public void setInfo(String info) {
			this.info=info;
		}
	}
}
