package menuClasses;

import java.util.ArrayList;

public class MainMenu extends Menu {
	private static final MainMenu MM = new MainMenu(); 
	private MainMenu() { 
		super(); 
		String title; 
		ArrayList<Option> options = new ArrayList<Option>();  
		title = "Main Menu"; 
		options.add(new Option("Show all Lists", new ShowListsAction())); 
		options.add(new Option("Create New List", new CreateListAction())); 
		options.add(new Option("Delete an Existing List", new DeleteListAction()));
		options.add(new Option("Operations on Lists", new OperateListAction())); 
		options.add(new Option("Alter Content of a List", new AlterListContentAction())); 
		options.add(Option.EXIT); 

		super.InitializeMenu(title, options); 
	}
	
	public static MainMenu getMainMenu() { 
		return MM; 
	}
}
