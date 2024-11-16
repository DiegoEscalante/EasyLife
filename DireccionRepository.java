import java.util.ArrayList;
import java.util.StringTokenizer;

public class DireccionRepository extends Repository<Direccion>{
    public DireccionRepository(){
        super("direccion.txt", "|");
    }
    @Override
    public void insertDataEntity(Direccion direccion) {
        this.fileManage.writeFile(this.getDataLine(direccion));
    }

    @Override
    public ArrayList<Direccion> getDataList(){
        ArrayList<Direccion> direcciones = null;
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if(lines != null){
            direcciones = new ArrayList<>();
            for (String line : lines){
                StringTokenizer tokens = new StringTokenizer(line, this.delimiter);
                int id = Integer.parseInt(tokens.nextToken());
                int calle = Integer.parseInt(tokens.nextToken());
                int numero = Integer.parseInt(tokens.nextToken());
                String barrio = tokens.nextToken();
                int codigoPostal = Integer.parseInt(tokens.nextToken());
                String estado = tokens.nextToken();
                String pais = tokens.nextToken();
                direcciones.add(new Direccion(id, calle, numero, barrio, codigoPostal, estado, pais));
            }
        }
        return direcciones;
    }

    @Override
    public void updateDataEntity(Direccion oldDireccion, Direccion newDireccion){
        this.fileManage.updateFile(
                this.getDataLine(oldDireccion),
                this.getDataLine(newDireccion)
        );
    }

    @Override
    public void deleteDataEntity(Direccion direccion) {
        this.fileManage.deleteFile(this.getDataLine(direccion));
    }


    @Override
    public String getDataLine(Direccion direccion){
        return direccion.getId() + this.delimiter + direccion.getCalle() + this.delimiter + direccion.getNumero() + this.delimiter + direccion.getBarrio() + this.delimiter + direccion.getCodigoPostal() + this.delimiter + direccion.getEstado() + this.delimiter + direccion.getPais();
    }

    public Direccion findEntityById(int id){
        ArrayList<Direccion> direcciones = this.getDataList();
        for (Direccion Direccion : direcciones){
            if(Direccion.getId() == id){
                return Direccion;
            }
        }
        return null;
    }

}
