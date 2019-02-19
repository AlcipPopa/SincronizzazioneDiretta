import java.util.Date;

public class BufferLimitato implements BufferI{
	private Date[] buffer;
	private int in, out, count;
	private final int BUFFER_SIZE = 5;
	
	public BufferLimitato() {
		buffer = new Date[BUFFER_SIZE];
		in = 0;
		out = 0;
		count = 0;
	}
	
	public synchronized void inserisci(Date data) {
		while (count == BUFFER_SIZE) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		
		++count;
		buffer[in] = data;
		System.out.println("inserito " + data);
		in = (in + 1) % BUFFER_SIZE;
		
		if (count == BUFFER_SIZE) {
			System.out.println("Buffer pieno!");
		}
		notifyAll();
	}
	
	public synchronized Date rimuovi() {
		Date data;
		
		while (count == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		
		data = buffer[out];
		System.out.println("rimosso " + data);
		out = (out + 1) % BUFFER_SIZE;
		--count;
		
		if (count == 0) {
			System.out.println("Buffer vuoto!");
		}
		
		notifyAll();
		return data;		
	}
}
