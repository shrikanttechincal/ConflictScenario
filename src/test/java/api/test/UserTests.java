package api.test;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User payload;
	public Logger logger;
	
	@BeforeClass
public void setupData() {
	faker =new Faker();
	payload=new User();
	payload.setId(faker.idNumber().hashCode());
	payload.setUsername(faker.name().username());
	payload.setFirstName(faker.name().firstName());
	payload.setLastName(faker.name().lastName());
	payload.setEmail(faker.internet().safeEmailAddress());
	payload.setPassword(faker.internet().password(5,10));
	payload.setPhone(faker.phoneNumber().cellPhone());
	logger=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testPostUser() {
		logger.info("*********************");
		Response response=UserEndPoints.createUser(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("*********************User is created");
	}
	
	@Test(priority=2)
	public void testGetUserByName() {
		Response response=UserEndPoints.ReadUser(this.payload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("*********************User info is displayed");
	}
	
	@Test(priority=3)
	public void testUpdateUserByName() {
		
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());

		Response response=UserEndPoints.updateUser(this.payload.getUsername(), payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		Response responseAfterUpdate=UserEndPoints.ReadUser(this.payload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
		logger.info("*********************User info is updateed");

	}
	@Test(priority=4)
	public void testDeleteUserByName() {
		Response response=	UserEndPoints.deleteUser(this.payload.getUsername());
	Assert.assertEquals(response.getStatusCode(),200);
	logger.info("*********************User info is delete1wd");
	
	}
	}
