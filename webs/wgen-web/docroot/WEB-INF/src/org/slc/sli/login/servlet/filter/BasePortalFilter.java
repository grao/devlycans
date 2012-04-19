package org.slc.sli.login.servlet.filter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BaseFilter;
import com.liferay.portal.kernel.util.GetterUtil;

/**
 * BasePortalFilter.java
 * 
 * @author
 * @version 1.0
 */
public abstract class BasePortalFilter extends BaseFilter {

	@Override
	public boolean isFilterEnabled() {
		return _filterEnabled;
	}

	@Override
	protected Log getLog() {
		return _log;
	}

	private Log _log = LogFactoryUtil.getLog(getClass());

	private boolean _filterEnabled = GetterUtil.getBoolean(
			"org.slc.sli.login.servlet.filter.sso.wgensso.WgenSSOFilter", true);

}