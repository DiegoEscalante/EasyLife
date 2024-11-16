import java.io.*;
import java.util.ArrayList;

public class FileManage {

    private String nameFile;

    public FileManage(String nameFile) {
        this.nameFile = nameFile;
    }

    public File getFile() {
        return new File("src/files/" + this.nameFile);
    }

    public ArrayList<String> getDataOfFile() {
        ArrayList<String> lines = null;
        try{
            File file = this.getFile();
            if (file.exists()){
                lines = new ArrayList<>();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.getFile()));
                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    lines.add(line);
                }
                bufferedReader.close();
            }else {
                System.out.println("El archivo no existe!");
            }
        }catch (IOException e){
            e.printStackTrace(System.out);
        }

        return lines;
    }

    public void writeFile(String newLine)
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.getFile(), true));
            writer.write(newLine);
            writer.newLine();
            writer.close();
            System.out.println("Line added sucessfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateFile(String oldLine, String newLine){
        ArrayList<String> lines = this.getDataOfFile();
        if(lines != null){
            for (int i = 0; i < lines.size(); i++) {
                if(lines.get(i).equals(oldLine)){
                    lines.set(i, newLine);
                    this.writeAllLinesInFile(lines);
                    break;
                }
            }
        }
    }

    public void deleteFile(String line)
    {
        ArrayList<String> lines = this.getDataOfFile();
        if(lines != null){
            for (int i = 0; i < lines.size(); i++) {
                if(lines.get(i).equals(line)){
                    lines.remove(i);
                    this.writeAllLinesInFile(lines);
                    System.out.println("The line was deleted success");
                    break;
                }
            }
        }
    }

    public void writeAllLinesInFile(ArrayList<String> lines){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.getFile()));
            for(String line : lines){
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}