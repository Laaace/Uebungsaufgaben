const tasks = [
    { title: "Setup Projekt", done: true, priority: 2 },
    { title: "API anbinden", done: false, priority: 1 },
    { title: "Tests schreiben", done: false, priority: 3 },
    { title: "Doku schreiben", done: false, priority: 1 },
];

const priorities = [3, 2, 1]; // Prio 3 zuerst, da "wichtigste"

// Aufgabe 1: Implementiere eine Methode getOpenTasksSortedByPriority(tasks),
// die alle offenen Tasks aufsteigend nach Priorität sortiert zurückgibt.
function getOpenTasksSortedByPriority(tasks) {
    return tasks
        .filter(task => !task.done)
        .sort((a, b) => b.priority - a.priority);
}

// Aufgabe 2: Implementiere eine Methode renderTaskList(tasks), die aus dem
// Array eine einfache HTML-Liste (als String) erzeugt, z.B.:
// "<ul><li>[ ] (P1) API anbinden</li>...</ul>"
function renderTaskList(tasks) {  
        const items = [...tasks]
            .sort((a, b) => b.priority - a.priority)
                .map(task => `<li>Priorität: ${task.priority}, ${task.title}, fertig? ${task.done ? "Ja" : "Nein"}</li>`)
                .join("");

    return `<ul>${items}</ul>`;
}

// Aufgabe 3 (Bonus): Implementiere eine Methode countOpenTasksByPriority(tasks),
// die ein Objekt zurückgibt, z.B. {1: 2, 3: 1}.
function countOpenTasksByPriority(tasks) {
    const counts = {};
    tasks
        .filter(task => !task.done)
        .forEach(task => {
            counts[task.priority] = (counts[task.priority] ?? 0) + 1;
        });

    return counts;
}

// Aufrufen der Funktionen zum testen 
console.log(getOpenTasksSortedByPriority(tasks));
console.log(renderTaskList(tasks));
console.log(countOpenTasksByPriority(tasks));