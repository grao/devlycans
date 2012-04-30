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

public class AppSelInterfaceTest extends TestCase {
	
	private String token = "e88cb6d1-771d-46ac-a207-2e58d7f12196";
	private String userAppsArray ="[{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"SLI dashboard application\",\"name\":\"Dashboard\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"organization\":\"SLI\",\"license_acceptance\":true}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"SLI dashboard application (integration server)\",\"name\":\"Dashboard (Integration)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"organization\":\"SLI\",\"license_acceptance\":true}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"SLI dashboard application (deployment server)\",\"name\":\"Dashboard (Deployment)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"organization\":\"SLI\",\"license_acceptance\":true}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"SLI dashboard application (CI server)\",\"name\":\"Dashboard (CI)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"organization\":\"SLI\",\"license_acceptance\":true}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Dashboard NXBuild server\",\"name\":\"Dashboard (NXBuild)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Dashboard NXBuild2 server\",\"name\":\"Dashboard (NXBuild2)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Portal Devlr1\",\"name\":\"Portal Devlr1\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Portal Devlr2\",\"name\":\"Portal Devlr2\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Portal Testlr1\",\"name\":\"Portal Testlr1\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"SDK Sample Application\",\"name\":\"SDK Sample\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}}]";
	
	
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
	public void testIs_Admin(){
		
		JsonParser parser = new JsonParser();
		JsonArray jsonArray = parser.parse(userAppsArray).getAsJsonArray();
		
		for (JsonElement jsonEle : jsonArray) {
			boolean is_admin = jsonEle.getAsJsonObject().get("is_admin").getAsBoolean();
			
			assertEquals(false, is_admin);
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
	private static Log _log = LogFactoryUtil.getLog(AppSelInterfaceTest.class);
	
}
