import java.util.concurrent.locks.Lock;

public class SynchronousCounter extends Counter {
	protected long total = super.total;

	@Override
	public synchronized void add(int amount) {
		total += amount;
	}
}
