# Recipe API
## Overview
This API interacts with recipes and recipe reviews from a MongoDB database

### What can it do?
<ul>
  <li>Access all recipes in the database</li>
  <li>Find recipe by ID</li>
  <li>Find recipes by tag(s)</li>
  <li>Create reviews for recipes</li>
  <li>Update reviews</li>
</ul>

### Built with:
- Java
- Spring Boot
- MongoDB
- Recipe data from [tabatkins's repository](https://github.com/tabatkins/recipe-db)

## Guide
### Get all recipes
**GET** `http://localhost:8080/api/v1/recipes`

### Get recipe by id
**GET** `http://localhost:8080/api/v1/recipes/{id}`

### Get recipes by tag(s)
**GET** `http://localhost:8080/api/v1/recipes/tags?tags={tag1},{tag2}`
<br><br>
This will return all recipes that contain both tag1 and tag2.

**Example:** 

Request: `http://localhost:8080/api/v1/recipes/tags?tags=main,soup`

Response body:
```
{
    "id": {
        "timestamp": 1683762659,
        "date": "2023-05-10T23:50:59.000+00:00"
    },
    "recipeId": "133",
    "name": "Red lentil soup with sage and bacon",
    "source": "http://www.marthastewart.com/342138/red-lentil-soup-with-sage-and-bacon?center=0&gallery=274637&slide=262724",
    "preptime": 0,
    "waittime": 0,
    "cooktime": 0,
    "servings": 4,
    "comments": "",
    "instructions": "In a large saucepan over medium-high heat, cook the bacon until crisp, about 3 minutes. Transfer the bacon to a piece of paper towel, and set aside. Discard all but 1 tablespoon bacon drippings from pan.\r\n\r\nAdd the garlic to saucepan. Cook over medium heat until tender, about 5 minutes. Add the minced sage, and cook 1 minute more.\r\n\r\nAdd the lentils and chicken stock; stir to combine. Simmer until lentils are cooked and falling apart, 20 to 25 minutes.\r\n\r\nTo serve, divide the hot soup among four soup plates, and garnish with the reserved bacon and additional sage.",
    "ingredients": [
        "5 slices bacon, (4 ounces), cut into 1/4-inch dice\r",
        "2 clove garlic, finely chopped\r",
        "6 fresh sage leaves, minced, plus more for garnish\r",
        "1 1/2 cup red lentils\r",
        "5 cup homemade or low-sodium canned chicken stock"
    ],
    "tags": [
        "soup",
        "main"
    ],
    "reviewIds": []
}
```

### Create review
**POST** `http://localhost:8080/api/v1/reviews`
<br><br>Example request body:
```
{
    "recipeId": "2",
    "username": "BettyCrocker123",
    "rating": 4,
    "reviewBody": "This was very tasty. Great recipe.",
    "created": "2023-05-12T02:06:55.271"
}
```
### Update review
**PATCH** `http://localhost:8080/api/v1/reviews`
<br><br>Example request body:
```
{
    "id": "6466941c064d5241fdfb9161",
    "rating": 5,
    "reviewBody": "This recipe is amazing.",
    "updated": "2023-05-18T02:05:16.000"
}
```
## Database Setup
The raw data that I used in my MongoDB database can be found in the 'data' directory of this project.
