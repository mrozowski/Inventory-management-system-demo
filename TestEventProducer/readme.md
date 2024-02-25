# Test Event Producer

This services generats inventory events and publish them on Kafka which alter are consumed by main service

## Endpoints

**Item sold event**
``` 
curl localhost:8085/v1/produce/sold?id=1&amount=1
```
* **id**: item id
* **amount**: number of items sold


**Item added event**
``` 
curl localhost:8085/v1/produce/added?id=1&amount=10
```

* **id**: item id 
* **amount**: number of items added to inventory
