<%@ page import = "Apparel_Store.Product" %>
<%@ page import = "java.util.LinkedList" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Search | Apparel Store</title>
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
        <link rel="stylesheet" href="/style.css"/>
        <style>
            body{
                background-image: url(https://previews.123rf.com/images/layritten/layritten1508/layritten150800013/43412570-seamless-pattern-of-colorful-clothes-for-stylish-design-transparent-pattern-background-of-clothing-s.jpg);
                background-size: cover;
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
                    <jsp:include page="./navmenu.jsp"/>
                </div>
            </nav>

            <div class="container-fluid container-dark border rounded mt-3" id ="searchBody" style="background-color: rgb(255,255,255,.8);" >              
                <div class="container" id="planeCard">
                    <div class="col-12">
                        <p class="text-center display-4 mt-2">Search Results</p>
                    </div>
                    <div class="col-12 d-flex flex-row justify-content-center flex-wrap align-center">
                        
                        <%  LinkedList<Product> result = (LinkedList)request.getAttribute("search_result");
                            if(result != null && result.size()>0){
                                for(Product p:result){
                        %>
                    
                        <!-- This block will repeat -->
                            <div class="card w-25 my-2 mx-3">                                
                                <div class="position-absolute">                        
                                    <%if(p.isDiscounted()){%>
                                        <span class="badge badge-danger">Discounted</span>
                                    <%}%>
                                    <%if(p.isNew()){%>
                                        <span class="badge badge-warning">Fresh Arrivals</span>
                                    <%}%>
                                </div>
                                <img class="card-img-top pt-3" src="<%=p.getImage_url()%>">
                                <div class="card-body text-center">
                                    <p class="card-title h2 mb-0"><%=p.getName()%></p>    
                                    <%
                                        if(p.isDiscounted()){
                                            %><p class="mb-0 text-muted text-center" style="text-decoration:line-through"><%=p.getCost()%></p><%
                                        }
                                        else{
                                            %><p class="mb-0 text-muted text-center invisible"><%=p.getCost()%></p><%
                                        }
                                    %>                                    
                                    <p class="mb-0 lead text-center">&#8377;<%=p.getSellingPrice()%></p>
                                </div>
                                <button class="btn-block btn-primary" onclick="addToCart(this,'<%=p.getProduct_id()%>',<%=p.getDeal_id()%>)">Add to Cart</button>
                            </div>
                        <!--  -->

                        <%}}
                        else{%>
                        <div>No Results</div>
                        <%}%>            
                    </div>
                </div>
            </div>

        </div> 
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.1/js/mdb.min.js"></script>
    </body>
</html>