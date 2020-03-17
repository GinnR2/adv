

<link rel="stylesheet" href="css/header.css">

<!------ Include the above in your HEAD tag ---------->

  <div id="wrapper" class="animate">
    <nav class="navbar header-top fixed-top navbar-expand-lg  navbar-dark bg-dark">
      <span class="navbar-toggler-icon leftmenutrigger"></span>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Index.jsp corp</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav animate side-nav">
          <li class="nav-item">
            <a class="nav-link profile" href="${pageContext.request.contextPath}/profile.jsp">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link addPeriod" href="${pageContext.request.contextPath}/createProduct.jsp">Add periodical</a>
          </li>
          <li class="nav-item">
            <a class="nav-link bucket" href="${pageContext.request.contextPath}/bucket.jsp">Bucket</a>
          </li>
          
        </ul>
        <ul class="navbar-nav ml-md-auto d-md-flex">
         
          <li class="nav-item status"><h6 style="color: #8f9296;margin: 10.4px 0px 0px 0px;"></h6></li>
          <li class="nav-item">
          	<a style="display: none" class="nav-link login" href="${pageContext.request.contextPath}/login.jsp">Login</a>
            <a style="display: none" class="nav-link logout" href="#">Logout</a>
          </li>
        </ul>
      </div>
    </nav>
    
  </div>
  
 <script src="js/header.js"></script>