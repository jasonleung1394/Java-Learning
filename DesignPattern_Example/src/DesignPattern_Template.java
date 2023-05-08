public class DesignPattern_Template {
    String pattern_name;
    String pattern_description;

    String patternOutput;


    public String getPatternInfo (){
        return "\n---------------------------------------------------------------------------------------------------" +
                "---------\n"+"The pattern is \"" + pattern_name + "\" Description: " + pattern_description + "\n----" +
                "-------------------------------------------------------------------------------------------" +
                "-------------\n";
    }
    public String getPatternOutput(){
        return "Following are the output of \"" + pattern_name + "\"" + patternOutput;
    }
}
