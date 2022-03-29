/**
 * Operatiion class
 * To Handling requests 
 */
package pk1;

import java.util.Scanner;

public class Operation {
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Show the main menu 
	 */
	public void displayMenu() {
		System.out.println("Chose an option:");
		System.out.println("1. Add a new employee in to Binary Search Tree (BST)");
		System.out.println("2. In-order Traverse BST ");
		System.out.println("3. Breadth-First Traversal(BFT)");
		System.out.println("4. Find Employee's information by ID");
		System.out.println("5. Delete an Employee by ID");
		System.out.println("6. Balance Binary Search Tree");
		System.out.println("7. Depth-First Graph Traversal (DFT)");
		System.out.println("8. Find a shortest from A to F city with Dijkstra algorithms");
		System.out.println("0. End");
		System.out.println("__________________________________________");
		System.out.println();
	}
	
	/**
	 * 1. Add a new employee in to Binary Search Tree (BST)
	 * add new Employee in to Binary search tree
	 * @param empTree
	 */
	public void addNewEmployee(BST_Employee empTree) {
		//create a new employee
		Employee emp = new Employee();
		String id = "";
		//get id of employee and check new id is existed or not then set ID for new employee
		do {
			System.out.println("Enter the ID:");
			id = sc.next();
			if(checkID(empTree, id)) System.out.println("ID already exsti, pls try again!");
		}while(checkID(empTree, id));
		emp.setId(id);
		
		//Get name of employee
		sc.nextLine();
		System.out.println("Enter name of Employee:");
		emp.setName(sc.nextLine());
		
		//Get date of birth of employee
		System.out.println("Enter date of birth:");
		emp.setDateOfBirth(sc.nextLine());
		
		//Get birth place of employee
		System.out.println("Enter the birthplace:");
		emp.setBirthPlace(sc.nextLine());
		
		//add this employee in to BST
		empTree.insert(emp);
	}
	
	/**
	 * 2. In-order Traverse BST
	 * display information of employee by In order
	 * @param empTree
	 */
	public void displayByInOrder(BST_Employee empTree) {
		System.out.println("ID \t|\t Name \t\t|\t Date of birh \t|\t Birthplace");
		System.out.println("------------------------------------------------------------------");
		empTree.inOrder();		
		System.out.println();
	}
	
	/**
	 * 3. Breadth-First Traversal(BFT)
	 * display information of employee by Breadth
	 * @param empTree
	 */
	public void displayByBeadthFirst(BST_Employee empTree) {
		System.out.println("ID \t|\t Name \t\t|\t Date of birh \t|\t Birthplace");
		System.out.println("------------------------------------------------------------------");
		empTree.breadthFirst();
		System.out.println();
	}
	
	
	/**
	 * 4. Find Employee's information by ID
	 * find employee by ID in BST
	 * @param empTree
	 */
	public void findById(BST_Employee empTree) {
		if(empTree.isEmpty()) System.out.println("EMPTY LIST");
		else {
			System.out.println("Nhap ID");
			String id = sc.next();
			findID(empTree.getRoot(), id);
			
		}
		System.out.println();
	}
	
	/**
	 * 5. Delete an Employee by ID
	 * remove a node by ID
	 * @param empTree
	 */
	public void removeById(BST_Employee empTree) {
		if(empTree.isEmpty()) System.out.println("EMPTY LIST");
		else {
			System.out.println("Nhap ID");
			String id = sc.next();
			if(empTree.findNode(id) == null) {
				System.out.println("ID not found");
				return;
			}
			else empTree.removeNode(empTree.findNode(id));
			System.out.println("DONE");
			System.out.println();
		}
	}
	
	/**
	 * 6. Balance Binary Search Tree
	 * Check and balance BST
	 * @param empTree
	 */
	public void balanceTree(BST_Employee empTree) {
		empTree.balanceTree();
		System.out.println("DONE");
		System.out.println();
	}
	
	/**
	 * 7. Depth-First Graph Traversal (DFT)
	 * Display vertex by depth first search
	 * @param start
	 * @param myGraph
	 */
	public void printVertex(char start, Graph myGraph) {
		myGraph.showVertex(start);
		System.out.println("--------------------------");
		System.out.println();
	}
	
	/**
	 * 8. Find a shortest from A to F city with Dijkstra algorithms
	 * Find a shortest way form two vertex
	 * @param start
	 * @param end
	 * @param myGraph
	 */
	public void findShortestWay(char start, char end, Graph myGraph) {
		myGraph.findShortestWay(start, end);
		System.out.println("--------------------------");
		System.out.println();
	}
	
	
	/******************************************************************sub method******************************************/
	/**
	 * find node by ID in BST from any node
	 * @param node
	 * @param id
	 */
	public void findID(TreeNode node, String id) {
		if(node.getData().getId().indexOf(id) >= 0) {
			System.out.println(node);
		}
		if(node.getLeftChild() != null )  findID(node.getLeftChild(), id);
		if(node.getRightChild() != null ) findID(node.getRightChild(), id);
	}
	
	/**
	 * Check ID already exsit or not 
	 * @param empTree
	 * @param ID
	 * @return
	 */
	public boolean checkID(BST_Employee empTree, String ID) {
		if(empTree.isEmpty()) return false;
		if(empTree.findNode(ID) == null) return false;
		else return true;
	}
	
	/**
	 * Check input for Integer variable
	 * @param sc
	 * @return int
	 */
	public int inputInt(Scanner sc) {
		int num = 0;
		boolean check = true;
		do {
			//Use try catch to keep program flow continue when exception across
			try {
				num = sc.nextInt();
				check = true;
			}catch(Exception ex) {
				check = false;
				System.out.println("Data format is wrong, Pls try again!..."); 
				sc.nextLine();
			}
			if(num<0) {
				System.out.println("Not allow number less than 0");
				System.out.print("Please try again:");
				check = false;
			}
		}while(!check);
		
		return num;
	}
}
