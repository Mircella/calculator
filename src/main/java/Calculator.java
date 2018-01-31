import java.util.ArrayList;

public class Calculator {
    private double result;

    public Calculator() {
    }

    private double add(double s1,double s2){
        return s1+s2;
    }

    private double divide(double s1,double s2) {
        try {
            s1/=s2;
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("You have division by zero");
        }
        return s1;
    }
    private double multiply(double s1,double s2){
        return s1*s2;
    }
    private double subtract(double s1, double s2){
        return s1-s2;
    }

    public double calculate(double number, ArrayList<String>instructions){
        result = number;
        double d=0;
        for(String s:instructions){
            String[]lines = s.trim().split(" ");
            try{
                d = Double.parseDouble(lines[1].trim());
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
            switch (lines[0].trim().toLowerCase()){
                case "add":{
                    result = add(result,d);
                }break;
                case "subtract":{
                    result = subtract(result,d);
                }break;
                case "multiply":{
                    result = multiply(result,d);
                }break;
                case "divide":{
                    if(d!=0){
                    result = divide(result,d);}
                    else {
                        System.out.println("You have division by zero");
                    }
                }break;
                default:{
                    System.out.println("unknown operation");
                }
            }
        }
        return result;
    }
}
