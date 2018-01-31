import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        String path;
        ArrayList<String>instructions;
        double result=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if(args.length==0){
        System.out.println("Enter the name of the file:");
        try{
            path = reader.readLine();
            instructions = new ArrayList<>();
            if(path.endsWith("doc")||path.endsWith("docx")){
                DocReader docReader = new DocReader();
                instructions = docReader.read(path);
            }
            if(path.endsWith("txt")){
                TxtReader txtReader = new TxtReader();
                instructions = txtReader.read(path);
            }
            Calculator calculator = new Calculator();
            double number=0;
            for(Iterator<String>iterator = instructions.iterator();iterator.hasNext();){
                String line = iterator.next();
                if(line.contains("apply")){
                    String[]data=line.trim().split(" ");
                    try {
                        number = Double.parseDouble(data[1]);
                    }catch (NumberFormatException e){e.printStackTrace();}
                    catch (Exception e){e.printStackTrace();}
                    iterator.remove();
                }

            }
            result = calculator.calculate(number,instructions);
            System.out.println("Result is "+result);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getClass().getSimpleName());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getClass().getSimpleName());
        }finally {
            try {
                reader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        }
    }

}
