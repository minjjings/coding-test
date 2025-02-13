package com.brique.httprequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class HttprequestApplication {

	public static void main(String[] args) {
		String url = "http://codingtest.brique.kr:8080/random";  // 요청 URL
		RestTemplate restTemplate = new RestTemplate();

		// 응답에서 각 id의 빈도를 저장할 맵
		Map<Integer, Integer> idFrequency = new HashMap<>();

		// 100번 요청 보내기
		for (int i = 0; i < 100; i++) {
			// 응답 데이터를 받아옵니다
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
			String responseData = response.getBody();

			// 응답 데이터에서 id와 quote를 추출
			int id = extractId(responseData);
			String quote = extractQuote(responseData);

			// 각 id의 출현 횟수를 맵에 기록
			int currentCount = idFrequency.getOrDefault(id, 0) + 1;
			idFrequency.put(id, currentCount);

			// count와 함께 응답 데이터 출력
			System.out.println("count: " + currentCount + " " + responseData);
		}

		// 총합 계산
		int totalCount = 0;
		for (Map.Entry<Integer, Integer> entry : idFrequency.entrySet()) {
			totalCount += entry.getValue();
		}

		// 총합 출력
		System.out.println("Total count: " + totalCount);
	}

	// 응답 데이터에서 id 값을 추출하는 메서드
	private static int extractId(String responseData) {
		int idStart = responseData.indexOf("\"id\":") + 5; // "id": 뒤의 시작 인덱스
		int idEnd = responseData.indexOf(",", idStart); // id 끝 인덱스

		return Integer.parseInt(responseData.substring(idStart, idEnd).trim());  // id 부분만 추출하여 반환
	}

	// 응답 데이터에서 quote 값을 추출하는 메서드
	private static String extractQuote(String responseData) {
		int quoteStart = responseData.indexOf("\"quote\": \"") + 9; // "quote": " 뒤의 시작 인덱스
		int quoteEnd = responseData.indexOf("\"", quoteStart); // quote 끝 인덱스

		return responseData.substring(quoteStart, quoteEnd);  // quote 부분만 추출하여 반환
	}
}
