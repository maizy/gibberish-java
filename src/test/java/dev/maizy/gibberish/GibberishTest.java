package dev.maizy.gibberish;

/*
 * Copyright (c) Nikita Kovalev, maizy.dev, 2023
 * See LICENSE.txt for details.
 */

import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GibberishTest {

  @Test
  void generateWordRandomness() {
    var g = new Gibberish();
    Set<String> words = new HashSet<>();
    for (var i = 0; i < 10000; i++) {
      var word = g.generateWord();
      assertTrue(word.length() > 0);
      if (i < 20) {
        System.out.println(word);
      }
      words.add(word);
    }
    assertTrue(words.size() > 9700, "words size: " + words.size());
  }

  @Test
  void generateSlugRandomness() {
    var g = new Gibberish();
    Set<String> slugs = new HashSet<>();
    final int checks = 1000000;
    for (var i = 0; i < checks; i++) {
      var slug = g.generateSlug();
      if (i < 20) {
        System.out.println(slug);
      }
      assertTrue(slug.length() > 0);
      slugs.add(slug);
    }
    assertEquals(slugs.size(), checks);
  }

  @Test
  void generateSlugParts() {
    var g = new Gibberish();
    for (var i = 1; i <= 10; i++) {
      var word = g.generateSlug(i);
      assertEquals(word.split("-").length, i);
    }
  }
}
