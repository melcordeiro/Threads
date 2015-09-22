import java.io.*;
import java.util.List;
import java.util.Random;

public class Teste implements Runnable{

	static Thread threadMain;
	static Thread threadPushNumber;	
	static Thread threadPopNumber;

	static List<Integer> numberstack;
	
	
	public static void main (String[] args) {
	Teste e = new Teste();
	
	
	threadPushNumber = new Thread(e);
	threadPopNumber = new Thread(e);
	threadListen = new Thread(e);
	

	threadListen.start();
	
}
	public void run() {
		Thread currentThread = Thread.currentThread();
		
		if (currentThread == threadPushNumber)
			push();
		else if (currentThread == threadPopNumber)
			pop();
		else if (currentThread = threadListen)
			listenKeyboard();
		
	}

	

	public voidlistenKeyboard();
	{
		InputStreamReader(System.in));
		String line = "";
		do
		{	
			try 
			{
				line = input.readLine();
				if(line.equals("push")
				{
				  threadPushNumber.start();
				  threadPopNumber.stop();	
				}
				else if(line.equals("pop")
				{
				  threadPushNumber.stop();
				  threadPopNumber.start();	
				}	
				
			}
			catch (IOException exception) {}
		}


		while (!line.equals("stop"))}
		for(Integer i: numberstack)
		{
		
			
		}

	}

	public Integer calculateRandomNumber(){
		Random gerador = new Random();
		
		Integer resultado = gerador.nextInt(10000);
		
		
		}

	public void pop()
	{
		
		Integer i = numberstack.get(0);
		numberstack.remove(0);
		System.out.printf("Removed +" i + "from the stack.");
		

		try
		{
		threadPopNumber.sleep(3000);
	
		}catch(Exception e){}
		
	}
	
	public void push() {
		numberstack.add(calculateRandomNumber());
		System.out.printf("Added "+ numberstack.get(numberstack.lengh-1) + "to the stack.");

		try
		{
		threadPushNumber.sleep(3000);
	
		}catch(Exception e){}
		
		
	}
}
