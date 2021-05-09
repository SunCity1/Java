package Project03.view;

import Project03.domain.Employee;
import Project03.domain.Programmer;
import Project03.service.NameListService;
import Project03.service.TeamException;
import Project03.service.TeamService;

import static Project03.view.TSUtility.*;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    //主界面显示及控制方法
    public void enterMainMenu(){
        boolean flag = true;
        char seel = 0;
        do {
            if (seel != '1'){
                listAllEmployees();
            }
            System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4):");
            seel = readMenuSelection();
            switch (seel){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    getTeam();
                    break;
                case '3':
                    deleteMember();
                    getTeam();
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N):");
                    char set = readConfirmSelection();
                    if (set == 'Y'){
                        flag = false;
                    }
                    break;
                default:
                    System.out.println("输入错误!");
                    break;
            }
        }while(flag);
    }
    //以表格形式列出公司所有成员
    private void listAllEmployees(){
        System.out.println("-----------------------开发调度软件------------------------");
        Employee[] emps = listSvc.getAllEmployees();

        if (emps == null || emps.length == 0){
            System.out.println("目前无员工!");
        }else{
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
            for (Employee e : emps){
                System.out.println(" " + e);
            }
        }
        System.out.println("---------------------------------------------------------");
    }
    //显示团队成员列表操作
    private void getTeam(){
        System.out.println("---------------------团队成员列表--------------------------");
        Programmer[] pros = teamSvc.getTeam();
        if (pros ==null || teamSvc.getTotal() == 0){
            System.out.println("目前没有成员!");
        }else {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
            for (int i = 0; i < teamSvc.getTotal(); i++) {
                System.out.println(" " + pros[i].getDetailsForTeam());
            }
        }
        System.out.println("---------------------------------------------------------");
    }
    //实现添加成员操作
    private void addMember(){
        System.out.print("请输入要添加的员工ID:");
        int id = readInt();
        try {
            teamSvc.addMember(listSvc.getEmployee(id));
            System.out.println("添加成功");
        }catch(TeamException e){
            System.out.println("添加失败，原因:" + e.getMessage());
        }
        readReturn();
    }
    //实现删除成员操作
    private void deleteMember(){
        System.out.print("请输入要删除员工的TID:");
        int tid = readInt();
        System.out.print("确认是否删除(Y/N):");
        char selt = readConfirmSelection();
        if (selt == 'Y'){
            try {
                teamSvc.removeMember(tid);
                System.out.println("删除成功");
            }catch (TeamException e){
                System.out.println("删除失败，原因:" + e.getMessage());
            }
        }
        readReturn();
    }
    public static void main(String[] args) {
        TeamView tv = new TeamView();
        tv.enterMainMenu();
    }
}
