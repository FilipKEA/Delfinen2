public class SwimResult {
    double time;
    int date;
    Object Member;

    Object Discipline;

    String compName;

    int placement;
    public SwimResult(double time, int date, Object member, Object discipline) { //Træningsresultat
        this.time = time;
        this.date = date;
        this.Member = member;
        this.Discipline = discipline;
    }
    public SwimResult(double time, String compName, int placement, Object member, Object discipline) { //Konkurrenceresultat
        this.time = time;
        this.compName = compName;
        this.placement = placement;
        this.Member = member;
        this.Discipline = discipline;
    }

    public double getTime() {
        return time;
    }

    public Object getDiscipline() {
        return Discipline;
    }

    public Object getMember() {
        return Member;
    }

    public int getPlacement() {
        return placement;
    }
}
