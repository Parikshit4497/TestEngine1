package com.brainmentors.testengine.user.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import com.brainmentors.testengine.user.dto.RegisterDTO;
import com.brainmentors.testengine.user.dto.UserDTO;
import com.brainmentors.testengine.user.view.dao.UserDao;
import com.brainmentors.testengine.util.constants.Authentication;
import com.brainmentors.testengine.util.constants.Offline;
import com.toedter.calendar.JCalendar;
import java.awt.GridLayout;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class RegisterWindow extends JFrame {
  
	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField emailID;
	private JTextField phoneNo;
	private String confirmPassword;
	private JTextField password;
	private String Gender;
	private String isChar;
	private String checkEmail1;
	private String isCorrect;
	private String CheckPassword;
	private String  ConfirmPass;
	JRadioButton Male_Selected;
	JRadioButton Female_Selected;
	Authentication auth=new Authentication();
	/**
	 * Launch the application.
	 */
	UserDTO registerDTO=new UserDTO();
	private JLabel pass_check;
	private JPasswordField passwordField;
	private JPasswordField password_format;
	private JPasswordField password_confirm;
	private JPasswordField password_form;
	private JTextField IdText;
	private JTextField userIdText;
	private String date;
	JComboBox cityChooser;
	JComboBox collegeChooser ;
	JComboBox User_Type;
	JDateChooser dateChooser;
	static RegisterWindow frame ;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new RegisterWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public   void  goBackLogin() {
		this.setVisible(false);
		this.dispose();
		LoginView loginWindow=new LoginView();
		loginWindow.setVisible(true);
		
	}
	public void checkOffline() {
		try {
		UserDTO userdto=Offline.readObj();
		
		if(userdto!=null) {
		firstName.setText(userdto.getFirstName());
		lastName.setText(userdto.getLastName());
		if(userdto.getGender()=="Male") {
			Male_Selected.setSelected(true);
		}else{
			Female_Selected.setSelected(true);
		}
		cityChooser.setSelectedItem(userdto.getSelectCity());
		emailID.setText(userdto.getCollegId());
	    phoneNo.setText(userdto.getPhoneNO());
	    collegeChooser.setSelectedItem(userdto.getSelectCity());
	    IdText.setText(userdto.getCollegId());
	    userIdText.setText(userdto.getCollegId());
	    User_Type.setSelectedItem(userdto.getSelectUsertype());
	    password_form.setText(userdto.getPassword());
	    password_confirm.setText(userdto.getConfirmPassword());
		 }
		}
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public RegisterWindow() {
		checkOffline();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel email_format = new JLabel(" ");
		email_format.setHorizontalAlignment(SwingConstants.LEFT);
		email_format.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		email_format.setBounds(714, 173, 246, 24);
		contentPane.add(email_format);
		
		JLabel phone_format = new JLabel("");
		phone_format.setHorizontalAlignment(SwingConstants.CENTER);
		phone_format.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		phone_format.setBounds(714, 223, 192, 29);
		contentPane.add(phone_format);
		
		pass_check = new JLabel("");
		pass_check.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pass_check.setHorizontalAlignment(SwingConstants.CENTER);
		pass_check.setBounds(714, 390, 192, 23);
		contentPane.add(pass_check);
		
		JLabel confir_check = new JLabel("");
		confir_check.setHorizontalAlignment(SwingConstants.LEFT);
		confir_check.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		confir_check.setBounds(687, 451, 246, 23);
		contentPane.add(confir_check);
		
		JLabel lblNewLabel = new JLabel("Registeration  Form");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(341, 11, 293, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First  Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(101, 104, 90, 29);
		contentPane.add(lblNewLabel_1);
		
		firstName = new JTextField();
		firstName.setBounds(242, 108, 178, 24);
		contentPane.add(firstName);
		firstName.setColumns(10);
		firstName.setToolTipText("Use only upper case or lower case charachters");
		firstName.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				isChar=auth.checksChar(firstName.getText());
				if(isChar=="correct") {

				//	JOptionPane.showMessageDialog(firstName,"correct username");
					
				}else if(isChar=="incorrect") {
					
			JOptionPane.showMessageDialog(frame,"Please use only  charachters");
			}
				

				
			}
						
		});
		 
		
		JLabel lblNewLabel_2 = new JLabel("Last  Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(101, 147, 90, 29);
		contentPane.add(lblNewLabel_2);
		
		lastName = new JTextField();
		lastName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lastName.setBounds(242, 152, 178, 23);
		contentPane.add(lastName);
		lastName.setColumns(10);
		lastName.setToolTipText("Use only upper case or lower case charachters");
		lastName.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				isChar=auth.checksChar(lastName.getText());
				if(isChar=="correct") {

				//	JOptionPane.showMessageDialog(firstName,"correct username");
					
				}else if(isChar=="incorrect") {
					
			JOptionPane.showMessageDialog(frame,"Please use only  charachters");
			}
				

				
			}
						
		});
		 
		ButtonGroup buttongroup=new ButtonGroup();
		JRadioButton Male_Selected = new JRadioButton("Male");
		Male_Selected.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
			
            Gender=Male_Selected.getText();
			}
		});
		Male_Selected.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Male_Selected.setBounds(248, 193, 73, 29);
		contentPane.add(Male_Selected);
		buttongroup.add(Male_Selected );
		JRadioButton Female_Selected = new JRadioButton("Female");
		Female_Selected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gender=Female_Selected.getText();
			}
		});
		buttongroup.add(Female_Selected);
		Female_Selected.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Female_Selected.setBounds(341, 196, 79, 23);
		contentPane.add(Female_Selected);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(101, 193, 66, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDateOfBirth.setBounds(101, 254, 94, 20);
		contentPane.add(lblDateOfBirth);
		
		JComboBox cityChooser = new JComboBox();
		cityChooser.setModel(new DefaultComboBoxModel(new String[] {"Adilabad", "Agra", "Ahmedabad", "Ahmednagar", "Aizawl", "Ajitgarh (Mohali)", "Ajmer", "Akola", "Alappuzha", "Aligarh", "Alirajpur", "Allahabad", "Almora", "Alwar", "Ambala", "Ambedkar Nagar", "Amravati", "Amreli district", "Amritsar", "Anand", "Anantapur", "Anantnag", "Angul", "Anjaw", "Anuppur", "Araria", "Ariyalur", "Arwal", "Ashok Nagar", "Auraiya", "Aurangabad", "Aurangabad", "Azamgarh", "Badgam", "Bagalkot", "Bageshwar", "Bagpat", "Bahraich", "Baksa", "Balaghat", "Balangir", "Balasore", "Ballia", "Balrampur", "Banaskantha", "Banda", "Bandipora", "Bangalore Rural", "Bangalore Urban", "Banka", "Bankura", "Banswara", "Barabanki", "Baramulla", "Baran", "Bardhaman", "Bareilly", "Bargarh (Baragarh)", "Barmer", "Barnala", "Barpeta", "Barwani", "Bastar", "Basti", "Bathinda", "Beed", "Begusarai", "Belgaum", "Bellary", "Betul", "Bhadrak", "Bhagalpur", "Bhandara", "Bharatpur", "Bharuch", "Bhavnagar", "Bhilwara", "Bhind", "Bhiwani", "Bhojpur", "Bhopal", "Bidar", "Bijapur", "Bijapur", "Bijnor", "Bikaner", "Bilaspur", "Bilaspur", "Birbhum", "Bishnupur", "Bokaro", "Bongaigaon", "Boudh (Bauda)", "Budaun", "Bulandshahr", "Buldhana", "Bundi", "Burhanpur", "Buxar", "Cachar", "Central Delhi", "Chamarajnagar", "Chamba", "Chamoli", "Champawat", "Champhai", "Chandauli", "Chandel", "Chandigarh", "Chandrapur", "Changlang", "Chatra", "Chennai", "Chhatarpur", "Chhatrapati Shahuji Maharaj Nagar", "Chhindwara", "Chikkaballapur", "Chikkamagaluru", "Chirang", "Chitradurga", "Chitrakoot", "Chittoor", "Chittorgarh", "Churachandpur", "Churu", "Coimbatore", "Cooch Behar", "Cuddalore", "Cuttack", "Dadra and Nagar Haveli", "Dahod", "Dakshin Dinajpur", "Dakshina Kannada", "Daman", "Damoh", "Dantewada", "Darbhanga", "Darjeeling", "Darrang", "Datia", "Dausa", "Davanagere", "Debagarh (Deogarh)", "Dehradun", "Deoghar", "Deoria", "Dewas", "Dhalai", "Dhamtari", "Dhanbad", "Dhar", "Dharmapuri", "Dharwad", "Dhemaji", "Dhenkanal", "Dholpur", "Dhubri", "Dhule", "Dibang Valley", "Dibrugarh", "Dima Hasao", "Dimapur", "Dindigul", "Dindori", "Diu", "Doda", "Dumka", "Dungapur", "Durg", "East Champaran", "East Delhi", "East Garo Hills", "East Khasi Hills", "East Siang", "East Sikkim", "East Singhbhum", "Eluru", "Ernakulam", "Erode", "Etah", "Etawah", "Faizabad", "Faridabad", "Faridkot", "Farrukhabad", "Fatehabad", "Fatehgarh Sahib", "Fatehpur", "Fazilka", "Firozabad", "Firozpur", "Gadag", "Gadchiroli", "Gajapati", "Ganderbal", "Gandhinagar", "Ganganagar", "Ganjam", "Garhwa", "Gautam Buddh Nagar", "Gaya", "Ghaziabad", "Ghazipur", "Giridih", "Goalpara", "Godda", "Golaghat", "Gonda", "Gondia", "Gopalganj", "Gorakhpur", "Gulbarga", "Gumla", "Guna", "Guntur", "Gurdaspur", "Gurgaon", "Gwalior", "Hailakandi", "Hamirpur", "Hamirpur", "Hanumangarh", "Harda", "Hardoi", "Haridwar", "Hassan", "Haveri district", "Hazaribag", "Hingoli", "Hissar", "Hooghly", "Hoshangabad", "Hoshiarpur", "Howrah", "Hyderabad", "Hyderabad", "Idukki", "Imphal East", "Imphal West", "Indore", "Jabalpur", "Jagatsinghpur", "Jaintia Hills", "Jaipur", "Jaisalmer", "Jajpur", "Jalandhar", "Jalaun", "Jalgaon", "Jalna", "Jalore", "Jalpaiguri", "Jammu", "Jamnagar", "Jamtara", "Jamui", "Janjgir-Champa", "Jashpur", "Jaunpur district", "Jehanabad", "Jhabua", "Jhajjar", "Jhalawar", "Jhansi", "Jharsuguda", "Jhunjhunu", "Jind", "Jodhpur", "Jorhat", "Junagadh", "Jyotiba Phule Nagar", "Kabirdham (formerly Kawardha)", "Kadapa", "Kaimur", "Kaithal", "Kakinada", "Kalahandi", "Kamrup", "Kamrup Metropolitan", "Kanchipuram", "Kandhamal", "Kangra", "Kanker", "Kannauj", "Kannur", "Kanpur", "Kanshi Ram Nagar", "Kanyakumari", "Kapurthala", "Karaikal", "Karauli", "Karbi Anglong", "Kargil", "Karimganj", "Karimnagar", "Karnal", "Karur", "Kasaragod", "Kathua", "Katihar", "Katni", "Kaushambi", "Kendrapara", "Kendujhar (Keonjhar)", "Khagaria", "Khammam", "Khandwa (East Nimar)", "Khargone (West Nimar)", "Kheda", "Khordha", "Khowai", "Khunti", "Kinnaur", "Kishanganj", "Kishtwar", "Kodagu", "Koderma", "Kohima", "Kokrajhar", "Kolar", "Kolasib", "Kolhapur", "Kolkata", "Kollam", "Koppal", "Koraput", "Korba", "Koriya", "Kota", "Kottayam", "Kozhikode", "Krishna", "Kulgam", "Kullu", "Kupwara", "Kurnool", "Kurukshetra", "Kurung Kumey", "Kushinagar", "Kutch", "Lahaul and Spiti", "Lakhimpur", "Lakhimpur Kheri", "Lakhisarai", "Lalitpur", "Latehar", "Latur", "Lawngtlai", "Leh", "Lohardaga", "Lohit", "Lower Dibang Valley", "Lower Subansiri", "Lucknow", "Ludhiana", "Lunglei", "Madhepura", "Madhubani", "Madurai", "Mahamaya Nagar", "Maharajganj", "Mahasamund", "Mahbubnagar", "Mahe", "Mahendragarh", "Mahoba", "Mainpuri", "Malappuram", "Maldah", "Malkangiri", "Mamit", "Mandi", "Mandla", "Mandsaur", "Mandya", "Mansa", "Marigaon", "Mathura", "Mau", "Mayurbhanj", "Medak", "Meerut", "Mehsana", "Mewat", "Mirzapur", "Moga", "Mokokchung", "Mon", "Moradabad", "Morena", "Mumbai City", "Mumbai suburban", "Munger", "Murshidabad", "Muzaffarnagar", "Muzaffarpur", "Mysore", "Nabarangpur", "Nadia", "Nagaon", "Nagapattinam", "Nagaur", "Nagpur", "Nainital", "Nalanda", "Nalbari", "Nalgonda", "Namakkal", "Nanded", "Nandurbar", "Narayanpur", "Narmada", "Narsinghpur", "Nashik", "Navsari", "Nawada", "Nawanshahr", "Nayagarh", "Neemuch", "Nellore", "New Delhi", "Nilgiris", "Nizamabad", "North 24 Parganas", "North Delhi", "North East Delhi", "North Goa", "North Sikkim", "North Tripura", "North West Delhi", "Nuapada", "Ongole", "Osmanabad", "Pakur", "Palakkad", "Palamu", "Pali", "Palwal", "Panchkula", "Panchmahal", "Panchsheel Nagar district (Hapur)", "Panipat", "Panna", "Papum Pare", "Parbhani", "Paschim Medinipur", "Patan", "Pathanamthitta", "Pathankot", "Patiala", "Patna", "Pauri Garhwal", "Perambalur", "Phek", "Pilibhit", "Pithoragarh", "Pondicherry", "Poonch", "Porbandar", "Pratapgarh", "Pratapgarh", "Pudukkottai", "Pulwama", "Pune", "Purba Medinipur", "Puri", "Purnia", "Purulia", "Raebareli", "Raichur", "Raigad", "Raigarh", "Raipur", "Raisen", "Rajauri", "Rajgarh", "Rajkot", "Rajnandgaon", "Rajsamand", "Ramabai Nagar (Kanpur Dehat)", "Ramanagara", "Ramanathapuram", "Ramban", "Ramgarh", "Rampur", "Ranchi", "Ratlam", "Ratnagiri", "Rayagada", "Reasi", "Rewa", "Rewari", "Ri Bhoi", "Rohtak", "Rohtas", "Rudraprayag", "Rupnagar", "Sabarkantha", "Sagar", "Saharanpur", "Saharsa", "Sahibganj", "Saiha", "Salem", "Samastipur", "Samba", "Sambalpur", "Sangli", "Sangrur", "Sant Kabir Nagar", "Sant Ravidas Nagar", "Saran", "Satara", "Satna", "Sawai Madhopur", "Sehore", "Senapati", "Seoni", "Seraikela Kharsawan", "Serchhip", "Shahdol", "Shahjahanpur", "Shajapur", "Shamli", "Sheikhpura", "Sheohar", "Sheopur", "Shimla", "Shimoga", "Shivpuri", "Shopian", "Shravasti", "Sibsagar", "Siddharthnagar", "Sidhi", "Sikar", "Simdega", "Sindhudurg", "Singrauli", "Sirmaur", "Sirohi", "Sirsa", "Sitamarhi", "Sitapur", "Sivaganga", "Siwan", "Solan", "Solapur", "Sonbhadra", "Sonipat", "Sonitpur", "South 24 Parganas", "South Delhi", "South Garo Hills", "South Goa", "South Sikkim", "South Tripura", "South West Delhi", "Sri Muktsar Sahib", "Srikakulam", "Srinagar", "Subarnapur (Sonepur)", "Sultanpur", "Sundergarh", "Supaul", "Surat", "Surendranagar", "Surguja", "Tamenglong", "Tarn Taran", "Tawang", "Tehri Garhwal", "Thane", "Thanjavur", "The Dangs", "Theni", "Thiruvananthapuram", "Thoothukudi", "Thoubal", "Thrissur", "Tikamgarh", "Tinsukia", "Tirap", "Tiruchirappalli", "Tirunelveli", "Tirupur", "Tiruvallur", "Tiruvannamalai", "Tiruvarur", "Tonk", "Tuensang", "Tumkur", "Udaipur", "Udalguri", "Udham Singh Nagar", "Udhampur", "Udupi", "Ujjain", "Ukhrul", "Umaria", "Una", "Unnao", "Upper Siang", "Upper Subansiri", "Uttar Dinajpur", "Uttara Kannada", "Uttarkashi", "Vadodara", "Vaishali", "Valsad", "Varanasi", "Vellore", "Vidisha", "Viluppuram", "Virudhunagar", "Visakhapatnam", "Vizianagaram", "Vyara", "Warangal", "Wardha", "Washim", "Wayanad", "West Champaran", "West Delhi", "West Garo Hills", "West Kameng", "West Khasi Hills", "West Siang", "West Sikkim", "West Singhbhum", "West Tripura", "Wokha", "Yadgir", "Yamuna Nagar", "Yanam", "Yavatmal", "Zunheboto"}));
		cityChooser.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cityChooser.setBounds(248, 317, 178, 20);
		contentPane.add(cityChooser);
		
		JLabel lblNewLabel_4 = new JLabel("Select City");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(101, 319, 89, 16);
		contentPane.add(lblNewLabel_4);
		
		JComboBox collegeChooser = new JComboBox();
		collegeChooser.setModel(new DefaultComboBoxModel(new String[] {"1 IIT Kanpur Kanpur ", "2\tIIT Kharagpur\tKharagpur\t", "3\tIIT Bombay\tMumbai\t", "4\tIIT Madras\tChennai ", "5\tIIT Delhi\tDelhi\t", "6\tBITS Pilani\tPilani ", "7\tIIT Roorkee\tRoorkee\t", "8\tIT-BHU\tVaranasi\t", "9\tIIT Guwahati\tGuwahati\t", "10\tCollege of Engg, Anna University Guindy\t", "11\tJadavpur University, Faculty of Engg & Tech Calcutta ", "12\tIndian School of Mines\tDhanbad\t", "13\tNIT Warangal\t", "14\tBIT, Mesra Ranchi ", "15\tNIT Trichy", "16\tDelhi College of Engineering\tNew Delhi ", "17\tPunjab Engineering College\tChandigarh ", "18\tNIT\tSuratkal\t", "19\tMotilal Nehru National Inst. of Technology Allahabad ", "20\tThapar Inst of Engineering & Technology\tPatiala\t", "21\tBengal Eng and Science University, Shibpur Howrah ", "22\tMANIT\tBhopal\t", "23 PSG College of Technology Coimbatore ", "24\tIIIT\tHyderabad ", "25 Harcourt Butler Technological Institute\tKanpur\t", "26\tMalviya National Institute of Technology Jaipur ", "27\tVNIT\tNagpur\t", "28\tNIT\tKozhikode ", "29\tDhirubhai Ambani IICT\tGandhinagar ", "30\tOsmania Univ. College of Engineering\tHyderabad ", "31\tCollege of Engineering, Andhra University Vishakhapatnam\t", "32\tNetaji Subhas Institute of Technology\tNew Delhi\t", "33\tNIT\tKurukshetra\t", "34\tNIT\tRourkela\t", "35\tSVNIT\tSurat\t", "36\tGovt. College of Engineering\tPune ", "37\tManipal Institute of Technology\tManipal ", "38\tJNTU\tHyderabad\t", "39\tR.V. College of Engineering\tBangalore ", "40\tNIT\tJamshedpur\t", "41\tUniversity Visvesvaraya College of Engg.\tBangalore\t", "42\tVJTI\tMumbai ", "43\tVellore Institute of Technology\tVellore ", "44\tCoimbatore Institute of Technology Coimbatore\t", "45\tSSN College of Engineering\tChennai\t", "46\tIIIT\tAllahabad\t", "47\tCollege of Engineering\tTrivandrum\t", "48\tNIT Durgapur\tDurgapur\t", "49\tSIT\tCalcutta\t", "50\tMumbai University Inst of Chemical Tech\tMumbai\t", "51\tSardar Patel College of Engineering\tMumbai ", "52\tP.E.S. Institute of Technology\tBangalore ", "53\tMaharashtra Institute of Technology\tPune ", "54\tAmrita Institute of Technology & Science Coimbatore\t", "55\tNational Institute of Engineering Mysore\t", "56\tB.M.S. College of Engineering\tBangalore\t", "57\tLaxminarayan Institute Of Tech.\tNagpur\t", "58\tNirma Institute of Technology\tAhmedabad\t", "59\tIIIT\tPune\t", "60\tAmity School of Engineering\tNoida\t", "61\tJNTU\tKakinada\t", "62\tS.J. College of Engineering\tMysore\t", "63\tChaitanya Bharathi Inst. of Technology\tHyderabad\t", "64\tIIIT\tBangalore\t", "65\tSRM Institute of Science and Technology\tChennai\t", "66\tSASTRA\tThanjavur ", "67\tBangalore Institute of Technology\tBangalore\t", "68\tThe Technological Inst. of Textile & Sciences\tBhiwani\t", "69\tIIIT\tGwalior\t", "70\tJNTU\tAnantpur\t", "71 M.S. Ramaiah Institute of Technology\tBangalore\t", "72\tGitam\tVishakhapatnam ", "73\tNIT\tHamirpur\t", "74\tNIT\tJalandhar ", "75\tSV University Engineering College\tTirupati\t", "76\tNIT\tRaipur\t", "77\tVasavi College of Engineering\tHyderabad ", "78\tThe ICFAI Inst of Science and Technology\tHyderabad\t", "79\tNIT\tPatna ", "80\tCummins College of Engg for Women\tPune\t", "81\tVIT\tPune\t", "82\tShri Ramdeo Baba K.N. Engineering College\tNagpur ", "83\tMuffakham Jah Engineering College\tHyderabad ", "84\tKarunya Institute of Technology\tCoimbatore\t", "85\tD.J. Sanghvi\tMumbai\t", "86\tSathyabhama Engineering College\tChennai\t", "87\tKongu Engineering College\tErode ", "88\tMepco Schlenk Engineering College\tSivakasi\t", "89\tGuru Nanak Dev Engineering College\tLudhiana\t", "90\tHindustan Inst of Engineering Technology\tChennai\t", "91\tSDM College of Engineering\tDharwad\t", "92\tR.V.R. & J.C. College Of Engg\tGuntur\t", "93\tJamia Millia Islamia, New Delhi\tNew Delhi ", "94\tK.L. College of Engineering\tVeddeswaram\t", "95\tDharmsinh Desai Institute of Technology\tNadiad ", "96\tS.G.S. Institute of Technology & Science\tIndore ", "97\tJabalpur Engineering College\tJabalpur\t", "98\tSree Chitra Thirunal College of Engineering\tTrivandrum\t", "99\tG.H. Patel College of Engg & Technology\tVallabh Vidyanagar ", "100\tKalinga Institute of Industrial Technology Bhubaneshwar", "101 Bhagwan Parshuram Institute od Technolgy"}));
		collegeChooser.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		collegeChooser.setBounds(242, 371, 184, 20);
		contentPane.add(collegeChooser);
		
		JLabel lblNewLabel_5 = new JLabel("Select College\r\n");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(104, 372, 102, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Email -Id\r\n");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setBounds(558, 148, 73, 29);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Select Stream");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setBounds(558, 113, 90, 20);
		contentPane.add(lblNewLabel_7);
		
		emailID = new JTextField();
		emailID.setBounds(714, 147, 192, 24);
		contentPane.add(emailID);
		emailID.setColumns(10);
		emailID.setToolTipText("The format of email id has to be xyz123!@abcd.com ");
		emailID.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				checkEmail1=auth.checkEmail(emailID.getText());
				if(checkEmail1=="incorrect") {
					email_format.setText("The email you entered is incorrect");
				}else if(checkEmail1=="correct") {
					email_format.setText("The email you entered is correct");
				}
				
			}
			
		});
		
		
		JComboBox streamChooser = new JComboBox();
		streamChooser.setModel(new DefaultComboBoxModel(new String[] {"Environmental Engineering", "Marine Engineering\tAeronautical ", "Aerospace Engineering", "Architecture & Construction\t", "Automobile Engineering\t", "Telecommunication Engineering", "Highway Engineering\t", "Chemical Engineering\t", "Electronics and Communication Engineering", "Computer Engineering\t", "Electrical Engineering\t", "Agricultural Engineering", "Civil Engineering\t", "Instrumentation Engineering\t", "Production & Industrial Engineering", "Mechanical Engineering\t", "Mining Engineering\t", "Electronics Engineering", "Metallurgical Engineering\t", "Leather Technology\t", "Ceramic Technology", "Petroleum Engineering\t", "Plastics Technology\t", "Polymer Engineering", "Textile Engineering\t", "Industrial Engineering", "Information Technology"}));
		streamChooser.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		streamChooser.setBounds(714, 110, 192, 20);
		contentPane.add(streamChooser);
		
		JLabel lblNewLabel_8 = new JLabel("Phone Number");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8.setBounds(558, 193, 113, 26);
		contentPane.add(lblNewLabel_8);
		
		phoneNo = new JTextField();
		phoneNo.setBounds(714, 198, 192, 20);
		contentPane.add(phoneNo);
		phoneNo.setColumns(10);
		phoneNo.setToolTipText("Enter your 10 digit moble no");
        phoneNo.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			
				if(phoneNo.getText().length()==10) {
					isCorrect=auth.checkPhoneNo(phoneNo.getText());
				if(isCorrect=="correct") {
					phone_format.setText(" ");
				}else if(isCorrect=="incorrect") {
					JOptionPane.showMessageDialog(frame,"please type  correct phone no" );
				}
				}else if(phoneNo.getText().length()<10||phoneNo.getText().length()>10) {
		          		phone_format.setText("The phone no must have 10 digits");
				}
			}
        	
        });
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUserType.setBounds(558, 250, 113, 22);
		contentPane.add(lblUserType);
		
		JComboBox User_Type = new JComboBox();
		User_Type.setFont(new Font("Times New Roman", Font.BOLD, 15));
		User_Type.setModel(new DefaultComboBoxModel(new String[] {"Teacher", "Student ", "Professional"}));
		User_Type.setBounds(714, 254, 192, 20);
		contentPane.add(User_Type);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPassword.setBounds(558, 359, 113, 18);
		contentPane.add(lblPassword);
		
		
		
		JLabel lblNewLabel_9 = new JLabel("Confirm Password");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_9.setBounds(558, 416, 123, 20);
		contentPane.add(lblNewLabel_9);
		password_confirm = new JPasswordField();
		password_confirm.setBounds(714, 417, 192, 20);
		contentPane.add(password_confirm);
		
		password_form = new JPasswordField();
		password_form.setBounds(713, 359, 193, 20);
		contentPane.add(password_form);
		
		JLabel ClgIdLbl = new JLabel("College Id");
		ClgIdLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		ClgIdLbl.setBounds(104, 417, 102, 24);
		contentPane.add(ClgIdLbl);
		
		IdText = new JTextField();
		IdText.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		IdText.setBounds(242, 420, 184, 20);
		contentPane.add(IdText);
		IdText.setColumns(10);
		
		JLabel userIdlbl = new JLabel("User ID");
		userIdlbl.setHorizontalAlignment(SwingConstants.CENTER);
		userIdlbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		userIdlbl.setBounds(525, 315, 123, 24);
		contentPane.add(userIdlbl);
		
		userIdText = new JTextField();
		userIdText.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		userIdText.setBounds(714, 318, 192, 20);
		contentPane.add(userIdText);
		userIdText.setColumns(10);
		password_confirm.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
				String confirm=String.valueOf(password_confirm.getPassword()).trim();
				String initial=String.valueOf(password_form.getPassword()).trim();
				if(confirm.length()<initial.length()||confirm.length()>initial.length()) {
					confir_check.setText("Password length should be the same");
				}else if(confirm.length()==initial.length()) {
					confirmPassword=auth.passwordMatch(initial,confirm);
				
				if(confirmPassword=="correct") {
					confir_check.setText("Password match");
				}else {
					confir_check.setText("Password don't match");
				}}else if(confirm.length()==0) {
					confir_check.setText(" ");
				}
			
			}
			
		});

		
		password_form.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@SuppressWarnings("deprecation")
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				CheckPassword=auth.checkPassword(String.valueOf(password_form.getPassword()).trim());
				if(CheckPassword=="weak") {
					pass_check.setText("Weak");
					pass_check.setForeground(Color.RED);
				}else if(CheckPassword=="medium") {
					pass_check.setText("Medium");
					pass_check.setForeground(Color.ORANGE);
				}else if(CheckPassword=="strong") {
					pass_check.setText("Strong");
					pass_check.setForeground(Color.GREEN);
				}else if(CheckPassword==null) {
					pass_check.setText(" ");
					
				}
			}
			
		});		
		

	
	

		
		JButton btnNewButton = new JButton("Submit ");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String date=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				if(firstName.getText()==null||lastName.getText()==null||Gender==null||date==null||cityChooser.getSelectedItem().toString()==null||collegeChooser.getSelectedItem().toString()==null||emailID.getText()==null||phoneNo.getText()==null||password_form.getPassword().toString()==null||password_confirm.getPassword().toString()==null||streamChooser.getSelectedItem().toString()==null||User_Type.getSelectedItem().toString()==null||IdText.getText()==null||userIdText.getText()==null) {
					JOptionPane.showMessageDialog(btnNewButton,"Please fill all the fields ");
				}
				registerDTO.setFirstName(firstName.getText());
                registerDTO.setLastName(lastName.getText());
                registerDTO.setGender(Gender);
                
                
                System.out.println("The date is " + date );
                registerDTO.setDateOfBirth(date);
                registerDTO.setSelectCity(cityChooser.getSelectedItem().toString());
                registerDTO.setSelectCollege(collegeChooser.getSelectedItem().toString());
                registerDTO.setEmailId(emailID.getText());
		        registerDTO.setPhoneNO(phoneNo.getText());
		        String password=new String(password_form.getPassword());
                registerDTO.setPassword(password);
