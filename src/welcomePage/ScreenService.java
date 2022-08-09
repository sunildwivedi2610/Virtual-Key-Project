package welcomePage;

public class ScreenService {
	public static Welcome Welcome = new Welcome();
	public static FileOption FileOptionScreen = new FileOption();
	
	public static Screen CurrentScreen = Welcome;
	
	public static Screen getCurrentScreen() {
		return CurrentScreen;
	}
	public static void setCurrentScreen(Screen currentScreen) {
		CurrentScreen = currentScreen;
	}
}
