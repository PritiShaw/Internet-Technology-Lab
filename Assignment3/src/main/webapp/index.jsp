<%@ page import = "java.util.*" %>


<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>Travel Thru Air</title>
    <meta name="description" content="JUBCSE Internet Technology Lab" />
    <meta name="author" content="Priti Shaw 001710501076" />

    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.1/css/fontawesome.min.css"
    />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.1/css/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" href="main.css"> 
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- Leave those next 4 lines if you care about users using IE8 -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
      .w-33{
        width : 33% !important;
      }
    </style>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light static-top">
      <div class="container">
        <a class="navbar-brand" href="#">Travel Thru Air</a>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarResponsive"
          aria-controls="navbarResponsive"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="#">Admin</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container-fluid container-dark bg-primary" id ="searchBody" >
      <div class="row" id="searchRow">        
        <div class="col-3 offset-1">
          <div class="md-form from-lg">
            <input type="text" id="fromInput" class="form-control text-white border-bottom">
            <label for="fromInput" id="labelStyle" class="text-white">From</label>              
            <p class="text-light">Airport Name</p>
          </div>
        </div>
        
        <div class="col-3">
          <div class="md-form from-lg">
            <input type="text" id="fromInput" class="form-control text-white border-bottom">
            <label for="fromInput" id="labelStyle" class="text-white">To</label>    
            <p class="text-light">Airport Name</p>
          </div>
        </div>
        
        <div class="col-2">
          <div class="md-form from-lg">
            <input type="text" id="fromInput" class="form-control text-white border-bottom">
            <label for="fromInput" id="labelStyle" class="text-white">Time</label>                   
          </div>
        </div>

        <div class="col-2">
          <button type="button" class="btn btn-warning">Search</button>
        </div>
      </div>
    </div>

    <div class="container" id="planeCard">
      <div class="col-12">
        <p class="text-center display-4 mt-4">
          Deals
        </p>
      </div>
      <div class="col-12 d-flex flex-row justify-content-center flex-wrap">

        <div class="card w-25 my-2 mx-3">
          <img class="card-img-top" src="./images/deal1.jpg">
          <div class="card-body text-center">
            <p class="card-title h2 mb-0">BOM-CCU</p>
            <div class="text-center">
              <p class="mb-0 h3">&#8377;200</p>
              <p class="text-muted">Valid till 1230</p>
            </div>
          </div>
        </div>

        
        <div class="card w-25 my-2 mx-3">
          <img class="card-img-top" src="./images/deal1.jpg">
          <div class="card-body text-center">
            <p class="card-title h2 mb-0">BOM-CCU</p>
            <div class="text-center">
              <p class="mb-0 h3">&#8377;200</p>
              <p class="text-muted">Valid till 1230</p>
            </div>
          </div>
        </div>

      </div>
    </div>
    <!-- Including Bootstrap JS (with its jQuery dependency) so that dynamic components work -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.1/js/mdb.min.js"></script>
  </body>
</html>
