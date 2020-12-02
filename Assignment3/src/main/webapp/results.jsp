<%@ page import = "travelThruAir.Route" %>
<%@ page import = "travelThruAir.Flight" %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>Travel Thru Air</title>
    <meta name="description" content="JUBCSE Internet Technology Lab" />
    <meta name="author" content="Priti Shaw 001710501076" />

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.1/css/fontawesome.min.css" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.1/css/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" href="main.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- Leave those next 4 lines if you care about users using IE8 -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .w-33 {
            width: 33% !important;
        }
        .deal {
            animation: blinker 1s linear infinite;
        }

        @keyframes blinker {
            50% {
                opacity: 0;
            }
        }
    </style>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light static-top">
        <div class="container">
            <a class="navbar-brand" href="/travelThruAir">Travel Thru Air</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="./admin">Admin</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Page Content -->
    <div class="container-fluid container-dark bg-primary" id ="searchBody" >
    <form action="./search" method="POST">
      <div class="row" id="searchRow">        
        <div class="col-3 offset-1">
          <div class="md-form from-lg">
            <input name="dep" onkeyup="airportName('fromDep','depName')" required type="text" id="fromDep" value="<%=request.getAttribute("dep")%>" class="form-control text-white border-bottom">
            <label for="fromDep" class="text-white">From</label>              
            <p class="text-light" id="depName"></p>
          </div>
        </div>
        
        <div class="col-3">
          <div class="md-form from-lg">
            <input name="arr" onkeyup="airportName('fromArr','arrName')" required type="text" value="<%=request.getAttribute("arr")%>" id="fromArr" class="form-control text-white border-bottom">
            <label for="fromArr" class="text-white">To</label>    
            <p class="text-light" id="arrName"></p>
          </div>
        </div>
        
        <div class="col-2">
          <div class="md-form from-lg">
            <input name="time" required type="time" id="fromTime" value="<%=request.getAttribute("time")%>" class="form-control text-white border-bottom">
          </div>
        </div>

        <div class="col-2">
          <button type="submit" class="btn btn-warning">Search</button>
        </div>
      </div>
      </form>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-12">
                <p class="text-center display-4 mt-4">Results</p>
            </div>
        </div>

        <%
            ArrayList<Route> result = (ArrayList)request.getAttribute("result");
            for(Route route : result){
                %>
                    <%-- Here HTML for Route(Flight Container)--%>
                    <div class="row border rounded py-2 my-3 bg-light">            
                       <%-- Flight in nested loop --%>
                       <%
                            for(Flight flight : route.getFlights()){
                                %>
                                    <%-- Here HTML for Flight --%>                                    
                                    <div class="col-3 h2"><%=flight.getFlightNumber()%></div>
                                    <div class="col-6">
                                        <div class="row">
                                            <div class="col-5 text-right">
                                                <p class="h3 mb-0"><%=flight.getDeparture()%></p>
                                                <small><%=flight.getDepartureTime()%></small>
                                            </div>
                                            <div class="col-2 text-center">
                                                <p class="h3 mb-0" >&#9992;</p>
                                                <small><%=flight.getDuration(0)%></small>
                                            </div>
                                            <div class="col-5">
                                                <p class="h3 mb-0"><%=flight.getArrival()%></p>
                                                <small><%=flight.getArrivalTime()%></small>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-3 text-right">
                                        <p class="mb-0 h2 <%=flight.isDiscounted()?"deal":""%>">&#8377;<%=flight.getPrice()%></p>
                                    </div>
                                <%
                            }
                       %>
                    </div>
                <%
            }
        %>
        </div>
    </div>

    <!-- Including Bootstrap JS (with its jQuery dependency) so that dynamic components work -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.1/js/mdb.min.js"></script>
    <script src="/travelThruAir/script.js"></script>
    <script>
      airportName('fromDep','depName');
      airportName('fromArr','arrName');
    </script>
</body>

</html>