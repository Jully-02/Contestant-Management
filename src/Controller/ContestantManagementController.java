package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import Model.Contestant;
import Model.Province;
import View.ContestantManagementView;

public class ContestantManagementController implements ActionListener{
	private ContestantManagementView contestantManagementView;
	
	public ContestantManagementController(ContestantManagementView contestantManagementView) {
		this.contestantManagementView = contestantManagementView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String controller = e.getActionCommand();
//		JOptionPane.showMessageDialog(this.contestantManagementView, "You Just Clicked The Button: " + controller);
		if (controller.equals("Insert")) {
			this.contestantManagementView.refreshFormInformation();
			this.contestantManagementView.contestantManagement.setSelection(controller);
		}
		else if (controller.equals("Delete")) {
			this.contestantManagementView.deleteContestant();
		}
		else if (controller.equals("Update")) {
			this.contestantManagementView.showSelectedContestantInfomation();
		}
		else if (controller.equals("Save")) {
			try {
				Contestant contestant = this.contestantManagementView.getDataFromFormInformation();
				this.contestantManagementView.insertOrUpdateContestant(contestant);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		else if (controller.equals("Cancel")) {
			this.contestantManagementView.refreshFormInformation();
			this.contestantManagementView.refreshTableInformation();
			
		}
		else if (controller.equals("Filter")) {
			this.contestantManagementView.filterContestant();
		}
		else if (controller.equals("About Me")) {
			this.contestantManagementView.aboutMe();
		}
		else if (controller.equals("Exit")) {
			this.contestantManagementView.exit();
		}
		else if (controller.equals("Save File")) {
			this.contestantManagementView.saveFile();
		}
		else if (controller.equals("Open File")) {
			this.contestantManagementView.openFile();
		}
	}
	
}
