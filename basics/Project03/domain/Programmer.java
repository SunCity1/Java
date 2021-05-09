package Project03.domain;

import Project03.service.Status;

//程序员
public class Programmer extends Employee {
    private int memberld;       //记录成员加入开发团队后在团队的ID
    private Status status =Status.FREE;
    private Equipment equipment;//成员领用的设备

    public Programmer(int id, String name, int age, double salary, Equipment equipment){
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public void setMemberld(int memberld) {
        this.memberld = memberld;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
    public int getMemberld() {
        return memberld;
    }
    public Status getStatus() {
        return status;
    }
    public Equipment getEquipment() {
        return equipment;
    }
    public String getDetailsForTeam(){
        return getMemberld() + "/"+ getDetails() + "\t" + "程序员";
    }

    @Override
    public String toString() {
        return getDetails() + "\t" + "程序员" + "\t" + getStatus() + "\t\t\t\t\t" + getEquipment().getDescription();
    }
}
