# Story 3

When scores come into the system, the system should unmarshall the scores, adding to the league table and push a text message notification to a customer's mobile device including the updated league table.

Scores will be received via a RESTful web service. The CSV will be sent in the message body of a POST method, however, it's sufficient to build the functionality from a component similar to the following.

```java
private class ResultListener {
   public void onResultReceipt() throws IOException {
      // ...
   }
}
```

The intention being that a HTTP servlet (or similar) would extract the content as a Reader and delegate to the class above.


## Acceptance Criteria

- When a stream containing result data as CSV (as a Reader) is received, then the system will unmarshall the results into a set of results.
- Given the set of results above, the system will update the league table with appropriate point values (from Story 2).
- When the league table has been updated, the entire league table  will be sent as a SMS message.