import java.io.*;
import java.util.ArrayList;

public class TxtReader implements Reader {
    private ArrayList<String>result;

    private FileInputStream fis;
    private BufferedReader reader;
    private InputStreamReader isr;

    public TxtReader() {
    }

    @Override
    public ArrayList<String> read(String path) {
        try
        {
            result = new ArrayList<>();
            String line;
            File file = new File(path);
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            reader = new BufferedReader(isr);
            while((line = reader.readLine()) != null){
                result.add(line);
            }
            reader.close();
            isr.close();
            fis.close();
        }
        catch(Exception e){

        }finally {
            try {
                isr.close();
                fis.close();
                reader.close();
            }catch (IOException e){e.printStackTrace();}
        }
        return result;
    }

}
