package org.slc.sli.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slc.sli.client.RESTClient;
import org.slc.sli.json.bean.AppsData;
import org.slc.sli.json.bean.UserData;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * <b>This Class is utility class to retrieve list of user accessible applications.</b>
 * @author Manoj Mali
 * 
 * 
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

	
	
	public static boolean isAdmin(UserData userdata){
		boolean isAdmin=false;
		if(Validator.isNotNull(userdata)){
			String[] granted_authorities = userdata.getGranted_authorities();
			for(String role : granted_authorities){
				if(role.equalsIgnoreCase(GetterUtil.getString(PropsUtil.get(WgenPropsKeys.ROLE_IT_ADMINISTRATOR))) || 
						role.equalsIgnoreCase( GetterUtil.getString(PropsUtil.get(WgenPropsKeys.ROLE_SLI_ADMINISTRATOR))))
				{
					isAdmin=true;
					break;
				}
			}
		}
		return isAdmin;
	}
	
	
	
	public static UserData getUserData(String token)
			throws IOException {
			return instance._getUserData(token);
			}

			private UserData _getUserData(String token){
				JsonObject json  = getRestClient().sessionCheck(token);
				UserData userData = new Gson().fromJson(json, UserData.class);
				return userData;
			}
			
			
			
	
	
	/**
	 * <b>This Method returns List of App accessible to user.</b>
	 * 
	 * @author Manoj Mali
	 * @param token - OAuth token retrieved from liferay session
	 * @return List of AppsData
	 * @throws IOException
	 */
	
	public static List<AppsData> getUserApps(String token) throws IOException {

				return instance._getUserApps(token);
	}
	
	/**
	 *<b> This method maps list of Apps to UserData Bean.</b>
	 * 
	 * @author Manoj Mali
	 * @param token - OAuth Token retrieved from liferay session
	 * @return List of AppsData
	 * @throws IOException
	 */
	private List<AppsData> _getUserApps(String token) throws IOException{
		
		List<AppsData> listApps = new ArrayList<AppsData>();
		
		_log.info("calling restclient");
			
		//call rest client and retrieve json array
		JsonArray jsonArray = getRestClient().callUserApps(token);

		for (JsonElement jsonEle : jsonArray) {
			
			AppsData apps = new AppsData();

			String name = jsonEle.getAsJsonObject().get("name").toString().replaceAll("\"", "");
			String description = jsonEle.getAsJsonObject().get("description").toString().replaceAll("\"", "");
			String behaviour = jsonEle.getAsJsonObject().get("behavior").toString().replaceAll("\"", "");
			String imageUrl = jsonEle.getAsJsonObject().get("image_url").toString().replaceAll("\"", "");
			String applicationUrl = jsonEle.getAsJsonObject().get("application_url").toString();

			

			// Map Name,Description,Image url and app Url to bean
			if(!applicationUrl.equalsIgnoreCase("\"\"")){
				applicationUrl = applicationUrl.replaceAll("\"","");
				
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
			
			// add apps data bean to list
			listApps.add(apps);
			}
		}

		return listApps;

	}

	private static Log _log = LogFactoryUtil.getLog(AppsUtil.class);

	private static AppsUtil instance;
}