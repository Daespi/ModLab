const tabs = document.querySelectorAll(".tab");
const contents = document.querySelectorAll(".tab-content");

tabs.forEach(tab => {
  tab.addEventListener("click", () => {
    // Quitar activos
    tabs.forEach(t => t.classList.remove("active"));
    contents.forEach(c => c.classList.remove("active"));

    // Activar el que se clicó
    tab.classList.add("active");
    document.getElementById(tab.dataset.tab).classList.add("active");
  });
});
