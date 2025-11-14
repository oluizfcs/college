const inputName = document.getElementById("name");
const inputEmail = document.getElementById("email");
const inputPassword = document.getElementById("password");

document.querySelector("form").addEventListener("submit", (e) => {

    if (inputName.value.length < 3) {
        document.getElementById("validation-name").innerText = "Name is too short";
        e.preventDefault();
    } else {
        document.getElementById("validation-name").innerText = "";
    }

    if (inputEmail.value.search(/@/) === -1 || inputEmail.value.search(/\./) === -1) {
        document.getElementById("validation-email").innerText = "Email must contain both \"@\" and \".\" characters";
        e.preventDefault();
    } else {
        document.getElementById("validation-email").innerText = "";
    }

    if (inputPassword.value.length < 6) {
        document.getElementById("validation-password").innerText = "Password must be at least 6 characters long";
        e.preventDefault();
    } else {
        document.getElementById("validation-password").innerText = "";
    }

});