import java.util.ArrayList;
import java.util.StringTokenizer;

public class PerfilMedicoRepository {

    private  departmentRepository;

    public EmployeeRepository() {
        super("employees.txt", "|");
        this.departmentRepository = new DepartmentRepository();
    }

    @Override
    public ArrayList<Employee> getDataList() {
        ArrayList<Employee> employees = null;
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if (lines != null) {
            employees = new ArrayList<>();
            for (String line : lines) {
                StringTokenizer tokens = new StringTokenizer(line, this.delimiter);
                int id = Integer.parseInt(tokens.nextToken());
                String firstName = tokens.nextToken();
                String lastName = tokens.nextToken();
                double salary = Double.parseDouble(tokens.nextToken());
                String phoneNumber = tokens.nextToken();
                int idDepartment = Integer.parseInt(tokens.nextToken());
                Employee employee = new Employee(id, firstName, lastName, phoneNumber, salary);
                Department department = this.departmentRepository.findEntityById(idDepartment);
                if(department != null){
                    employee.setDepartment(department);
                }
                employees.add(employee);
            }
        }
        return employees;
    }

    @Override
    public void insertDataEntity(Employee employee) {
        this.fileManage.writeFile(this.getDataLine(employee));
    }

    @Override
    public void updateDataEntity(Employee oldEmployee, Employee newEmployee){
        this.fileManage.updateFile(
                this.getDataLine(oldEmployee),
                this.getDataLine(newEmployee)
        );
    }

    public void deleteDataEntity(Employee deleteEmployee){
        this.fileManage.deleteFile(this.getDataLine(deleteEmployee));
    }

    @Override
    public String getDataLine(Employee employee){
        return employee.getId() + this.delimiter + employee.getFirstName() + this.delimiter + employee.getLastName()
                + this.delimiter + Math.round(employee.getSalary()) + this.delimiter + employee.getPhoneNumber();
    }
}

}
