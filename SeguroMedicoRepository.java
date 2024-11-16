import java.util.ArrayList;
import java.util.StringTokenizer;

public class SeguroMedicoRepository extends Repository<SeguroMedico>{
    public SeguroMedicoRepository(){
        super("SeguroMedico.txt", "|");
    }
    @Override
    public void insertDataEntity(SeguroMedico SeguroMedico) {
        this.fileManage.writeFile(this.getDataLine(SeguroMedico));
    }

    @Override
    public ArrayList<SeguroMedico> getDataList(){
        ArrayList<SeguroMedico> segurosMedicos = null;
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if(lines != null){
            segurosMedicos = new ArrayList<>();
            for (String line : lines){
                StringTokenizer tokens = new StringTokenizer(line, this.delimiter);
                int id = Integer.parseInt(tokens.nextToken());
                String proveedor = tokens.nextToken();
                String cobertura = tokens.nextToken();
                segurosMedicos.add(new SeguroMedico(id, proveedor, cobertura));
            }
        }
        return segurosMedicos;
    }

    @Override
    public void updateDataEntity(SeguroMedico oldSeguroMedico, SeguroMedico newSeguroMedico){
        this.fileManage.updateFile(
                this.getDataLine(oldSeguroMedico),
                this.getDataLine(newSeguroMedico)
        );
    }

    @Override
    public void deleteDataEntity(SeguroMedico seguroMedico) {
        this.fileManage.deleteFile(this.getDataLine(seguroMedico));
    }


    @Override
    public String getDataLine(SeguroMedico seguroMedico){
        return seguroMedico.getId() + this.delimiter + seguroMedico.getProveedor() + this.delimiter + seguroMedico.getCobertura();
    }

    public SeguroMedico findEntityById(int id){
        ArrayList<SeguroMedico> segurosMedicos = this.getDataList();
        for (SeguroMedico seguroMedico : segurosMedicos){
            if(seguroMedico.getId() == id){
                return seguroMedico;
            }
        }
        return null;
    }

}