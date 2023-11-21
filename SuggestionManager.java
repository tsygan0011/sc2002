import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * The SuggestionManager class manages suggestions from commitee members, interacting with CSV data.
 * It provides methods to retrieve, add, and manipulate suggestions.
 */
public class SuggestionManager extends CSVReader{
    public static void main(String[] args) {
        addSuggestion(CampManager.getCamp("stupid camp"), UserManager.getUser("DIMAS001"), "test suggestion");
    }

     /**
     * Retrieves the array of all suggestions from the CSV file.
     *
     * @return An array of Suggestion objects containing suggestion data.
     */
    public static Suggestion[] getSuggestionDatabase(){
        List<Suggestion> suggList = new LinkedList<>();
        for(String s : getLines("data/suggestions.csv")){
            String[] items = s.split(",");
            suggList.add(new Suggestion(items[0], UserManager.getUser(items[1]), CampManager.getCamp(items[2]), getCommas(items[3]), items[4]));
        }
        return suggList.toArray(new Suggestion[suggList.size()]); 
    }

    /**
     * Retrieves the array of all suggestions for a specific camp.
     *
     * @param camp The Camp object that corresponds to the target camp.
     * @return An array of Suggestion objects containing suggestion data for this camp.
     */
    public static Suggestion[] getSuggestionsForCamp(Camp camp){
        List<Suggestion> suggList = new LinkedList<>();
        for(Suggestion s : getSuggestionDatabase()){
            if(s.camp.campName.equals(camp.campName)){
                suggList.add(s);
            }
        }
        return suggList.toArray(new Suggestion[suggList.size()]);
    }

    /**
     * Retrieves the array of all suggestions by a specific user.
     *
     * @param user The User object that corresponds to the user making the suggestion.
     * @return An array of Suggestion objects containing suggestion data for this camp.
     */
    public static Suggestion[] getSuggestionsByUser(User user){
        List<Suggestion> suggList = new LinkedList<>();
        for(Suggestion s : getSuggestionDatabase()){
            if(s.committeeMember.userID.equals(user.userID)){
                suggList.add(s);
            }
        }
        return suggList.toArray(new Suggestion[suggList.size()]);
    }

    /**
     * Creates a new suggestion into the CSV file.
     *
     * @param camp The Camp object that correspods to the target camp.
     * @param committeeMember The User object that corresponds to the committee member creating this suggestion.
     * @param message The contents of the suggestion
     */
    public static void addSuggestion(Camp camp, User committeeMember, String message){
        Suggestion[] suggDB = getSuggestionDatabase();
        int suggID = CSVReader.toInt(suggDB[suggDB.length-1].suggestionID)+1;
        String line = String.format("%s,%s,%s,%s,None", suggID, committeeMember.userID, camp.campName, removeCommas(message));
        addLine("data/suggestions.csv", line);
    }
}