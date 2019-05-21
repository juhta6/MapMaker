package me.mapmaker.interactive;

import java.util.ArrayList;

import javafx.scene.Node;

public class Interactive {
	
	private ArrayList<Node> nodes = new ArrayList<Node>();
	
	public Interactive(Node... nodes) {
		for(Node node: nodes) {
			if(node != null) {
				this.nodes.add(node);
			}
		}
	}
	
	public void addNodes(Node... nodes) {
		for(Node node: nodes) {
			if(node != null) {
				this.nodes.add(node);
			}
		}
	}
	
	public void addNode(Node node) {
		if(node != null)
			nodes.add(node);
	}
	
	public void removeNodes(Node... nodes) {
		for(Node node: nodes) {
			if(node != null) {
				this.nodes.remove(node);
			}
		}
	}
	
	public void removeNode(Node node) {
		if(node != null)
			nodes.remove(node);
	}
	
	public ArrayList<Node> getNodes() {
		return nodes;
	}

}
