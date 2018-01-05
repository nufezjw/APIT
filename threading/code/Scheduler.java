import java.util.*;

public class Scheduler implements Runnable {
	private MessageQueue myQueue;
	ArrayList<Node> nodes;
	Integer nNodes;
	Message[] nowRunning;
	Boolean finished = false;
	public Scheduler(ArrayList<Message> a,Integer n) {
		
		myQueue = new MessageQueue(a);
		nNodes = n;
		nowRunning = new Message[nNodes];
		nodes = new ArrayList<Node>();
		for(int i=0;i<nNodes;i++) {
			String ns = "Node " + i;
			nodes.add(new Node(ns));
		}
	}
	public void run() {
		while(!finished) {
			// Have any of the now running jobs just finished?
			for(int n=0;n<nNodes;n++) {
				if(nowRunning[n]==null || nowRunning[n].getComplete()) {
					nowRunning[n] = null;
					runHighestPriority(n);
				}
			}
			int nRunning = 0;
			for(int n=0;n<nNodes;n++) {
				if(nowRunning[n]!=null) {
					nRunning++;
				}
			}
			if(myQueue.size() == 0 && nRunning == 0) {
				finished = true;
			}
		}
		// Display the load of each node
		System.out.println();
		System.out.println();
		System.out.println("Node loads");
		for(int i=0;i<nNodes;i++) {
			System.out.println("Node " + i + ": " + nodes.get(i).getLoad());
		}
	}
	
	public void addMessage(Message m) {
		myQueue.addMessage(m);
	}
	private void runHighestPriority(Integer nodeID) {
		
		ArrayList<Integer> runningCategories = new ArrayList<Integer>();
		for(int i=0;i<nNodes;i++) {
			if(nowRunning[i]!=null) {
				runningCategories.add(nowRunning[i].getCategory());
			}
		}
		Message thisMessage = myQueue.getHighestPriority(runningCategories);
		if(thisMessage!=null) {
			nodes.get(nodeID).setMessage(thisMessage);
			nowRunning[nodeID] = thisMessage;
			Thread t = new Thread(nodes.get(nodeID));
			t.start();
		}
	}

}