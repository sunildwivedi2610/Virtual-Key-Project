package welcomePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileOption implements Screen {
	private Directory dir = new Directory();
	private ArrayList<String> options = new ArrayList<>();
	
	public FileOption() {
		options.add("\t1. Add File");
		options.add("\t2. Delete File");
		options.add("\t3. Search File");
		options.add("\t4. Return to Main Menu");
	}
	public void Show() {
		System.out.println("File Operation Menu");
		for(String s : options) {
			System.out.println(s);
		}
	}
	public void GetUserInput() {
		int selectedOption;
		while((selectedOption = this.getOption())!=4) {
			this.NavigateOption(selectedOption);
		}
	}
	@Override
	public void NavigateOption(int option) {
		switch(option) {
		case 1: 
			this.AddFile();
			this.Show();
			break;
		case 2:
			this.DeleteFile();
			this.Show();
			break;
		case 3:
			this.SearchFile();
			this.Show();
			break;
		case 4:
			ScreenService.setCurrentScreen(ScreenService.Welcome);
			ScreenService.getCurrentScreen().Show();
			ScreenService.getCurrentScreen().GetUserInput();
			break;
			
			default: 
				System.out.println("Invalid Option");
				break;
		}
	}
	//While selected Add File Option
	public void AddFile() {
		System.out.println("Please Enter the File name : ");
		String fileName = this.getInputString();
		System.out.println("You are adding a file "+fileName);
		try {
			Path path = FileSystems.getDefault().getPath(Directory.name+fileName).toAbsolutePath();
			File file = new File(dir.getName()+fileName);
			
			if(file.createNewFile()) {
				System.out.println("File created - "+file.getName());
				dir.getFiles().add(file);
				
			}
			else {
				System.out.println("File is Already Exist.");
			}
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	//While selected DeleteFile Option
	public void DeleteFile() {
		System.out.println("Please enter File name to Delete : ");
		String fileName = this.getInputString();
		System.out.println("You are deleting a file "+fileName);
		Path path =FileSystems.getDefault().getPath(Directory.name+fileName).toAbsolutePath();
		File file = path.toFile();
		if(file.delete()) {
			System.out.println(file.getName()+" Deleted");
			dir.getFiles().remove(file);
		}
		else {
			System.out.println("Failed to delete "+fileName+", file not found in directory");
		}
	}
	//While selected SearchFile Option
	public void SearchFile() {
		Boolean found = false;
		System.out.println("Enter file name to search : ");
		String fileName = this.getInputString();
		System.out.println("You are searching a "+fileName);
		ArrayList<File> files = dir.getFiles();
		for(int i=0;i<files.size();i++) {
			if(files.get(i).getName().equals(fileName)) {
				System.out.println("File found : "+fileName);
				found = true;
			}
		}
		if(found == false) {
			System.out.println("File not found.");
		}
	}
	private String getInputString() {
		Scanner sc = new Scanner(System.in);
		return(sc.nextLine());
	}
	private int getOption() {
		Scanner sc = new Scanner(System.in);
		int returnOption = 0;
		try {
			returnOption = sc.nextInt();
		}
		catch(InputMismatchException ex) {
			System.out.println("Invalid input");
		}
		return returnOption;
	}
}
