package Project03.service;

import Project03.domain.*;

import java.util.Arrays;

import static Project03.service.Data.*;

public class NameListService {

    private Employee[] employees;

    public NameListService(){
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < employees.length;i++){
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            int salary = Integer.parseInt(EMPLOYEES[i][4]);

            Equipment eq;
            double bonus;
            int stock;

            switch(type){
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    eq = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, eq);
                    break;
                case DESIGNER:
                    eq = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, eq, bonus);
                    break;
                case ARCHITECT:
                    eq = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, eq, bonus, stock);
                    break;
            }
        }
    }

    private Equipment createEquipment(int index){

        int type = Integer.parseInt(EQUIPMENTS[index][0]);
        Equipment eqm;
        switch(type){
            case PC:
                eqm = new PC(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
                break;
            case NOTEBOOK:
                eqm = new NoteBook(EQUIPMENTS[index][1], Double.parseDouble(EQUIPMENTS[index][2]));
                break;
            case PRINTER:
                eqm = new Printer(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
                break;
            default:
                eqm = new Equipment() {
                    @Override
                    public String getDescription() {
                        return null;
                    }
                };
                break;
        }
        return eqm;

    }

    public Employee[] getAllEmployees() {
        return employees;
    }
    public Employee getEmployee(int id) throws TeamException{
        for (int i = 0; i < employees.length; i++) {
            if (id == employees[i].getId()){
                return employees[i];
            }
        }
        throw new TeamException("找不到指定的员工!");

//        try {
//            return employees[id - 1];
//        }catch (TeamException e){
//            throw new TeamException("找不到指定的员工!");
//        }
    }


}
