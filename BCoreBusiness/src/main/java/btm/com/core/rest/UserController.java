package btm.com.core.rest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import btm.com.common.integrationmessage.IntegrationMessage;
import btm.com.common.integrationmessage.IntegrationMessageBody;
import btm.com.common.integrationmessage.IntegrationMessageHeader;
import btm.com.common.model.UserProfileMessage;
import btm.com.core.model.UserProfile;
import btm.com.core.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;

	// Get all user
	@PostMapping("/all")
	public IntegrationMessage getAll(@RequestBody String msg) {
		IntegrationMessage msgResponse = new IntegrationMessage();
		IntegrationMessageHeader header = new IntegrationMessageHeader();
		IntegrationMessageBody body = new IntegrationMessageBody();
		try {
			Gson gson = new Gson();
			msgResponse = gson.fromJson(msg, IntegrationMessage.class);
			List<UserProfileMessage> userProfileMessage = msgResponse.getBody().getUserProfileMessage();
			List<UserProfile> userProfiles = userService.findAll();
			for (UserProfile userProfile : userProfiles) {
				UserProfileMessage userProfileMessages = new UserProfileMessage();
				userProfileMessages.setEmail(userProfile.getEmail());
				userProfileMessages.setUserPwd(userProfile.getUserPwd());
				userProfileMessages.setFullName(userProfile.getFullName());
				userProfileMessages.setPhone(userProfile.getPhone());
				userProfileMessages.setDob(userProfile.getDob());
				userProfileMessages.setGender(userProfile.getGender());
				userProfileMessages.setCreatedAt(userProfile.getCreatedAt());
				userProfileMessage.add(userProfileMessages);
			}
			header.setErrorCode("USR003");
			header.setErrorDetail("All users have been loaded successfully!");
			header.getAddressIp();

			body.setUserProfileMessage(userProfileMessage);

			msgResponse.setBody(body);
			msgResponse.setHeader(header);
		} catch (Exception e) {
			header.setErrorCode("USR001");
			header.setErrorDetail("The attempt to load all users has failed.");
			header.getAddressIp();
			msgResponse.setHeader(header);
		}
		return msgResponse;
	}

	// Search user by name
	@GetMapping("/search")
	public IntegrationMessage findProductByNameLike(@QueryParam("msg") String msg) {
		IntegrationMessage msgResponse = new IntegrationMessage();
		IntegrationMessageHeader header = new IntegrationMessageHeader();
		IntegrationMessageBody body = new IntegrationMessageBody();
		try {
			Gson gson = new Gson();
			msgResponse = gson.fromJson(msg, IntegrationMessage.class);
			List<UserProfileMessage> userProfileMessages = msgResponse.getBody().getUserProfileMessage();
			for (UserProfileMessage userProfileMessage : userProfileMessages) {
				List<UserProfile> userProfile = userService
						.findUserByFullNameLike("%" + userProfileMessage.getFullName() + "%");
				if (userProfile.size() > 0) {
					for (UserProfile userProfiles : userProfile) {
						userProfileMessage.setEmail(userProfiles.getEmail());
						userProfileMessage.setFullName(userProfiles.getFullName());
						userProfileMessage.setPhone(userProfiles.getPhone());
						userProfileMessage.setDob(userProfiles.getDob());
						userProfileMessage.setGender(userProfiles.getGender());
					}
					header.setErrorCode("USR003");
					header.setErrorDetail("A user has been successfully found!");
					header.getAddressIp();
					body.setUserProfileMessage(userProfileMessages);
					msgResponse.setHeader(header);
					msgResponse.setBody(body);
				} else {
					header.setErrorCode("USR002");
					header.setErrorDetail("The user could not be found.");
					header.getAddressIp();
					msgResponse.setHeader(header);
					msgResponse.setBody(body);
				}
			}
		} catch (Exception e) {
			header.getAddressIp();
			header.setErrorCode("USR002");
			header.setErrorDetail("Not found");
			msgResponse.setHeader(header);
		}

		return msgResponse;
	}

	// Insert new user for Point of sale machine
	@PostMapping("/insert")
	public IntegrationMessage insert(@RequestBody String msg) {
		IntegrationMessage msgResponse = new IntegrationMessage();
		IntegrationMessageHeader header = new IntegrationMessageHeader();
		IntegrationMessageBody body = new IntegrationMessageBody();
		try {
			Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
			msgResponse = gson.fromJson(msg, IntegrationMessage.class);
			List<UserProfileMessage> userProfileMessages = msgResponse.getBody().getUserProfileMessage();
			for (UserProfileMessage userProfileMessage : userProfileMessages) {
				Optional<UserProfile> userProfile = userService.findEmail(userProfileMessage.getEmail());
				if (userProfile.isPresent()) {
					header.setErrorCode("USR002");
					header.setErrorDetail("Email already existed!");
					msgResponse.setBody(body);
					msgResponse.setHeader(header);
				} else {

					UserProfile insertedUserProfile = new UserProfile();
					// get data from userProfileMessage
					insertedUserProfile.setEmail(userProfileMessage.getEmail());
					insertedUserProfile.setFullName(userProfileMessage.getFullName());
					insertedUserProfile.setUserPwd(userProfileMessage.getUserPwd());
					insertedUserProfile.setPhone(userProfileMessage.getPhone());
					insertedUserProfile.setDob(userProfileMessage.getDob());
					insertedUserProfile.setGender(userProfileMessage.getGender());
					insertedUserProfile.setCreatedAt(userProfileMessage.getCreatedAt());
					///
					userService.save(insertedUserProfile);

					header.setErrorCode("USR004");
					header.setErrorDetail("A user has been added successfully!");
					body.setUserProfileMessage(userProfileMessages);
					msgResponse.setBody(body);
					msgResponse.setHeader(header);

				}
			}
		} catch (Exception e) {
			header.setErrorCode("USER003");
			header.setErrorDetail("This user cannot be inserted.");
			msgResponse.setBody(body);
			msgResponse.setHeader(header);
			e.printStackTrace();
		}

		return msgResponse;
	}

	// Register new user for web
	@PostMapping("/register")
	public IntegrationMessage register(@RequestBody String msg) {
		IntegrationMessage msgResponse = new IntegrationMessage();
		IntegrationMessageHeader header = new IntegrationMessageHeader();
		IntegrationMessageBody body = new IntegrationMessageBody();
		try {
			Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
			msgResponse = gson.fromJson(msg, IntegrationMessage.class);
			List<UserProfileMessage> userProfileMessages = msgResponse.getBody().getUserProfileMessage();
			for (UserProfileMessage userProfileMessage : userProfileMessages) {
				Optional<UserProfile> userProfile = userService.findEmail(userProfileMessage.getEmail());
				if (userProfile.isPresent()) {
					header.setErrorCode("USR002");
					header.setErrorDetail("Email already existed!");
					msgResponse.setBody(body);
					msgResponse.setHeader(header);
				} else {

					UserProfile insertedUserProfile = new UserProfile();
					// get data from userProfileMessage
					insertedUserProfile.setEmail(userProfileMessage.getEmail());
					insertedUserProfile.setFullName(userProfileMessage.getFullName());
					insertedUserProfile.setUserPwd(userProfileMessage.getUserPwd());
					insertedUserProfile.setPhone(userProfileMessage.getPhone());
					insertedUserProfile.setDob(userProfileMessage.getDob());
					insertedUserProfile.setGender(userProfileMessage.getGender());
					insertedUserProfile.setCreatedAt(userProfileMessage.getCreatedAt());
					///
					userService.save(insertedUserProfile);

					header.setErrorCode("USR004");
					header.setErrorDetail("A user has been added successfully!");
					body.setUserProfileMessage(userProfileMessages);
					msgResponse.setBody(body);
					msgResponse.setHeader(header);

				}
			}
		} catch (Exception e) {
			header.setErrorCode("USER003");
			header.setErrorDetail("This user cannot be inserted.");
			msgResponse.setBody(body);
			msgResponse.setHeader(header);
			e.printStackTrace();
		}

		return msgResponse;
	}

	// Authenticate login user
	@PostMapping("/authenticate")
	public IntegrationMessage authenticate(@RequestBody String msg) {
	    IntegrationMessage msgResponse = new IntegrationMessage();
	    IntegrationMessageHeader header = new IntegrationMessageHeader();
	    IntegrationMessageBody body = new IntegrationMessageBody();
	    
	    try {
	        // Change JSON to Object
	        Gson gson = new Gson();
	        msgResponse = gson.fromJson(msg, IntegrationMessage.class);
	        List<UserProfileMessage> userProfileMessages = msgResponse.getBody().getUserProfileMessage();
	        
	        for (UserProfileMessage userProfileMessage : userProfileMessages) {
	            List<UserProfile> userProfiles = userService.authenticate(userProfileMessage.getEmail(), userProfileMessage.getUserPwd());
	            
	            if (userProfiles.size() > 0) {
	                for (UserProfile userProfile : userProfiles) {
	                    if (userProfile.isEnabled()) {
	                        // Only allow login if the user's profile is enabled
	                        userProfileMessage.setEmail(userProfile.getEmail());
	                        userProfileMessage.setFullName(userProfile.getFullName());
	                        userProfileMessage.setPhone(userProfile.getPhone());
	                        userProfileMessage.setDob(userProfile.getDob());
	                        userProfileMessage.setGender(userProfile.getGender());
	                        
	                        header.setErrorCode("USR003");
	                        header.setErrorDetail("Login successfully!");
	                        body.setUserProfileMessage(userProfileMessages);
	                        msgResponse.setHeader(header);
	                        msgResponse.setBody(body);
	                    } else {
	                        // User's profile is not enabled
	                        header.setErrorCode("USR004"); // You can use a specific error code for this scenario
	                        header.setErrorDetail("User account is not enabled!");
	                        msgResponse.setHeader(header);
	                        msgResponse.setBody(body);
	                    }
	                }
	            } else {
	                header.setErrorCode("USR002");
	                header.setErrorDetail("Invalid email or password!");
	                msgResponse.setHeader(header);
	                msgResponse.setBody(body);
	            }
	        }
	    } catch (Exception e) {
	        header.getAddressIp();
	        header.setErrorCode("USR002");
	        header.setErrorDetail("Login failed!");
	        msgResponse.setHeader(header);
	    }
	    
	    return msgResponse;
	}


	// Get single user depend on user email
	@PostMapping
	public IntegrationMessage get(@RequestBody String msg) {
		IntegrationMessage msgResponse = new IntegrationMessage();
		IntegrationMessageHeader header = new IntegrationMessageHeader();
		IntegrationMessageBody body = new IntegrationMessageBody();
		try {
			Gson gson = new Gson();
			msgResponse = gson.fromJson(msg, IntegrationMessage.class);
			List<UserProfileMessage> userProfileMessages = msgResponse.getBody().getUserProfileMessage();
			for (UserProfileMessage userProfileMessage : userProfileMessages) {
				List<UserProfile> userProfile = userService.get(userProfileMessage.getEmail());
				if (userProfile.size() > 0) {
					for (UserProfile userProfiles : userProfile) {
						userProfileMessage.setEmail(userProfiles.getEmail());
						userProfileMessage.setFullName(userProfiles.getFullName());
						userProfileMessage.setPhone(userProfiles.getPhone());
						userProfileMessage.setDob(userProfiles.getDob());
						userProfileMessage.setGender(userProfiles.getGender());
					}
					header.setErrorCode("USR003");
					header.setErrorDetail("A user has been successfully found!");
					header.getAddressIp();
					body.setUserProfileMessage(userProfileMessages);
					msgResponse.setHeader(header);
					msgResponse.setBody(body);
				} else {
					header.setErrorCode("USR002");
					header.setErrorDetail("The user could not be found.");
					header.getAddressIp();
					msgResponse.setHeader(header);
					msgResponse.setBody(body);
				}
			}
		} catch (Exception e) {
			header.getAddressIp();
			header.setErrorCode("USR002");
			header.setErrorDetail("The user could not be found.");
			msgResponse.setHeader(header);
		}

		return msgResponse;
	}

	// Change password depend on email user
	@PutMapping("/changepass")
	public IntegrationMessage changePass(@RequestBody String msg) {
		IntegrationMessage msgResponse = new IntegrationMessage();
		IntegrationMessageHeader header = new IntegrationMessageHeader();
		IntegrationMessageBody body = new IntegrationMessageBody();

		try {
			Gson gson = new Gson();
			msgResponse = gson.fromJson(msg, IntegrationMessage.class);
			List<UserProfileMessage> userProfileMessages = msgResponse.getBody().getUserProfileMessage();
			for (UserProfileMessage userProfileMessage : userProfileMessages) {
				Optional<UserProfile> userProfile = userService.findEmail(userProfileMessage.getEmail());
				if (userProfile.isPresent()) {
					userProfile.map(x -> {
						x.setUserPwd(userProfileMessage.getUserPwd());
						return userService.save(x);
					}).orElseGet(() -> {
						return null;
					});
					body.setUserProfileMessage(userProfileMessages);
					header.setErrorCode("USR003");
					header.setErrorDetail("The password has been changed successfully!");
					msgResponse.setBody(body);
					msgResponse.setHeader(header);
				} else {
					header.setErrorCode("USR002");
					header.setErrorDetail("Email does not exist.");
					msgResponse.setHeader(header);
					msgResponse.setBody(body);

				}
			}
		} catch (Exception e) {
			header.getAddressIp();
			header.setErrorCode("USR002");
			header.setErrorDetail("The password cannot be changed.");
			msgResponse.setHeader(header);
			e.printStackTrace();
		}
		return msgResponse;
	}

	// Update user profile
	@PutMapping("/updateinfo")
	public IntegrationMessage updateInfo(@RequestBody String msg) {
		IntegrationMessage msgResponse = new IntegrationMessage();
		IntegrationMessageHeader header = new IntegrationMessageHeader();
		IntegrationMessageBody body = new IntegrationMessageBody();
		try {
			Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
			msgResponse = gson.fromJson(msg, IntegrationMessage.class);
			List<UserProfileMessage> userProfileMessages = msgResponse.getBody().getUserProfileMessage();
			for (UserProfileMessage userProfileMessage : userProfileMessages) {
				Optional<UserProfile> userProfile = userService.findEmail(userProfileMessage.getEmail());
				// Check email exist
				if (userProfile.isPresent()) {
					// Replace new data
					userProfile.map(x -> {
						x.setFullName(userProfileMessage.getFullName());
						x.setPhone(userProfileMessage.getPhone());
						x.setDob(userProfileMessage.getDob());
						x.setGender(userProfileMessage.getGender());
						x.setUpdatedAt(new Date());
						return userService.save(x);
					}).orElseGet(() -> {
						return null;
					});
					body.setUserProfileMessage(userProfileMessages);
					header.setErrorCode("USR003");
					header.setErrorDetail("The user has been updated successfully!");
					msgResponse.setBody(body);
					msgResponse.setHeader(header);
				} else {
					header.setErrorCode("USR002");
					header.setErrorDetail("Email not existed!");
					msgResponse.setHeader(header);
					msgResponse.setBody(body);

				}
			}

		} catch (

		Exception e) {
			header.getAddressIp();
			header.setErrorCode("USR002");
			header.setErrorDetail("The user cannot be updated.");
			msgResponse.setHeader(header);
			e.printStackTrace();
		}

		return msgResponse;
	}

	// Enable user account
	@PutMapping("/status")
	public IntegrationMessage activated(@RequestBody String msg) {
		IntegrationMessage msgResponse = new IntegrationMessage();
		IntegrationMessageHeader header = new IntegrationMessageHeader();
		IntegrationMessageBody body = new IntegrationMessageBody();

		try {
			Gson gson = new Gson();
			msgResponse = gson.fromJson(msg, IntegrationMessage.class);
			List<UserProfileMessage> userProfileMessages = msgResponse.getBody().getUserProfileMessage();
			for (UserProfileMessage userProfileMessage : userProfileMessages) {
				Optional<UserProfile> userProfile = userService.findEmail(userProfileMessage.getEmail());
				if (userProfile.isPresent()) {
					userProfile.map(x -> {
						x.setEnabled(userProfileMessage.isEnabled());
						return userService.save(x);
					}).orElseGet(() -> {
						return null;
					});
					body.setUserProfileMessage(userProfileMessages);
					header.setErrorCode("USR003");
					header.setErrorDetail("The user's status has been changed successfully.");
					msgResponse.setBody(body);
					msgResponse.setHeader(header);
				} else {
					header.setErrorCode("USR002");
					header.setErrorDetail("Email does not exist.");
					msgResponse.setHeader(header);
					msgResponse.setBody(body);
				}
			}
		} catch (Exception e) {
			header.getAddressIp();
			header.setErrorCode("USR002");
			header.setErrorDetail("The user's status cannot be changed.");
			msgResponse.setHeader(header);
			e.printStackTrace();
		}
		return msgResponse;
	}

	// Delete staff account
	@DeleteMapping("/delete")
	public IntegrationMessage delete(@RequestBody String msg) {
		IntegrationMessage msgResponse = new IntegrationMessage();
		IntegrationMessageHeader header = new IntegrationMessageHeader();
		IntegrationMessageBody body = new IntegrationMessageBody();

		try {
			Gson gson = new Gson();
			msgResponse = gson.fromJson(msg, IntegrationMessage.class);
			List<UserProfileMessage> userProfileMessages = msgResponse.getBody().getUserProfileMessage();
			for (UserProfileMessage userProfileMessage : userProfileMessages) {
				Optional<UserProfile> userProfile = userService.findEmail(userProfileMessage.getEmail());
				if (userProfile.isPresent()) {
					userService.delete(userProfileMessage.getEmail());
					header.setErrorCode("USR003");
					header.setErrorDetail("The user has been deleted successfully!");
					msgResponse.setBody(body);
					msgResponse.setHeader(header);
				} else {
					header.setErrorCode("USR002");
					header.setErrorDetail("Email does not exist.");
					msgResponse.setHeader(header);
					msgResponse.setBody(body);

				}
			}
		} catch (Exception e) {
			header.getAddressIp();
			header.setErrorCode("USR002");
			header.setErrorDetail("The user cannot be deleted.");
			msgResponse.setHeader(header);
			e.printStackTrace();
		}
		return msgResponse;
	}

}