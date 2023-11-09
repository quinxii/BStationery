package btm.com.common.integrationmessage;

import java.io.Serializable;
import java.util.List;

import btm.com.common.model.ProductMessage;
import btm.com.common.model.UserProfileMessage;

public class IntegrationMessageBody implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<UserProfileMessage> userProfile;
	private List<ProductMessage> productModel;

	public List<UserProfileMessage> getUserProfileMessage() {
		return userProfile;
	}

	public List<ProductMessage> getProductModel() {
		return productModel;
	}

	public void setUserProfileMessage(List<UserProfileMessage> userProfile) {
		this.userProfile = userProfile;
	}

	public void setProductModel(List<ProductMessage> productModel) {
		this.productModel = productModel;
	}

	public IntegrationMessageBody(List<UserProfileMessage> userProfile, List<ProductMessage> productModel) {
		super();
		this.userProfile = userProfile;
		this.productModel = productModel;
	}

	public IntegrationMessageBody() {
	}
}
