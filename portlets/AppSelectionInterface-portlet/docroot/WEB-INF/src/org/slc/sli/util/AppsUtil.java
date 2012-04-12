package org.slc.sli.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slc.sli.client.RESTClient;
import org.slc.sli.json.bean.AppsData;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONTransformer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * <p>
 * See http://issues.liferay.com/browse/LEP-5943.
 * </p>
 * 
 * @author Prashant Dighe
 * @author Brian Wing Shun Chan
 * @author Wesley Gong
 */

public class AppsUtil {

	private RESTClient restClient;

	public RESTClient getRestClient() {
		return restClient;
	}

	public void setRestClient(RESTClient restClient) {
		this.restClient = restClient;
	}

	public AppsUtil() {
		this.instance = this;
	}

	public static List<AppsData> getUserApps(String token) throws IOException {

				return instance._getUserApps(token);
	}
	
	
	private List<AppsData> _getUserApps(String token) throws IOException{
		
		List<AppsData> listApps = new ArrayList<AppsData>();
		System.out.println("calling restclient");

		//RESTClient restClient = new RESTClient();
	
		
		JsonArray jsonArray = getRestClient().sessionCheck(token);

		for (JsonElement jsonEle : jsonArray) {
			AppsData apps = new AppsData();

			String name = jsonEle.getAsJsonObject().get("name").toString();
			String description = jsonEle.getAsJsonObject().get("description").toString();
			String behaviour = jsonEle.getAsJsonObject().get("behavior").toString();
			String imageUrl = jsonEle.getAsJsonObject().get("image_url").toString();
			String applicationUrl = jsonEle.getAsJsonObject().get("application_url").toString();

			System.out.println("name---" + name);
			System.out.println("description---"+description);
			System.out.println("behaviour---"+behaviour);
			System.out.println("image url---"+imageUrl);
			System.out.println("app url---"+applicationUrl);

			apps.setName(name);
			apps.setDescription(description);
			apps.setBehaviour(behaviour);
			apps.setImage_url(imageUrl);
			apps.setApplication_url(applicationUrl);
			listApps.add(apps);
		}

		return listApps;

	}

	private static Log _log = LogFactoryUtil.getLog(AppsUtil.class);

	private static AppsUtil instance;

	/*public static void main(String[] args) throws IOException {
		String jsonText = "[{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Sample App\",\"name\":\"Sample\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"Acme\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Sample App\",\"name\":\"Sample\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"Acme\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"SLI dashboard application\",\"name\":\"Dashboard\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"organization\":\"SLI\",\"license_acceptance\":true}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"SLI dashboard application (integration server)\",\"name\":\"Dashboard (Integration)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"organization\":\"SLI\",\"license_acceptance\":true}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"SLI dashboard application (deployment server)\",\"name\":\"Dashboard (Deployment)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"organization\":\"SLI\",\"license_acceptance\":true}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"SLI dashboard application (CI server)\",\"name\":\"Dashboard (CI)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"organization\":\"SLI\",\"license_acceptance\":true}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Admin app integration server\",\"name\":\"Admin App (Integration)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Administers SLI.\",\"name\":\"Admin App\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Administers SLI.\",\"name\":\"Admin App\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Admin app deployment server\",\"name\":\"Databrowser (Deployment)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Databrowser integration server\",\"name\":\"Databrowser (Integration)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"SLI Databrowser\",\"name\":\"Databrowser\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Databrowser deployment server\",\"name\":\"Databrowser (Deployment)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Databrowser NXBuild server\",\"name\":\"Databrowser (NXBuild)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Dashboard NXBuild server\",\"name\":\"Dashboard (NXBuild)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"AdminTools NXBuild server\",\"name\":\"AdminTools (NXBuild)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Databrowser NXBuild2 server\",\"name\":\"Databrowser (NXBuild2)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Dashboard NXBuild2 server\",\"name\":\"Dashboard (NXBuild2)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":true,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"AdminTools NXBuild2 server\",\"name\":\"AdminTools (NXBuild2)\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Portal Devlr1\",\"name\":\"Portal Devlr1\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Portal Devlr2\",\"name\":\"Portal Devlr2\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"Portal Testlr1\",\"name\":\"Portal Testlr1\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}},{\"behavior\":\"Full Window App\",\"version\":\"1.0\",\"is_admin\":false,\"image_url\":\"http://placekitten.com/150/150\",\"description\":\"SDK Sample Application\",\"name\":\"SDK Sample\",\"application_url\":\"\",\"administration_url\":\"http://devadmin1.slidev.org/apps\",\"developer_info\":{\"license_acceptance\":true,\"organization\":\"SLI\"}}]";
		getUserApps("e88cb6d1-771d-46ac-a207-2e58d7f12196");
	}*/
}