package featureSteps;

import static org.junit.Assert.assertTrue;

import api.GETCalls;
import api.POSTCalls;
import api.PUTCalls;
import cucumber.api.java.en.When;
import enums.Actions;
import enums.StringToActions;
import cucumber.api.java.en.Then;

public class ActionSteps {

	GETCalls getCalls = new GETCalls();
	PUTCalls putCalls = new PUTCalls();
	POSTCalls postCalls = new POSTCalls();
	StringToActions actionHelper = new StringToActions();

	@When("^User \"([^\"]*)\" perform \"([^\"]*)\"$")
	public void user_perform(String userName, String action) throws Throwable {
		putCalls.addEntry(actionHelper.ActionHelper(action), userName);
	}

	@Then("^Adequate \"([^\"]*)\" for user \"([^\"]*)\" should be recorded$")
	public void adequate_for_user_should_be_recorded(String action, String userName) throws Throwable {
		assertTrue(String.format("Action type of user: %s should be: %2s.", userName, action),
				getCalls.VerifyActionForUser(userName, actionHelper.ActionHelper(action)));
	}

	@When("^User \"([^\"]*)\" perform \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_perform_and(String userName, String action1, String action2) throws Throwable {
		putCalls.addEntries(actionHelper.ActionHelper(action1), userName);
		putCalls.addEntries(actionHelper.ActionHelper(action2), userName);
	}

	@Then("^User \"([^\"]*)\" actions \"([^\"]*)\" and \"([^\"]*)\" should be recorded$")
	public void user_actions_and_should_be_recorded(String userName, String action1, String action2) throws Throwable {
		// Actions[] actions = { actionHelper.ActionHelper(action1), actionHelper.ActionHelper(action2) };
		assertTrue(String.format("Action type of user: %s should be: %2s, %3s.", userName, action1, action2),
				getCalls.VerifyActionForUser(userName, actionHelper.ActionHelper(action1))
						&& getCalls.VerifyActionForUser(userName, actionHelper.ActionHelper(action2)));
	}
}
