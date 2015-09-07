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
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


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
		
		addAction(livingRoom, Room.LIVINGROOM);
		//******************************************************************************************************************
		
		//2
		Kitchen = new JButton();
		Kitchen.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\kitchen.jpg"));
		wholeGrid.add(Kitchen);
		
		addAction(Kitchen, Room.KITCHEN);
		//******************************************************************************************************************
		
		//3
		DinningRoom = new JButton();
		DinningRoom.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\DinningRoom.jpg"));
		wholeGrid.add(DinningRoom);
		
		addAction(DinningRoom, Room.DINNINGROOM);
		//******************************************************************************************************************
		
		//4		
		Bathroom = new JButton();
		Bathroom.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\Bathroom.jpg"));
		wholeGrid.add(Bathroom);
		
		addAction(Bathroom, Room.BATHROOM);
		//******************************************************************************************************************
		
		//5		
		GrandparentsB = new JButton();
		GrandparentsB.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\GrandparentsB.jpg"));
		wholeGrid.add(GrandparentsB);
		
		addAction(GrandparentsB, Room.GRANDMASBATHROOM);
		//******************************************************************************************************************

		//6
		Hallway = new JButton();
		Hallway.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\Hallway.jpg"));
		wholeGrid.add(Hallway);
		
		addAction(Hallway, Room.HALLWAY);
		//******************************************************************************************************************
		
		//7
		FrontYard = new JButton();
		FrontYard.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\FrontYard.jpg"));
		wholeGrid.add(FrontYard);
		
		addAction(FrontYard, Room.FRONTYARD);
		//******************************************************************************************************************

		//8
		BackYard = new JButton();
		BackYard.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\BackYard.jpg"));
		wholeGrid.add(BackYard);
		
		addAction(BackYard, Room.BACKYARD);
		//******************************************************************************************************************

		//9
		Pool = new JButton();
		Pool.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\Pool.jpg"));
		wholeGrid.add(Pool);
		
		addAction(Pool, Room.POOL);
		//******************************************************************************************************************

		//10
		Vehicles = new JButton();
		Vehicles.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\Vehicles.jpg"));
		wholeGrid.add(Vehicles);
		
		addAction(Vehicles, Room.VEHICLES);
		//******************************************************************************************************************

		//11
		Patio = new JButton();
		Patio.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\Patio.jpg"));
		wholeGrid.add(Patio);
		
		addAction(Patio, Room.PATIO);
		//******************************************************************************************************************
		
		//12
		DogsRoom = new JButton();
		DogsRoom.setIcon(new ImageIcon("C:\\Users\\Dean\\workspace\\Chores\\img\\DogsRoom.jpg"));
		wholeGrid.add(DogsRoom);
		
		addAction(DogsRoom, Room.DOGSROOM);
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

	public void addAction(JButton room, Room roomName)
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
				JLabel temp = new JLabel(roomName.getName());
				
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
				try {
					addChoreTable(roomName, tablep);
				} catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void addChoreTable(Room roomName, JPanel tablep) throws BiffException, IOException
	{
		//////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////
		// Adding Chores here should be put in a separate method but for now I am putting here 
		File f = new File("C:\\Users\\Dean\\Google Drive\\asd\\Chores.xls");
		
		String columns[] = {"Chore", "Money Earned", "Description"};
		String data[][]; //= {{"clean", "20", "false", "Do This and that and this"}, 
						 //  {"mop", "100", "True", "Do This and that and this"}, 
						 //  {"sweep", "200", "False", "Do This and that and this"}};
		
		Workbook wb;
		wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet(roomName.getSheet());
		int row = s.getRows();
		int col = 3;
		
		data = new String[row][col]; 
		for(int i = 1; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				Cell c = s.getCell(j,i);
				data[i-1][j] = c.getContents();
			}
		}
		
		JTable table = new JTable(data, columns)
		{
			public boolean isCellEditable(int data, int columns)
			{
				return false;
			}
		};
		tablep.setVisible(true);
		table.setPreferredScrollableViewportSize(new Dimension(742, 459));
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
