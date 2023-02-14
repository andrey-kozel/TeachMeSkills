#!/bin/bash
set -e

curl -w '\n' -X PUT http://localhost:9200/users_2 -H 'Content-Type: application/json' -d @- <<REQUEST_BODY
    {
      "settings" : {
        "index" : {
          "number_of_shards" : 1,
          "number_of_replicas" : 1
        }
      },
      "mappings" : {
         "_source": { "enabled": true },
         "dynamic": false,
         "properties": {
           "id": { "type": "long" },
           "username": { "type": "text" },
           "description": { "type": "text" }
         }
      },
      "aliases" : {
      	"users_search" : {}
      }
    }
REQUEST_BODY

