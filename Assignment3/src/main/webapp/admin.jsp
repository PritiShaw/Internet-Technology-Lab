<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Admin | Travel Thru Air</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="JUBCSE Internet Technology Lab" />
    <meta name="author" content="Priti Shaw 001710501076" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.1/css/mdb.min.css" rel="stylesheet">
    <style>
        html {
            background-color: #0093E9;
            background-image: linear-gradient(160deg, #0093E9 0%, #80D0C7 100%);
            background-size: 100%;
            background-repeat: no-repeat;
        }
    </style>
  </head>
  <body class="bg-transparent pt-5">
    <div class="container pt-5 mt-5">
        <p class="display-4 text-center">Admin Panel</p>        
        <div class="col-6 offset-3 bg-white shadow border rounded">
            <p class="h3 text-center mt-4 mb-1">Make Deal</p>
            <form class="pt-4 px-3" method="POST" action="">
                <div class="form-row " >
                    <div class="col">
                        <div class="md-form">
                            <input class="form-control" type="text" id="adminDeparture" list="airport_codes"  autocomplete="off"/>
                            <label for="fromInput" id="adminDeparture">Departure</label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="md-form">
                            <input class="form-control" type="text" id="arrivalDeparture" list="airport_codes"  autocomplete="off"/>
                            <label for="fromInput" id="arrivalDeparture">Arrival</label>
                        </div>
                    </div>
                </div>      
                <div class="form-row mt-2">
                    <div class="col">
                        <div class="md-form">
                            <input class="form-control" type="number" id="discount" required name="cost">
                            <label for="fromInput" id="discount">Discounted Price</label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="md-form">
                            <input class="form-control" id="exp" type="time" required name="expiry">
                            <label class="active" for="exp">Valid till</label>
                        </div>
                    </div>
                </div>
            <button class="btn btn-block btn-primary">Submit</button>
            <p class="w-100 text-success lead text-center py-2 mb-0">
                <!-- <span class=<%=request.getAttribute("message")%>>Success</span> -->
            </p>
            </form>
        </div>
    </div>
    <datalist id="airport_codes">
    <!-- <%
        Set<String> airports = (Set)request.getAttribute("airports");
        if(airports != null)
            for ( String airport: airports){%>
                <option value=<%= airport %>>
    <%}%> -->
   </datalist>

   <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.1/js/mdb.min.js"></script>
</body>
</html>