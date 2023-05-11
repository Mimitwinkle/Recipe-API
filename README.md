# Recipe API
## Overview
This API interacts with recipes and recipe reviews from a MongoDB database

### What can it do?
<ul>
  <li>Access all recipes in the database</li>
  <li>Find recipe by ID</li>
  <li>Create reviews for recipes</li>
</ul>

### Built with:
<ul>
  <li>Java</li>
  <li>Spring Boot</li>
  <li>MongoDB</li>
</ul>

## Guide
### Get all recipes
**GET** `http://localhost:8080/api/v1/recipes`

### Get recipe by id
**GET** `http://localhost:8080/api/v1/recipes/{id}`

### Create review
**POST** `http://localhost:8080/api/v1/reviews`
<br>Example body:
```
{
    "recipeId": "2",
    "reviewBody": "This was very tasty. Great recipe.",
    "username": "BettyCrocker123",
    "created": "2023-05-12T02:06:55.271"
}
```
