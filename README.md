EN [JP](./README_JP.md)

# gen.mjava

## Description

This is a AST Generator of [GumTree](https://github.com/GumTreeDiff/gumtree) for `.mjava` file.
 `.mjava` is extracted method as a single file.

## Usage in your project

### Gradle (with GitHub Packages)

build.gradle
```groovy
repositories {
    ....
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/a-fujimt/gen.mjava")
        credentials {
            username = project.hasProperty("GITHUB_USER") ? GITHUB_USER : ''
            password = project.hasProperty("GITHUB_TOKEN") ? GITHUB_TOKEN : ''
        }
    }
}

dependencies {
  implementation 'com.fujimotoakira:gen.mjava:1.0-SNAPSHOT'
  implementation 'com.github.gumtreediff:core:version' // GumTree
  implementation 'com.github.gumtreediff:client:version' // GumTree
  ....
}
```

gradle.properties
 ```
GITHUB_USER = XXXXXX
GUTHUB_TOKEN = YYYYYY
 ```

Add GitHub authentication in `gradle.properties` because this project is published in Github Package. If you want to know detail about GitHub authentication, see [this page](https://docs.github.com/en/packages/learn-github-packages/about-github-packages#about-scopes-and-permissions-for-package-registries).

### Parsing a file

#### Using the generator registry ([ref](https://github.com/GumTreeDiff/gumtree/wiki/GumTree-API#using-the-generator-registry))
```java
Run.initGenerators(); // registers the available parsers
String file = "myfile.mjava";
TreeContext tc = TreeGenerators.getInstance().getTree(file); // retrieves and applies the default parser for the file 
Tree t = tc.getRoot(); // retrieves the root of the tree
System.out.println(t.toTreeString()); // displays the tree in our ad-hoc format
```

#### Using mjava JDT generator ([ref](https://github.com/GumTreeDiff/gumtree/wiki/GumTree-API#using-a-specific-generator))
```java
String file = "myfile.mjava";
Tree tree = new MJdtTreeGenerator().generateFrom().file(file).getRoot(); // instantiates and applies the MJDT generator
```



