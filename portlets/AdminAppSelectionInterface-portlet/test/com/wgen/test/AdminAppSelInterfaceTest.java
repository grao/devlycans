package com.wgen.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.slc.sli.json.bean.AppsData;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;



//import com.liferay.portal.kernel.test.TestCase;

public class AdminAppSelInterfaceTest extends TestCase {
	
	private String token = "e88cb6d1-771d-46ac-a207-2e58d7f12196";
	private String userAppsArray ="[{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Sample App\",\"name\":\"Sample\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"Acme\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Sample App\",\"name\":\"Sample\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"Acme\"}},{\"behavior\":\"Full Window App\",\"endpoints\":[{\"name\":\"Application Registration\",\"description\":\"Register an application that can access SLI API.\",\"url\":\"https://testadmin1.slidev.org/apps\",\"roles\":[\"SLI Administrator\"]},{\"name\":\"Realm Role Mapper\",\"description\":\"Control how roles are from a IDP are mapped to SLI roles.\",\"url\":\"https://testadmin1.slidev.org/realms/\",\"roles\":[\"SLI Administrator\"]},{\"name\":\"Role Viewer\",\"description\":\"View available roles.\",\"url\":\"https://testadmin1.slidev.org/\",\"roles\":[\"SLI Administrator\"]}],\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Admin app integration server\",\"name\":\"Admin App (Integration)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"endpoints\":[{\"name\":\"Application Registration\",\"description\":\"Register an application that can access SLI API.\",\"url\":\"http://local.slidev.org:3000/apps\",\"roles\":[\"SLI Administrator\"]},{\"name\":\"Realm Role Mapper\",\"description\":\"Control how roles are from a IDP are mapped to SLI roles.\",\"url\":\"http://local.slidev.org:3000/realms/\",\"roles\":[\"SLI Administrator\"]},{\"name\":\"Role Viewer\",\"description\":\"View available roles.\",\"url\":\"http://local.slidev.org:3000/\",\"roles\":[\"SLI Administrator\"]}],\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Administers SLI.\",\"name\":\"Admin App\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"endpoints\":[{\"name\":\"Application Registration\",\"description\":\"Register an application that can access SLI API.\",\"url\":\"http://localhost:3000/apps\",\"roles\":[\"SLI Administrator\"]},{\"name\":\"Realm Role Mapper\",\"description\":\"Control how roles are from a IDP are mapped to SLI roles.\",\"url\":\"http://localhost:3000/realms/\",\"roles\":[\"SLI Administrator\"]},{\"name\":\"Role Viewer\",\"description\":\"View available roles.\",\"url\":\"http://localhose:3000/\",\"roles\":[\"SLI Administrator\"]}],\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Administers SLI.\",\"name\":\"Admin App\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"endpoints\":[{\"name\":\"Application Registration\",\"description\":\"Register an application that can access SLI API.\",\"url\":\"https://devadmin1.slidev.org/apps\",\"roles\":[\"SLI Administrator\"]},{\"name\":\"Realm Role Mapper\",\"description\":\"Control how roles are from a IDP are mapped to SLI roles.\",\"url\":\"https://devadmin1.slidev.org/realms/\",\"roles\":[\"SLI Administrator\"]},{\"name\":\"Role Viewer\",\"description\":\"View available roles.\",\"url\":\"https://devadmin1.slidev.org/\",\"roles\":[\"SLI Administrator\"]}],\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Admin app deployment server\",\"name\":\"Databrowser (Deployment)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Databrowser integration server\",\"name\":\"Databrowser (Integration)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"SLI Databrowser\",\"name\":\"Databrowser\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Databrowser deployment server\",\"name\":\"Databrowser (Deployment)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Databrowser NXBuild server\",\"name\":\"Databrowser (NXBuild)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"AdminTools NXBuild server\",\"name\":\"AdminTools (NXBuild)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"AdminTools NXBuild2 server\",\"name\":\"AdminTools (NXBuild2)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Iframe App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"SDK Sample App CI server\",\"name\":\"SDK Sample App (CI)\",\"application_url\":\"https://ci.slidev.org/oauth2-sample/students\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}}]";
	
	
	/*
	 * Test to check user apps are retrieved or not
	 */
	@Test
	public void testGetUserApps() throws IOException{
		
		assertNotNull(_getUserApps(userAppsArray));
	}
	
		
	/*
	 * Test to check whether all non admin apps are retrieved or not
	 */
	@Test
	public void testIs_AdminApp(){
		
		JsonParser parser = new JsonParser();
		JsonArray jsonArray = parser.parse(userAppsArray).getAsJsonArray();
		
		for (JsonElement jsonEle : jsonArray) {
			boolean is_admin = jsonEle.getAsJsonObject().get("is_admin").getAsBoolean();
			
			assertEquals(true, is_admin);
		}
	}

	
	
	private List<AppsData> _getUserApps(String userAppsArray) throws IOException{
		
		List<AppsData> listApps = new ArrayList<AppsData>();

		JsonParser parser = new JsonParser();
		JsonArray jsonArray = parser.parse(userAppsArray).getAsJsonArray();

		for (JsonElement jsonEle : jsonArray) {
			AppsData apps = new AppsData();

			String name = jsonEle.getAsJsonObject().get("name").toString();
			String description = jsonEle.getAsJsonObject().get("description").toString();
			String behaviour = jsonEle.getAsJsonObject().get("behavior").toString();
			String imageUrl = jsonEle.getAsJsonObject().get("image_url").toString();
			String applicationUrl = jsonEle.getAsJsonObject().get("application_url").toString();

			_log.info("name---" + name);
			_log.info("description---"+description);
			_log.info("behaviour---"+behaviour);
			_log.info("image url---"+imageUrl);
			_log.info("app url---"+applicationUrl);

			apps.setName(name);
			apps.setDescription(description);
			apps.setBehaviour(behaviour);
			apps.setImage_url(imageUrl);
			apps.setApplication_url(applicationUrl);
			
			listApps.add(apps);
		}

		return listApps;

	}
	
	private static Log _log = LogFactoryUtil.getLog(AdminAppSelInterfaceTest.class);
	
}
