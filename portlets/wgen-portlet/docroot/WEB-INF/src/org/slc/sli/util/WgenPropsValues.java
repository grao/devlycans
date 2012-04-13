package org.slc.sli.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;

public class WgenPropsValues {
	//public static final int ASSET_FILTER_SEARCH_LIMIT = GetterUtil.getInteger(PropsUtil.get(PropsKeys.ASSET_FILTER_SEARCH_LIMIT));
	
	//public static final boolean ASSET_ENTRY_INCREMENT_VIEW_COUNTER_ENABLED = GetterUtil.getBoolean(PropsUtil.get(PropsKeys.ASSET_ENTRY_INCREMENT_VIEW_COUNTER_ENABLED));
	
	public static String ROLE_IT_ADMINISTRATOR = GetterUtil.getString(PropsUtil.get(WgenPropsKeys.ROLE_IT_ADMINISTRATOR));
	
	public static String ROLE_SLI_ADMINISTRATOR = GetterUtil.getString(PropsUtil.get(WgenPropsKeys.ROLE_SLI_ADMINISTRATOR));
}
