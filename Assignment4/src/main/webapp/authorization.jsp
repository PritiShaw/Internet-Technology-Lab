<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login | Apparel Store</title>
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
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    </head>
    <style>
         body{
                background-image: url(https://previews.123rf.com/images/layritten/layritten1508/layritten150800013/43412570-seamless-pattern-of-colorful-clothes-for-stylish-design-transparent-pattern-background-of-clothing-s.jpg);
                background-size: cover;
            }
        .part2{
            padding-top: 5em;
        }
        .brand{
                font-weight: bolder;
        }
    </style>
    <body>
        <div class="container">
            <nav class="navbar mt-3 bg-light">
                <div class="container-fluid">
                    <div class="col-12">
                        <div class="text-center" style="padding:10px"><a href="/"><h4 class="brand">Apparel Store</h4></a></div>
                    </div>
                </div>
            </nav>
            <div class="container login-container part2">
                <div class="row">
                    <div class="col-md-6 login-form-1" style="background-color: rgb(255,255,255,.5);">
                        <h3 style="font-weight: bolder;">Login</h3>
                        <form method="POST" action="/auth/signin" autocomplete="off">
                            <div class="form-group">
                                <input type="email" id="email-inp" autocomplete=off name="email" class="form-control" placeholder="Your Email *" required value="" />
                            </div>
                            <div class="form-group">
                                <input type="password" autocomplete=off name="password" class="form-control" placeholder="Your Password *" required value="" />
                            </div>
                            <div class="form-group">
                                <button class="btn btn-dark" type="submit">Login</button>
                            </div>
                        </form>
                        <p class="bg-white text-center text-danger"><%=request.getAttribute("login_error")!=null?request.getAttribute("login_error"):""%></p>
                        <%
                            Cookie cookie = null;
                            Cookie[] cookies = request.getCookies();
                            if(cookies != null){
                                boolean show_relogin = false;
                                String user_email = "";
                                String user_name = "";
                                for (int i = 0; i < cookies.length; i++) {
                                    cookie = cookies[i];                                    
                                    if((cookie.getName()).compareTo("user_email") == 0){
                                        show_relogin = true;
                                        user_email = cookie.getValue();
                                    }                                  
                                    else if((cookie.getName()).compareTo("user_name") == 0){
                                        user_name = cookie.getValue();
                                    }
                                }
                                if(show_relogin){
                        %>
                            <h3 style="font-weight: bolder;">Last User</h3>
                                <div class="card" onclick="document.getElementById('email-inp').value='<%=user_email%>'">
                                    <div class="card-body">
                                        <p class="card-title lead"><%=user_name%></p>
                                    </div>
                               </div>
                        <%
                                }
                            }
                        %>
                    </div>
                    <div class="col-md-6 login-form-2 border-left"  style="background-color: rgb(255,255,255,.4);">
                        <h3 style="font-weight: bolder;">Register</h3>
                        <form method="POST" action="/auth/register" autocomplete="off">
                            <div class="form-group">
                                <input type="text" autocomplete=off name="name" required class="form-control" placeholder="Your Name *" value="" />
                            </div>
                            <div class="form-group">
                                <input type="text" autocomplete=off name="email"  required class="form-control" placeholder="Your Email *" value="" />
                            </div>
                            <div class="form-group">
                                <label style="font-weight: bolder;">Gender</label>
                                <select class="form-control" name = "gender" aria-labelledby="dropdownMenuButton" required>
                                    <option value="F">Female</option>
                                    <option value="M">Male</option>                                    
                                </select>
                            </div>
                            <div class="form-group">
                                <label style="font-weight: bolder;">Your Preference</label>
                                <select  class="form-control" name = "preference" aria-labelledby="dropdownMenuButton" required>
                                    <option  value="D">Discounted</option>
                                    <option  value="N">New Arrivals</option>                                    
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="password" autocomplete=off name="password" required class="form-control" placeholder="Your Password *" value="" />
                            </div>
                            <div class="form-group">
                                <button class="btn btn-dark" type="submit">Register</button>
                            </div>
                        </form>
                        <p class="bg-white text-center text-danger"><%=request.getAttribute("reg_error")!=null?request.getAttribute("reg_error"):""%></p>
                    </div>
                </div>
            </div>
        </div> 
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.1/js/mdb.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </body>
</html>
