import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Teste_cesar implements Runnable{

	static Thread threadListen;
	static Thread threadPushNumber;	
	static Thread threadPopNumber;

	static List<Integer> numberstack;
	
	
	public static void main (String[] args) {
	Teste e = new Teste();
	
	
	threadPushNumber = new Thread(e);
	threadPopNumber = new Thread(e);
	threadListen = new Thread(e);
	
	numberstack = new ArrayList();
	

	threadListen.start();
	/*threadPopNumber.start();
	threadPushNumber.start();*/
	
}
	public void run() {
		Thread currentThread = Thread.currentThread();
		
		if (currentThread == threadPushNumber)
			push();
		else if (currentThread == threadPopNumber)
			pop();
		else if (currentThread == threadListen)
			listenKeyboard();
		
	}

	

	public void listenKeyboard()
	{
		BufferedReader imput = new BufferedReader(new InputStreamReader(System.in));
		//InputStreamReader(System.in));
		String line = "";
		do
		{	
			try 
			{
				line = imput.readLine();
				if(line.equals("push"))
				{
				  threadPushNumber.start();
				  threadPopNumber.stop();	
				}
				else if(line.equals("pop"))
				{
				  threadPushNumber.stop();
				  threadPopNumber.start();	
				}	
				
			}
			catch (IOException exception) {}
		}


		while(!line.equals("stop"));
		
			
		for(Integer i: numberstack)
		{
			
		System.out.printf("");
		}
	}
		
	
	public Integer calculateRandomNumber()
	{
		Random gerador = new Random();
		return gerador.nextInt(10000);
	}

	public void pop()
	{
		
		Integer i = numberstack.get(0);
		numberstack.remove(0);
		System.out.printf("Removed +" + i + "from the stack.");
		

		try
		{
		threadPopNumber.sleep(3000);
	
		}catch(Exception e){}
		
	}
	
	public void push() 
	{
		numberstack.add(calculateRandomNumber());
		System.out.println("Added "+ numberstack.get(numberstack.size()-1) + "to the stack.");

		try
		{
		threadPushNumber.sleep(3000);
	
		}catch(Exception e){}
		
		
	}
}

