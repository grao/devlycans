package org.slc.sli.util;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class VelocityUtil {

	public static String velocityHeaderRes(String headerRes) {
		StringWriter writer = new StringWriter();


		try {
			VelocityEngine ve = new VelocityEngine();
			ve.setProperty("file.resource.loader.class",
					ClasspathResourceLoader.class.getName());
			ve.init();
			/* next, get the Template */
			Template t = ve.getTemplate("templates/wheader.vm");
			/* create a context and add data */
			VelocityContext context = new VelocityContext();
			context.put("header", headerRes);
			/* now render the template into a StringWriter */

			t.merge(context, writer);
			/* show the World */
			//System.out.println(writer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writer.toString();
	}

	public static String velocityFooterRes(String headerRes) {
		StringWriter writer = new StringWriter();


		try {
			VelocityEngine ve = new VelocityEngine();
			ve.setProperty("file.resource.loader.class",
					ClasspathResourceLoader.class.getName());
			ve.init();
			/* next, get the Template */
			Template t = ve.getTemplate("templates/wfooter.vm");
			/* create a context and add data */
			VelocityContext context = new VelocityContext();
			context.put("footer", headerRes);
			/* now render the template into a StringWriter */

			t.merge(context, writer);
			/* show the World */
			//System.out.println(writer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writer.toString();
	}

}
