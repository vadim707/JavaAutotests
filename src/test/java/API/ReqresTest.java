package API;

import com.codeborne.selenide.As;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String URL = "https://reqres.in";

    @Test
    public void checkAvatarAndIdTest(){
        Specifications.installationSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());
        List<UserData> users = given()
                .when()
                .header("x-api-key", "reqres-free-v1")
                .get("/api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        users.forEach(x-> Assertions.assertTrue(x.getAvatar().contains(x.getId().toString())));
        Assertions.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));

        List<String> avatars = users.stream().map(UserData::getAvatar).toList();
        List<String> ids = users.stream().map(x->x.getId().toString()).toList();
        for (int i=0; i<avatars.size(); i++){
            Assertions.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }

    @Test
    public void successRegistrationTest(){
        Specifications.installationSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");
        SuccessRegistr successRegistr = given()
                .body(user)
                .when()
                .header("x-api-key", "reqres-free-v1")
                .post("/api/register")
                .then().log().all()
                .extract().as(SuccessRegistr.class);
        Assertions.assertEquals(id, successRegistr.getId());
        Assertions.assertEquals(token, successRegistr.getToken());
    }

    @Test
    public void UnsuccessRegistrationTest(){
        Specifications.installationSpecification(Specifications.requestSpec(URL), Specifications.responseSpec400());
        Register user = new Register("sydney@fife", "");
        UnsuccessRegistr unsuccessRegistr = given()
                .body(user)
                .when()
                .header("x-api-key", "reqres-free-v1")
                .post("/api/register")
                .then().log().all()
                .extract().as(UnsuccessRegistr.class);
        Assertions.assertEquals("Missing password", unsuccessRegistr.getError());
    }

    @Test
    public void sortedYearsTest(){
        Specifications.installationSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());
        List<ColorsData> colors = given()
                .when()
                .header("x-api-key", "reqres-free-v1")
                .get("/api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ColorsData.class);
        List<Integer> years = colors.stream().map(ColorsData::getYear).toList();
        List<Integer> sortedYears = years.stream().sorted().toList();

        Assertions.assertEquals(sortedYears, years);
    }

    @Test
    public void DeleteUserTest(){
        Specifications.installationSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(204));
        given()
                .when()
                .header("x-api-key", "reqres-free-v1")
                .delete("/api/users/2")
                .then().log().all();
    }

    @Test
    public void TimeTest(){
        Specifications.installationSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200());
        UserTimeRequest user = new UserTimeRequest("morpheus", "zion resident");
        UserTimeResponse userTimeResponse = given()
                .body(user)
                .when()
                .header("x-api-key", "reqres-free-v1")
                .put("/api/users/2")
                .then().log().all()
                .extract().as(UserTimeResponse.class);
        String regex1 = "(.{14})$";
        String regex2 = "(.{8})$";
        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex1, "");
        Assertions.assertEquals(currentTime, userTimeResponse.getUpdatedAt().replaceAll(regex2, ""));
    }
}
