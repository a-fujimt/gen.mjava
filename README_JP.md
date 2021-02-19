[EN](./README.md) JP

# gen.mjava

## 概要

[GumTree](https://github.com/GumTreeDiff/gumtree)の `.mjava` 用のASTを生成します．
 `.mjava`ファイルはJavaプログラムから一つのメソッドのみを抽出したファイルです．

## 使用方法

### Gradle (GitHub Packagesを使用)

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

このプロジェクトはGitHub Packageで公開されているため`gradle.properties`にGitHubのアクセストークンを記載します．アクセストークンについての詳しい情報は[こちら](https://docs.github.com/ja/packages/learn-github-packages/about-github-packages#managing-packages)をご覧ください．

### ASTの生成

#### ファイル種類に応じたGeneratorを利用 ([参考](https://github.com/GumTreeDiff/gumtree/wiki/GumTree-API#using-the-generator-registry))
```java
Run.initGenerators(); // registers the available parsers
String file = "myfile.mjava";
TreeContext tc = TreeGenerators.getInstance().getTree(file); // retrieves and applies the default parser for the file 
Tree t = tc.getRoot(); // retrieves the root of the tree
System.out.println(t.toTreeString()); // displays the tree in our ad-hoc format
```

#### mjavaファイルのGeneratorを利用 ([参考](https://github.com/GumTreeDiff/gumtree/wiki/GumTree-API#using-a-specific-generator))
```java
String file = "myfile.mjava";
Tree tree = new MJdtTreeGenerator().generateFrom().file(file).getRoot(); // instantiates and applies the MJDT generator
```



