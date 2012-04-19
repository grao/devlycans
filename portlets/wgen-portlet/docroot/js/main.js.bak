
    $(document).ready(function showPopup_new() {
            
		//Change these values to style your modal popup
		var align = 'center';									//Valid values; left, right, center
		var top = 160; 											//Use an integer (in pixels)
		var width = 715; 										//Use an integer (in pixels)
		var padding = 30;										//Use an integer (in pixels)
		var backgroundColor = '#FFFFFF'; 						//Use any hex code
		var source = '/web/guest/report-a-problem'; 								//Refer to any page on your server, external pages are not valid e.g. http://www.google.co.uk
		var borderColor = '#666666'; 							//Use any hex code
		var borderWeight = 1; 									//Use an integer (in pixels)
		var borderRadius = 0; 									//Use an integer (in pixels)
		var fadeOutTime = 300; 									//Use any integer, 0 = no fade
		var disableColor = '#FFF'; 							//Use any hex code
		var disableOpacity = 60; 								//Valid range 0-100
		var loadingImage = '/wgen-portlet/js/loading.gif';		//Use relative path from this page
			
		//This method initialises the modal popup
        $(".modal").click(function() {
            modalPopup(align, top, width, padding, disableColor, disableOpacity, backgroundColor, borderColor, borderWeight, borderRadius, fadeOutTime, source, loadingImage);
        });
		
		//This method hides the popup when the escape key is pressed
		$(document).keyup(function(e) {
			if (e.keyCode == 27) {
				closePopup(fadeOutTime);
			}
		});

    });
	
	
	