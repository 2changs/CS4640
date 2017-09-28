function validate() {
    var a = document.forms["form-contact"]["name"].value;
    var b = document.forms["form-contact"]["email"].value;
    var c = document.forms["form-contact"]["phone"].value;
    var d = document.forms["form-contact"]["message"].value;

    if (a == null || a ==""){
    	document.getElementById('error-name').innerHTML = '*Please enter a name.'
    }
    if (b == null || b ==""){
    	document.getElementById('error-email').innerHTML = '*Please enter an email.'
    }
    if (c == null || c ==""){
    	document.getElementById('error-phone').innerHTML = '*Please enter a phone number.'
    }
    if (d == null || d ==""){
    	document.getElementById('error-message').innerHTML = '*Please enter a message.'
    }

}

function goBack() {
    window.history.back();
}

function addIngredient() {
    var text = document.getElementById("ingredient").value;
    if(text != "" | text != null) { 
        var node = document.createElement("LI"); 
        var textnode = document.createTextNode(text);
        node.appendChild(textnode);
        document.getElementById("ingredient-list").appendChild(node);
    }
}
