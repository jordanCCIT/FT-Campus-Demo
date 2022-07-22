export default function home(campuses){
    return `
    <main class="main-content">
    <section class="campus-library">
        ${campuses.map(campus =>{
            return `
            <div class="campus">
                <h2 class="campus-location">${campus.location}</h2>
                <input type="hidden" class="id-field" value="${campus.id}">
                <h3 class="campus-tech-stack">${campus.techStack}</h3>

                <input type="text" class="update-tech-stack" placeholder="New Tech Stack">                
                <button class="update-button">Update Tech Stack</button>
                <button class="delete-button">Delete</button>
            </div>
            `
        }).join("")
    }
 
    </section>
    </main>
    `
}