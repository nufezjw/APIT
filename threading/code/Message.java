public class Message {
	private Integer category;
	private Integer timeToRun;
	private Boolean isComplete = false;
	public Message(Integer c, Integer t) {
		category = c;
		timeToRun = t;
	}

	public Integer getCategory() {
		return category;
	}

	public Integer getTimeToRun() {
		return timeToRun;
	}

	public void complete() {
		// Do something here
		isComplete = true;
	}
	public Boolean getComplete() {
		return isComplete;
	}

}