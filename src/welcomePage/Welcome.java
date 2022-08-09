package welcomePage;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Welcome implements Screen{
	private String appName = "Welcome to Virtual Key";
	private String devloperName = "Sunil Dwivedi";
	private ArrayList<String> options =new ArrayList<>();
	
	public Welcome() {
		options.add("1. Show Files");
		options.add("2. Show File Options Menu");
		options.add("3. Quit");
	}
	public void intro() {
		System.out.println(appName);
		System.out.println("Developer : "+devloperName);
		System.out.println();
		Show();
	}
	//Override the Show method which is under Screen 
	@Override
	public void Show() {
		System.out.println("Main Menu");
		for(String s : options) {
			System.out.println(s);
		}
	}
	public void GetUserInput() {
		int selectedOption = 0;
		while((selectedOption = this.getOption())!=3) {
			this.NavigateOption(selectedOption);
		}
	}
	@Override
	public void NavigateOption(int option) {
		switch(option) {
		//list files directory
		case 1:
			this.ShowFiles();
			this.Show();
			break;
			//Show File SubMenu
		case 2:
			ScreenService.setCurrentScreen(ScreenService.FileOptionScreen);
			ScreenService.getCurrentScreen().Show();
			ScreenService.getCurrentScreen().GetUserInput();
			this.Show();
			break;
			default:
				System.out.println("Invalid Option");
				break;
		}
	}
	//List Directory files
	public void ShowFiles() {
		System.out.println("List of Files : ");
		DirectoryService.PrintFiles();
	}
	private int getOption() {
		Scanner sc = new Scanner(System.in);
		int returnOption = 0;
		try {
			returnOption = sc.nextInt();
		}
		catch(InputMismatchException ex) {
		}
		return returnOption;
	}
}
