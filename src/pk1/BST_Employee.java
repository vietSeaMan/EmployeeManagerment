/**
 * BST_Employee class
 * To Create and manipulate Binary Search tree that store Employee data 
 */
package pk1;

import java.lang.Math;
import java.lang.String;
public class BST_Employee {
	
	private TreeNode root;
	
	/**
	 * Add new node with data in Binary Tree
	 * @param data
	 */
	public void insert(Employee data) {
		if(this.root == null) this.root = new TreeNode(data);
		else root.insert(data);
	}
	
	/**
	 * Find a Node by ID
	 * @param id
	 * @return
	 */
	public TreeNode findNode(String id) {
		if(this.root != null) return root.find(id);
		else return null;
	}
	
	/**
	 * Print out Binary tree InOrder
	 */
	public void inOrder() {
		if(root == null) System.out.println("List is Empty");
		else root.inOrder(root);
	}
	
	/**
	 * Print out Binary tree PreOrder
	 */
	public void preOrder() {
		if(root == null) System.out.println("List is Empty");
		else root.preOrder(root);
	}
	
	/**
	 * Print out Binary tree breadth First
	 */
	public void breadthFirst() {
		if(root == null) System.out.println("List is Empty");
		else root.breadthFirst();
	}
	
	/**
	 * Check binary is empty or not
	 * @return
	 */
	public boolean isEmpty() {
		if(root == null) return true;
		else return false;
	}
	
	/**
	 * Remove a node
	 * @param node
	 */
	public void removeNode(TreeNode node) {
		root.deleteNode(node);
	}
	
	/**
	 * Get root Node, use for find Node by ID (find from the root)
	 * @return
	 */
	public TreeNode getRoot() {
		return root;
	}
	
	/**
	 * Get high of node in binary tree
	 * @param node
	 * @return
	 */
	public int highOfNode(TreeNode node) {
		return  root.high(node);
	}
	
	/**
	 * Method to rotate root node to the left
	 */
	public void rotateLeftRoot() {
		//Do nothing if root has no right child
		if(this.root.getRightChild() == null) return;
		//Set newRoot is right child of old root
		TreeNode newRoot = this.root.getRightChild();
		//set oldRoot is current Root
		TreeNode oldRoot = this.root;
		
		//set right child of old root is left child of new root if this root has left child and update parent node for this let child
		if(newRoot.getLeftChild() != null) {
			oldRoot.setRightChild(newRoot.getLeftChild());
			newRoot.getLeftChild().setParentNode(oldRoot);
		}
		else oldRoot.setRightChild(null);
		
		//set old root become left child of new root
		newRoot.setLeftChild(oldRoot);
		//Update parent node for old root
		oldRoot.setParentNode(newRoot);
		//Set root of Binary tree is new root
		this.root = newRoot;
		
	}
	
	/**
	 * Method to rotate root node to the right
	 */
	public void rotateRightRoot() {
		//Do nothing if root has no left child
		if(this.root.getLeftChild() == null) return;
		//Set newRoot is left child of old root
		TreeNode newRoot = this.root.getLeftChild();
		//set oldRoot is current Root
		TreeNode oldRoot = this.root;
		
		//set Left child of old root is right child of new root if this root has right child and update parent node for this right child
		if(newRoot.getRightChild() != null) {
			oldRoot.setLeftChild(newRoot.getRightChild());
			newRoot.getRightChild().setParentNode(oldRoot);
		}
		else oldRoot.setLeftChild(null);
		
		//set old root become right child of new root
		newRoot.setRightChild(oldRoot);
		//Update parent node for old root
		oldRoot.setParentNode(newRoot);
		//Set root of Binary tree is new root
		this.root = newRoot;
	}
	
