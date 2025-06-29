package API;

public class UserTimeResponse extends UserTimeRequest{
    private String updatedAt;

    public UserTimeResponse() {}

    public UserTimeResponse(String name, String job, String updatedAt) {
        super(name, job);
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
