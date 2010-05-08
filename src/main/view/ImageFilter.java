package main.view;

import java.io.File;
import javax.swing.filechooser.*;

public class ImageFilter extends FileFilter {

	public final static String jpeg = "jpeg";
	public final static String jpg = "jpg";
	public final static String gif = "gif";
	public final static String png = "png";

	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		String extension = getExtension(f);
		if (extension != null) {
			if (extension.equals(gif) || extension.equals(jpeg)
					|| extension.equals(jpg) || extension.equals(png)) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	public String getExtension(File file) {
		String extension = null;
		String fileName = file.getName();
		int i = fileName.lastIndexOf('.');

		if (i > 0 && i < fileName.length() - 1) {
			extension = fileName.substring(i + 1).toLowerCase();
		}
		return extension;
	}

	public String getDescription() {
		return "Only Images";
	}
}
