<div class="d-flex flex-row-reverse ">                    
    <div style="padding:10px"><a href="/auth/signout"><i class="fas fa-sign-out-alt"></i></a></div>                        
    <div style="padding:10px"><a href="/profile.jsp"><i class="fa fa-user"></i></a></div>
    <div style="padding:10px"><a href="/cart"><i class="fas fa-shopping-bag mr-1"></i></a></div>
    <div style="padding:10px"><a href="/"><h4 class="brand">Apparel Store</h4></a></div>
</div>
<style>
    .card-img-top {
        width: initial;
    }
    body {
        background-attachment: fixed;
        padding-bottom: 2em;
    }
</style>
<script>
    function sleep (time) {
        return new Promise((resolve) => setTimeout(resolve, time));
    }
    function addToCart(d,e,dcis) {
        d.disabled = true
        d.innerText = "Please Wait"
        fetch('/cart?pid=' + e + "&dis=" + dcis, {
            method: 'post'
        }).then(function(response) {
            return response.text();
        }).then((res)=>{
            if (res=="200"){
                d.innerText = "Successful"
                d.className = "btn-success"
            }    
            else{
                console.log(res)
                d.innerText = "Try Again"
                d.className = "btn-danger"
            }
            sleep(1000).then(()=>{
                d.innerText = "Add to Cart";d.className = "btn-primary"
                d.disabled = false
            })        
        });        
    }

    function removeFromCart(pid) {
        fetch('/cart?pid=' + pid, {
            method: 'delete'
        }).then(function(response) {
            return response.text();
        }).then((res)=>{
            if (res=="200"){
                location.reload();
            }    
            else{
                console.log(res)
                alert("Could not Remove from Cart")
            }        
        });        
    }
</script>