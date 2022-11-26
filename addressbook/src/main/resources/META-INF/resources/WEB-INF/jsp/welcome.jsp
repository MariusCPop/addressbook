<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
    <title>Address Book - Welcome</title>
</head>
<body>
<div class="container">
  <div
    class="p-5 text-center bg-image"
    style="
      background-image: url('https://mdbcdn.b-cdn.net/img/new/slides/041.webp');
      height: 400px;
    "
  >
    <div class="mask" style="background-color: rgba(0, 0, 0, 0.6);">
      <div class="d-flex justify-content-center align-items-center h-100">
        <div class="text-white">
          <h3 class="mb-3">Welcome ${name},</h3>
          <h4 class="mb-3">to your address book</h4>
          <a class="btn btn-outline-light btn-lg" href="list-contacts" role="button"
          >Manage contacts</a
          >
        </div>
      </div>
    </div>
  </div>
  </div>
  <!-- Background image -->
 	
<%@ include file="common/footer.jspf" %>