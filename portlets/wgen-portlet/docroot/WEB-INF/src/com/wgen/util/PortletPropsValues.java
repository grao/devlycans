/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.wgen.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * @author
 */
public class PortletPropsValues {

	public static final String MENU_ARROW = GetterUtil.getString(PortletProps
			.get(PortletPropsKeys.MENU_ARROW));
	public static final String ARROW = GetterUtil.getString(PortletProps
			.get(PortletPropsKeys.ARROW));
	public static final String ARROW_W = GetterUtil.getString(PortletProps
			.get(PortletPropsKeys.ARROW_W));
	public static final String SLI_LOGO = GetterUtil.getString(PortletProps
			.get(PortletPropsKeys.SLI_LOGO));
}