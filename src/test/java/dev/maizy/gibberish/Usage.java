package dev.maizy.gibberish;

public class Usage {
  public static void main(String[] args) {
    var gen = new Gibberish();

    var word = gen.generateWord(); // "briedly"
    System.out.println(word);

    var longerWord = gen.generateWord(3, false, false); // "weemsiochoerg"
    System.out.println(longerWord);

    var slug = gen.generateSlug(); // "staiack-czuds-moav"
    System.out.println(slug);

    var longerSlug = gen.generateSlug(5); // "szol-staifyauerly-typuoyeuff-kheuwnian-hyeaunn"
    System.out.println(longerSlug);
  }
}
