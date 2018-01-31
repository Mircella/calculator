import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.*;
import java.util.ArrayList;

public class DocReader implements Reader {
    private ArrayList<String> result;
    private  FileInputStream fis;
    public DocReader() {
    }

    @Override
    public ArrayList<String> read(String path) {
        result = new ArrayList<>();
        try{
            File file = new File(path);
            fis = new FileInputStream(file.getAbsolutePath());
            HWPFDocument document = new HWPFDocument(fis);
            WordExtractor extractor = new WordExtractor(document);
            String text = extractor.getText();
            String[]data = text.split("\r|\n|\r\n");
            for(String s:data){
                if(!s.isEmpty()){
                    result.add(s);
                }
            }
            fis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println(e.getClass().getSimpleName());
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getClass().getSimpleName());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getClass().getSimpleName());
        }finally {
            try {
                fis.close();
            }catch (IOException e){e.printStackTrace();}
        }

        return result;
    }


}
