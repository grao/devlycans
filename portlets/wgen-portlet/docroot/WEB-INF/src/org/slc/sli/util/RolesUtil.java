package org.slc.sli.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.CookieUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.slc.sli.client.RESTClient;
import org.slc.sli.json.bean.UserData;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.springframework.web.util.WebUtils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.CharPool;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * See http://issues.liferay.com/browse/LEP-5943.
 * </p>
 *
 * @author Prashant Dighe
 * @author Brian Wing Shun Chan
 * @author Wesley Gong
 */

public class RolesUtil {

	private RESTClient restClient;

	public RESTClient getRestClient() {
		return restClient;
	}

	public void setRestClient(RESTClient restClient) {
		this.restClient = restClient;
	}

	public RolesUtil() {
		this.instance = this;
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
	
	private static Log _log = LogFactoryUtil.getLog(RolesUtil.class);

	private static RolesUtil instance;

}