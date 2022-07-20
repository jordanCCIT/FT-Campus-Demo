import home from "./home.js";
import header from "./header.js";
import footer from "./footer.js";

fetch("http://localhost:8080/api/campuses")
.then(res => res.json())
.then(campuses => {
    console.log(campuses);
    const container = document.querySelector(".container");
    container.innerHTML += header();
    container.innerHTML += home(campuses);
    container.innerHTML += footer();


    const campusesElement = document.querySelectorAll(".campus");

    campusesElement.forEach(campus =>{
        campus.addEventListener("click",()=>{
            let campusId = campus.querySelector(".id_field");
            alert(`You clicked campus id: ${campusId.value}`);
        })
    })
})