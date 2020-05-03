import java.io.*;
import java.util.*;

public class Gender {
    public static void main(String[] args) throws IOException {
        String nameList = "/Users/devila03/Downloads/names.csv";
        String databaseList = "/Users/devila03/Downloads/name_gender.csv";
        String rankingsList = "/Users/devila03/Downloads/elo_rankings.csv";

        ArrayList<Student> debaters = loadFile1(nameList);
        ArrayList<NameGender> database = loadFile2(databaseList);
        ArrayList<ELORankings> rank = loadFile3(rankingsList);

        FileWriter writer = new FileWriter("result.csv");
        String fileContent = "";
        for (int i = 0; i < debaters.size(); i++) {
            Student subject = debaters.get(i);
            NameGender temp = binarySearch(database, subject.getFirstName());
            if (temp != null) {
                subject.changeGender(temp.getGender());
                subject.changePredictionAccuracy(temp.getProbability());
               //        fileContent += subject.getFirstName() + "," + subject.getLastName() + "," + subject.getSchool() + "," + subject.getMaleOrFemale() + "," + subject.getPredictionAccuracy() + "\n";
            }
            double tempELO = binarySearch2(rank, subject.getSchool());
            if (tempELO != 0) {
                subject.changeELO(tempELO);
            }
            fileContent += subject.getFirstName() + "," + subject.getLastName() + "," + subject.getSchool() + "," + subject.getMaleOrFemale() + "," + subject.getPredictionAccuracy() + "," + subject.getELO() + "\n";

        }
        writer.write(fileContent);
        writer.close();
    }

    public static NameGender binarySearch(List<NameGender> database, String searchValue) {

        int low = 0;
        int high = database.size() - 1;
        int mid = (low + high) / 2;

        while (low <= high && !database.get(mid).getName().equalsIgnoreCase(searchValue)) {

            if (database.get(mid).getName().compareTo(searchValue) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = (low + high) / 2;

            if (low > high) {
                mid = -1;
            }

        }
        if (mid >= 0)
            return database.get(mid);
        else
            return null;
    }

    public static double binarySearch2(List<ELORankings> database, String searchValue) {

        int low = 0;
        int high = database.size() - 1;
        int mid = (low + high) / 2;

        while (low <= high && !database.get(mid).getSchoolName().contains(searchValue)) {
            if (database.get(mid).getSchoolName().compareTo(searchValue) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = (low + high) / 2;

            if (low > high) {
                mid = -1;
            }

        }
        if (mid >= 0)
            return database.get(mid).getEloRating();
        else
            return 0;
    }

    public static ArrayList<Student> loadFile1(String csvFile) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Student> kids = new ArrayList<Student>();
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] info = line.split(cvsSplitBy);

                kids.add(new Student(info[0], info[1], info[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return kids;
    }

    public static ArrayList<NameGender> loadFile2(String csvFile) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<NameGender> names = new ArrayList<NameGender>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] info = line.split(cvsSplitBy);
                names.add(new NameGender(info[0], info[1], info[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return names;
    }

    public static ArrayList<ELORankings> loadFile3(String csvFile) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<ELORankings> ranks = new ArrayList<ELORankings>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] info = line.split(cvsSplitBy);
                ranks.add(new ELORankings(info[0], info[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ranks;
    }
}
