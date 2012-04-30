Liferay.Service.register("Liferay.Service.wgen", "org.slc.sli.headerfooter.service", "wgen-portlet");

Liferay.Service.registerClass(
	Liferay.Service.wgen, "HeaderFooter",
	{
		getHeader: true,
		getFooter: true
	}
);