package enums;

public class StringToActions {

	public Actions ActionHelper(String action) {

		switch (action) {
		case "DELETE":
			return Actions.DELETE;

		case "LOGIN":
			return Actions.LOGIN;

		case "SAVE":
			return Actions.SAVE;

		case "UPDATE":
			return Actions.UPDATE;
		}

		return null;

	}

}
