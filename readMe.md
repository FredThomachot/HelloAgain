
# Installation

* Installer le JDK (Java Development Kit) et JRE (Java Environment Execution)

* Paramétrer le PATH : C:\Program Files\Java\jdk1.8.0_161\bin

* Ajouter une variable "JAVA_HOME" : C:\Program Files\Java\jdk1.8.0_161

* Vérifier en entrant dans un Bash :

```bash
java -version
javac
```


# Installer Maven

* Télécharger : [lien](http://maven.apache.org/download.cgi)
* Copier le dossier "apache-maven" (dans le zip) dans : C\Programmes (par exemple)
* Ajouter dans le PATH : C:\Program Files\apache-maven-3.5.3\bin


# Démarrer un projet Java - Maven

* Créer un répertoire avec l'arborescence "NomRépertoire/src/main/java/hello" en ligne de commande :

```bash
mkdir -p NomRépertoire/src/main/java/hello
```

* Créer le fichier 'pom.xml' à côté de 'src':

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>fr.campus-numerique-in-the-alps</groupId>
    <artifactId>hello</artifactId>
    <version>1</version>
    <packaging>jar</packaging>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>2.1</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <transformers>
                                <transformer
                                        implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>hello.HelloWorld</mainClass>
                                </transformer>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    <dependencies>
        <dependency>
            <groupId>joda-time</groupId>
            <artifactId>joda-time</artifactId>
            <version>2.9.2</version>
        </dependency>
    </dependencies>
</project>
```
* A noter dans ce fichier :
  * mainClass : fichier principal où on va mettre tout
  * artifactId : version.jar
* Coder en mettant les fichiers java dans 'hello'

* Utiliser Maven :
```bash
mvn compile
mvn install
java -cp target/<artifactId> <mainClass>
```


Dans le fichier mainClass (exemple):
```
package hello;

public class Hello {
    public static void main(String[] args) {
        Animal poupou = new Dog();
        Human fred = new Human();

        System.out.println(poupou.sayHello());
        System.out.println(fred.sayHello());
    }
}
```




