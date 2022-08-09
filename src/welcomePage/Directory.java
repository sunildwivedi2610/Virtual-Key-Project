package welcomePage;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class Directory {
	//Directory Location
	public static final String name = "D:\\VirtualKey\\";
	private ArrayList<File> files = new ArrayList<File>();
	Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();
	File Dfiles = path.toFile();
	
	public String getName() {
		return name;
	}
	public void print() {
		System.out.println("Existing Files : ");
		files.forEach(f -> System.out.println(f));
	}
	public ArrayList<File> fillFiles(){
		File[] directoryFiles = Dfiles.listFiles();
		
		files.clear();
		for(int i=0;i<directoryFiles.length;i++) {
			if(directoryFiles[i].isFile()) {
				files.add(directoryFiles[i]);
			}
		}
		//Collections.sort method is sorting the elements of ArrayList in ascending order.
		Collections.sort(files);
		return files;
	}
	public ArrayList<File> getFiles(){
		fillFiles();
		return files;
	}
}
