spreedly-java
=============

```
<dependency>
    <groupId>cc.protea.spreedly</groupId>
    <artifactId>spreedly</artifactId>
    <version>0.9</version>
</dependency>
```

I've attempted to preserve as much as possible of the Spreedly nomenclature, while making this more accessible to folk who spend
a lot more time writing Java code than they do working with the Spreedly team.

In general, the only spelling differences are the use of StudlyCaps rather than under_scores.  I have taken the liberty of
branching the Spreedly term "gateway" into "gatewayAccount" and "gatewayProvider", which removes a frequent source of confusion
for people newly exposed to the API.  A gatewayProvider is a business such as Authorize.Net, and a gatewayAccount is the 
entity represented by a gatewayProvider and a set of credentials, such as a M_ID.

For general usage, create a new Spreedly(environmentKey, apiSecret) - this is threadsafe - and call its top level methods 
directly such as spreedly.listGatewayProviders() or spreedly.purchase(transactionRequest);

Since I assume that you're going to be using this in a much larger project, all Spreedly classes are prefaced with the word 
Spreedly to avoid confusion.
