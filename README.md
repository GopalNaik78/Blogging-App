# Blogging App
## JSON Entities
### User

    {
	    "id": 134,
	    "username": "AjayNaik",
	    "email": 	"ajaynaik8971@gmail.com",
	    "bio":      "writes nice articles!",
	    "image":    "https://i.pinimg.com/474x/66/ff/cb/66ffcb56482c64bdf6b6010687938835.jpg"
    }
### Article
    {
	    "id": 134,
	    "title": "How the stock market fell in 2024",
	    "slug": "how-stock-market-fell-2024",
	    "subtitle": "An article about how the stock market had a crash in 2024",
	    "body": "This is an Article about.... <b>stock market</b>.....<i>2024</i>......",
	    "createdAt": "2024-02-06 03:40:55",
	    "tags": ["finance", "stocks"]
    }
### Comments

    {
	    "title": "great article",
	    "body": "This was a great article, loved reading it!",
	    "createdAt": "2024-03-07 06:50:42"
    }
### Errors
```
{
    "message": "User with username: ajay naik not found"
}
```

## API Endpoints
### `POST /users`
create new user

### `POST /users/login`

### `GET /profiles`

### `GET /profiles/{username}`

### `GET /articles`
get all articles (default page size 10)
available filters

- `/articles?tag=stocks`
- `/articles?author=ajay`
- `/articles?page=3&size=10`

### `GET /articles/{article-slug}`

### `POST /articles`🔐
create new article

### `PATCH /article/{article-slug}`🔐👤
edit an article

### `GET /article/{article-slug}/comments`📄
get all comments of an article

### `POST /article/{article-slug}/comments`🔐

### `DELETE /article/{article-slug}/comments/{comment-id}`🔐👤


