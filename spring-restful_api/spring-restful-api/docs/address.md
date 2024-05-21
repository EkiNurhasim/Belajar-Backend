# Address Api Spec

## Create Address

Endpoint : POST /api/contacts/{idContact}/addresses

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "street": "Jalan apa",
  "city": "Tangerang",
  "province": "Banten",
  "country": "Indonesia",
  "postalCode": 12213
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "street": "Jalan apa",
    "city": "Tangerang",
    "province": "Banten",
    "country": "Indonesia",
    "postalCode": 12213
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "contact is not found"
}
```

## Update Address

Endpoint : PUT /api/contacts/{contactId}/addresses{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "street": "Jalan apa",
  "city": "Tangerang",
  "province": "Banten",
  "country": "Indonesia",
  "postalCode": 12213
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "street": "Jalan apa",
    "city": "Tangerang",
    "province": "Banten",
    "country": "Indonesia",
    "postalCode": 12213
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "address is not found"
}
```

## Get Address

Endpoint : GET /api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "street": "Jalan apa",
    "city": "Tangerang",
    "province": "Banten",
    "country": "Indonesia",
    "postalCode": 12213
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "address is not found"
}
```

## Remove Address

Endpoint : DELETE /api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": "OK"
}
```

Response Body (Failed) :

```json
{
  "errors": "address is not found"
}
```

## List Address

Endpoint : GET /api/contacts/{idContact}/addresses

Request Header :

- X-API-TOKEN : Token (Mandatory)

```json
{
  "data": [
    {
      "id": "random-string",
      "street": "Jalan apa",
      "city": "Tangerang",
      "province": "Banten",
      "country": "Indonesia",
      "postalCode": 12213
    }
  ]
}
```

Response Body (Failed) :

```json
{
  "errors": "contact is not found"
}
```
