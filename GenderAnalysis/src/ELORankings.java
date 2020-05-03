public class ELORankings {
    private String schoolName;
    private double eloRating;

    public ELORankings(String s, String elo){
        schoolName = s;
        eloRating = Double.parseDouble(elo);
    }
    public String getSchoolName(){
        return schoolName;
    }
    public double getEloRating(){
        return eloRating;
    }
}
