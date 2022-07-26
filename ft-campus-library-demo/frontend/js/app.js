import home from "./home.js";
import header from "./header.js";
import footer from "./footer.js";
import campusView from "./campusView.js"
const container = document.querySelector(".container");

// function makeHomeView(){
//     fetch("http://localhost:8080/api/campuses")
//     .then(res => res.json())
//     .then(campuses => {
//         console.log(campuses);
        
//         container.innerHTML = header();
//         container.innerHTML += home(campuses);
//         container.innerHTML += footer();


//         const campusesElement = document.querySelectorAll(".campus");

//         campusesElement.forEach(campus =>{
//             campus.addEventListener("click",()=>{
//                 let campusId = campus.querySelector(".id_field");
//                 // alert(`You clicked campus id: ${campusId.value}`);
//                 makeCampusView(campusId.value);
//             })
//         })
//     })
// }


function makeHomeView() {
    fetch("http://localhost:8080/api/campuses")
    .then(res => res.json())
    .then(campuses => {
        makeHomeViewFromJSON(campuses);
    })
}

function makeHomeViewFromJSON(campuses){
    console.log(campuses);
    container.innerHTML = header();
    container.innerHTML += home(campuses);
    container.innerHTML += footer();

    const campusEl = container.querySelectorAll(".campus");

    campusEl.forEach(campus => {
        let campusElId = campus.querySelector(".id-field");
        const campusH2 = campus.querySelector(".campus-location");
        campusH2.addEventListener("click",()=>{
            campuses.forEach(campusJson => {
                makeCampusView(campusJson)
            })
        })

        const deleteButton = campus.querySelector(".delete-button");
        deleteButton.addEventListener("click",()=>{
            fetch(`http://localhost:8080/api/campuses/${campusElId.value}`,{
                method: 'DELETE'
            })
            .then(res => res.json())
            .then(newCampuses => {
                makeHomeViewFromJSON(newCampuses);
            })
        })

        const updateButton = campus.querySelector(".update-button");
        updateButton.addEventListener("click",() =>{
            const updateInput = campus.querySelector(".update-tech-stack");
            fetch(`http://localhost:8080/api/campuses/${campusElId.value}`,{
                method: 'PATCH',
                body: updateInput.value
            })
            .then(res => res.json())
            .then(newCampuses =>{
                makeHomeViewFromJSON(newCampuses);
            })
            
        })
    });

}


function makeCampusView(campus) {
        console.log(campus);
        container.innerHTML = header();
        container.innerHTML += campusView(campus);
        container.innerHTML += footer();

        const bookElement = document.querySelectorAll(".book");

        bookElement.forEach(book=>{
            book.addEventListener("click",()=>{
                let bookSum = book.querySelector(".sum_field");
                alert(bookSum.value);
            })
        })

        const backButton = document.querySelector(".back-navigation");
        backButton.addEventListener("click",()=>{
            makeHomeView();
        })

        const bookNameIn = container.querySelector(".bookNameInput");
        const bookSumIn = container.querySelector(".bookDescriptionInput");
        const addBookButton = container.querySelector(".addBookButton");

        addBookButton.addEventListener("click",()=>{
            const newBookJson = {
                "title": bookNameIn.value,
                "summary": bookSumIn.value,
            }
            fetch(`http://localhost:8080/api/campuses/${campus.id}/addBook`,{
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newBookJson)
            })
            .then(res => res.json())
            .then(campus => {
                makeCampusView(campus);
            })
        })
}

makeHomeView();