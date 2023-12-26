# gibberish-java

Java port of [greghaskins/gibberish](https://github.com/greghaskins/gibberish/).

## Get it

Gradle:

```
repositories {
  mavenCentral()
}
dependencies {
  implementation 'dev.maizy:gibberish:1.0.0'
}
```

Maven:

```
<dependency>
    <groupId>dev.maizy</groupId>
    <artifactId>gibberish</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

```java
import dev.maizy.gibberish.Gibberish;

public class Usage {
  public static void main(String[] args) {
    var gen = new Gibberish();

    var word = gen.generateWord(); // "briedly"
    var longerWord = gen.generateWord(3, false, false); // "weemsiochoerg"
    var slug = gen.generateSlug(); // "staiack-czuds-moav"
    var longerSlug = gen.generateSlug(5); // "szol-staifyauerly-typuoyeuff-kheuwnian-hyeaunn"
  }
}
```
