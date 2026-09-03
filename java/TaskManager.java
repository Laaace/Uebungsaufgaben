import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskManager {

    private List<Task> tasks;

    public TaskManager(List<Task> tasks) {
        this.tasks = tasks;
    }

    // Aufgabe 1: Implementiere eine Methode, die alle Tasks zurück gibt, die NICHT erledigt sind,
    // sortiert nach Priorität (1 zuerst).
    public List<Task> getOpenTasksSortedByPriority() {
        return tasks.stream()
                .filter(task -> !task.isDone())
                .sorted(Comparator.comparingInt(Task::getPriority))
                .collect(Collectors.toList());
    }

    // Aufgabe 2: Implementiere eine Methode, die den Task mit dem übergebenen Titel als erledigt markiert.
    // Falls kein Task mit diesem Titel existiert, wirf eine
    // IllegalArgumentException mit einer sinnvollen Fehlermeldung.
    public void markAsDone(String title) {
        Task task = tasks.stream()
                .filter(t -> t.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Es konnte keine Aufgabe mit diesem Titel gefunden werden."));

        task.setDone(true);
    }
    
    // Aufgabe 3: Implementiere eine Methode, die die Anzahl offener Tasks je Prioritätsstufe zurück gibt,
    // z.B. als Map<Integer, Long> (Priorität -> Anzahl).
    public Map<Integer, Long> countOpenTasksByPriority() {
        return tasks.stream()
                .filter(task -> !task.isDone())
                .collect(Collectors.groupingBy(Task::getPriority, Collectors.counting()));
    }

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Setup Projekt", true, 2));
        tasks.add(new Task("API anbinden", false, 1));
        tasks.add(new Task("Tests schreiben", false, 3));
        tasks.add(new Task("Doku schreiben", false, 1));

        TaskManager manager = new TaskManager(tasks);

        // Aufgabe 1
        System.out.println("Offene Tasks nach Prio sortiert ausgeben");
        System.out.println(manager.getOpenTasksSortedByPriority());

        // Aufgabe 2
        manager.markAsDone("API anbinden");
        System.out.println("Task als done markieren");
        System.out.println(tasks);

        // Aufgabe 3
        System.out.println("Prüfen wie viele Tasks pro Prio offen sind");
        System.out.println(manager.countOpenTasksByPriority());
    }

}
