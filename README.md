# reversegeo

A simple wrapper to get the location by passing lat/long value to Google Maps Reverse Geocoding.

## Usage

```java
ReverseGeo reverseGeo = new ReverseGeo("16.780833,96.149722");
reverseGeo.setType(ReverseGeo.LOCALITY);
reverseGeo.getShortNameAsync(); // returns the short name with locality type
// OR
reverseGeo.getShortNameSync(); // returns the short name with locality type
```

Note that there are two ways to get the value. One of them is `getShortNameSync()`.
If you use `getShortNameSync()`, wrap it with `AsyncTask` .

The available types are
* ROUTE
* NEIGHBORHOOD
* SUBLOCALITY
* LOCALITY
* COUNTRY

Depends on location, the attributes may vary and not be available.

Please see sample for more.

Contributing
------------

 1. Fork it
 2. Create your feature branch (`git checkout -b my-new-feature`)
 3. Commit your changes (`git commit -am 'Added some feature'`)
 4. Push to the branch (`git push origin my-new-feature`)
 5. Create new Pull Request

License
--------

MIT
