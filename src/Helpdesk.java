public class Helpdesk {
    int deskNum;
    public final QueueSys sys = QueueSys.getInstance();

    public Helpdesk(int deskNum) {
        this.deskNum = deskNum;
    }

    public int getDeskNum() {
        return deskNum;
    }

    public void nextPerson() {
        sys.dequeue(deskNum);
    }

    public void reset(int newNum) {
        sys.reset(deskNum, newNum);
    }


}
