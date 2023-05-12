package Views;

import javax.swing.JFrame;

public class TestCrudVehiculos extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListViewVehiculos listview=new ListViewVehiculos();
		listview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listview.setLocationRelativeTo(null);
		listview.setVisible(true);
	}

}
