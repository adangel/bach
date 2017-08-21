/*
 * Bach - Java Shell Builder
 * Copyright (C) 2017 Christian Stein
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class BasicsTests {

  @Test
  void isJavaFile() {
    assertFalse(Basics.isJavaFile(Paths.get("")));
    assertFalse(Basics.isJavaFile(Paths.get("a/b")));
    assertTrue(Basics.isJavaFile(Paths.get("src/test/java/BasicsTests.java")));
  }

  @Test
  void isJarFile() {
    assertFalse(Basics.isJarFile(Paths.get("")));
    assertFalse(Basics.isJarFile(Paths.get("a/b")));
  }

  @Test
  void resolve() throws IOException {
    Path temp = Files.createTempDirectory("resolve-");
    new Basics.Resolvable("org.opentest4j", "opentest4j", "1.0.0-SNAPSHOT")
        .resolve(temp, Basics.Resolvable.REPOSITORIES);
    new Basics.Resolvable("org.opentest4j", "opentest4j", "1.0.0-ALPHA")
        .resolve(temp, Basics.Resolvable.REPOSITORIES);
  }
}