	/**
	 * Rotate Binary Tree to the Right at a node
	 * @param Node
	 */
	public void rotateRight(TreeNode node) {
		//Do nothing if this node has no left child
		if(node.getLeftChild()==null) return;
		//if node is root then call rotate Root method
		if(node.getParentNode() == null) {
			rotateRightRoot();
			return;
		}
		
		//Get parent node of old node
		TreeNode parent = node.getParentNode();
		//get replce node is left child of old node
		TreeNode replaceNode = node.getLeftChild();
		//get current node is old node
		TreeNode currentNode = node;
		
		//Set new left child of current node is right child of replace node 
		//update parent node of replace's right child
		if(replaceNode.getRightChild() != null) {
			currentNode.setLeftChild(replaceNode.getRightChild());
			replaceNode.getRightChild().setParentNode(currentNode);
		}
		//If replace Node has no right child then point left child of current node to null 
		else currentNode.setLeftChild(null);
		//Update parent node of current Node
		currentNode.setParentNode(replaceNode);
		
		//set right child of replace node to current node
		replaceNode.setRightChild(currentNode);
		//update parent node
		replaceNode.setParentNode(parent);
		
		//Determined position of  current node to set right or left child for parent node.
		if(currentNode.getData().getId().compareTo(parent.getData().getId()) < 0) parent.setLeftChild(replaceNode);
		else parent.setRightChild(replaceNode);
		
	}
	
	/**
	 * Rotate Binary Tree to the Left at node
	 * @param Node
	 */
	public void rotateLeft(TreeNode node) {
		//Can not rotate left Node if node has no right child
		if(node.getRightChild()==null) return;
		//If node have parent = null => node is root
		if(node.getParentNode() == null) {
			rotateLeftRoot();
			return;
		}
		
		TreeNode parent = node.getParentNode();
		TreeNode replaceNode = node.getRightChild();
		TreeNode currentNode = node;
		//Set new right child of current node is left child of replace node 
		//update parent node of replace's left child
		if(replaceNode.getLeftChild() != null) {
			currentNode.setRightChild(replaceNode.getLeftChild());
			replaceNode.getLeftChild().setParentNode(currentNode);
		}
		//If replace NOde has no left child then point right child of current node to null 
		else currentNode.setRightChild(null);
		//Update parent node of current Node
		currentNode.setParentNode(replaceNode);
		
		//set left child of replace node to current node
		replaceNode.setLeftChild(currentNode);
		//update parent node
		replaceNode.setParentNode(parent);
		
		//Determined position of  current node to set right or left child for parent node.
		if(currentNode.getData().getId().compareTo(parent.getData().getId()) < 0) parent.setLeftChild(replaceNode);
		else parent.setRightChild(replaceNode);
	}
	
	/**
	 * Check the balance at a node and rebalance if necessary
	 * @param currentNode
	 */
	private void checkBalanceNode(TreeNode currentNode) {
		//Do nothing if node is leaf node
		if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null) return;
		
		//Get left child and right child of current node
		TreeNode leftChild = currentNode.getLeftChild();
		TreeNode rightChild = currentNode.getRightChild();
		
		//get check parameter 
		double check  = highOfNode(leftChild) - highOfNode(rightChild);
		
		//Do nothing if node already meet the require of AVL tree
		if(Math.abs(check) <= 1) return;
		//Balance tree 
		else {
			//if Node deviate to left
			if(check > 0) {
				//Case deviate (left-right)
				if(highOfNode(leftChild.getLeftChild()) < highOfNode(leftChild.getRightChild())) {
					rotateLeft(leftChild);
					rotateRight(currentNode);
				}
				//Case deviate (left-left)
				else {
					rotateRight(currentNode);
				}
			}
			//if Node deviate to right
			if(check < 0) {
				//Case deviate (right-left)
				if(highOfNode(rightChild.getLeftChild()) > highOfNode(rightChild.getRightChild())) {
					rotateRight(rightChild);
					rotateLeft(currentNode);
				}
				//Case deviate (right-right)
				else {
					rotateLeft(currentNode);
				}
			} 
		}	
	}
	
	/**
	 * balance all Binary Tree
	 * @param check
	 */
	private void balance(TreeNode currentNode) {
		if(currentNode.getLeftChild() != null) balance(currentNode.getLeftChild());
		if(currentNode.getRightChild() != null) balance(currentNode.getRightChild());
		checkBalanceNode(currentNode);
	}
	
	/**
	 * check balance from the root node
	 */
	public void balanceTree() {
		balance(root);
	}
	
	
}
