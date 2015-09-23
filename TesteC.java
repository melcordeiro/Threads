import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.lang.*;

public class TesteC implements Runnable{

	static Thread threadListen;
	static Thread threadPushNumber;	
	static Thread threadPopNumber;

	static List<Integer> numberstack;
	
	
	public static void main (String[] args) {
	TesteC e = new TesteC();
	
	
	threadPushNumber = new Thread(e);
	threadPopNumber = new Thread(e);
	threadListen = new Thread(e);
	numberstack = new ArrayList();

	threadListen.start();
	threadPopNumber.start();
	threadPushNumber.start();
	
		
	
	
	
}
	public void run() {
		Thread currentThread = Thread.currentThread();
		BufferedReader imput = new BufferedReader(new InputStreamReader(System.in));
		//InputStreamReader(System.in));
		String line = "";
		do
		{	
			try 
			{
				line = imput.readLine();
				if ((currentThread == threadPushNumber) && (line.equals("push")))
					push();
				else if ((currentThread == threadPopNumber) && (line.equals("pop")))
					pop();
	
			}
			catch (IOException exception) {}
		}


		while(!line.equals("stop"));
		
			
		for(Integer i: numberstack)
		{
			
		System.out.printf("");
		}
		
		
		
		
		
		
		
		
		
	}

	

	public void listenKeyboard()
	{
		
	}
		
	
	public Integer calculateRandomNumber()
	{
		Random gerador = new Random();
		return (Integer)10000;
	}

	public void pop()
	{
		
		Integer i = numberstack.get(0);
		numberstack.remove(0);
		System.out.printf("Removed +" + i + "from the stack.");
		
	}
	
	public void push() 
	{
		
		numberstack.add(calculateRandomNumber());
		System.out.println("Added "+ numberstack.get(numberstack.size()-1) + " to the stack.");
	}
}

