package teamCityProject.api.requests;

/**
 * Interface which force us to create required methods(CRUD) for endpoints
 */
public interface CrudInterface {

    public Object create(Object obj);
    public Object get(String id);
    public Object update (Object obj);
    public Object delete(String id);
}
