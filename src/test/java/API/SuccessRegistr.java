package API;

public class SuccessRegistr {
    private Integer id;
    private String token;

    public SuccessRegistr() {}

    public SuccessRegistr(String token, Integer id) {
        this.token = token;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
