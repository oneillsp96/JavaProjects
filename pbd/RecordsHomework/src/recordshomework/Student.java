package recordshomework;

public class Student {

    public String name;
    public int grade;
    public double gpa;

//    public Student () {
//    
//        name=nameIn;
//        grade=gradeIn;
//        gpa=gpaIn;
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

}
