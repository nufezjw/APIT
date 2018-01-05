import java.util.*;
public class MessageQueue {
	ArrayList<Message> messageList;
	ArrayList<Double> priorityList;
	public MessageQueue(ArrayList<Message> m) {
		messageList = m;
		priorityList = new ArrayList<Double>();
		computePriorities();
	}

	private void computePriorities() {
		for(int i=0;i<messageList.size();i++) {
			priorityList.add(1.0*i);
		}
	}

	private void computePriorities(ArrayList<Integer> nowRunning) {
		for(int i=0;i<messageList.size();i++) {
			if(nowRunning.indexOf(messageList.get(i).getCategory()) != -1) {
				priorityList.set(i,0.0);
			}
		}
	}
	public int size() {
		return messageList.size();
	}
	public Message getHighestPriority(ArrayList<Integer> nowRunning) {
		if(messageList.size()>0) {
			computePriorities(nowRunning);
			Double bestPriority = priorityList.get(0);
			int bestIndex = 0;
			for(int i=0;i<messageList.size();i++){
				if(priorityList.get(i)<bestPriority) {
					bestPriority = priorityList.get(i);
					bestIndex = i;
				}
			}
			Double thisPriority = priorityList.remove(bestIndex);
			return messageList.remove(bestIndex);
		}else {
			return null;
		}
	}
	public void addMessage(Message m) {
		messageList.add(m);
		Double maxPriority = 0.0;
		for(int i=0;i<priorityList.size()-1;i++) {
			if(priorityList.get(i)>maxPriority) {
				maxPriority = priorityList.get(i);
			}
		}
		priorityList.add(maxPriority + 1.0);
	}
}