const airportName = function (inp_class, p_class) {
    var code = document.getElementById(inp_class).value;
    if (code.length < 3) {
        document.getElementById(p_class).innerText = ""
        return
    }
    $.post('/travelThruAir/airport', { code: code }, function (result) {
        if (result.length == 0)
            result = "Enter Valid Airport Code";
        document.getElementById(p_class).innerText = result;
    });
};