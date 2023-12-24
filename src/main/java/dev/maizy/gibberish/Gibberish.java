package dev.maizy.gibberish;
/*
 * Copyright (c) Nikita Kovalev, maizy.dev, 2023
 * See LICENSE.txt for details.
 */

import java.security.SecureRandom;
import java.util.Random;

public class Gibberish {
  final private Random random;

  public Gibberish(Random random) {
    this.random = random;
  }

  public Gibberish() {
    this(new SecureRandom());
  }

  public String generateWord(int vowelConsonantRepeats, boolean startVowel, boolean endVowel) {
    if (vowelConsonantRepeats < 1) {
      throw new IllegalArgumentException("At least one repeat is required");
    }

    var sb = new StringBuilder();
    if (!startVowel) {
      sb.append(choice(Components.initial_consonants));
    }
    for (var i = 0; i < vowelConsonantRepeats; i++) {
      sb.append(choice(Components.vowels));
      // don't append a consonant if the last char should be a vowel
      if (i != vowelConsonantRepeats - 1 || !endVowel) {
        sb.append(choice(Components.final_consonants));
      }
    }
    return sb.toString();
  }

  public String generateWord() {
    return generateWord(1, false, false);
  }

  public String generateSlug(
      int words, int vowelConsonantRepeatsFrom, int vowelConsonantRepeatsTo, String divider) {

    if (vowelConsonantRepeatsFrom < 0 || vowelConsonantRepeatsTo < 0 ||
          vowelConsonantRepeatsFrom > vowelConsonantRepeatsTo) {
      throw new IllegalArgumentException("Invalid bounds for repeats amount");
    }
    if (words < 1) {
      throw new IllegalArgumentException("Invalid words amount");
    }

    var sb = new StringBuilder();
    for (var i = 0; i < words; i++) {
      var repeats = (vowelConsonantRepeatsFrom == vowelConsonantRepeatsTo)
          ? vowelConsonantRepeatsFrom
          : random.nextInt(vowelConsonantRepeatsTo - vowelConsonantRepeatsFrom) + vowelConsonantRepeatsFrom;

      sb.append(generateWord(repeats, false, false));
      if (i != words - 1) {
        sb.append(divider);
      }
    }
    return sb.toString();
  }

  public String generateSlug(int words) {
    return generateSlug(words, 1, 3, "-");
  }

  public String generateSlug() {
    return generateSlug(3 + random.nextInt(3), 1, 2, "-");
  }

  private String choice(String[] variants) {
    return variants[random.nextInt(variants.length)];
  }

}
