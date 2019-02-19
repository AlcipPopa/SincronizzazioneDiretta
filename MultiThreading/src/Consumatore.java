
public class Consumatore implements Runnable{
	private BufferI buffer;
	int i = 0;
	
	public Consumatore(BufferI buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while (true) {
			buffer.rimuovi();
		}
		
	}
	
	
}
