public class InputValidation {
    public static boolean validateInteger(String isInteger){
        try {
            int number = Integer.valueOf(isInteger);
            return validateIsPositive(number);
        } catch (Exception e){
            CommandLineApplication.outputInvalidInput();
            return false;
        }
    }

    public static boolean validateIsPositive(int isPositive){
        if (isPositive >= 0){
            return true;
        }
        CommandLineApplication.outputInvalidInput();
        return false;
    }
}
