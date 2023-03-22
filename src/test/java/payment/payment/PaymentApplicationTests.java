package payment.payment;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class PaymentApplicationTests {
	@Value("${imp-key}")
	private String impKey;
	@Value("${imp-secret}")
	private String impSecret;
	@Test
	void contextLoads() {
	}
	@Test
	void getIamportApiToken() throws Exception{
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("imp_key",impKey);
		params.add("imp_secret",impSecret);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);

		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> responseEntity = rt.exchange(
				"https://api.iamport.kr/users/getToken", //{요청할 서버 주소}
				HttpMethod.POST, //{요청할 방식}
				entity, // {요청할 때 보낼 데이터}
				String.class); //{요청시 반환되는 데이터 타입}

		JSONParser parser = new JSONParser();
		JSONObject object = (JSONObject) parser.parse(responseEntity.getBody().toString());

		JSONObject response=(JSONObject) object.get("response");

		System.out.println(response.get("access_token"));
	}

}
