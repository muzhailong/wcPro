package com.ui;
import java.io.File;
import javax.swing.JFileChooser;

public class WordSelector {
	JFileChooser jfc = new JFileChooser();// 文件选择器

	public WordSelector() {// 设置界面ui
		jfc.setCurrentDirectory(new File("c:\\"));
		
	}
	
	public File select() {
		jfc.setFileSelectionMode(0);
		int state = jfc.showOpenDialog(null);
		if (state == 1) {// 取消
			return null;
		} else {
			return jfc.getSelectedFile();
		}
	}
}