import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * 
 * @author Michael Baca, Joshua Villegas, James Bias
 * @version 1.2 (11/17/2016)
 *Public class initializing the registration system. this class handles the creation of the user interface
 *and delivers the main functions of the system. These functions include: login, register for classes, check grades,
 *drop classes, and logout.
 */
public class RegistrationSystem extends JFrame {
	
	/**courses that are visible and available to register for */
	public ArrayList<Course> courseList = new ArrayList<>();
	/**checklist that allows students to select classes by selecting a box by its name */
	ArrayList<JCheckBox> courseCheckList = new ArrayList<>();

	/**the user that will be using this system */
	public Student s;
	
	/**boolean value that flags if a course has been added to the list of available courses to 
	 * register for */
	private boolean addedToList = false;

	/**grid used to map out user interface */
	GridBagConstraints g;
	/**logout button on the interface. activates when clicked. logs user out of system */
	JButton logout;
	/**login button on the interface. activates when clicked. logs user in to system */
	JButton login;

	/**
	 * builds the frame for the user interface.
	 */
	public void buildFrame(){
		setTitle("Registration System");
		setSize(700,400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		login();
	}

	/**
	 * creates login page and validates user credentials to access the system
	 */
	public void login() {

		g = new GridBagConstraints();

		JPanel panel = new JPanel(new GridBagLayout());
		
		getContentPane().removeAll();
		getContentPane().repaint();

		/**name field for the login page */
		JTextField userNameField = new JTextField("student",15);
		/**password field for the login page */
		JTextField passwordField = new JTextField("password",15);
		login = new JButton("Login");
		g.gridx = 1;
		panel.add(userNameField, g);
		g.gridy = 1;
		panel.add(passwordField, g);
		g.gridy = 2;
		panel.add(login, g);
		add(panel);

		revalidate();
	
	login.addActionListener(new ActionListener() {
		@Override
			/**
			 * validates the user credentials when the login button is pushed
			 */
			public void actionPerformed(ActionEvent e) {
				if(userNameField.getText().equals(s.getName()) && passwordField.getText().equals(s.getPassword())){
					studentHome();
				}
				else{
					
				}
			}
		});

	}

	/**
	 * creates the student home page interface. Also sets actions for the different even buttons:
	 * register, classes, drop course, logout
	 */
	public void studentHome(){

		// boolean a = false;
		g = new GridBagConstraints();
		g.insets = new Insets(5,5,5,5);

		JLabel name = new JLabel("Student Name:  "+s.getName());

		JPanel panel = new JPanel(new BorderLayout());
		JPanel centerPanel = new JPanel(new GridBagLayout());
		panel.add(centerPanel, BorderLayout.CENTER);
		panel.add(name, BorderLayout.NORTH);
		getContentPane().removeAll();
		getContentPane().repaint();

		JButton classes = new JButton("     Classes     ");
		JButton register = new JButton("     Register     ");
		JButton dropCourse = new JButton("Drop Courses");
		logout = new JButton("      Logout      ");

		g.gridx = 1;
		centerPanel.add(register, g);
		g.gridy = 1;
		centerPanel.add(classes, g);
		g.gridy = 2;
		centerPanel.add(dropCourse, g);
		g.gridy = 3;
		centerPanel.add(logout, g);
		add(panel);

		revalidate();

		logout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){
				login();
			}
		});

		classes.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){
				classes();
			}
		});

		register.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				register();
				JOptionPane.showMessageDialog(null,"Please note that you cannot be registered for more than 4 classes");
			}
		});

		dropCourse.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				dropCourse();
			}
		});

	}

	/**
	 * creates the classes interface. this interface shows the student name, the course name, and the grade in the
	 * course for each class that a student is registered for 
	 */
	public void classes(){
		JLabel courseName;
		JLabel grade;
		JLabel name = new JLabel("Student Name:  " + s.getName());
		JLabel c = new JLabel("Classes: ");
		JLabel gLabel = new JLabel("Grade: ");

		JButton back = new JButton("Back");

		getContentPane().removeAll();
		getContentPane().repaint();

		g = new GridBagConstraints();
		g.insets = new Insets(5,5,5,5);
		g.anchor = GridBagConstraints.WEST;

		JPanel panel = new JPanel(new BorderLayout());
		JPanel leftPanel = new JPanel(new GridBagLayout());
		JPanel centerPanel = new JPanel(new GridBagLayout());
		JPanel rightPanel = new JPanel(new BorderLayout());

		JScrollPane scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		panel.add(leftPanel, BorderLayout.WEST);
		panel.add(name, BorderLayout.NORTH);
		panel.add(centerPanel, BorderLayout.CENTER);
		panel.add(rightPanel, BorderLayout.EAST);

		leftPanel.add(c,g);
		centerPanel.add(gLabel,g);
		rightPanel.add(back, BorderLayout.SOUTH);

		for(int i=0;i<s.getCourseList().size();i++){
			g.gridy=i+1;
			courseName = new JLabel(""+s.getCourseList().get(i).courseName);
			grade = new JLabel(""+s.getCourseList().get(i).grade);
			leftPanel.add(courseName, g);
			centerPanel.add(grade, g);
		}

		add(scrollPane);

		revalidate();

		back.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				studentHome();
			}
		});
	}

	/**
	 * creates the interface for the student to register for classes and adds actions to the buttons on the page
	 */
	public void register(){

		getContentPane().removeAll();
		getContentPane().repaint();
		
		g = new GridBagConstraints();
		g.insets = new Insets(5,30,5,30);
		g.anchor = GridBagConstraints.WEST;


		JPanel panel = new JPanel(new BorderLayout());
		JPanel topPanel = new JPanel(new GridBagLayout());
		JPanel rightPanel = new JPanel(new BorderLayout());
		JPanel leftPanel = new JPanel(new GridBagLayout());
		JPanel centerPanel = new JPanel(new GridBagLayout());
		JPanel bottomPanel = new JPanel(new BorderLayout());
		JPanel bottomCenterPanel = new JPanel(new GridBagLayout());


		panel.add(rightPanel, BorderLayout.EAST);
		panel.add(topPanel, BorderLayout.NORTH);
		panel.add(leftPanel, BorderLayout.WEST);
		panel.add(centerPanel, BorderLayout.CENTER);
		panel.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.add(bottomCenterPanel, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		JButton register = new JButton("Register");
		JButton back = new JButton("Back");


		JCheckBox c1;

		JLabel courses = new JLabel("Courses: ");
		JLabel registered = new JLabel("Registered: ");
		JLabel capacity = new JLabel("Capacity: ");
		JLabel capacityLabel;
		JLabel registeredLabel;

		centerPanel.add(courses, g);
		g.gridx=2;
		centerPanel.add(capacity, g);
		g.gridx=4;
		centerPanel.add(registered, g);
		g.gridx=0;

		for(int i=0;i<courseList.size(); i++){
			if(addedToList == false){
				c1 = new JCheckBox(""+courseList.get(i).courseName);
				c1.setName(courseList.get(i).courseName);
				courseCheckList.add(c1);
			}
		}

		addedToList = true;

		for(int i=0;i<courseCheckList.size();i++){
			g.gridy=i+1;
			centerPanel.add(courseCheckList.get(i), g);
			capacityLabel = new JLabel(""+courseList.get(i).capacity);
			registeredLabel = new JLabel(""+courseList.get(i).studentsRegistered);
			g.gridx=2;
			centerPanel.add(capacityLabel, g);
			g.gridx=4;
			centerPanel.add(registeredLabel, g);
			g.gridx=0;
			g.gridy=0;
		}
		bottomCenterPanel.add(register, g);
		bottomPanel.add(back, BorderLayout.EAST);

		JLabel title = new JLabel("Available Courses");
		topPanel.add(title, g);

		add(scrollPane);

		revalidate();

		back.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				studentHome();
			}
		});

		register.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e){


				for(int i=0; i<courseCheckList.size();i++){
					if(courseCheckList.get(i).isSelected()&&courseList.get(i).studentsRegistered < courseList.get(i).capacity&&s.getCourseList().size()<4){
						s.addCourse(courseList.get(i));
						courseCheckList.get(i).setEnabled(false);
						courseCheckList.get(i).setSelected(false);
					}
				}
				
				classes();
			}
		});
	}

	/**
	 * creates the interface that allows a student to drop a class, and enables actions for the buttons on this page
	 */
	public void dropCourse(){

		
		if(s.getCourseList().isEmpty()){
			JOptionPane.showMessageDialog(null, "You are not Registered for any Courses.");
		}else{
			getContentPane().removeAll();
			getContentPane().repaint();

			g = new GridBagConstraints();
			g.insets = new Insets(5,5,5,5);
			g.anchor = GridBagConstraints.WEST;

			ArrayList<JCheckBox> registeredCheckList = new ArrayList<>();
			for(int i=0; i<s.getCourseList().size();i++){
				JCheckBox cb = new JCheckBox(""+s.getCourseList().get(i).courseName);
				cb.setName(s.getCourseList().get(i).courseName);
				registeredCheckList.add(cb);
			}

			JButton drop = new JButton("Drop Course(s)");
			JButton back = new JButton("Back");

			JPanel panel = new JPanel(new BorderLayout());
			JPanel leftPanel = new JPanel(new GridBagLayout());
			JPanel topPanel = new JPanel(new GridBagLayout());
			JPanel southPanel = new JPanel(new GridBagLayout());

			panel.add(leftPanel, BorderLayout.WEST);
			panel.add(topPanel, BorderLayout.NORTH);
			panel.add(southPanel, BorderLayout.SOUTH);

			southPanel.add(drop, g);
			southPanel.add(back, g);

			JLabel classLabel = new JLabel("Registered Classes:");
			topPanel.add(classLabel);
			for(int i=0; i<registeredCheckList.size();i++){
				g.gridy=i;
				leftPanel.add(registeredCheckList.get(i), g);

			}
			add(panel);
			revalidate();

			back.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e){
					studentHome();

				}
			});

			drop.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e){
					String name = "";
					for(int i=0;i<registeredCheckList.size();i++){

						if(registeredCheckList.get(i).isSelected()){
							name = registeredCheckList.get(i).getName();
							s.dropCourse(s.getCourseList().get(i));
							registeredCheckList.remove(i);
							i--;
							for(int j=0;j<courseCheckList.size();j++){
								if(courseCheckList.get(j).getName().equals(name)){
									courseCheckList.get(j).setEnabled(true);
								}
							}
						}

					}
					dropCourse();
				}
			});
		}
	}
}
