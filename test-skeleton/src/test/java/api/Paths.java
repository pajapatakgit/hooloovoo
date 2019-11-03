package api;

public final class Paths {
	
	public static final String localhost = "http://localhost:9762/audit";

	public static final String addEntry = "/audit/add";
	public static final String findEntriesForUser = "/audit/user/"; // username
	
	public static final String error = "/error";
	
	public static final String findByUsername = "/users/"; // username
	public static final String validateLogin = "/users/login"; 
	public static final String registerUser = "/users/register";

}
