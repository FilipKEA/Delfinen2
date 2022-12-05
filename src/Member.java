public class Member {
    String name;
    int age;
    boolean active;
    boolean competitive;
    boolean senior = false;
    int subFee;
    boolean subPaid = false;

    boolean crawl;

    boolean backstroke;
    public Member(String name, int age, boolean active) { //Motionist constructor
        this.name = name;
        this.age = age;
        this.active = active;
        this.competitive = false;
        if (age > 17) {
            this.senior = true;
        }
        if (!active) {
            this.subFee = 500;
        } else if (age > 17 && age < 60){
            this.subFee = 1600;
        } else if (age > 59) {
            this.subFee = 1200;
        } else {
            this.subFee = 1000;
        }
    }
    public Member(String name, int age, boolean active, boolean crawl, boolean backstroke) { //Competitive constructor
        this.name = name;
        this.age = age;
        this.active = active;
        this.competitive = true;
        if (age > 17) {
            this.senior = true;
        }
        if (!active) {
            this.subFee = 500;
        } else if (age > 17 && age < 60){
            this.subFee = 1600;
        } else if (age > 59) {
            this.subFee = 1200;
        } else {
            this.subFee = 1000;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubFee() {
        return subFee;
    }

    public void setSubFee(int subFee) {
        this.subFee = subFee;
    }

    public boolean isSubPaid() {
        return subPaid;
    }

    public void setSubPaid(boolean subPaid) {
        this.subPaid = subPaid;
    }

    public void setAge(int age) {
        this.age = age;
        if (age > 17) {
            this.senior = true;
        } else {
            this.senior = false;
        }
    }

    public int getAge() {
        return age;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }

    public boolean isSenior() {
        return senior;
    }

    public void setCrawl(boolean crawl) {
        this.crawl = crawl;
    }

    public boolean isCrawl() {
        return crawl;
    }

    public boolean isBackstroke() {
        return backstroke;
    }

    public void setBackstroke(boolean backstroke) {
        this.backstroke = backstroke;
    }

    public void setCompetitive(boolean competitive) {
        this.competitive = competitive;
    }

    public boolean isCompetitive() {
        return competitive;
    }
    @Override
    public String toString() {
        return getName();
    }

}
