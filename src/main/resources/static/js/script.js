console.log("Script loaded");

let currentTheme = getTheme();
// Initial stage
document.addEventListener("DOMContentLoaded", () =>{
    changeTheme();
});


//TODO:
function changeTheme() {
// Set current theme to WebPage
    changePageTheme(currentTheme, currentTheme);
    // Set the listener to change theme button
    const changeThemeButton = document.querySelector("#theme_change_button");
    changeThemeButton.querySelector("span").textContent =
        currentTheme == "light" ? "Dark" : "Light";

    changeThemeButton.addEventListener("click", (e) => {
        let oldTheme = currentTheme;
        console.log("Button clicked");
        if (currentTheme === "dark") {
            //change to light
            currentTheme = "light"
        } else {
            //   change to dark
            currentTheme = "dark";
        }
        changePageTheme(currentTheme, oldTheme);
    });
}

//Set theme to LocalStorage
function setTheme(theme) {
    localStorage.setItem("theme", theme);
}

//Get theme from LocalStorage
function getTheme() {
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
    // if (theme)
    //     return theme
    // else return "light";
}

//change current page theme
function changePageTheme(theme, oldTheme) {
    //update to local storage
    setTheme(currentTheme);
// remove the current theme
    document.querySelector("html").classList.remove(oldTheme);
//set the current theme
    document.querySelector("html").classList.add(theme);

    //     change the color of button
    document
        .querySelector("#theme_change_button")
        .querySelector("span").textContent = theme == "light" ? "dark" : "light";
}
