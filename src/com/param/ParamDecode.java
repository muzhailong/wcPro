package com.param;

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
			op.isConsole=true;
			op.setFn(s);
		}else {
			//error
			op.isErr=true;
		}
		return op;
	}
	
	public static class Options{
		public boolean isX;
		public boolean isConsole;
		public boolean isErr;
		private String fn;
		public void setFn(String fn) {
			this.fn=fn;
		}
		public String getFn() {
			return fn;
		}
	}
}
