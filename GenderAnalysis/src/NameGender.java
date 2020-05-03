public class NameGender {
    private String name;
    private String gender;
    private double probability;

    public NameGender(String f, String g, String p)
    {
        name = f;
        gender = g;
        probability = Double.parseDouble(p);
    }

    public String getName()
    {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public double getProbability() {
        return probability;
    }
}
