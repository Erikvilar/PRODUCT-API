# PRODUCT-API  PROVA PRÁTICA - PARTE 2
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

## POST - CREATE NEW CATEGORY
* URL PATH : [ http://localhost:6680/category/save ]

* Nota -> Há alguns erros de implementação ocorrendo ao salvar a string de categoryID como por exemplo na visualização dos dados não sendo completo, isso será corrigido em breve.


```JSON
{
  "name":"Item Frágil"
}
```
### RESULT 
```JSON
{
  "id": "6757378a6c605500b7ca68bf",
  "name": "Item Frágil"
}
```

## POST - CREATE NEW PRODUCT
* URL PATH : [ http://localhost:6680/product/save ]

### BODY AND RESULT

```JSON
{
  "name": "Taça de vidro",
  "price": 50.0,
  "productIdentifier": "prod-12345",
  "description": "Taça de vidro tipo cristal",
  "categoryId": "6757378a6c605500b7ca68bf"
}
```

## GET - PRODUCT BY ID
* URL PATH : [ http://localhost:6680/product/id/675737796c605500b7ca68bd ]

### RESULT 
```JSON
{
  "id": "675737796c605500b7ca68bd",
  "name": "Taça de vidro",
  "productIdentifier": "prod-12345",
  "description": "Taça de vidro tipo cristal",
  "price": 50.0,
  "categoryId": "6757378a6c605500b7ca68bf"
}
```
##  GET - PRODUCT BY productIdentifier
* URL PATH : [ http://localhost:6680/product/prod-12345 ]
### RESULT 

```JSON

[
  {
    "id": "67572856d418ce59cf72460d",
    "name": "Product A",
    "productIdentifier": "prod-12345",
    "description": "A great product.",
    "price": 100.0,
    "categoryId": "6757378a6c605500b7ca68bf"
  },
  {
    "id": "675737796c605500b7ca68bd",
    "name": "Computador DELL Optplex 4090",
    "productIdentifier": "prod-12345",
    "description": "Computador de marca boa",
    "price": 2892.0,
    "categoryId": "6757376f6c605500b7ca68bc"
  }
]

```

### GET - ALL PRODUCTS

* URL PATH : [ http://localhost:6680/product ]

### RESULT
```JSON
[
  {
    "id": "67572856d418ce59cf72460d",
    "name": "Product A",
    "productIdentifier": "prod-12345",
    "description": "A great product.",
    "price": 100.0,
    "categoryId": "67572841d418ce59cf72460c"
  },
  {
    "id": "675737796c605500b7ca68bd",
    "name": "Taça",
    "productIdentifier": "prod-12345",
    "description": "A great product.",
    "price": 50.0,
    "categoryId": "6757376f6c605500b7ca68bc"
  }
]
```

##  GET - PRODUCT PAGE
* URL PATH : [ http://localhost:6680/product/pageable?size=1&page=1 ]

### RESULT 

```JSON
{
  "content": [
    {
      "id": "675737796c605500b7ca68bd",
      "name": "Taça de vidro",
      "productIdentifier": "prod-12345",
      "description": "A great product.",
      "price": 50.0,
      "categoryId": "6757376f6c605500b7ca68bc"
    }
  ],
  "pageable": {
    "pageNumber": 1,
    "pageSize": 1,
    "sort": {
      "empty": true,
      "sorted": false,
      "unsorted": true
    },
    "offset": 1,
    "paged": true,
    "unpaged": false
  },
  "last": true,
  "totalElements": 2,
  "totalPages": 2,
  "size": 1,
  "number": 1,
  "sort": {
    "empty": true,
    "sorted": false,
    "unsorted": true
  },
  "first": false,
  "numberOfElements": 1,
  "empty": false
}
```
##  GET - PRODUCT BY CATEGORY INSIDE COLLECTION PRODUCT

* URL PATH : [ http://localhost:6680/product/category/6757378a6c605500b7ca68bf ]

### RESULT 
```JSON
{
  "id": "675737796c605500b7ca68bd",
  "name": "Taça de vidro",
  "productIdentifier": "prod-12345",
  "description": "Taça de vidro tipo cristal",
  "price": 50.0,
  "categoryId": "6757378a6c605500b7ca68bf"
}
```

### DELETE - BY PRODUCT ID
* URL PATH : [ http://localhost:6680/product/id/675737796c605500b7ca68bd ]

### RESULT 
* Produto deletado de id: 675737796c605500b7ca68bd
```JAVA
HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("http://localhost:6680/product/id/675737796c605500b7ca68bd"))
    .header("Accept", "*/*")
    .header("User-Agent", "Thunder Client (https://www.thunderclient.com)")
    .method("DELETE", HttpRequest.BodyPublishers.noBody())
    .build();
HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
System.out.println(response.body());

```

### POST - UPDATE CATEGORY

* URL PATH : [ http://localhost:6680/category/id/67572959d418ce59cf72460f ]

### BODY
```JSON
{
  "name":"Item descartavel"
}

```
### RESULT
```JSON
{
  "id": "67572959d418ce59cf72460f",
  "name": "Item descartavel"
}
```

### DELETE - CATEGORY BY ID

* URL PATH : [ http://localhost:6680/category/id/67572959d418ce59cf72460f ]

### RESULT 
 * categoria deletada de id: 67572959d418ce59cf72460f

### GET -  All CATEGORIES

* URL PATH : [ http://localhost:6680/category ]

### RESULT 

```JSON
[
  {
    "id": {
      "timestamp": 1733765185,
      "date": "2024-12-09T17:26:25.000+00:00"
    },
    "name": "Categoria atualizada"
  },
  {
    "id": {
      "timestamp": 1733765268,
      "date": "2024-12-09T17:27:48.000+00:00"
    },
    "name": "Eletronico"
  },
  {
    "id": {
      "timestamp": 1733769071,
      "date": "2024-12-09T18:31:11.000+00:00"
    },
    "name": "Categoria nova"
  },
  {
    "id": {
      "timestamp": 1733769098,
      "date": "2024-12-09T18:31:38.000+00:00"
    },
    "name": "Categoria nova"
  },
  {
    "id": {
      "timestamp": 1733769098,
      "date": "2024-12-09T18:31:38.000+00:00"
    },
    "name": "Categoria nova"
  }
]
```
### GET - CATEGORIES PAGE

* URL PATH : [ http://localhost:6680/category/pageable?size=1&page=1 ]
### RESULT
```JSON
{
  "content": [
    {
      "id": "67572894d418ce59cf72460e",
      "name": "Eletronico"
    }
  ],
  "pageable": {
    "pageNumber": 1,
    "pageSize": 1,
    "sort": {
      "empty": true,
      "unsorted": true,
      "sorted": false
    },
    "offset": 1,
    "unpaged": false,
    "paged": true
  },
  "last": false,
  "totalElements": 6,
  "totalPages": 6,
  "first": false,
  "size": 1,
  "number": 1,
  "sort": {
    "empty": true,
    "unsorted": true,
    "sorted": false
  },
  "numberOfElements": 1,
  "empty": false
}
```