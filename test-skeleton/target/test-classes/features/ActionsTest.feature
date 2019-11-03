Feature: Testing task for Hooloovoo regarding actions 
	I want to point out people in Hooloovoo that I am very good tester :)


Scenario Outline: Recording user's action 
	Given Registering new "<username>" with adequate password 
	When User "<username>" perform "<action>" 
	Then Adequate "<action>" for user "<username>" should be recorded 
	
	Examples: 
		|username 			|action	|
		|actionUserLogin 	|LOGIN 	|
		|actionUserSave		|SAVE	|
		|actionUserUpdate	|UPDATE	|
		|actionUserDelete	|DELETE	|
		
		
Scenario Outline: Recording user's actions 
	Given Registering new "<username>" with adequate password 
	When User "<username>" perform "<action1>" and "<action2>" 
	Then User "<username>" actions "<action1>" and "<action2>" should be recorded 
	
	Examples: 
		|username 			|action1	|action2	|
		|actionsUserLS1 	|LOGIN 		|SAVE		|
		|actionsUserSU1		|SAVE		|UPDATE		|
		|actionsUserUD1 	|UPDATE		|DELETE		|
		|actionsUserDL1 	|DELETE		|LOGIN		|