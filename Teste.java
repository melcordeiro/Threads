import java.io.*;
import java.util.Random;

public class Teste implements Runnable{
	static Thread threadCalculate;
	static Thread threadListen;
	static Thread threadKeyboard;	
	
	long totalPrimesFound = 0;
	
	public static void main (String[] args) {
	Teste e = new Teste();
	
	threadCalculate = new Thread(e);
	threadListen = new Thread(e);
	threadKeyboard = new Thread(e);
	
	threadCalculate.start();
	threadListen.start();
	threadKeyboard.start();
}
	public void run() {
		Thread currentThread = Thread.currentThread();
		
		if (currentThread == threadCalculate)
			calculateRandom();
		else if (currentThread == threadKeyboard)
			readKeyboard();
		else if (currentThread == threadListen)
			listenForStop();
	}

/*	public void calculatePrimes() {
		int n = 1;
		while (true) {
			n++;
			boolean isPrime = true;
			for (int i = 2; i < n; i++)
				if ((n / i) * i == n) {
					isPrime = false;
					break;
					}
				if (isPrime) {
					totalPrimesFound++;
					System.out.println(n);
					}
		}
	}
*/

	public void readKeyboard(){
		BufferedReader imput = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		
		if(!line.equals(null)){
			line = imput.readLine();
		}
		
			/*while (!line.equals(null)){
				try{
					line = imput.readLine();
				 }
				 catch(IOException.exception){};
			*/
				 
		System.out.println("");
		}
	
	public void calculateRandom(){
		Random gerar = new Random();
		
		boolean resultado = gerador.nextBoolean();
		
		System.out.println(resultado);
		}
	
	private void listenForStop() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String line = "";

		while (!line.equals("stop")) {
			try {
				line = input.readLine();
				}
			catch (IOException exception) {}
			}
		System.out.println("Found " + totalPrimesFound + " prime numbers before you said stop");
		System.exit(0);
	}
}
