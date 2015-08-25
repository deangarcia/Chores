import java.awt.BorderLayout;
import java.awt.Color;
//Use flowLayout for more customization
//import java.awt.FlowLayout;
import java.awt.GridLayout;
//import java.util.ArrayList;
//import java.util.Scanner;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChoreProgram extends JFrame
{
	JPanel  pan;
	
	// Fifteen different rooms or sections of the house that can be cleaned
	// PLD = P for room idk and LD is Leviathyn and Damien
	JPanel 	PlivingRoom, PKitchen, PGrandparentsB, 
			PBathroom, PHallway, PFrontYard, 
			PBackYard, PPool, PVehicles, 
			PDogsRoom, PPatio, PDinningRoom;
	
	JButton livingRoom, Kitchen,GrandparentsB, 
			Bathroom, Hallway, FrontYard, 
			BackYard, Pool, Vehicles, 
			DogsRoom, Patio, DinningRoom;
	
	public ChoreProgram()
	{	
		// JPanel is kind of like a table
		// This is our base Panel 
		pan = new JPanel();
		
		//1
		livingRoom = new JButton();
		livingRoom.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\livingRoom.jpg"));
		pan.add(livingRoom);
		
		livingRoom.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{	
				// Want to load in Defaults From .txt and then 
				// when instantiating the text field compare default 
				// text to valid values and depending on what it is 
				// disable it and set the right color
				
				// Set old panel visibility to false 
				pan.setVisible(false);
				
				// Create new panel with chore list
				PlivingRoom = new JPanel();
				JLabel temp;
				temp = new JLabel("Living Room");
				PlivingRoom.add(temp);
				add(PlivingRoom);
				
				// Main Menu Back Button
				JButton done;
				done = new JButton("Back");
				PlivingRoom.add(done);
				done.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						PlivingRoom.setVisible(false);
						pan.setVisible(true);
					}
				});
				
				// Clean TV Stand Text Field
				JTextField CleanTVStand = new JTextField(10);
				PlivingRoom.add(CleanTVStand);
				CleanTVStand.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						// Save name to file along with a time stap and name of the chore
						// Instead of getting on Enter get it on button with the actual chore name and possibly value
						// Then disable that button whenever the text field is Green or whatever
						String input = CleanTVStand.getText();
						System.out.println(input);
						CleanTVStand.setEditable(false);
						CleanTVStand.setBackground(Color.GREEN);
					}
				});
				

				PlivingRoom.setBackground(Color.WHITE);
				PlivingRoom.setVisible(true);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		//******************************************************************************************************************
		
		//2
		Kitchen = new JButton();
		Kitchen.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\kitchen.jpg"));
		pan.add(Kitchen);
		//******************************************************************************************************************
		
		//3
		DinningRoom = new JButton();
		DinningRoom.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\DinningRoom.jpg"));
		pan.add(DinningRoom);
		//******************************************************************************************************************
		
		//4		
		Bathroom = new JButton();
		Bathroom.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\Bathroom.jpg"));
		pan.add(Bathroom);
		//******************************************************************************************************************
		
		//5		
		GrandparentsB = new JButton();
		GrandparentsB.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\GrandparentsB.jpg"));
		pan.add(GrandparentsB);
		//******************************************************************************************************************

		//6
		Hallway = new JButton();
		Hallway.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\Hallway.jpg"));
		pan.add(Hallway);
		//******************************************************************************************************************
		
		//7
		FrontYard = new JButton();
		FrontYard.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\FrontYard.jpg"));
		pan.add(FrontYard);
		//******************************************************************************************************************

		//8
		BackYard = new JButton();
		BackYard.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\BackYard.jpg"));
		pan.add(BackYard);
		//******************************************************************************************************************

		//9
		Pool = new JButton();
		Pool.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\Pool.jpg"));
		pan.add(Pool);
		//******************************************************************************************************************

		//10
		Vehicles = new JButton();
		Vehicles.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\Vehicles.jpg"));
		pan.add(Vehicles);
		//******************************************************************************************************************

		//11
		Patio = new JButton();
		Patio.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\Patio.jpg"));
		pan.add(Patio);
		//******************************************************************************************************************
		
		//12
		DogsRoom = new JButton();
		DogsRoom.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\DogsRoom.jpg"));
		pan.add(DogsRoom);
		//******************************************************************************************************************
		
		
		add(pan);
		validate();
		pan.setBackground(Color.BLACK);
		pan.setLayout(new GridLayout(2,6));

		
		setTitle("Chores of Exotic Adventures");
		setSize(1200,742);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
	}

	public static void main(String[] args) 
	{
		ChoreProgram choreAdventure = new ChoreProgram();
		
		/*
		ArrayList<chore> choreList = new ArrayList<chore>();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Type 1, to add in a new chore: ");
		System.out.println("Type 2, to get a list of chores: ");
		
		int choice = scan.nextInt();
		
		switch(choice)
		{
			case 1: 
				String chorename = scan.nextLine();
				int value = scan.nextInt();
				break;
			case 2:
				// randomly get chores from a text file 
				break;
				default: break;
		}
		*/
		
		
	}

}
