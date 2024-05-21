# User Api Spec

## Register User

- Endpoint : POST /api/users

Request Body :

```json
{
  "username": "asari",
  "password": "rahasia",
  "name": "Eki Nurhaism Al ASari"
}
```

Response Body (Success):

```json
{
  "data": "OK"
}
```

Response Body (Faield):

```json
{
  "data": "KO",
  "errors": "username must not blank, ???"
}
```

## Login User

- Endpoint : POST /api/auth/login

Request Body :

```json
{
  "username": "asari",
  "password": "rahasia"
}
```

Response Body (Success):

```json
{
  "data": {
    "token": "TOKEN",
    "expiredAt": 142341234223452 // milliseconds
  }
}
```

Response Body (Faield, 401):

```json
{
  "errors": "username or password wrong"
}
```

## Get User

- Endpoint : GET /api/users/current

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success):

```json
{
  "data": {
    "username": "asari",
    "name": "Eki Nurhasim Al Asari"
  }
}
```

Response Body (Faield, 401):

```json
{
  "errors": "Unauthorized"
}
```

## Update User

- Endpoint : PATCH /api/users/current

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "name": "Eki Asari", // put if only want to update name
  "password": "new password" // put if only want to update password
}
```

Response Body (Success):

```json
{
  "data": {
    "username": "asari",
    "name": "Eki Nurhasim Al Asari"
  }
}
```

Response Body (Faield, 401):

```json
{
  "errors": "Unauthorized"
}
```

## Logout user

- Endpoint : DELETE /api/auth/logout

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success):

```json
{
  "data": "OK"
}
```
