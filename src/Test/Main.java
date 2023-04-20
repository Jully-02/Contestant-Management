package Test;

import javax.swing.UIManager;

import View.ContestantManagementView;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new ContestantManagementView();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
