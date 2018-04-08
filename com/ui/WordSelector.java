package com.ui;
import java.io.File;
import javax.swing.JFileChooser;

/**
 * ui界面模块类
 * @author wangyuzhe
 *
 */
public class WordSelector {
	/**
	 * 文件选择器
	 */
	JFileChooser jfc = new JFileChooser();

	/**
	 * 设置界面ui
	 */
	public WordSelector() {
		jfc.setCurrentDirectory(new File("c:\\"));
		
	}
	
	/**
	 * @return 使用ui界面选择的文件
	 */
	public File select() {
		jfc.setFileSelectionMode(0);
		int state = jfc.showOpenDialog(null);
		if (state == 1) {
			return null;
		} else {
			return jfc.getSelectedFile();
		}
	}
}