package lab_7_timeout_manager_with_pq;

import java.util.*;

public class TimeoutManager {
	// Priority queue for timeout items. The timeout item with the lowest
	// callback time is the first to be dequeued.
	protected PriorityQueue<TimeoutItem> pq = new PriorityQueue<TimeoutItem>();

	// A clock used to get the current time in the addTimeout() and
	// update() method.
	protected MillisecondClock clock;

	public TimeoutManager(MillisecondClock clock) {
		this.clock = clock;
	}

	// Returns a reference to this timeout manager's internal priority queue.
	// Used only for grading purposes.
	public PriorityQueue<TimeoutItem> getPriorityQueue() {
		return pq;
	}

	// Adds a timeout item, given a callback method and delay time as
	// parameters. The added timeout expires at:
	// (clock's current time when this method is called) + (delay time)
	public void addTimeout(CallbackMethod callback, int delayBeforeCallback) {
		this.pq.add(new TimeoutItem(callback, clock.getTime() + delayBeforeCallback));
	}

	// Dequeues each expired timeout item from the priority queue and calls each
	// expired item's callback method.
	public void update() {
		while (!this.pq.isEmpty() && this.pq.peek().getCallbackTime() <= this.clock.getTime()) {
			pq.peek().callCallback();
			pq.remove();
		}
	}
}
