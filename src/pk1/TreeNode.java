/**
 * TreeNode class
 * To create and manipulate a Node in Binary Tree
 */
package pk1;

import java.util.LinkedList;
import java.util.Queue;
import java.lang.String;

public class TreeNode {
	//declare data for a this node
	private Employee data;
	//declare left Child of this node
	private TreeNode leftChild;
	//declare right Child of this node
	private TreeNode rightChild;
	//declare parent node of this node
	private TreeNode parentNode;
	
	/**
	 * Initialization with data
	 * @param data
	 */
	public TreeNode (Employee data){
		this.data = data;
	}
	
	/**
	 * Initialization with data and parent node
	 * @param data
	 * @param parent
	 */
	public TreeNode (Employee data, TreeNode parent) {
		this.data = data;
		this.parentNode = parent;
	}
	
	/**
	 * Add new node in binary Tree follow BST rule 
	 * @param data
	 */
	public void insert(Employee data) {
		//Chose the suitable node to add in left child
		if(data.getId().compareTo(this.data.getId()) < 0) {
			if(this.leftChild == null ) {
				//Create a new node with data and parent node is current node
				this.leftChild = new TreeNode(data, this);			
				return;
			}
			//Use recursive
			else this.leftChild.insert(data);
		}
		
		//Chose the suitable node to add in right child
		if(data.getId().compareTo(this.data.getId()) >= 0) {
			if(this.rightChild == null ) {
				//Create a new node with data and parent node is current node
				this.rightChild = new TreeNode(data, this);
				return;
			}
			//Use recursive
			else this.rightChild.insert(data);
		}
		
	}
	
	/**
	 * Find and return a node by ID of Employee
	 * @param id
	 * @return
	 */
	public TreeNode find(String id) {
		//stop the method if node is found and return this node
		if(this.data.getId().compareTo(id) == 0) return this;
		
		//Use recursive to search in left sub tree and right sub tree
		if(leftChild != null && id.compareTo(this.data.getId()) < 0) return leftChild.find(id);
		if(rightChild != null && id.compareTo(this.data.getId()) >= 0) return rightChild.find(id);
		
		return null;
	}
	
	/**
	 * Print out Binary tree by inOrder
	 * @param node
	 */
	public void inOrder(TreeNode node) {
		if(node.getLeftChild() != null) inOrder(node.getLeftChild());
		System.out.println(node);
		if(node.getRightChild() != null) inOrder(node.getRightChild());
		
	}
	
	/**
	 * Print out Binary Tree by PreOrder
	 * @param node
	 */
	public void preOrder(TreeNode node) {
		System.out.println(node);
		if(node.getLeftChild() != null) inOrder(node.getLeftChild());
		if(node.getRightChild() != null) inOrder(node.getRightChild());
		
	}
	
	/**
	 * print out binary Tree by breadth 
	 */
	public void breadthFirst() {
		Queue<TreeNode> myQueue = new LinkedList<TreeNode>();
		TreeNode curretnNode = this;
		myQueue.add(curretnNode);
		while(!myQueue.isEmpty()) {
			TreeNode temp = myQueue.remove();
			System.out.println(temp);
			if(temp.getLeftChild() != null) myQueue.add(temp.getLeftChild());
			if(temp.getRightChild() != null) myQueue.add(temp.getRightChild());
		}
		
	}
	
	/**
	 * Delete a node in BST
	 * @param node
	 */
	public void deleteNode(TreeNode node) {
		TreeNode parent = node.getParentNode();
		
		//Case node is leaf node
		if(node.getLeftChild() == null && node.getRightChild() == null) {
			
			if(node.getData().getId().compareTo(parent.getData().getId()) < 0) 
				parent.setLeftChild(null);
			else parent.setRightChild(null);
			return;
		}
		
		//Case node have one child is Left
		if(node.getLeftChild() != null && node.getRightChild() == null) {
			//Update new Parent Node for left Child of delete node
			node.getLeftChild().setParentNode(parent);
			//Check if node is left child or right child of parent node
			if(node.getData().getId().compareTo(parent.getData().getId()) < 0) {
				parent.setLeftChild(node.getLeftChild());
			}
			else parent.setRightChild(node.getLeftChild());
			node.setLeftChild(null);
			return;
		}
		
		//Case node have one child is right
		if(node.getRightChild() != null && node.getLeftChild() == null) {
			//Update new Parent Node for left Child of delete node
			node.getRightChild().setParentNode(parent);
			//Check if node is Right child or left child of parent node
			if(node.getData().getId().compareTo(parent.getData().getId()) < 0) {
				parent.setLeftChild(node.getRightChild());
			}
			else parent.setRightChild(node.getRightChild());
			node.setRightChild(null);
			return;
		}
		
		//Case node have two child
		//Find minimum node in right sub tree form delete node
		TreeNode replaceNode = findMin(node.getRightChild());
		//update new data for delete node
		node.setData(replaceNode.getData());
		//Delete repalceNode
		deleteNode(replaceNode);
		
	}
	
	/**
	 * Find node has min value from
	 * @param node
	 * @return
	 */
	public TreeNode findMin(TreeNode node) {
		return node.getLeftChild()==null ? node : findMin(node.getLeftChild());
	}
	
	
	/**
	 * calculator high of any node
	 * @param node
	 * @return
	 */
	public int high(TreeNode  node) {
		if(node  == null) return -1;
		else {
			int hL = 0;
			int hR = 0;
			if(node.getLeftChild() != null) hL = high(node.getLeftChild()) + 1;
			if(node.getRightChild() != null) hR = high(node.getRightChild()) + 1;
			if(node.getLeftChild() == null && node.getRightChild() == null) return 0;
			if(hL>hR) return hL;
			else return hR;
		}
	}
	
	/**
	 * Set data of node
	 * @param data
	 */
	public void setData(Employee data) {
		this.data = data;
	}
	/**
	 * Set left child of node
	 * @param data
	 */
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
	/**
	 * Set right of node
	 * @param data
	 */
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	/**
	 * Set parent node of node
	 * @param data
	 */
	public void setParentNode(TreeNode parentNode) {
		this.parentNode = parentNode;
	}
	
	/**
	 * Get data of node
	 * @return
	 */
	public Employee getData() {
		return data;
	}
	/**
	 * Get left child of node
	 * @return
	 */
	public TreeNode getLeftChild() {
		return leftChild;
	}
	/**
	 * Get right child of node
	 * @return
	 */
	public TreeNode getRightChild() {
		return rightChild;
	}
	/**
	 * Get parent node of node
	 * @return
	 */
	public TreeNode getParentNode() {
		return parentNode;
	}

	
	@Override
	public String toString() {
		return ""+data;
	}
	
	
}
