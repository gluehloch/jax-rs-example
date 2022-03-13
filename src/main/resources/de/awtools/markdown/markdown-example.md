# KeyStore

## KeyStore allgemein
Im KeyStore werden private Schlüssel und Zertifikate abgelegt.

## KeyStore Formate (Randnotiz)
Das alte, vor Java 9 verwendete, KeyStore Formate nennt sich JKS. Seid
Java 9 wird das allgemeine, standardisierte PKCS12 verwendet.

## KeyStore anlegen
Im ersten Schritt wird mit dem Befehl `keytool` ein KeyStore inklusive Zertifikat angelegt.
Ich habe als Passwort `awtest666` gewählt.
```
keytool -genkey -alias awtest -keyalg RSA -keystore awtest.jks -keysize 4096
```

Im zweiten Schritt das Zertifikat exportieren.
TODO: Ist das exportierte Zertifikat der 'öffentliche Schlüssel'?
```
keytool -export -keystore awtest.jks -alias awtest -file awtest.cer
```

    setExpiration() should set a Date object that is later than the Date object for the setIssuedAt().
    signWith() uses the private key to sign the JWT token. This is where we should use the private key.

```
String jksPassword = "awtest666";

KeyStore ks  = KeyStore.getInstance(KeyStore.getDefaultType());
ks.load(new FileInputStream("awtest.jks"), jksPassword.toCharArray());
Key key = ks.getKey("awtest", jksPassword.toCharArray());
```


### links
* [X.509](https://de.wikipedia.org/wiki/X.509)
