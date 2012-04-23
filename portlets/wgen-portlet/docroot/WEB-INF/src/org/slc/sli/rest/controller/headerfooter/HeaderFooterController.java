package org.slc.sli.rest.controller.headerfooter;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import org.slc.sli.headerfooter.model.HeaderFooter;
import org.slc.sli.headerfooter.service.HeaderFooterLocalServiceUtil;
import org.slc.sli.rest.bean.HeaderFooterModel;

@Controller
public class HeaderFooterController {

	private Jaxb2Marshaller jaxb2Mashaller;

	public void setJaxb2Mashaller(Jaxb2Marshaller jaxb2Mashaller) {
		this.jaxb2Mashaller = jaxb2Mashaller;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/header")
	public @ResponseBody
	HeaderFooterModel getHeaderFooter(
			HttpSession session,HttpServletRequest request) {
		
		 Enumeration headerNames = request.getHeaderNames();
		 
		 while(headerNames.hasMoreElements()) {
		      String headerName = (String)headerNames.nextElement();
		      System.out.println("headerName " + headerName);
		      System.out.println("header...." + request.getHeader(headerName));
		    }
		 
		String token = (String) session.getAttribute("OAUTH_TOKEN");
		
		System.out.println("inside header footer contoller ...  accessing session from same war"+session.getAttribute("computer"));
		
		System.out.println("token is ..."+token);
		String type="header";
		HeaderFooterModel headerFooterModel = new HeaderFooterModel();
		/*if (Validator.isNotNull(token)) {
			try {
				if (Validator.isNotNull(type) && "header".equals(type)) {
					HeaderFooter header = HeaderFooterLocalServiceUtil
							.getHeader(token);
					if (Validator.isNotNull(header)) {
						headerFooterModel.setData(header.getData());
						headerFooterModel.setId(header.getId());
						headerFooterModel.setType(header.getType());
					}
				} else if (Validator.isNotNull(type) && "footer".equals(type)) {
					HeaderFooter footer = HeaderFooterLocalServiceUtil
							.getFooter(token);
					if (Validator.isNotNull(footer)) {
						headerFooterModel.setData(footer.getData());
						headerFooterModel.setId(footer.getId());
						headerFooterModel.setType(footer.getType());
					}
				}

			} catch (SystemException e) {
				_log.error("Error in accessing Header and Footer");
			}
		}*/
		
		// List<Employee> employees = employeeDS.getAll();
		// EmployeeList list = new EmployeeList(employees);
		return headerFooterModel;
	}

	private static Log _log = LogFactoryUtil
			.getLog(HeaderFooterController.class);

}
