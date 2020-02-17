package incident;

public class Priority {
    private final int priorityCode;
    private int influence;
    private int urgency;
    private String description;
    private int deadline;

    public Priority(int influence, int urgency) {
        this.influence = influence;
        this.urgency = urgency;
        priorityCode = influence + urgency + 1;

        switch (priorityCode) {
            case 1:
                description = "Критический";
                deadline = 1;
                break;
            case 2:
                description = "Высокий";
                deadline = 8;
                break;
            case 3:
                description = "Средний";
                deadline = 24;
                break;
            case 4:
                description = "Низкий";
                deadline = 48;
                break;
            case 5:
                description = "Планируемый";
                deadline = 99;
                break;
        }
    }

    public int getPriorityCode() {
        return priorityCode;
    }

    public int getInfluence() {
        return influence;
    }

    public int getUrgency() {
        return urgency;
    }

    public String getDescription() {
        return description;
    }

    public int getDeadline() {
        return deadline;
    }
}