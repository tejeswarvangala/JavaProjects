<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>New Customer</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script>
$(document).ready(function () {
$("#countryDD").change(function () {
	if ($("#countryDD").val()!="") {
	
        jQuery.ajax({
            url: "/HibernateApp/updateCities?countryCode="+$("#countryDD").val(),		
            success: function (data) {
            	$("#cityDD").find('option')
            	.remove()
            	.end()
            	.append('<option value="">Select City</option>')
            	.val('');
            	$("#cityDD").removeAttr("disabled");
            	
            	$.each(data, function(index, city) {
                    addDropDownCity(city);
                });  
            },
            error: function (data) {
                alert(data + " error, could not get cities for the country.");
            }
        });
    } else {
    	$("#cityDD").attr("disabled","true");
        alert("Please select a valid country");
    }
});
});

function addDropDownCity(city){
	var option = $('<option/>');
	option.attr({ 'value': city.id }).text(city.cityName);
	$('#cityDD').append(option);
	
}
</script>	
</head>
<body>
	<nav role="navigation" class="navbar navbar-default">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" data-target="#navbarCollapse"
				data-toggle="collapse" class="navbar-toggle">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand">HibernateApp</a>
		</div>
		<!-- Collection of nav links and other content for toggling -->
		<div id="navbarCollapse" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/HibernateApp/custHome">Home</a></li>
				<li class="active"><a href="#">Customer</a></li>
				<li><a href="#">Invoice</a></li>
			</ul>
		</div>
	</nav>
	<h3>Welcome, Enter The Employee Details</h3>

	<div class="container">
		<div class="row">
			<div class="col-lg-5">
				<form:form method="POST" class="form-horizontal"
					action="/HibernateApp/saveCustomer" modelAttribute="cust">
					<div class="form-group">
						<form:label for="custFName" path="customerFname">First Name:</form:label>
						<div class="col-xs-5">
							<form:input id="custFName" class="form-control input-sm"
								path="customerFname" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="customerLname">Last Name:</form:label>
						<div class="col-xs-5">
							<form:input class="form-control input-sm" path="customerLname" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="dob">DOB:</form:label>
						<div class="col-xs-5">
							<form:input class="form-control input-sm"
								placeholder="mm/dd/yyyy" path="dob" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="doj">DOJ:</form:label>
						<div class="col-xs-5">
							<form:input class="form-control input-sm"
								placeholder="mm/dd/yyyy" path="doj" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="category">Category Name:</form:label>
						<div class="col-xs-5">
							<form:input class="form-control input-sm" path="category" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="country.countryCode">Country:</form:label>
						<div class="col-xs-5">
							<form:select id="countryDD" class="form-control input-sm" path="country.countryCode">
								<form:option value="">Select Country</form:option>
								<c:forEach items="${countries}" var="country">
									<form:option value="${country.countryCode}">${country.countryName}</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<form:label path="city.id">City:</form:label>
						<div class="col-xs-5">
							<%-- <form:select id="cityDD" class="form-control input-sm" path="city.id" disabled="true">
								<form:option value="">Select City</form:option>
								removed because we no longer get data on initial page load
								<c:forEach items="${cities}" var="cty">
									<form:option value="${cty.id}">${cty.cityName}</form:option>
								</c:forEach>
							</form:select> --%>
							
						</div>
					</div>
					<div class="form-group">
						<form:label path="email">Email:</form:label>
						<div class="col-xs-5">
							<form:input class="form-control input-sm" path="email" />
						</div>
					</div>

					<input type="submit" class="btn btn-default btn-sm" value="Submit" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>