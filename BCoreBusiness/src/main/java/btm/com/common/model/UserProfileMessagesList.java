package btm.com.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserProfileMessagesList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<UserProfileMessage> userProfileMessages = new ArrayList<>();

	public List<UserProfileMessage> getUserProfileMessages() {
		return userProfileMessages;
	}

	public void setUserProfileMessages(List<UserProfileMessage> userProfileMessages) {
		this.userProfileMessages = userProfileMessages;
	}

	public void addUserProfileMessage(UserProfileMessage userProfileMessage) {
		userProfileMessages.add(userProfileMessage);
	}

}
