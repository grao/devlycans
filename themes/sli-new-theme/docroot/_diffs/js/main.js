AUI().ready(
	'liferay-hudcrumbs', 'liferay-navigation-interaction',
	function(A) {
		var navigation = A.one('#navigation');

		if (navigation) {
			navigation.plug(Liferay.NavigationInteraction);
		}

		var siteBreadcrumbs = A.one('.site-breadcrumbs');

		if (siteBreadcrumbs) {
			siteBreadcrumbs.plug(A.Hudcrumbs);
		}
	}
);

	var menu_n=new menu_n.dd("menu_n");
	menu_n.init("menu_n","menuhover");

	