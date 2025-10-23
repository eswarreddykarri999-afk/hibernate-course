Hibernate provides default cache which is called L1-Cache.
Under same session, when we do fetch, it will get data from cache using insert query.
when we create new session and try to fetch, then it will be select query.
 select
        ae1_0.aid,
        ae1_0.aname,
        ae1_0.tech
    from
        Alien_Eager ae1_0
    where
        ae1_0.aid=?
The query doesn't have laptop details because when we have collections in entity,
    then hibernate by default implement lazy fetch.
when we ask to print it, then it will show laptop details in the query.
It is better to have LAZY because production have lot of data.
To show laptop details without ask, then use EAGER.