package client;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.PrintWriter; 
import java.net.Socket; 
import java.util.Scanner; 

public class client { 
	private static Socket clientSocket; // Ŭ���̾�Ʈ ���� 
	private static BufferedReader br; // Ŭ���̾�Ʈ�κ��� ���޹��� �޽����� �о�帱 ���� �޸� 
	private static PrintWriter pw; // Ŭ���̾�Ʈ�� �޽����� ���� 
	private static Scanner sc; // ������ �Է� 
	
	public static void main(String[] args) { 
		socketClient(); 
	} 
	
	public static void socketClient() { 
		init(); 
	} 
	
	public static void init() { 
		try { 
			clientSocket = new Socket("localhost", 8981); 
			System.out.println("Server Connect");
			br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));// ������ ���� �����͸� �޾ƿ� �غ� 
			pw = new PrintWriter(clientSocket.getOutputStream());// ������ �����͸� ���� �غ� 
			sc = new Scanner(System.in);//�Է��� �����͸� ���� �غ� 
			
			//System.out.println(""); 
			String inputData = "";//�Է��� �����͸� ������ ����
			while(!inputData.equals("exit")) { 
				System.out.print("to Server: "); 
				pw.println(sc.next());//���� ������ �о�ͼ� ������ ������ 
				pw.flush();//������ ������ �޸𸮸� �ʱ�ȭ ���Ѽ� ���ο� �ִ� �����͸� ������ �����Ѵ� 
				
				System.out.println("from Server: " + br.readLine()); //�������� ���� �����͸� ǥ���Ѵ�. 
			} 
			clientSocket.close();//���� �����ϸ� ������ �ݴ´�. 
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
	} 
}