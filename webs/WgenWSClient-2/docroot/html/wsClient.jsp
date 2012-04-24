
<html>

<body>
<%
	String jsonText=(String)request.getAttribute("jsonText");
	String jsonText2=(String)request.getAttribute("jsonText2");
%>


<%=jsonText%>
<div id="content_main">
<br/><p>
	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin orci elit, porta ac convallis eu, egestas quis eros. Pellentesque diam enim, scelerisque et porta at, imperdiet sed lacus. Nullam nec urna et nulla volutpat tempor sed eget sem. Aenean gravida, odio et luctus facilisis, ligula tellus mollis lacus, in bibendum neque ipsum a lectus. Pellentesque ultricies justo eget nulla tempus mollis eget vel ipsum. Cras leo ipsum, tristique sit amet blandit et, laoreet vitae ipsum. Nunc tortor neque, pellentesque non faucibus non, semper eget erat. Nulla vitae ipsum est. Phasellus vel nisl erat. Mauris orci magna, pellentesque vel feugiat eu, blandit id velit. Etiam nisi felis, blandit ut vulputate non, pulvinar nec justo.

Nulla vel lacus nec justo porta placerat ac eget elit. In et sapien felis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Phasellus eu neque neque. Suspendisse potenti. Quisque nibh nunc, condimentum sed cursus lacinia, ultricies sed mauris. Nunc quis euismod turpis. Curabitur accumsan facilisis mi, nec interdum sapien venenatis quis.</p>
<br/>
 <%=jsonText2 %>
  </div>

</body>
</html>