# Story 3

When scores come into the system, the system should unmarshall the scores, adding to the league table and push a text message notification to a customer's mobile device indicating with the updated league table. 

Scores will be received via a RESTful web service. The CSV will be sent in the message body of a POST method, however, it's sufficent to build the functionality from a component similar to the following.

```
private class ResultListener {
   public void onResultReceipt() throws IOException {
      // ...
   }
}
```

The intention being that a HTTP servlet (or similar) would extract the content as a Reader and delegate to the class above.

The system should also log to the audit and record the updated league table to a database.

## Acceptance Criteria