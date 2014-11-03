reversegeo
-----------

A simple wrapper to get the location by passing lat/long value to Google Maps Reverse Geocoding.

Usage
=====

```java
    ReverseGeo reverseGeo = new ReverseGeo("16.780833,96.149722");
    reverseGeo.setType(ReverseGeo.LOCALITY);
    reverseGeo.getShortNameAsync(); // returns the short name with locality type
    // OR
    reverseGeo.getShortNameSync(); // returns the short name with locality type
```

Note that there are two ways to get the value. One of them it `getShortNameSync()`.
If you are `getShortNameSync()`, wrap it with `AsyncTask` .

See sample for more.
