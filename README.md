# Recipe-App-Project
App build using HTML, CSS, Java, Spring(MVC+Data+Rest+Security) with mapping by MapStruct and api documentation by Swagger.<br/>
Simple app to add and view recipes.<br/>

**Main Views**
* "/" index page with list of recipes
* "/recipe/{id}/show" - get single recipe by id
* "/recipe{id}/update" - update recipe by id
* "/recipe/{id}/delete" - delete recipe by id
* "/recipe/new" - create new recipe
* "/swagger" - swagger api documentation<br/>
**REST Api**
* Method: GET "/api/recipe" - get list of all recipes
* Method: GET "/api/recipe/{id}" - get single recipe by id
* Method: POST "/api/recipe" - create new recipe
* Method: PUT "/api/recipe/{id}" - update single recipe by id
* Method: DELETE "/api/recipe/{id}" - delete recipe by id<br/>
**Security**
* "/login" - login page for existing users
* "/registration" - page for creating new account
* unauthenticated visitor can only view main page, can register or login
* USER can view recipe details and create new recipes
* ADMIN has permision to view, update, delete recipes and acces to rest api 
