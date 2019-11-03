Feature: Testing task for Hooloovoo regarding login
	I want to point out people in Hooloovoo that I am very good tester :)


Scenario Outline: Happy Flow: Username should be between 6 and 50 characters 
	Given User with "<username>" is not registered 
	When Registering new "<username>" with adequate password 
	Then User "<username>" should be registered 
	
	Examples: 
		|username                                          |
		|abcdef                              		   |
		|thisistextwithfiftycharachtersthisistextwithfiftyc|
		
		
Scenario Outline: Non Happy Flow: Username should not be less than 6 or more than 50 charachters 
	Given User with "<username>" is not registered 
	When Registering new "<username>" with adequate password 
	Then User "<username>" should not be registered 
	
	Examples: 
		|username                                            |
		|fiver                                               |
		|thisisusernamewithfiftyonecharactersthisisusernamew |
		
		
Scenario Outline: Happy Flow: Password should contain number, special characters, upper and lover case 
	Given User with "<username>" is not registered 
	When Registering new "<username>" with adequate "<password>" 
	Then User "<username>" should be registered 
	Examples: 
		| username 				| password		|
		| userWithGoodPass		| paSsword1!	|
		
		
Scenario Outline: Non Happy Flow: Password should contain number, special characters, upper and lover case 
	Given User with "<username>" is not registered 
	When Registering new "<username>" with "<password>" 
	Then User "<username>" should not be registered 
	
	Examples: 
		| username 				| password	|
		| userPassNoNumbers		| paSsword!	|
		| userPassNoSpecials	| paSSWord1	|
		| userPassNoUpperCase	| password1!|
		| userPassNoLowerCase	| PASSWORD1!|
		
		
Scenario Outline: Registered user should login 
	Given Registering new "<username>" with adequate "<password>" 
	When That registered user "<username>" sends login request with adequate password
	Then That user "<username>" should be logged in 
	Examples: 
		| username 				| 
		| perfectlyGoodUser		| 
		
		
Scenario Outline: Not registered user, user without a password, user with wrong password, user without username at login should not login
	Given Registering new "<username1>" with adequate "<password1>" 
	When That registered user sends login request with username  "<username2>" and "<password2>"
	Then That user "<username2>" should not be logged in 
	Examples: 
		| username1 				| username2			| password1 	| password2 	|
		| registeredUser			| notRegisteredUsr	| Password1! 	| Password1! 	|
		| userWithWrongPass			| userWithWrongPass	| Password1!	| passWor1!d	|
		| userWithoutUserName		| 					| Password1!	| Password1!	|
		
		
Scenario Outline: Checking if registered user exists
	When Registering new "<username>" with adequate password 
	Then User "<username>" should be registered 
		Examples: 
		| username 		| 
		| userInSystem	| 
