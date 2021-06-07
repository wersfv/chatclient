package server;

import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.PrintWriter; 
import java.net.ServerSocket; 
import java.net.Socket; 

public class server { 
	private static ServerSocket serverSocket; // ���� ���� 
	private static BufferedReader br; // Ŭ���̾�Ʈ�κ��� ���޹��� �޽����� �о�帱 ���� �޸� 
	private static PrintWriter pw; // Ŭ���̾�Ʈ�� �޽����� ���� 
	private static Socket clientSocket; // Ŭ���̾�Ʈ ����
	
	public static void main(String[] args) {
		socketServer(); 
	} 
	
	public static void socketServer() {
		init(); 
	} 
	
	public static void init() { 
		try { 
			serverSocket = new ServerSocket(8981); // ���� �����Ƿ� 8981��Ʈ�� ����Ͽ� ���� ���� 
			System.out.println("Server is ready"); 
			System.out.println("connect clinet..."); 
			
			clientSocket = serverSocket.accept(); // 
			System.out.println("Client has accepted"); 
			br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // Ŭ���̾�Ʈ�� ���� �����͸� �о�� �غ� 
			pw = new PrintWriter(clientSocket.getOutputStream());// Ŭ���̾�Ʈ�� ���� �����͸� ���� �غ� 
			String readData = ""; // Ŭ���̾�Ʈ�� ���� �о�� �����͸� ������ ����
			while (!(readData = br.readLine()).equals(null)) { 
				System.out.println("from Client>" + readData); 
				pw.println(readData);// ���� �޽����� �״�� Ŭ���̾�Ʈ�� �ٽ� ����
				pw.flush();// ����Ʈ ������ �޸𸮸� �ʱ�ȭ ���Ѿ� �����Ͱ� ������ 
				} 
				clientSocket.close(); 
			} catch (Exception e) { 
				e.printStackTrace(); 
			} 
	}

}