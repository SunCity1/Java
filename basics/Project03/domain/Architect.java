package Project03.domain;

//架构师
public class Architect extends Designer {
    private int stock;//公司奖励的股票数量

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }

    public String getDetailsForTeam(){
        return getMemberld() + "/" + getDetails() + "\t" + "架构师" + "\t" + getBonus() + "\t" + getStock();
    }

    @Override
    public String toString() {
        return getDetails() + "\t" + "架构师" + "\t" + getStatus() + "\t" + getBonus() + "\t" + getStock() + "\t" + getEquipment().getDescription();
    }
}
