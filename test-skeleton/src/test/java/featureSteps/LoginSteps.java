package featureSteps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import api.GETCalls;
import api.POSTCalls;
import api.PUTCalls;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class LoginSteps {

	GETCalls getCalls = new GETCalls();
	PUTCalls putCalls = new PUTCalls();
	POSTCalls postCalls = new POSTCalls();
	int loginResponse;

	@Given("^User with \"([^\"]*)\" is not registered$")
	public void user_with_is_not_registered(String userName) throws Exception {
		assertFalse(String.format("User %s should not be registered. Preconditions are not met!", userName),
				getCalls.VerifyUserRegistered(userName));
	}

	@When("^Registering new \"([^\"]*)\" with adequate password$")
	public void registering_new_with_adequate_password(String userName) throws Throwable {
		putCalls.registerUser(userName);
	}

	@When("^Registering new \"([^\"]*)\" with \"([^\"]*)\"$")
	public void registering_new_with_adequate(String userName, String password) throws Throwable {
		putCalls.registerUser(userName, password);
	}

	@Then("^User \"([^\"]*)\" should be registered$")
	public void user_should_be_registered(String userName) throws Throwable {
		assertTrue(String.format("User %s should be registered.", userName), getCalls.VerifyUserRegistered(userName));
	}

	@Then("^User \"([^\"]*)\" should not be registered$")
	public void user_should_not_be_registered(String userName) throws Throwable {
		assertFalse(String.format("User %s should not be registered.", userName),
				getCalls.VerifyUserRegistered(userName));
	}

	@When("^That registered user \"([^\"]*)\" sends login request with adequate password$")
	public void that_registered_user_sends_login_request_with_adequate_password(String userName) throws Throwable {
	loginResponse = postCalls.validateLogin(userName);
	}

	@Then("^That user \"([^\"]*)\" should be logged in$")
	public void that_user_should_be_logged_in(String userName) throws Throwable {
	assertTrue(String.format("User %s should be logged in. Instead, response is: %2s", userName, loginResponse), loginResponse == 200);
	}
	
	@Then("^That user \"([^\"]*)\" should not be logged in$")
	public void that_user_should_not_be_logged_in(String userName) throws Throwable {
		assertFalse(String.format("User %s should not be logged in. Instead, response is: %2s", userName, loginResponse), loginResponse == 200);
	}

	@When("^That registered user sends login request with username  \"([^\"]*)\" and \"([^\"]*)\"$")
	public void that_registered_user_sends_login_request_with_username_and(String userName, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginResponse = postCalls.validateLogin(userName, password);
	}
}
