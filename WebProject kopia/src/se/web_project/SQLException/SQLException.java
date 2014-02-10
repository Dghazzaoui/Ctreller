package se.web_project.SQLException;

public class SQLException extends Exception {

	private static final long serialVersionUID = 6497191729830639182L;

	public SQLException(String errMsg) {
		super(errMsg);
	}
}