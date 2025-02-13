package org.example;

import java.io.*;
import java.net.*;

public class PingPongServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            // 서버 소켓을 생성하고 7777번 포트와 결합
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 시작되었습니다. 클라이언트의 연결을 기다립니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                // 클라이언트 연결 대기
                Socket socket = serverSocket.accept();
                System.out.println("클라이언트가 연결되었습니다.");

                // 소켓의 입력 스트림을 얻는다
                InputStream in = socket.getInputStream();
                DataInputStream dis = new DataInputStream(in);

                // 소켓의 출력 스트림을 얻는다
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                // 클라이언트가 메시지를 보내면 응답을 계속 받기 위해 루프
                while (true) {
                    String receivedMessage = dis.readUTF();
                    System.out.println("Received: " + receivedMessage);

                    // 3초 대기
                    Thread.sleep(3000);  // 3초 대기

                    // Ping에 대해서는 Pong 응답, 그 외 메시지는 그대로 응답
                    String responseMessage;
                    if ("Ping".equalsIgnoreCase(receivedMessage)) {
                        responseMessage = "Pong";
                    } else {
                        responseMessage = receivedMessage;
                    }
                    dos.writeUTF(responseMessage);
                    System.out.println("Sent: " + responseMessage);

                    // 만약 클라이언트가 "exit" 메시지를 보냈다면 연결을 종료
                    if ("exit".equalsIgnoreCase(receivedMessage)) {
                        break;  // 루프 종료 후 소켓 닫기
                    }
                }

                // 연결 종료
                dos.close();
                dis.close();
                socket.close();
                System.out.println("클라이언트와의 연결을 종료합니다.");

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
