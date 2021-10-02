let prev = document.getElementById("prev")
let next = document.getElementById("next")
prev.addEventListener("click", page)
next.addEventListener("click", page)

function page(event) {
    let pageValue = event.target.id === "prev" ? -1 : 1;
    const params = new URLSearchParams(window.location.search)
    let newPage = +params.get("page") + pageValue
    window.location.href = "http://localhost:8080/news?page=" + newPage
}