//              String confirm_password=new String(password_confirm.getPassword());
//		        registerDTO.setConfirmPassword(confirm_password);
                registerDTO.setConfirmPassword(password_confirm.getPassword().toString());
                
                registerDTO.setSelectStream(streamChooser.getSelectedItem().toString());
                registerDTO.setSelectUsertype(User_Type.getSelectedItem().toString());
                registerDTO.setCollegId(IdText.getText());	
              
                registerDTO.setUserid(userIdText.getText());
              //  System.out.println(userIdText.getText());
                UserDao userdao=new UserDao();
               
                try {
				String result =	userdao.checkIfPresent(registerDTO);
				JOptionPane.showMessageDialog(frame,result);
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					try {
						String result =Offline.writeToObj(registerDTO)?"Record Stored in offline mode ":"Record could not be saved in  offline mode";
						JOptionPane.showMessageDialog(frame, result);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					e.printStackTrace();
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
        
                	
                

			}
		});
		btnNewButton.setBounds(248, 475, 94, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go Back\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBackLogin();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(707, 475, 113, 34);
		contentPane.add(btnNewButton_1);
		
		dateChooser = new JDateChooser();
		
		dateChooser.setDateFormatString("yyyy-MM-dd");
		
		dateChooser.setBounds(242, 254, 178, 20);
		contentPane.add(dateChooser);
		
	}	
		
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
