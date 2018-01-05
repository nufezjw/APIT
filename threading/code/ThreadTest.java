import java.util.*;

public class ThreadTest {
	


	public static void main(String[] args) {
		System.out.println("ThreadTest!");

		Integer nNodes = Integer.parseInt(args[0]);
		ArrayList<Message> alm = new ArrayList<Message>();
		alm.add(new Message(2,1000));
		alm.add(new Message(1,500));
		alm.add(new Message(2,100));
		alm.add(new Message(0,100));
		alm.add(new Message(1,100));
		alm.add(new Message(2,100));
		alm.add(new Message(0,100));
		alm.add(new Message(0,100));
		alm.add(new Message(0,100));

		Scheduler s = new Scheduler(alm,nNodes);
		Thread a = new Thread(s);
		a.start();

		s.addMessage(new Message(3,500));
		s.addMessage(new Message(3,500));
		s.addMessage(new Message(3,500));
		s.addMessage(new Message(4,50));
		s.addMessage(new Message(4,50));
		s.addMessage(new Message(4,50));
		s.addMessage(new Message(3,500));
		s.addMessage(new Message(3,500));
		s.addMessage(new Message(3,500));

		// Node n = new Node("Node 1");
		// Thread t = new Thread(n);
		// Message m = new Message(1,100);
		// n.setMessage(m);
		// t.start();


	}
}