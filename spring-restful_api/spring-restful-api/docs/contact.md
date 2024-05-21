# Contact Api Spec

## Create Contact

Endpoint : POST /api/contacts

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "firstName": "Eki Nurhasim",
  "lastName": "Al Asari",
  "email": "ekiasari24@gmail.com",
  "phone": "082313132342"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "firstName": "Eki Nurhasim",
    "lastName": "Al Asari",
    "email": "ekiasari24@gmail.com",
    "phone": "082313132342"
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "Email format invalid, phone format invalid..."
}
```

## Update Contact

Endpoint : PUT /api/contacts/{idContact}

Request Header :

- X-API-TOOKEN : Token (Mandatory)

Request Body :

```json
{
  "firstName": "Eki Nurhasim",
  "lastName": "Al Asari",
  "email": "ekiasari24@gmail.com",
  "phone": "082313132342"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "firstName": "Eki Nurhasim",
    "lastName": "Al Asari",
    "email": "ekiasari24@gmail.com",
    "phone": "082313132342"
  }
}
```

Response Body (Faild) :

```json
{
  "errors": "Email format invalid, phone format invalid..."
}
```

## Get Contact

Endpoint : GET /api/contacts/{idContact}

Request Header :

- X-API-TOOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "firstName": "Eki Nurhasim",
    "lastName": "Al Asari",
    "email": "ekiasari24@gmail.com",
    "phone": "082313132342"
  }
}
```

Response Body (Faild) :

```json
{
  "errors": "Contact is not found"
}
```

## Search Contact

Endpoint : GET /api/contacts

Query Param :

- name : String, contact first name or last name, using like query (optional)
- phone : String, contact phone, using like query (optional)
- email : String, contact email, using like query (optional)
- page : Integer, start from 0, default 0
- size : Integer, default 10

Request Header :

- X-API-TOOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": [
    {
      "id": "random-string",
      "firstName": "Eki Nurhasim",
      "lastName": "Al Asari",
      "email": "ekiasari24@gmail.com",
      "phone": "082313132342"
    }
  ],
  "paging": {
    "currentPage": 0,
    "totalPage": 10,
    "size": 10
  }
}
```

Response Body (Faild) :

```json
{
  "error": "Unauthorized
}
```

## Remove Contact

Endpoint : DELETE api/contacts/{idcontact}

Request Header :

- X-API-TOOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": "OK"
}
```

Response Body (Faild) :

```json
{
  "error": "Contact is not found"
}
```
