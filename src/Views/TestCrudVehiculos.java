package Views;

import javax.swing.JFrame;

public class TestCrudVehiculos extends JFrame {

	public TestCrudVehiculos() {

	}

	public static void main(String[] args) {

		ListViewVehiculos listview = new ListViewVehiculos();
		listview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listview.setLocationRelativeTo(null);
		listview.setVisible(true);
	}

}
