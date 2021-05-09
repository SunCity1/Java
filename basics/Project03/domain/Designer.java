package Project03.domain;

//设计师
public class Designer extends Programmer {
    private double bonus;//奖金

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }
    public double getBonus(){
        return bonus;
    }
    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    public String getDetailsForTeam(){
        return getMemberld() + "/" + getDetails() + "\t" + "设计师" + "\t" + getBonus();
    }
    @Override
    public String toString() {
        return getDetails() + "\t" + "设计师" + "\t" + getStatus() + "\t" + getBonus() + "\t\t\t" + getEquipment().getDescription();
    }
}
