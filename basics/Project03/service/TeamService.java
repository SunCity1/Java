package Project03.service;

import Project03.domain.Architect;
import Project03.domain.Designer;
import Project03.domain.Employee;
import Project03.domain.Programmer;

public class TeamService {
    private static int counter = 1;    //生成团队的唯一ID
    private final int MAX_MEMBER = 5;   //开发团队的最大成员数
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;  //记录团队成员的实际人数

    public Programmer[] getTeam() {
        Programmer[] pro = new Programmer[total];
        for (int i = 0; i < total; i++) {
            pro[i] = team[i];
        }
        return pro;
    }

    public void addMember(Employee e) throws TeamException{

        if (total >= MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
        if (!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        Programmer prog = (Programmer) e;
        if (isExist(prog)){
            throw new TeamException("该成员已在本开发团队中");
        }
        if (Status.BUSY.equals(prog.getStatus())){
            throw new TeamException("该成员已是某团队成员");
        }else if (Status.VOCATION.equals(prog.getStatus())){
            throw new TeamException("该成员正在休假，无法添加");
        }
        int numOfArch = 0;
        int numOfDsgn = 0;
        int numOfPrg = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect){
                numOfArch ++;
            }else if (team[i] instanceof Designer){
                numOfDsgn ++;
            }else{
                numOfPrg ++;
            }
        }
        if (e instanceof Architect){
            if (numOfArch >= 1){
                throw new TeamException("团队中至多只能有一名架构师");
            }
        }else if (e instanceof Designer){
            if (numOfDsgn >= 2){
                throw new TeamException("团队中至多只能由两名设计师");
            }
        }else{
            if (numOfPrg >= 3){
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        team[total ++] = prog;
        prog.setMemberld(counter ++);
        prog.setStatus(Status.BUSY);
    }
    private boolean isExist(Programmer p){
        for (int i = 0; i < total; i++) {
            if (p.getId() == team[i].getId()){
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException{
        int i;
        for (i=0; i < total; i++) {
            if (memberId == team[i].getMemberld()){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if (i == total){
            throw new TeamException("找不到指定memberId的员工，删除失败!");
        }
        for (int j = i; j < total - 1; j++) {
            team[j] = team[j+1];
        }
        team[--total] = null;

    }
    public int getTotal() {
        return total;
    }
}
