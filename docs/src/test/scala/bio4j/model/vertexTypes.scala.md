
```scala
package bio4j.model.test

object vertexTypes {
  
  import bio4j.model.VertexType

  import bio4j.model._
  import propertyTypes._

  // just labels and witnesses for properties
  case object User extends VertexType {

    implicit val _id     = this has id
    implicit val _since  = this has since
    implicit val _name   = this has name
  }

  // User module?
  abstract class UserModule extends Vertex(User) {

    // require implicits here
  }

  case object Org extends VertexType
}
```


------

### Index

+ src
  + test
    + scala
      + bio4j
        + model
          + [propertyTypes.scala][test/scala/bio4j/model/propertyTypes.scala]
          + [vertices.scala][test/scala/bio4j/model/vertices.scala]
          + [relationships.scala][test/scala/bio4j/model/relationships.scala]
          + [vertexTypes.scala][test/scala/bio4j/model/vertexTypes.scala]
          + [edgeTypes.scala][test/scala/bio4j/model/edgeTypes.scala]
  + main
    + scala
      + bio4j
        + model
          + [properties.scala][main/scala/bio4j/model/properties.scala]
          + [edges.scala][main/scala/bio4j/model/edges.scala]
          + [vertices.scala][main/scala/bio4j/model/vertices.scala]
          + [relationships.scala][main/scala/bio4j/model/relationships.scala]
          + [relationshipTypes.scala][main/scala/bio4j/model/relationshipTypes.scala]
          + [vertexTypes.scala][main/scala/bio4j/model/vertexTypes.scala]
          + [edgeTypes.scala][main/scala/bio4j/model/edgeTypes.scala]

[test/scala/bio4j/model/propertyTypes.scala]: propertyTypes.scala.md
[test/scala/bio4j/model/vertices.scala]: vertices.scala.md
[test/scala/bio4j/model/relationships.scala]: relationships.scala.md
[test/scala/bio4j/model/vertexTypes.scala]: vertexTypes.scala.md
[test/scala/bio4j/model/edgeTypes.scala]: edgeTypes.scala.md
[main/scala/bio4j/model/properties.scala]: ../../../../main/scala/bio4j/model/properties.scala.md
[main/scala/bio4j/model/edges.scala]: ../../../../main/scala/bio4j/model/edges.scala.md
[main/scala/bio4j/model/vertices.scala]: ../../../../main/scala/bio4j/model/vertices.scala.md
[main/scala/bio4j/model/relationships.scala]: ../../../../main/scala/bio4j/model/relationships.scala.md
[main/scala/bio4j/model/relationshipTypes.scala]: ../../../../main/scala/bio4j/model/relationshipTypes.scala.md
[main/scala/bio4j/model/vertexTypes.scala]: ../../../../main/scala/bio4j/model/vertexTypes.scala.md
[main/scala/bio4j/model/edgeTypes.scala]: ../../../../main/scala/bio4j/model/edgeTypes.scala.md