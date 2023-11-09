function validateEmail(inputText) {
  var data = inputText.value;
  var atSign = data.indexOf("@");
  var dotSign = data.indexOf(".");
  if (atSign<1 || dotSign<atSign+2 || dotSign+2>=data.length) {
    alert("Please add @ and .!");
    return false;
  }
}