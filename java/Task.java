public class Task {
    private String title;
    private boolean done;
    private int priority; // 1 = hoch, 3 = niedrig

    public Task(String title, boolean done, int priority) {
        this.title = title;
        this.done = done;
        this.priority = priority;
    }


    public String getTitle() {
        return this.title;
    }


    public boolean isDone() {
        return this.done;
    }


    public int getPriority() {
        return this.priority;
    }


    public void setDone(boolean done) {
        this.done = done;
    }


    @Override
    public String toString() {
        return "[" + (done ? "x" : " ") + "] (P" + priority + ") " + title;
    }
}