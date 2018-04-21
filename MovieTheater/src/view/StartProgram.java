// Joe Fazio
// 4/18/18
// This program was modified from the Console Shopping project from the course.  I felt that was a 
// Good starting program to help with persisting to the database and being able to apply CRUD techniques
// with creating, reading, updating and deleting permissions that i would access later with a screen.
// This program just displays the menu item regardless the username and password entered.  Next is to 
// Take that username and password to look up the role and then route the user to the appropriate 
// function per their role.  This program defaults to ADMIN and shows a screen that only the ADMIN role
// will have access to.  For this program to work, the credentials table will need to be built from the specs in the repo

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ListCredsHelper;
import customer.CustInputDriver;
import model.ListCreds;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListCredsHelper lch = new ListCredsHelper();
		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Admin Rights Menu ---");

			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a permission");
				System.out.println("*  2 -- Edit a permission");
				System.out.println("*  3 -- Delete a permission");
				System.out.println("*  4 -- View the list of permissions");
				System.out.println("*  5 -- Exit");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();
				if (selection == 1) {
					addAnAccessCode();
				} else if (selection == 2) {
					editAnAccessCode();
				} else if (selection == 3) {
					deleteAnAccessCode();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lch.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}
			}
		}

		private static void addAnAccessCode() {
			// TODO Auto-generated method stub
			System.out.print("Enter a username: ");
			String username = in.nextLine();
			System.out.print("Enter a password: ");
			String accesscode = in.nextLine();
			System.out.print("Enter a role (ADMIN, EMPLOYEE or MANAGER): ");
			String role = in.nextLine();
			ListCreds toAdd = new ListCreds(username, accesscode, role);
			lch.insertAccessCode(toAdd);
		}

		private static void editAnAccessCode() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by username");
			System.out.println("2 : Search by role");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListCreds> foundAccessCodes = null;
			
			if (searchBy == 1) {
				System.out.print("Enter the username: ");
				String UserNameName = in.nextLine();
				foundAccessCodes = lch.searchForAccessCodeByUsername(UserNameName);
			} else if (searchBy ==2) {
				System.out.print("Enter the role: ");
			    String RoleName = in.nextLine();
			    foundAccessCodes = lch.searchForAccessCodeByRole(RoleName);
			} 
			
			if (!foundAccessCodes.isEmpty()) {
				System.out.println("Found Results.");
				for (ListCreds l : foundAccessCodes) {
					System.out.println("ID: " + l.getId() + " - " + l.returnAccessCodeDetails());
				}

				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListCreds toEdit = lch.searchForAccessCodeById(idToEdit);
				System.out.println("Retrieved " + toEdit.getId() + " from " + toEdit.getUserName());
				System.out.println("1 : Update username");
				System.out.println("2 : Update password");
				System.out.println("3 : Update role");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New username: ");
					String newUserName = in.nextLine();
					toEdit.setUserName(newUserName);
				} else if (update == 2) {
					System.out.print("New password: ");
					String newAccessCode = in.nextLine();
					toEdit.setAccessCode(newAccessCode);
				} else if (update == 3) {
					System.out.print("New role: ");
					String newRole = in.nextLine();
					toEdit.setRole(newRole);
				}	
				lch.updateAccessCode(toEdit);
			} else {
				System.out.println("---- No results found");
			       }
			}
		    
			
		
		private static void deleteAnAccessCode() {

			// TODO Auto-generated method stub
			System.out.print("Enter the username to delete: ");
			String username = in.nextLine();
			String accesscode = "delete";
			String role = "delete";
			ListCreds toDelete = new ListCreds(username, accesscode, role);

			lch.deleteAccessCode(toDelete);
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runLoginView();
		}


		private static void runLoginView() {
			// TODO Auto-generated method stub
			JFrame frame = new JFrame("Movie Madness!!!");
			frame.setSize(300, 150);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel panel = new JPanel();
			frame.add(panel);
			placeComponents(panel);

			frame.setVisible(true);
		}

		private static void placeComponents(JPanel panel) {

			panel.setLayout(null);

			JLabel userLabel = new JLabel("User");
			userLabel.setBounds(10, 10, 80, 25);
			panel.add(userLabel);

			JTextField userText = new JTextField(20);
			userText.setBounds(100, 10, 160, 25);
			panel.add(userText);

			JLabel passwordLabel = new JLabel("Password");
			passwordLabel.setBounds(10, 40, 80, 25);
			panel.add(passwordLabel);

			JPasswordField passwordText = new JPasswordField(20);
			passwordText.setBounds(100, 40, 160, 25);
			panel.add(passwordText);

			JButton loginButton = new JButton("login");
			loginButton.setBounds(10, 80, 80, 25);
			panel.add(loginButton);
			
			ActionListener loginButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] password = passwordText.getPassword();
		    	String passwordString = new String(password);
		    	String user = userText.getText();
		       	searchAnAccessCode(user, passwordString);
		    	
			}
		    };
 			loginButton.addActionListener(loginButtonListener);
 		
			}  	
	
			private static void searchAnAccessCode(String user, String passwordString) {
				// TODO Auto-generated method stub
				
				List<ListCreds> foundAccessCodes = null;
				
				String UserNameName = user;
				foundAccessCodes = lch.searchAnAccessCode(UserNameName);
				if (!foundAccessCodes.isEmpty()) {
	 			    for (ListCreds l : foundAccessCodes) {
						String role = l.returnRole();
			       	    String emprole = "EMPLOYEE";
				     	String mgrrole = "MANAGER";
				    	String admrole = "ADMIN";
				    					    	
				    	if(role.equals(emprole))
				    		CustInputDriver.main(null);
		      		  	if(role.equals(mgrrole))
			      		    System.out.println("Hey its a  MANAGER ROLE!!!");
				    	if(role.equals(admrole))
				    		runMenu();
					}
				 }
			}
		
		

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListCreds> allItems = lch.showAllItems();
			for(ListCreds l : allItems){
				System.out.println(l.returnAccessCodeDetails());
		  }

		}		
			
	}