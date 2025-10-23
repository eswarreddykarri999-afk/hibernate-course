Hibernate provides a default cache known as Level 1 (L1) Cache.
Within the same session, when we fetch an entity second time, Hibernate retrieves the data from the cache instead of hitting the database (no new SELECT query).
However, when a new session is created and the same entity is fetched again, Hibernate executes a SELECT query, for example:

select
    ae1_0.aid,
    ae1_0.aname,
    ae1_0.tech
from
    Alien_Eager ae1_0
where
    ae1_0.aid = ?


This query doesn’t include laptop details because Hibernate applies lazy loading by default for collections in entities.
When we explicitly access or print the collection, Hibernate then triggers an additional query to fetch those details.

Using LAZY fetching is generally preferred in production environments, as it avoids unnecessary data loading and improves performance.
If you want to load the related data (like laptop details) immediately along with the main entity, you can use EAGER fetching instead.

When a user sends the same request within the same session, Hibernate serves the data from the L1 Cache.
However, if the same request is sent from a different session, Hibernate fetches the data from the database again.
To share cached data across multiple sessions, we need to configure a Level 2 (L2) Cache.
