public class Developer {
    private String prefLanguage;
    private int workHours;
    private int age;
    private String currentProject;
    private boolean isOnHoliday;

    //Getter
    public String getPrefLanguage() {
        return prefLanguage;
    }

    public int getWorkHours() {
        return workHours;
    }

    public int getAge() {
        return age;
    }

    public String getCurrentProject() {
        return currentProject;
    }

    public boolean isOnHoliday() {
        return isOnHoliday;
    }

    //Setter
    public void setOnHoliday(boolean onHoliday) {
        isOnHoliday = onHoliday;
    }

    public void setCurrentProject(String currentProject) {
        if (currentProject == null) {
            throw new IllegalArgumentException("Project must have a name");
        } else if (this.isOnHoliday) {
            throw new IllegalStateException("No new Project can be assigned, while Developer is on vacation");
        } else {
            this.currentProject = currentProject;
        }
    }

    public void setPrefLanguage(String prefLanguage) {
        if (prefLanguage == null) {
            throw new IllegalArgumentException("Language Name empty");
        } else if (this.age > 60) {
            throw new IllegalStateException("Developer is too old to change preferred language");
        } else {
            this.prefLanguage = prefLanguage;
        }
    }

    public void setWorkHours(int workHours) {
        if (workHours == 0) {
            setOnHoliday(true);
        } else if (workHours >= 50) {
            throw new IllegalArgumentException("Warning! Too many working Hours! Arbeitszeitbetrug imminent");
        } else {
            this.workHours = workHours;
        }
    }

    public void setAge(int age) {
        if (age < 18 || age > 67) {
            throw new IllegalArgumentException("Developer is either not an adult or retired");
        } else {
            this.age = age;
        }
    }

    //Constructor
    public Developer(){
    }

    //Methods
    public void startCoding(){
        if (isOnHoliday()){
            throw new IllegalStateException("Programmer on Vacation");
        }
        else {
            //Work work work
        }
    }

    public void finishCoding(){
        //Finish finish finish
    }

    public void changeSubject(String currentProject){
        setCurrentProject(currentProject);
    }

    public void grabCoffee(){
        System.out.println("Yummy");
    }

    public double calculateIncome(int workHours){
        return (workHours-1)*3.70;
    }
}
