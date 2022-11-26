<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
    <title>Address book - List of contacts</title>
</head>
<body>
	<div class="container-sm mt-2">
	    <table class="table table-dark table-hover">
	    	<thead>
	    	<tr>
	    		<th>First Name</th>
	    		<th>Last Name</th>
	    		<th>Picture</th>
	    		<th>Address</th>
	    		<th>Actions</th>
	    	</tr>
	    	</thead>
	    	<tbody>
	    		<c:forEach items="${contacts}" var="contact">
	    		<tr>
	    			<td>${contact.firstName}</td>
	    			<td>${contact.lastName}</td>
	    			<td><img src="${contact.picture}" class="img-thumbnail" alt="picture of ${contact.firstName}"></img></td>
	    			<td>${contact.address}</td>

	    			<td>
	    				<a href="delete-contact?id=${contact.id}" class="btn btn-sm btn-warning mx-auto m-1">Delete</a>
	    				<a href="update-contact?id=${contact.id}" class="btn btn-sm btn-primary mx-auto m-1">Update</a>
	    			</td>
	    		</tr>
	    		</c:forEach>
	    	</tbody>
	    </table>
	    <a href="add-contacts" class="btn btn-success">Add contact</a>
	    <a href="/export-to-csv" class="btn btn-secondary">Export CSV</a>
	</div>
<%@ include file="common/footer.jspf" %>