package com.test;

import junit.framework.TestCase;
import org.slc.sli.login.servlet.filters.sso.wgensso.WgenSSOUtil;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import org.slc.sli.login.util.WgenUtil;
import org.slc.sli.json.bean.UserData;
import com.google.gson.Gson;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author 
 */

public class WgenSSOTest extends TestCase{
	
	private String jsonString="{\"all_roles\":[{\"name\":\"Aggregate Viewer\",\"id\":\"7022bb7a-f1e5-4414-94a0-c9c86c170861\",\"rights\":[\"AGGREGATE_READ\"],\"springRoleName\":\"ROLE_AGGREGATE_VIEWER\",\"roleAsEntityBody\":{\"name\":\"Aggregate Viewer\",\"rights\":[\"AGGREGATE_READ\"]}},{\"name\":\"Educator\",\"id\":\"e650f9c8-1436-4e4b-b5a9-84ef6a272820\",\"rights\":[\"READ_GENERAL\",\"AGGREGATE_READ\"],\"springRoleName\":\"ROLE_EDUCATOR\",\"roleAsEntityBody\":{\"name\":\"Educator\",\"rights\":[\"READ_GENERAL\",\"AGGREGATE_READ\"]}},{\"name\":\"IT Administrator\",\"id\":\"e6a6836b-fbbe-4c5f-b254-f21741ae31ac\",\"rights\":[\"READ_GENERAL\",\"WRITE_RESTRICTED\",\"AGGREGATE_READ\",\"WRITE_GENERAL\",\"READ_RESTRICTED\"],\"springRoleName\":\"ROLE_IT_ADMINISTRATOR\",\"roleAsEntityBody\":{\"name\":\"IT Administrator\",\"rights\":[\"READ_GENERAL\",\"WRITE_RESTRICTED\",\"AGGREGATE_READ\",\"WRITE_GENERAL\",\"READ_RESTRICTED\"]}},{\"name\":\"SLI Administrator\",\"id\":\"690b687c-2e1f-4ca3-b220-ffc04ccaac33\",\"rights\":[\"ADMIN_ACCESS\"],\"springRoleName\":\"ROLE_SLI_ADMINISTRATOR\",\"roleAsEntityBody\":{\"name\":\"SLI Administrator\",\"rights\":[\"ADMIN_ACCESS\"]}},{\"name\":\"Leader\",\"id\":\"f7d50010-4f4c-4656-bba1-cbdf3175f891\",\"rights\":[\"READ_GENERAL\",\"AGGREGATE_READ\",\"READ_RESTRICTED\"],\"springRoleName\":\"ROLE_LEADER\",\"roleAsEntityBody\":{\"name\":\"Leader\",\"rights\":[\"READ_GENERAL\",\"AGGREGATE_READ\",\"READ_RESTRICTED\"]}}],\"authenticated\":true,\"full_name\":\"Mario Sanchez\",\"granted_authorities\":[\"Educator\"],\"realm\":\"dc=slidev,dc=net\",\"sessionId\":\"AQIC5wM2LY4SfcyaJiToADqmtWSaROyLgJGiOlhqzp40yT0.*AAJTSQACMDE.*\",\"user_id\":\"mario.sanchez@dc=slidev,dc=net\"}";

	public WgenSSOTest() {
		if (System.getProperty("external-properties") == null) {
				System.setProperty("external-properties", "portal-test.properties");
			}
	}

	public void testScreenName(){
		JsonParser parser = new JsonParser();
		JsonObject jsonObj = (JsonObject)parser.parse(jsonString);

		UserData userData = new Gson().fromJson(jsonObj, UserData.class);
		
		assertNotNull("Screen Name Should not be null",userData.getUser_id());
		assertEquals("mario.sanchez_dc_slidev_dc_net",WgenSSOUtil.convertScreenName("mario.sanchez@dc=slidev,dc=net"));
	}



	public void testRoles(){
		JsonParser parser = new JsonParser();
		JsonObject jsonObj = (JsonObject)parser.parse(jsonString);

		UserData userData = new Gson().fromJson(jsonObj, UserData.class);

		assertEquals(false,isAdmin(userData));
	}


	public void testUserFullName(){
		JsonParser parser = new JsonParser();
		JsonObject jsonObj = (JsonObject)parser.parse(jsonString);

		UserData userData = new Gson().fromJson(jsonObj, UserData.class);

		assertNotNull("FullName Should not be null",userData.getFull_name());
	}

	protected boolean isAdmin(UserData userdata){
		boolean isAdmin=false;
		if(Validator.isNotNull(userdata)){
			String[] granted_authorities = userdata.getGranted_authorities();
			for(String role : granted_authorities){
				if(role.equalsIgnoreCase("IT_ADMINISTRATOR") || 
						role.equalsIgnoreCase( "SLI_ADMINISTRATOR"))
				{
					isAdmin=true;
					break;
				}
			}
		}
		return isAdmin;
	}


}