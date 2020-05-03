public class Student {
    private String firstName;
    private String lastName;
    private String school;
    private String maleOrFemale;
    private double predictionAccuracy;
    private double ELO;

    public Student(String f, String l, String hs) {
        firstName = f;
        lastName = l;
        school = hs;
        maleOrFemale = null;
        predictionAccuracy = 0;
        ELO = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getSchool() {
        return school;
    }

    public String getMaleOrFemale() {
        return maleOrFemale;
    }

    public double getPredictionAccuracy() {
        return predictionAccuracy;
    }

    public double getELO() {
        return ELO;
    }

    public void changeGender(String g) {
        maleOrFemale = g;
    }
    public void changePredictionAccuracy(Double p) {
        predictionAccuracy = p;
    }

    public void changeELO(Double e) {
        ELO = e;
    }

    public String toString() {
        String temp = firstName + " " + lastName + " " + school + " " + maleOrFemale + " " + predictionAccuracy;
        return temp;
    }
}
