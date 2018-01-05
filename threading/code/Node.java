public class Node implements Runnable {

	private Message me;
	private String nodeName;
	private Double load = 0.0;
	public Node(String s) {
		nodeName = s;
	}
	public void run() {
		// Put your task statements in here
		try {
			System.out.println("Invoking job on node " + nodeName + " with category " + me.getCategory());
			Thread.sleep(me.getTimeToRun());
			load += me.getTimeToRun();
			me.complete();
		}catch (InterruptedException e) {
			// Don't need anything in here now
		}
	}
	public Double getLoad() {
		return load;
	}
	public void setMessage(Message m) {
		me = m;
	}

}