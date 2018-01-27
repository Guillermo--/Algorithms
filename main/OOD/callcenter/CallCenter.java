package OOD.callcenter;

import java.util.ArrayDeque;
import java.util.Queue;

public class CallCenter {
    protected static Queue<Employee> respondentsFree = new ArrayDeque<>();
    protected static Queue<Employee> managersFree = new ArrayDeque<>();
    protected static Queue<Employee> directorsFree = new ArrayDeque<>();
    protected static Queue<Call> calls = new ArrayDeque<>();

    public void listenForCalls() {
        if(!calls.isEmpty()) {
            Employee employee = findFreeEmployee();

            if(null != employee) {
                assignCall(calls.remove(), employee);
            }
        }
    }

    public Employee findFreeEmployee() {
       Employee freeEmployee;

       freeEmployee = findFreeRespondent();
       if(freeEmployee == null) freeEmployee = findFreeManager();
       if(freeEmployee == null) freeEmployee = findFreeDirector();

       return freeEmployee;
    }

    public Employee findFreeRespondent() {
        if(!respondentsFree.isEmpty()) return respondentsFree.remove();
        return null;
    }

    protected static Employee findFreeManager() {
        if(!managersFree.isEmpty()) return managersFree.remove();
        return null;
    }

    protected static Employee findFreeDirector() {
        if(!directorsFree.isEmpty()) return directorsFree.remove();
        return null;
    }

    protected static void assignCall(Call call, Employee employee) {
        employee.takeCall(call);
    }

}
