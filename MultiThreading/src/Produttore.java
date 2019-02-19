import java.util.Date;

public class Produttore implements Runnable{
	private BufferI buffer;
	int i = 0;
	
	public Produttore(BufferI buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while(true) {
			buffer.inserisci(new Date());
		}
		
	}
}
