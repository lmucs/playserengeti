function makeBlank(textfield) {
    textfield.value = "";
    textfield.style.color = "black";
}

function returnValue(id) {
    if (textfield.value == "") {
        textfield.style.color = "#CCCCCC";
        textfield.value = "Search for people, places, or teams";
    }
}
