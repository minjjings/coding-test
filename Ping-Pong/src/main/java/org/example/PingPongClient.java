package org.example;

import java.io.*;
import java.net.*;

public class PingPongClient {
    public static void main(String[] args) {

        try {
            String serverIp = "127.0.0.1";
            int serverPort = 7777;
            System.out.println("서버에 연결 중입니다. 서버 IP: " + serverIp + ", 포트: " + serverPort);

            // 서버와 연결
            Socket socket = new Socket(serverIp, serverPort);
            System.out.println("서버에 연결되었습니다.");

            // 소켓의 출력 스트림을 얻는다
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);

            // 소켓의 입력 스트림을 얻는다
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            // 첫 번째 메시지 전송: Ping
            String messageToSend = "Ping";
            dos.writeUTF(messageToSend);
            System.out.println("Sent: " + messageToSend);

            // 서버로부터 받은 첫 번째 응답 출력
            String response = dis.readUTF();
            System.out.println("Received: " + response);

            // 두 번째 메시지 전송: Ping
            messageToSend = "Ping";
            dos.writeUTF(messageToSend);
            System.out.println("Sent: " + messageToSend);

            // 서버로부터 받은 두 번째 응답 출력
            response = dis.readUTF();
            System.out.println("Received: " + response);

            // 세 번째 메시지 전송: foobar
            messageToSend = "foobar";
            dos.writeUTF(messageToSend);
            System.out.println("Sent: " + messageToSend);

            // 서버로부터 받은 세 번째 응답 출력
            response = dis.readUTF();
            System.out.println("Received: " + response);

            // 연결 종료 메시지 전송
            messageToSend = "exit";
            dos.writeUTF(messageToSend);


            // 연결 종료
            System.out.println("연결을 종료합니다.");
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
