package org.slc.sli.util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.wgen.util.PortletPropsValues;

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
			
			context.put("menu_arrow1","data:image/png;base64,"+getEncodedImg(PortletPropsValues.MENU_ARROW));
			context.put("arrow","data:image/png;base64,"+getEncodedImg(PortletPropsValues.ARROW));
			context.put("arrow_w","data:image/png;base64,"+getEncodedImg(PortletPropsValues.ARROW_W));

			t.merge(context, writer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writer.toString();
	}

	public static String getEncodedImg(String url) throws IOException, URISyntaxException{
		
		URL ImgUrl = new URL(url);
		
		BufferedImage img = ImageIO.read(ImgUrl);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(img, "png", baos);    
		baos.flush();
		String encodedImage = Base64.encodeBase64String(baos.toByteArray());
		
		InputStream is = new ByteArrayInputStream(encodedImage.getBytes());
		
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(is));
	
		StringBuilder strBdr = new StringBuilder();
		
		String line;
		while ((line = bufReader.readLine()) != null) {
			strBdr.append(line);
		}
	
		baos.close(); 
		
		return strBdr.toString();
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
