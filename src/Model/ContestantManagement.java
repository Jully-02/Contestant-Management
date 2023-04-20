package Model;

import java.util.ArrayList;

public class ContestantManagement {
	private ArrayList<Contestant> contestantList;
	private String selection;
	private String fileName;

	public ContestantManagement () {
		this.contestantList = new ArrayList<Contestant>();
		this.selection = "";
		this.fileName = "";
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ContestantManagement(ArrayList<Contestant> contestantList) {
		this.contestantList = contestantList;
	}

	public ArrayList<Contestant> getContestantList() {
		return contestantList;
	}

	public void setContestantList(ArrayList<Contestant> contestantList) {
		this.contestantList = contestantList;
	}
	
	
	
	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	public void insertContestant (Contestant contestant) {
		this.contestantList.add(contestant);
	}
	
	public void deleteContestant (Contestant contestant) {
		for (Contestant ct : contestantList) {
			if (ct.getIdentifier().equals(contestant.getIdentifier())) {
				this.contestantList.remove(ct);
				break;
			}
		}
//		this.contestantList.remove(contestant);
	}
	
	public void updateInformationOfContestant (Contestant contestant) {
		this.deleteContestant(contestant);
		this.insertContestant(contestant);
	}

	public boolean isExist(Contestant contestant) {
		for (Contestant ct : contestantList) {
			if (ct.getIdentifier().equals(contestant.getIdentifier())) {
				return true;
			}
		}
		return false;
	}
	
}
