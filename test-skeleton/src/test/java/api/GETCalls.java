package api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.http.HttpResponse;

import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import enums.Actions;
import enums.StringToActions;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.reflect.TypeToken;
import model.ActionModel;
import model.User;

public class GETCalls {

	private final CloseableHttpClient httpClient = HttpClients.createDefault();
	StringToActions stringToActions = new StringToActions();

	public void close() throws IOException {
		httpClient.close();
	}

	// Actions
	private HttpResponse sendGet(String userName) throws Exception {

		HttpGet request = new HttpGet(Paths.localhost + Paths.findByUsername + userName);
		HttpResponse response = httpClient.execute(request);
		return response;
	}

	public User getUser(String userName) throws Exception {
		var response = sendGet(userName);
		var jsonString = EntityUtils.toString(response.getEntity());
		close();
		Gson gson = new Gson();
		User user = gson.fromJson(jsonString, User.class);
		return user;
	}

	// Verifications
	public boolean VerifyUserRegistered(String userName) throws Exception {
		var path = Paths.localhost + Paths.findByUsername + userName;
		HttpGet request = new HttpGet(path);
		request.addHeader("accept", "*/*");
		HttpResponse response = httpClient.execute(request);
		var body = EntityUtils.toString(response.getEntity());
		var state = body.contains(userName);
		//close();
		return state;
	}

	public boolean VerifyActionForUser(String userName, Actions action) throws Exception {

		var actionPath = Paths.localhost + Paths.findEntriesForUser + "%7Busername%7D?username=" + userName;
		HttpGet request = new HttpGet(actionPath);

		HttpResponse response = httpClient.execute(request);
		var jsonString = EntityUtils.toString(response.getEntity());

		Gson gson = new Gson();

		Type collectionType = new TypeToken<Collection<ActionModel>>() {
		}.getType();
		Collection<ActionModel> actionList = gson.fromJson(jsonString, collectionType);

		for (ActionModel actionModel : actionList) {
			if (actionModel.getAction().equals(action))
				return true;
		}
		return false;
	}

//	public boolean VerifyActionsForUser(String userName, Actions[] actions) throws Exception {
//
//		var actionPath = Paths.localhost + Paths.findEntriesForUser + "%7Busername%7D?username=" + userName;
//		HttpGet request = new HttpGet(actionPath);
//
//		HttpResponse response = httpClient.execute(request);
//		var jsonString = EntityUtils.toString(response.getEntity());
//
//		Gson gson = new Gson();
//
//		Type collectionType = new TypeToken<Collection<ActionModel>>() {
//		}.getType();
//		Collection<ActionModel> modelsList = gson.fromJson(jsonString, collectionType);
//
//		// TODO Comparison
//		return true;
//	}
}