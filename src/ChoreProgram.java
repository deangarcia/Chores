import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class ChoreProgram extends JFrame
{
	JPanel  wholeGrid;
	
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
		wholeGrid = new JPanel();
		
		//1
		livingRoom = new JButton();
		livingRoom.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\livingRoom.jpg"));
		wholeGrid.add(livingRoom);
		
		addAction(livingRoom, "Living Room");
		//******************************************************************************************************************
		
		//2
		Kitchen = new JButton();
		Kitchen.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\kitchen.jpg"));
		wholeGrid.add(Kitchen);
		
		addAction(Kitchen, "Kitchen");
		//******************************************************************************************************************
		
		//3
		DinningRoom = new JButton();
		DinningRoom.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\DinningRoom.jpg"));
		wholeGrid.add(DinningRoom);
		
		addAction(DinningRoom, "Dinning Room");
		//******************************************************************************************************************
		
		//4		
		Bathroom = new JButton();
		Bathroom.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\Bathroom.jpg"));
		wholeGrid.add(Bathroom);
		
		addAction(Bathroom, "Bathroom");
		//******************************************************************************************************************
		
		//5		
		GrandparentsB = new JButton();
		GrandparentsB.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\GrandparentsB.jpg"));
		wholeGrid.add(GrandparentsB);
		
		addAction(GrandparentsB, "Grandparents Bathroom");
		//******************************************************************************************************************

		//6
		Hallway = new JButton();
		Hallway.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\Hallway.jpg"));
		wholeGrid.add(Hallway);
		
		addAction(Hallway, "Hallway");
		//******************************************************************************************************************
		
		//7
		FrontYard = new JButton();
		FrontYard.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\FrontYard.jpg"));
		wholeGrid.add(FrontYard);
		
		addAction(FrontYard, "Front Yard");
		//******************************************************************************************************************

		//8
		BackYard = new JButton();
		BackYard.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\BackYard.jpg"));
		wholeGrid.add(BackYard);
		
		addAction(BackYard, "Backyard");
		//******************************************************************************************************************

		//9
		Pool = new JButton();
		Pool.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\Pool.jpg"));
		wholeGrid.add(Pool);
		
		addAction(Pool, "Pool");
		//******************************************************************************************************************

		//10
		Vehicles = new JButton();
		Vehicles.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\Vehicles.jpg"));
		wholeGrid.add(Vehicles);
		
		addAction(Vehicles, "Vehicles");
		//******************************************************************************************************************

		//11
		Patio = new JButton();
		Patio.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\Patio.jpg"));
		wholeGrid.add(Patio);
		
		addAction(Patio, "Patio");
		//******************************************************************************************************************
		
		//12
		DogsRoom = new JButton();
		DogsRoom.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\DogsRoom.jpg"));
		wholeGrid.add(DogsRoom);
		
		addAction(DogsRoom, "Dogs Room");
		//******************************************************************************************************************
		
		
		add(wholeGrid);
		validate();
		wholeGrid.setBackground(Color.BLACK);
		wholeGrid.setLayout(new GridLayout(2,6));

		
		setTitle("Chores of Exotic Adventures");
		setSize(1200,742);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
	}

	public void addAction(JButton room, String roomName)
	{
		room.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{	
				// Want to load in Defaults From .txt and then 
				// when instantiating the text field compare default 
				// text to valid values and depending on what it is 
				// disable it and set the right color
				
				// Set old panel visibility to false 
				wholeGrid.setVisible(false);
				JPanel jpantemp = new JPanel();
				JPanel tablep = new JPanel();
				JLabel temp = new JLabel(roomName);
				
				jpantemp.add(temp);
				jpantemp.setBackground(Color.WHITE);
				jpantemp.setVisible(true);
				add(jpantemp, BorderLayout.NORTH);
				
				// Main Menu Back Button
				JButton done = new JButton("Back");
				jpantemp.add(done);
				done.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						jpantemp.setVisible(false);
						tablep.setVisible(false);
						wholeGrid.setVisible(true);
					}
				});
				addChoreTable(roomName, tablep);
			}
		});
	}
	
	public void addChoreTable(String roomName, JPanel tablep)
	{
		//////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////
		// Adding Chores here should be put in a separate method but for now I am putting here 
		String columns[] = {"Chore", "Cost", "Status", "Description"};
		String data[][] = {{"clean", "20", "false", "Do This and that and this"}, 
						   {"mop", "100", "True", "Do This and that and this"}, 
						   {"sweep", "200", "False", "Do This and that and this"}};
		JTable table = new JTable(data, columns)
		{
		public boolean isCellEditable(int data, int columns)
		{
		return false;
		}
		};
		tablep.setVisible(true);
		table.setPreferredScrollableViewportSize(new Dimension(742, 50));
		table.setFillsViewportHeight(true);
		JScrollPane jt = new JScrollPane(table);
		tablep.add(jt);
		tablep.setBackground(Color.WHITE);
		add(tablep, BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
