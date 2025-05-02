package manage.gulay;

public class AddCities {

    private String citiesInsert= "insert into cities(id,name,state_id,status,created_at) values(1, 'Abadan', 1715, 1, now());";
    private String getAfterCitiesInsert ="select id, name, state_id, status, created_at from cities where id = 1;";
}
