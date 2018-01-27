package OOD.callcenter;

import static OOD.callcenter.Rank.Director;
import static OOD.callcenter.Rank.Manager;

public class Employee {
    private Rank rank;
    long id;
    boolean isFree = true;
    Call currentCall;

    public Employee() {}

    public Employee(long id, Rank rank) {
        this.id = id;
        this.rank = rank;
    }

    public void takeCall(Call call) {
        this.currentCall = call;
        this.isFree = false;
    }

    public void callFinished() {
        this.isFree = true;
        this.currentCall = null;

        if(rank == Rank.Respondent) {
            CallCenter.respondentsFree.add(this);
        } else if(rank == Rank.Manager) {
            CallCenter.managersFree.add(this);
        } else if(rank == Director) {
            CallCenter.directorsFree.add(this);
        }
    }

    public Rank getNextRank() {
        if(rank == Rank.Respondent) return Manager;
        return Director;
    }

    public void reassignCall(Call call) {
        Rank nextRank = getNextRank();
        Employee reassignTo = null;

        if(nextRank == Rank.Manager)
            reassignTo = CallCenter.findFreeManager();
        if(nextRank == Rank.Director)
            reassignTo = CallCenter.findFreeDirector();

        if(reassignTo == null) {
            CallCenter.calls.add(call);
        }
        else {
            CallCenter.assignCall(call, reassignTo);
        }

        callFinished();
    }
}
