import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		Test test = new Test();
	}
	
	public Test() {
		Initialize();
	}
	
	void Initialize() {
		JFrame frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//frame.setUndecorated(true);
		frame.setVisible(true);
	}
}
