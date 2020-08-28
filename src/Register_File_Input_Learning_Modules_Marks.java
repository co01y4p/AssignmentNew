
import org.json.simple.JSONObject;

public class Register_File_Input_Learning_Modules_Marks {
    public JSONObject moduleLearningList(){
        JSONObject threeAssesMarkObj = new JSONObject();
        threeAssesMarkObj.put("Quiz", "");
        threeAssesMarkObj.put("Lab Test", "");
        threeAssesMarkObj.put("Assignment", "");
        return (threeAssesMarkObj);
    }
}