<%@ include file="common/header.jspf" %>
    <title>Address Book - Contact details</title>
</head>
<body class="container">
	<div class="container">
		<div class="container-sm mt-2">
		    <h2>Contact details</h2>
			<form:form method = "post" modelAttribute="contact">
			<fieldset class="mb-2">
				<form:label path="firstName">First name:</form:label>
				<form:input type="text" path="firstName" required="required"/>
				<form:errors path="firstName" cssClass="text-warning"/>
			</fieldset>
			<fieldset class="mb-2">	
				<form:label path="lastName">Last name:</form:label>
				<form:input type="text" path="lastName" />
			</fieldset>
			<fieldset class="mb-2">
				<form:label path="address">Address:</form:label>
				<form:input type="text" path="address" />
			</fieldset>
				<input type="submit" class="btn btn-primary"/>
			</form:form>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>