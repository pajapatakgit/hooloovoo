package api;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class POSTCalls {

	private final CloseableHttpClient httpClient = HttpClients.createDefault();
	
	private CloseableHttpResponse sendPostJson(String path, String json) throws Exception {

		HttpPost post = new HttpPost(Paths.localhost + path);

		post.addHeader("Content-Type", "application/json");
		post.addHeader("accept", "*/*");

		HttpEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
		post.setEntity(stringEntity);
		CloseableHttpResponse response = httpClient.execute(post);
		return response;
	}

	public void close() throws IOException {
		httpClient.close();
	}
	
	// Send POST to login user and send response code
	public int validateLogin (String userName, String password) throws Exception {

		String JSON_STRING = String.format("{\"password\": \"%s\", \"username\": \"%2s\"}", password, userName);
		var response = sendPostJson(Paths.validateLogin, JSON_STRING);
		var responseCode = response.getStatusLine().getStatusCode();
		if (responseCode != 200)
			System.out.println(
					String.format("Ooops, login of user %s failed with HTTP code: %2s!", userName, responseCode));
		System.out.println(String.format("User %s succesfully logged in.", userName));
		close();
		return responseCode;
	}
	
	// Send POST to login user and send response code
		public int validateLogin (String userName) throws Exception {

			String JSON_STRING = String.format("{\"password\": \"Password1!\", \"username\": \"%2s\"}", userName);
			var response = sendPostJson(Paths.validateLogin, JSON_STRING);
			var responseCode = response.getStatusLine().getStatusCode();
			if (responseCode != 200)
				System.out.println(
						String.format("Ooops, login of user %s failed with HTTP code: %2s!", userName, responseCode));
			System.out.println(String.format("User %s succesfully logged in.", userName));
			close();
			return responseCode;
		}
	
	
}
