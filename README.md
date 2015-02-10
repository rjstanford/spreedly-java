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

There are no significant external dependencies. The module does depend on a three-class HTTP utility that I had previously
included but is now its own project, but no substantial code will be pulled in.  It also depends on JAXB which should be available
on any reasonable server-side project.  

This is not intended to be used in client-side or mobile applications since it depends heavily on your Spreedly apiSecret which should
never leave your own servers and be exposed to the general public.  For pure client-side work, I suggest an approach similar to that
used in https://github.com/rjstanford/spreedly to tokenize.  

In general, the only spelling differences are the use of StudlyCaps rather than under_scores.  I have taken the liberty of
branching the Spreedly term "gateway" into "gatewayAccount" and "gatewayProvider", which removes a frequent source of confusion
for people newly exposed to the API.  A gatewayProvider is a business such as Authorize.Net, and a gatewayAccount is the 
entity represented by a gatewayProvider and a set of credentials, such as a M_ID.

For general usage, create a new Spreedly(environmentKey, apiSecret) - this is threadsafe - and call its top level methods 
directly such as spreedly.listGatewayProviders() or spreedly.purchase(transactionRequest);

Since I assume that you're going to be using this in a much larger project, all Spreedly classes are prefaced with the word 
Spreedly to avoid confusion.

To run the (trivial) tests, simply set the environment variables SPREEDLYCORE_ENVIRONMENT_KEY and SPREEDLYCORE_API_SECRET to appropriate values.