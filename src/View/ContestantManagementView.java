package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Contestant;
import Model.ContestantManagement;
import Model.Province;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controller.ContestantManagementController;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class ContestantManagementView extends JFrame {
	private JPanel contentPane;
	public ContestantManagement contestantManagement;
	public JTextField jTextFieldIdentifier;
	public JTextField jTextFieldIDIF;
	public JTextField jTextFieldNameIF;
	public JTextField jTextFieldDateIF;
	public JTextField jTextFieldEnglish;
	public JTextField jTextFieldLiterature;
	public JTextField jTextFieldMath;
	public JComboBox jComboboxPlaceIF;
	public ButtonGroup ButtonGroupGender;
	public JTable jTable;
	public JRadioButton jRadioButtonMale;
	public JRadioButton jRadioButtonFemale;
	private JComboBox jComboboxPlace;
	private JLabel jLabelErrorID;
	private JLabel jLabelErrorMath;
	private JLabel jLabelErrorName;
	private JLabel jLabelErrorLite;
	private JLabel jLabelErrorPlace;
	private JLabel jLabelErrorEnglish;
	private JLabel jLabelErrorDate;
	private JLabel jLabelErrorGender;

	public ContestantManagementView() {
		this.contestantManagement = new ContestantManagement();

		ActionListener ac = new ContestantManagementController(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 750);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		Font fontMenu = new Font("Arival", Font.PLAIN, 13);

		JMenu jMenuFile = new JMenu("File");
		jMenuFile.setFont(fontMenu);
		menuBar.add(jMenuFile);

		JMenuItem jMenuItemOpen = new JMenuItem("Open File");
		jMenuItemOpen.setFont(fontMenu);
		jMenuItemOpen.addActionListener(ac);
		jMenuFile.add(jMenuItemOpen);

		JMenuItem jMenuItemSave = new JMenuItem("Save File");
		jMenuItemSave.setFont(new Font("Arial", Font.PLAIN, 13));
		jMenuItemSave.addActionListener(ac);
		jMenuFile.add(jMenuItemSave);

		jMenuFile.addSeparator();

		JMenuItem jMenuItemExit = new JMenuItem("Exit");
		jMenuItemExit.setFont(fontMenu);
		jMenuItemExit.addActionListener(ac);
		jMenuFile.add(jMenuItemExit);

		JMenu jMenuAbout = new JMenu("About");
		jMenuAbout.setFont(fontMenu);
		menuBar.add(jMenuAbout);

		JMenuItem jMenuItemAboutMe = new JMenuItem("About Me");
		jMenuItemAboutMe.setFont(fontMenu);
		jMenuItemAboutMe.addActionListener(ac);
		jMenuAbout.add(jMenuItemAboutMe);

		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel jPanelFillter = new JPanel();
		jPanelFillter.setBounds(10, 34, 666, 72);
		jPanelFillter.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(jPanelFillter);
		jPanelFillter.setLayout(null);

		JLabel jLabelHomeTown = new JLabel("Place:");
		jLabelHomeTown.setFont(new Font("Arial", Font.BOLD, 13));
		jLabelHomeTown.setBounds(20, 26, 83, 24);
		jPanelFillter.add(jLabelHomeTown);

		JLabel jLabelIdentifier = new JLabel("Identifier:");
		jLabelIdentifier.setFont(new Font("Arial", Font.BOLD, 13));
		jLabelIdentifier.setBounds(292, 26, 64, 24);
		jPanelFillter.add(jLabelIdentifier);

		jTextFieldIdentifier = new JTextField();
		jTextFieldIdentifier.setFont(new Font("Arial", Font.PLAIN, 12));
		jTextFieldIdentifier.setColumns(10);
		jTextFieldIdentifier.setBounds(364, 24, 186, 29);
		jPanelFillter.add(jTextFieldIdentifier);

		JButton jButtonFilter = new JButton("Filter");
		jButtonFilter.addActionListener(ac);
		jButtonFilter.setFont(new Font("Arial", Font.BOLD, 13));
		jButtonFilter.setBounds(571, 26, 73, 24);
		jPanelFillter.add(jButtonFilter);

		jComboboxPlace = new JComboBox();
		ArrayList<Province> listProvince = Province.getListProvince();
		jComboboxPlace.addItem("");
		for (Province province : listProvince) {
			jComboboxPlace.addItem(province.getProvinceName());
		}
		jComboboxPlace.setFont(new Font("Arial", Font.PLAIN, 12));
		jComboboxPlace.setBounds(70, 24, 187, 29);
		jPanelFillter.add(jComboboxPlace);

		jTable = new JTable();
		jTable.setFont(new Font("Arial", Font.PLAIN, 12));
		jTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "No", "ID", "Name", "Place", "Date",
				"Gender", "Math Score", "Literature Score", "English Score" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class, Object.class,
					Object.class, Object.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		jTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		jTable.getColumnModel().getColumn(2).setPreferredWidth(103);
		jTable.getColumnModel().getColumn(4).setPreferredWidth(83);
		jTable.getColumnModel().getColumn(5).setPreferredWidth(67);
		jTable.getColumnModel().getColumn(6).setPreferredWidth(66);
		jTable.getColumnModel().getColumn(7).setPreferredWidth(84);

		jTable.setRowHeight(20);

		JScrollPane scrollPane = new JScrollPane(jTable);
		scrollPane.setBounds(10, 143, 666, 197);
		contentPane.add(scrollPane);

		JPanel jPanelInfomation = new JPanel();
		jPanelInfomation.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jPanelInfomation.setBounds(10, 373, 666, 203);
		contentPane.add(jPanelInfomation);
		jPanelInfomation.setLayout(null);

		JLabel jLabelIDIF = new JLabel("Identifier");
		jLabelIDIF.setFont(new Font("Arial", Font.BOLD, 13));
		jLabelIDIF.setBounds(30, 14, 64, 13);
		jPanelInfomation.add(jLabelIDIF);

		jTextFieldIDIF = new JTextField();
		jTextFieldIDIF.setFont(new Font("Arial", Font.PLAIN, 12));
		jTextFieldIDIF.setBounds(110, 7, 162, 27);
		jPanelInfomation.add(jTextFieldIDIF);
		jTextFieldIDIF.setColumns(10);

		JLabel jLabelNameIF = new JLabel("Name");
		jLabelNameIF.setFont(new Font("Arial", Font.BOLD, 13));
		jLabelNameIF.setBounds(30, 62, 64, 13);
		jPanelInfomation.add(jLabelNameIF);

		jTextFieldNameIF = new JTextField();
		jTextFieldNameIF.setFont(new Font("Arial", Font.PLAIN, 12));
		jTextFieldNameIF.setColumns(10);
		jTextFieldNameIF.setBounds(110, 55, 162, 27);
		jPanelInfomation.add(jTextFieldNameIF);

		JLabel jLabelPlaceIF = new JLabel("Place");
		jLabelPlaceIF.setFont(new Font("Arial", Font.BOLD, 13));
		jLabelPlaceIF.setBounds(30, 112, 64, 13);
		jPanelInfomation.add(jLabelPlaceIF);

		JLabel jLabelDateIF = new JLabel("Date");
		jLabelDateIF.setFont(new Font("Arial", Font.BOLD, 13));
		jLabelDateIF.setBounds(30, 161, 64, 13);
		jPanelInfomation.add(jLabelDateIF);

		jTextFieldDateIF = new JTextField();
		jTextFieldDateIF.setFont(new Font("Arial", Font.PLAIN, 12));
		jTextFieldDateIF.setColumns(10);
		jTextFieldDateIF.setBounds(110, 154, 162, 27);
		jPanelInfomation.add(jTextFieldDateIF);

		JLabel jLabelGender = new JLabel("Gender");
		jLabelGender.setFont(new Font("Arial", Font.BOLD, 13));
		jLabelGender.setBounds(390, 161, 64, 13);
		jPanelInfomation.add(jLabelGender);

		JLabel jLabelEnglish = new JLabel("English");
		jLabelEnglish.setFont(new Font("Arial", Font.BOLD, 13));
		jLabelEnglish.setBounds(391, 111, 64, 13);
		jPanelInfomation.add(jLabelEnglish);

		jTextFieldEnglish = new JTextField();
		jTextFieldEnglish.setFont(new Font("Arial", Font.PLAIN, 12));
		jTextFieldEnglish.setColumns(10);
		jTextFieldEnglish.setBounds(471, 104, 162, 27);
		jPanelInfomation.add(jTextFieldEnglish);

		jTextFieldLiterature = new JTextField();
		jTextFieldLiterature.setFont(new Font("Arial", Font.PLAIN, 12));
		jTextFieldLiterature.setColumns(10);
		jTextFieldLiterature.setBounds(471, 55, 162, 27);
		jPanelInfomation.add(jTextFieldLiterature);

		JLabel jLabelLiterature = new JLabel("Literature");
		jLabelLiterature.setFont(new Font("Arial", Font.BOLD, 13));
		jLabelLiterature.setBounds(391, 62, 64, 13);
		jPanelInfomation.add(jLabelLiterature);

		JLabel jLabelMath = new JLabel("Math");
		jLabelMath.setFont(new Font("Arial", Font.BOLD, 13));
		jLabelMath.setBounds(391, 14, 64, 13);
		jPanelInfomation.add(jLabelMath);

		jTextFieldMath = new JTextField();
		jTextFieldMath.setFont(new Font("Arial", Font.PLAIN, 12));
		jTextFieldMath.setColumns(10);
		jTextFieldMath.setBounds(471, 7, 162, 27);
		jPanelInfomation.add(jTextFieldMath);

		ButtonGroupGender = new ButtonGroup();

		jRadioButtonMale = new JRadioButton("Male");
		jRadioButtonMale.setFont(new Font("Arial", Font.BOLD, 12));
		jRadioButtonMale.setBounds(470, 157, 64, 21);
		jPanelInfomation.add(jRadioButtonMale);
		ButtonGroupGender.add(jRadioButtonMale);

		jRadioButtonFemale = new JRadioButton("Female");
		jRadioButtonFemale.setFont(new Font("Arial", Font.BOLD, 12));
		jRadioButtonFemale.setBounds(562, 157, 79, 21);
		jPanelInfomation.add(jRadioButtonFemale);
		ButtonGroupGender.add(jRadioButtonFemale);

		jComboboxPlaceIF = new JComboBox();
		jComboboxPlaceIF.addItem("");
		for (Province province : listProvince) {
			jComboboxPlaceIF.addItem(province.getProvinceName());
		}
		jComboboxPlaceIF.setFont(new Font("Arial", Font.PLAIN, 12));
		jComboboxPlaceIF.setBounds(110, 104, 162, 27);
		jPanelInfomation.add(jComboboxPlaceIF);

		jLabelErrorID = new JLabel("");
		jLabelErrorID.setFont(new Font("Arial", Font.ITALIC, 11));
		jLabelErrorID.setBounds(110, 38, 162, 13);
		jPanelInfomation.add(jLabelErrorID);

		jLabelErrorMath = new JLabel("");
		jLabelErrorMath.setFont(new Font("Arial", Font.ITALIC, 11));
		jLabelErrorMath.setBounds(471, 39, 162, 13);
		jPanelInfomation.add(jLabelErrorMath);

		jLabelErrorName = new JLabel("");
		jLabelErrorName.setFont(new Font("Arial", Font.ITALIC, 11));
		jLabelErrorName.setBounds(110, 86, 162, 13);
		jPanelInfomation.add(jLabelErrorName);

		jLabelErrorLite = new JLabel("");
		jLabelErrorLite.setFont(new Font("Arial", Font.ITALIC, 11));
		jLabelErrorLite.setBounds(471, 87, 162, 13);
		jPanelInfomation.add(jLabelErrorLite);

		jLabelErrorPlace = new JLabel("");
		jLabelErrorPlace.setFont(new Font("Arial", Font.ITALIC, 11));
		jLabelErrorPlace.setBounds(111, 136, 162, 13);
		jPanelInfomation.add(jLabelErrorPlace);

		jLabelErrorEnglish = new JLabel("");
		jLabelErrorEnglish.setFont(new Font("Arial", Font.ITALIC, 11));
		jLabelErrorEnglish.setBounds(471, 136, 162, 13);
		jPanelInfomation.add(jLabelErrorEnglish);

		jLabelErrorDate = new JLabel("");
		jLabelErrorDate.setFont(new Font("Arial", Font.ITALIC, 11));
		jLabelErrorDate.setBounds(111, 185, 162, 13);
		jPanelInfomation.add(jLabelErrorDate);

		jLabelErrorGender = new JLabel("");
		jLabelErrorGender.setFont(new Font("Arial", Font.ITALIC, 11));
		jLabelErrorGender.setBounds(472, 184, 162, 13);
		jPanelInfomation.add(jLabelErrorGender);

		JPanel jPanelController = new JPanel();
		jPanelController.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jPanelController.setBounds(10, 619, 666, 60);
		contentPane.add(jPanelController);
		jPanelController.setLayout(null);

		JButton jButtonInsert = new JButton("Insert");
		jButtonInsert.setFont(new Font("Arial", Font.BOLD, 12));
		jButtonInsert.setBounds(10, 10, 101, 40);
		jButtonInsert.addActionListener(ac);
		jPanelController.add(jButtonInsert);

		JButton jButtonDelete = new JButton("Delete");
		jButtonDelete.setFont(new Font("Arial", Font.BOLD, 12));
		jButtonDelete.setBounds(144, 10, 101, 40);
		jButtonDelete.addActionListener(ac);
		jPanelController.add(jButtonDelete);

		JButton jButtonUpdate = new JButton("Update");
		jButtonUpdate.setFont(new Font("Arial", Font.BOLD, 12));
		jButtonUpdate.setBounds(280, 10, 101, 40);
		jButtonUpdate.addActionListener(ac);
		jPanelController.add(jButtonUpdate);

		JButton jButtonSave = new JButton("Save");
		jButtonSave.setFont(new Font("Arial", Font.BOLD, 12));
		jButtonSave.setBounds(419, 10, 101, 40);
		jButtonSave.addActionListener(ac);
		jPanelController.add(jButtonSave);

		JButton jButtonCancel = new JButton("Cancel");
		jButtonCancel.setFont(new Font("Arial", Font.BOLD, 12));
		jButtonCancel.setBounds(555, 10, 101, 40);
		jButtonCancel.addActionListener(ac);
		jPanelController.add(jButtonCancel);

		JLabel jLabelContestantFillter = new JLabel("Contestant Fillter");
		jLabelContestantFillter.setFont(new Font("Arial", Font.BOLD, 15));
		jLabelContestantFillter.setBounds(10, 11, 135, 13);
		contentPane.add(jLabelContestantFillter);

		JLabel jLabelListContestant = new JLabel("List Contestant");
		jLabelListContestant.setFont(new Font("Arial", Font.BOLD, 15));
		jLabelListContestant.setBounds(10, 116, 119, 13);
		contentPane.add(jLabelListContestant);

		JLabel jLabelContestantIF = new JLabel("Contestant Information");
		jLabelContestantIF.setFont(new Font("Arial", Font.BOLD, 15));
		jLabelContestantIF.setBounds(10, 350, 170, 13);
		contentPane.add(jLabelContestantIF);

		JLabel jLabelController = new JLabel("Controller");
		jLabelController.setFont(new Font("Arial", Font.BOLD, 15));
		jLabelController.setBounds(10, 592, 85, 13);
		contentPane.add(jLabelController);

		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	public boolean checkDataInformation() {
		int countError = 0;
		if (this.jTextFieldIDIF.getText().length() != 10) {
			this.jLabelErrorID.setText("Please enter all 10 characters.");
			this.jLabelErrorID.setForeground(Color.RED);
			countError++;
		} else {
			this.jLabelErrorID.setText("");
		}

		if (this.jTextFieldNameIF.getText().length() == 0) {
			this.jLabelErrorName.setText("Can't be left blank.");
			this.jLabelErrorName.setForeground(Color.RED);
			countError++;
		} else {
			this.jLabelErrorName.setText("");
		}

//		if (!isValidDate(this.jLabelErrorDate.getText())) {
//			this.jLabelErrorDate.setText("Format \"dd/mm/yyy\".");
//			this.jLabelErrorDate.setForeground(Color.RED);
//			countError++;
//		} else {
//			this.jLabelErrorDate.setText("");
//		}

		if (Integer.valueOf(this.jTextFieldMath.getText()) < 0 || Integer.valueOf(this.jTextFieldMath.getText()) > 10) {
			this.jLabelErrorMath.setText("Invalid score!");
			this.jLabelErrorMath.setForeground(Color.RED);
			countError++;
		} else {
			this.jLabelErrorMath.setText("");
		}

		if (Integer.valueOf(this.jTextFieldLiterature.getText()) < 0 || Integer.valueOf(this.jTextFieldLiterature.getText()) > 10) {
			this.jLabelErrorLite.setText("Invalid score!");
			this.jLabelErrorLite.setForeground(Color.RED);
			countError++;
		} else {
			this.jLabelErrorLite.setText("");
		}

		if (Integer.valueOf(this.jTextFieldEnglish.getText()) < 0 || Integer.valueOf(this.jTextFieldEnglish.getText()) > 10) {
			this.jLabelErrorEnglish.setText("Invalid score!");
			this.jLabelErrorEnglish.setForeground(Color.RED);
			countError++;
		} else {
			this.jLabelErrorEnglish.setText("");
		}

		if (this.jRadioButtonMale.isSelected() == false && this.jRadioButtonFemale.isSelected() == false) {
			this.jLabelErrorGender.setText("You haven't chosen a gender.");
			this.jLabelErrorGender.setForeground(Color.RED);
			countError++;
		} else {
			this.jLabelErrorGender.setText("");
		}

		if (this.jComboboxPlaceIF.getSelectedIndex() == -1) {
			this.jLabelErrorPlace.setText("You haven't chosen a hometown.");
			this.jLabelErrorPlace.setForeground(Color.RED);
			countError++;
		} else {
			this.jLabelErrorPlace.setText("");
		}

		if (countError == 0) {
			return true;
		}
		return false;
	}

	public void refreshError() {
		this.jLabelErrorDate.setText("");
		this.jLabelErrorEnglish.setText("");
		this.jLabelErrorGender.setText("");
		this.jLabelErrorID.setText("");
		this.jLabelErrorLite.setText("");
		this.jLabelErrorMath.setText("");
		this.jLabelErrorName.setText("");
		this.jLabelErrorPlace.setText("");
	}

	public void refreshFormInformation() {
		jTextFieldIDIF.setText("");
		jTextFieldIDIF.setEditable(true);
		jTextFieldNameIF.setText("");
		jTextFieldDateIF.setText("");
		jTextFieldMath.setText("");
		jTextFieldLiterature.setText("");
		jTextFieldEnglish.setText("");
		jComboboxPlaceIF.setSelectedIndex(-1);
		ButtonGroupGender.clearSelection();
		refreshError();
	}

	public void insertAContestantIntoTable(Contestant contestant) {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		String dob = contestant.getDob().getDate() + "/" + (contestant.getDob().getMonth()) + "/"
				+ (contestant.getDob().getYear());
		int rowCount = tableModel.getRowCount() + 1;
		String gender = "Male";
		if (!contestant.getGender()) {
			gender = "Female";
		}
		tableModel.addRow(new Object[] { rowCount + "", contestant.getIdentifier(), contestant.getName(),
				contestant.getHomeTown().getProvinceName(), dob, gender, contestant.getMathScore(),
				contestant.getLiteratureScore(), contestant.getEnglishScore() });
	}

	public void insertOrUpdateContestant(Contestant contestant) {
		if (this.contestantManagement.isExist(contestant) == false) {
			if (checkDataInformation() == true) {
				this.contestantManagement.insertContestant(contestant);
				this.insertAContestantIntoTable(contestant);
			} else {
				JOptionPane.showMessageDialog(this, "Please Enter The Correct Information!");
			}
		} else {
			if (checkDataInformation() == true) {
				DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
				this.contestantManagement.updateInformationOfContestant(contestant);
				int rowCount = tableModel.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					String id = tableModel.getValueAt(i, 1) + "";
					if (id.equals(contestant.getIdentifier())) {
						String dob = contestant.getDob().getDate() + "/" + (contestant.getDob().getMonth()) + "/"
								+ (contestant.getDob().getYear());
						String gender = "Male";
						if (contestant.getGender() == false) {
							gender = "Female";
						}
						tableModel.setValueAt(contestant.getIdentifier(), i, 1);
						tableModel.setValueAt(contestant.getName(), i, 2);
						tableModel.setValueAt(contestant.getHomeTown().getProvinceName(), i, 3);
						tableModel.setValueAt(dob, i, 4);
						tableModel.setValueAt(gender, i, 5);
						tableModel.setValueAt(contestant.getMathScore(), i, 6);
						tableModel.setValueAt(contestant.getLiteratureScore(), i, 7);
						tableModel.setValueAt(contestant.getEnglishScore(), i, 8);
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Please Enter The Correct Information!");
			}
		}
	}

	public Contestant getSelectedInformationContestant() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		int row = jTable.getSelectedRow();
		String identifier = tableModel.getValueAt(row, 1) + "";
		String name = tableModel.getValueAt(row, 2) + "";
		Province province = Province.getProvinceByName(tableModel.getValueAt(row, 3) + "");
		StringTokenizer dobText = new StringTokenizer(tableModel.getValueAt(row, 4) + "", "/");
		Date dob = new Date(0, 0, 0);
		int count = 0;
		while (dobText.hasMoreElements()) {
			int x = Integer.valueOf(dobText.nextToken());
			if (count == 0) {
				dob.setDate(x);
			} else if (count == 1) {
				dob.setMonth(x);
			} else {
				dob.setYear(x);
				break;
			}
			count++;
		}
		String selectGender = tableModel.getValueAt(row, 5) + "";
		boolean gender = true;
		if (selectGender.equals("Female")) {
			gender = false;
		}
		float mathScore = Float.valueOf(tableModel.getValueAt(row, 6) + "");
		float literatureScore = Float.valueOf(tableModel.getValueAt(row, 7) + "");
		float englishScore = Float.valueOf(tableModel.getValueAt(row, 8) + "");

		Contestant contestant = new Contestant(identifier, name, province, dob, gender, mathScore, literatureScore,
				englishScore);
		return contestant;
	}

	public void showSelectedContestantInfomation() {
		Contestant contestant = getSelectedInformationContestant();
		this.jTextFieldIDIF.setText(contestant.getIdentifier());
		jTextFieldIDIF.setEditable(false);
		this.jTextFieldNameIF.setText(contestant.getName());
		this.jComboboxPlaceIF.setSelectedItem(contestant.getHomeTown().getProvinceName());
		String dob = contestant.getDob().getDate() + "/" + (contestant.getDob().getMonth()) + "/"
				+ (contestant.getDob().getYear());
		this.jTextFieldDateIF.setText(dob);
		this.jTextFieldMath.setText(contestant.getMathScore() + "");
		this.jTextFieldLiterature.setText(contestant.getLiteratureScore() + "");
		this.jTextFieldEnglish.setText(contestant.getEnglishScore() + "");
		if (contestant.getGender()) {
			jRadioButtonMale.setSelected(true);
		} else {
			jRadioButtonFemale.setSelected(true);
		}

	}

	public void deleteContestant() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		int row = jTable.getSelectedRow();
		int chooser = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected information?");
		if (chooser == JOptionPane.YES_OPTION) {
			Contestant contestant = getSelectedInformationContestant();
			this.contestantManagement.deleteContestant(contestant);
			tableModel.removeRow(row);
		} else {

		}

	}

	public Contestant getDataFromFormInformation() {
		// Get Data From Form Information
		String identifier = this.jTextFieldIDIF.getText();
		String name = this.jTextFieldNameIF.getText();
		int homeTownCode = this.jComboboxPlaceIF.getSelectedIndex() - 1;
		Province province = Province.getProvinceByCode(homeTownCode);
		StringTokenizer dobText = new StringTokenizer(this.jTextFieldDateIF.getText(), "/");
		Date dob = new Date(0, 0, 0);
		int count = 0;
		while (dobText.hasMoreElements()) {
			int x = Integer.valueOf(dobText.nextToken());
			if (count == 0) {
				dob.setDate(x);
			} else if (count == 1) {
				dob.setMonth(x);
			} else {
				dob.setYear(x);
				break;
			}
			count++;
		}
		boolean gender = this.jRadioButtonMale.isSelected();
		float mathScore = Float.valueOf(this.jTextFieldMath.getText());
		float literatureScore = Float.valueOf(this.jTextFieldLiterature.getText());
		float englishScore = Float.valueOf(this.jTextFieldEnglish.getText());

		Contestant contestant = new Contestant(identifier, name, province, dob, gender, mathScore, literatureScore,
				englishScore);
		return contestant;
	}

	public void refreshTableInformation() {
		while (true) {
			DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
			int rowCount = tableModel.getRowCount();
			if (rowCount == 0) {
				break;
			}
			tableModel.removeRow(0);
		}
		for (Contestant contestant : this.contestantManagement.getContestantList()) {
			this.insertAContestantIntoTable(contestant);
		}
	}

	public void filterContestant() {
		// Perform refresh table information
		refreshTableInformation();

		// Perform Information Filtering
		int provinceCode = this.jComboboxPlace.getSelectedIndex() - 1;
		String identifier = this.jTextFieldIdentifier.getText();
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		int rowCount = tableModel.getRowCount();
		Set<String> contestantIDToHide = new TreeSet<String>();
		if (provinceCode > 0) {
			Province province = Province.getProvinceByCode(provinceCode);
			for (int i = 0; i < rowCount; i++) {
				String provinceName = tableModel.getValueAt(i, 3) + "";
				String id = tableModel.getValueAt(i, 1) + "";
				if (!provinceName.equals(province.getProvinceName())) {
					contestantIDToHide.add(id);
				}
			}
		}
		if (identifier.length() > 0) {
			for (int i = 0; i < rowCount; i++) {
				String id = tableModel.getValueAt(i, 1) + "";
				if (!identifier.equals(id)) {
					contestantIDToHide.add(id);
				}
			}
		}

		for (String id : contestantIDToHide) {
			rowCount = tableModel.getRowCount();
			for (int i = 0; i < rowCount; i++) {
				String identifierInTable = tableModel.getValueAt(i, 1) + "";
				if (id.equals(identifierInTable)) {
					tableModel.removeRow(i);
					break;
				}
			}
		}
	}

	public void aboutMe() {
		JOptionPane.showMessageDialog(this, "The Software Is Developed By Jully. Version 1.0");
	}

	public void exit() {
		int choose = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the program?", "Exit",
				JOptionPane.YES_NO_OPTION);
		if (choose == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	public void save(String pathFile) {
		try {
			this.contestantManagement.setFileName(pathFile);
			FileOutputStream fos = new FileOutputStream(pathFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Contestant contestant : this.contestantManagement.getContestantList()) {
				oos.writeObject(contestant);
			}
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void saveFile() {
		if (this.contestantManagement.getFileName().length() > 0) {
			save(this.contestantManagement.getFileName());
		} else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				save(file.getAbsolutePath());
			}
		}

	}

	public void open(File file) {
		ArrayList<Contestant> contestantList = new ArrayList<Contestant>();
		try {
			this.contestantManagement.setFileName(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Contestant contestant = null;
			while ((contestant = (Contestant) ois.readObject()) != null) {
				contestantList.add(contestant);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.contestantManagement.setContestantList(contestantList);
	}

	public void openFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			open(file);
			refreshTableInformation();
			refreshFormInformation();
		}
	}
}
