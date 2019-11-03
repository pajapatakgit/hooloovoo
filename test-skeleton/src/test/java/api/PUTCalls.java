package api;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class PUTCalls {

	private final CloseableHttpClient httpClient = HttpClients.createDefault();

	public void close() throws IOException {
		httpClient.close();
	}

	private CloseableHttpResponse sendPutJson(String path, String json) throws Exception {

		HttpPut put = new HttpPut(Paths.localhost + path);

		put.addHeader("Content-Type", "application/json");
		put.addHeader("accept", "*/*");

		HttpEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
		put.setEntity(stringEntity);
		CloseableHttpResponse response = httpClient.execute(put);
		return response;
	}

	public void registerUser(String userName) throws Exception {

		String JSON_STRING = String.format("{\"password\": \"Passwrd1!\", \"username\": \"%s\"}", userName);
		var response = sendPutJson(Paths.registerUser, JSON_STRING);
		var responseCode = response.getStatusLine().getStatusCode();
		if (responseCode != 201)
			System.out.println(
					String.format("Ooops, registering user with adequtate password %s failed with HTTP code: %2s!", userName, responseCode));
		//close();
	}

	public void registerUser(String userName, String password) throws Exception {

		String JSON_STRING = String.format("{\"password\": \"%s\", \"username\": \"%2s\"}", password, userName);
		var response = sendPutJson(Paths.registerUser, JSON_STRING);
		var responseCode = response.getStatusLine().getStatusCode();
		if (responseCode != 201)
			System.out.println(
					String.format("Ooops, registering user %s failed with HTTP code: %2s!", userName, responseCode));
	//	close();
	}

	public void addEntry(enums.Actions action, String userName) throws ClientProtocolException, IOException {
		
		var putPath = Paths.localhost + Paths.addEntry + "?action=" + action + "&username=" + userName;
		HttpPut put = new HttpPut(putPath);

		CloseableHttpResponse response = httpClient.execute(put);
		var responseCode = response.getStatusLine().getStatusCode();
		if (responseCode != 201)
			System.out.println(String.format("Ooops, %s for user %2s failed with HTTP code: %3s!", action, userName,
					responseCode));
		close();
	}
	
public void addEntries(enums.Actions action, String userName) throws ClientProtocolException, IOException {
		
		var putPath = Paths.localhost + Paths.addEntry + "?action=" + action + "&username=" + userName;
		HttpPut put = new HttpPut(putPath);

		CloseableHttpResponse response = httpClient.execute(put);
		var responseCode = response.getStatusLine().getStatusCode();
		if (responseCode != 201)
			System.out.println(String.format("Ooops, %s for user %2s failed with HTTP code: %3s!", action, userName,
					responseCode));
		}

}
