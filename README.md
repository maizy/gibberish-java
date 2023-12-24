# gibberish-java

Java port of [greghaskins/gibberish/](https://github.com/greghaskins/gibberish/)

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
