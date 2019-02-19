public class Principale {
	public static void main(String[] args) {
		BufferI server = new BufferLimitato();

  		// now create the producer and consumer threads
  		Thread producerThread = new Thread(new Produttore(server));
  		Thread consumerThread = new Thread(new Consumatore(server));

  		producerThread.start();
  		consumerThread.start();
				
	}
}
