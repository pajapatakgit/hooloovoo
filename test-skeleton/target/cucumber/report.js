$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("LoginTest.feature");
formatter.feature({
  "line": 2,
  "name": "Testing task for Hooloovoo",
  "description": "I want to point out people in Hooloovoo that I am very good tester :)",
  "id": "testing-task-for-hooloovoo",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    }
  ]
});
formatter.scenarioOutline({
  "line": 6,
  "name": "Happy Flow: Username should be between 6 and 50 characters",
  "description": "",
  "id": "testing-task-for-hooloovoo;happy-flow:-username-should-be-between-6-and-50-characters",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "User with \"\u003cusername\u003e\" is not registered",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Registering new \"\u003cusername\u003e\" with adequate password",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Registering should be sucessful",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "User \"\u003cusername\u003e\" is registered",
  "keyword": "And "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "testing-task-for-hooloovoo;happy-flow:-username-should-be-between-6-and-50-characters;",
  "rows": [
    {
      "cells": [
        "username"
      ],
      "line": 13,
      "id": "testing-task-for-hooloovoo;happy-flow:-username-should-be-between-6-and-50-characters;;1"
    },
    {
      "cells": [
        "user1"
      ],
      "line": 14,
      "id": "testing-task-for-hooloovoo;happy-flow:-username-should-be-between-6-and-50-characters;;2"
    },
    {
      "cells": [
        "thisisusernamewithfiftycharactersthisisusernamewit"
      ],
      "line": 15,
      "id": "testing-task-for-hooloovoo;happy-flow:-username-should-be-between-6-and-50-characters;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
  "name": "Happy Flow: Username should be between 6 and 50 characters",
  "description": "",
  "id": "testing-task-for-hooloovoo;happy-flow:-username-should-be-between-6-and-50-characters;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    },
    {
      "line": 5,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "User with \"user1\" is not registered",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Registering new \"user1\" with adequate password",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Registering should be sucessful",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "User \"user1\" is registered",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "user1",
      "offset": 11
    }
  ],
  "location": "LoginSteps.user_with_is_not_registered(String)"
});
formatter.result({
  "duration": 943554500,
  "error_message": "java.lang.AssertionError: User user1 should not be regestered. Preconditions are not met.\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat org.junit.Assert.assertFalse(Assert.java:64)\r\n\tat featureSteps.LoginSteps.user_with_is_not_registered(LoginSteps.java:18)\r\n\tat ✽.Given User with \"user1\" is not registered(LoginTest.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "user1",
      "offset": 17
    }
  ],
  "location": "LoginSteps.registering_new_with_adequate_password(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginSteps.registering_should_be_sucessful()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "user1",
      "offset": 6
    }
  ],
  "location": "LoginSteps.user_is_registered(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 15,
  "name": "Happy Flow: Username should be between 6 and 50 characters",
  "description": "",
  "id": "testing-task-for-hooloovoo;happy-flow:-username-should-be-between-6-and-50-characters;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    },
    {
      "line": 5,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "User with \"thisisusernamewithfiftycharactersthisisusernamewit\" is not registered",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Registering new \"thisisusernamewithfiftycharactersthisisusernamewit\" with adequate password",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Registering should be sucessful",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "User \"thisisusernamewithfiftycharactersthisisusernamewit\" is registered",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "thisisusernamewithfiftycharactersthisisusernamewit",
      "offset": 11
    }
  ],
  "location": "LoginSteps.user_with_is_not_registered(String)"
});
formatter.result({
  "duration": 8460700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "thisisusernamewithfiftycharactersthisisusernamewit",
      "offset": 17
    }
  ],
  "location": "LoginSteps.registering_new_with_adequate_password(String)"
});
formatter.result({
  "duration": 210900,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.registering_should_be_sucessful()"
});
formatter.result({
  "duration": 124200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "thisisusernamewithfiftycharactersthisisusernamewit",
      "offset": 6
    }
  ],
  "location": "LoginSteps.user_is_registered(String)"
});
formatter.result({
  "duration": 176200,
  "status": "passed"
});
});