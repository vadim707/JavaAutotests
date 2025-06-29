package API;

public class UnsuccessRegistr {
    private String error;

    public UnsuccessRegistr(){}

    public UnsuccessRegistr(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
