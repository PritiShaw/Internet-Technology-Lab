<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Profile | Apparel Store</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="JUBCSE Internet Technology Lab" />
        <meta name="author" content="Priti Shaw 001710501076" />
        <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.1/css/mdb.min.css" rel="stylesheet"> -->
        <link rel="stylesheet" type="text/css" href="https://bootswatch.com/4/sketchy/bootstrap.min.css">
        <script type="text/javascript" src="https://bootswatch.com/_vendor/jquery/dist/jquery.min.js"></script>
        <script type="text/javascript" src="https://bootswatch.com/_vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>
        <style>
            body{
                background-image: url(https://previews.123rf.com/images/layritten/layritten1508/layritten150800013/43412570-seamless-pattern-of-colorful-clothes-for-stylish-design-transparent-pattern-background-of-clothing-s.jpg);
                background-size: cover;
            }
            .profile tr {
                font-size: 1.5em;
            }
            .profile tr td {
                font-weight: lighter;
            }
            .brand{
                font-weight: bolder;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <nav class="navbar mt-3 navbar-dark bg-light">
                <div class="container-fluid">
                    <form class="d-flex input-group w-50" action="/search">
                        <input type="search" class="form-control" name="query" placeholder="Search" aria-label="Search"/>
                        <button class="btn btn-outline-white" type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                    </form>
                    <jsp:include page="./WEB-INF/navmenu.jsp"/>
                </div>
            </nav>
            <div class="row text-center pt-5 mt-5">
                <div class="col-sm-6 offset-sm-3">
                   <p class="display-4 text-center">Profile</p>
                   <table class="table profile table-hover table-bordered">
                    <tr>
                        <th>Name</th>
                        <td><%=session.getAttribute("name")%></td>
                    </tr>  
                    <tr>
                         <th>Email ID</th>
                         <td><%=session.getAttribute("email")%></td>
                     </tr>      
                     <tr>
                         <th>Gender</th>
                         <td><%=session.getAttribute("gender").equals("M")?"Male":"Female"%></td>
                     </tr>      
                     <tr>
                         <th>Preference</th>
                         <td><%=session.getAttribute("preference").equals("D")?"Discounted":"New Arrivals"%></td>
                     </tr>      
                   </table>
                </div>
             </div>    
             
        </div> 
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.1/js/mdb.min.js"></script>
    </body>
</html>